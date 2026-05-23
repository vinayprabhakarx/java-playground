package com.vinayprabhakarx.hibernate;

import com.vinayprabhakarx.hibernate.pojo.StudentResult;
import io.github.cdimascio.dotenv.Dotenv;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class HibernateCrudGuide {
    public static void main(String[] args) {
        // SessionFactory is expensive to create, so build it once and reuse it.
        try (SessionFactory sessionFactory = buildSessionFactory();
             Scanner scanner = new Scanner(System.in)) {
            runMenu(sessionFactory, scanner);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SessionFactory buildSessionFactory() {
        // Keep the database password outside source code and load it from .env.
        Dotenv dotenv = Dotenv.load();
        String dbPassword = dotenv.get("DB_PASSWORD");

        // hibernate.cfg.xml contains driver, URL, username, entity mapping, and SQL settings.
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.setProperty("hibernate.connection.password", dbPassword);

        return configuration.buildSessionFactory();
    }

    private static void runMenu(SessionFactory sessionFactory, Scanner scanner) {
        // Menu keeps the program interactive and avoids hardcoded CRUD values.
        int choice;

        do {
            printMenu();
            choice = readInt(scanner, "Enter your choice: ");

            switch (choice) {
                case 1 -> saveOrUpdateStudent(sessionFactory, scanner);
                case 2 -> findStudentById(sessionFactory, readInt(scanner, "Enter student id: "));
                case 3 -> listTopStudents(sessionFactory, readInt(scanner, "Enter minimum marks: "));
                case 4 -> updateStudentMarks(
                        sessionFactory,
                        readInt(scanner, "Enter student id: "),
                        readInt(scanner, "Enter new marks: ")
                );
                case 5 -> deleteStudentById(sessionFactory, readInt(scanner, "Enter student id: "));
                case 0 -> System.out.println("Exiting Hibernate CRUD guide.");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("Hibernate CRUD Guide");
        System.out.println("1. Save or update student");
        System.out.println("2. Find student by id");
        System.out.println("3. List students by minimum marks");
        System.out.println("4. Update student marks");
        System.out.println("5. Delete student by id");
        System.out.println("0. Exit");
    }

    private static void saveOrUpdateStudent(SessionFactory sessionFactory, Scanner scanner) {
        // Collect entity values from the user before sending the object to Hibernate.
        int id = readInt(scanner, "Enter student id: ");
        String name = readText(scanner, "Enter student name: ");
        int age = readInt(scanner, "Enter student age: ");
        String email = readText(scanner, "Enter student email: ");
        int marks = readInt(scanner, "Enter student marks: ");
        int phone = readInt(scanner, "Enter student phone: ");

        StudentResult student = new StudentResult(id, name, age, email, marks, phone);

        executeInsideTransaction(sessionFactory, session -> {
            // merge() inserts a new row if the id is new, or updates the row if it already exists.
            session.merge(student);
            System.out.println("Student saved or updated successfully: " + student);
        });
    }

    private static void findStudentById(SessionFactory sessionFactory, int id) {
        // A Session represents one unit of work with the database.
        try (Session session = sessionFactory.openSession()) {
            // find() loads an entity by primary key and returns null when no row exists.
            StudentResult student = session.find(StudentResult.class, id);

            if (student == null) {
                System.out.println("No student found with id: " + id);
                return;
            }

            System.out.println("Student found: " + student);
        }
    }

    private static void listTopStudents(SessionFactory sessionFactory, int minimumMarks) {
        try (Session session = sessionFactory.openSession()) {
            // HQL uses entity class names and field names, not raw table and column names.
            List<StudentResult> students = session
                    .createQuery(
                            "from StudentResult where marks >= :minimumMarks order by marks desc",
                            StudentResult.class
                    )
                    .setParameter("minimumMarks", minimumMarks)
                    .getResultList();

            System.out.println("Students with marks greater than or equal to " + minimumMarks + ":");
            students.forEach(System.out::println);
        }
    }

    private static void updateStudentMarks(SessionFactory sessionFactory, int id, int marks) {
        executeInsideTransaction(sessionFactory, session -> {
            StudentResult student = session.find(StudentResult.class, id);

            if (student == null) {
                System.out.println("No student found to update with id: " + id);
                return;
            }

            // Because this object is managed by the current Session, Hibernate detects the change.
            student.setMarks(marks);
            System.out.println("Student marks updated successfully: " + student);
        });
    }

    private static void deleteStudentById(SessionFactory sessionFactory, int id) {
        executeInsideTransaction(sessionFactory, session -> {
            StudentResult student = session.find(StudentResult.class, id);

            if (student == null) {
                System.out.println("No student found to delete with id: " + id);
                return;
            }

            // remove() deletes the managed entity when the transaction commits.
            session.remove(student);
            System.out.println("Student deleted successfully with id: " + id);
        });
    }

    private static void executeInsideTransaction(
            SessionFactory sessionFactory,
            HibernateOperation operation
    ) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            // Write operations should run inside a transaction.
            transaction = session.beginTransaction();
            operation.execute(session);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                // Roll back partial database changes when any operation fails.
                transaction.rollback();
            }

            throw e;
        }
    }

    @FunctionalInterface
    private interface HibernateOperation {
        void execute(Session session);
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static String readText(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("This field cannot be empty.");
        }
    }
}
