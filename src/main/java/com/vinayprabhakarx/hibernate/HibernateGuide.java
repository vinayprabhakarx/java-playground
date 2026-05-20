package com.vinayprabhakarx.hibernate;

import com.vinayprabhakarx.hibernate.pojo.StudentResult;
import io.github.cdimascio.dotenv.Dotenv;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateGuide {
    public static void main(String[] args) {

        // Load .env file
        Dotenv dotenv = Dotenv.load();

        // Read values
        String dbPassword = dotenv.get("DB_PASSWORD");

        // STEP 1: Loading the configuration
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        // Set password properties dynamically
        cfg.setProperty("hibernate.connection.password", dbPassword );


        // STEP 2: Create session factory
        try (SessionFactory sessionFactory = cfg.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            // STEP 3: Begin transaction
            Transaction transaction = session.beginTransaction();

            StudentResult student = new StudentResult();
            student.setId(101);
            student.setName("Vinay");
            student.setAge(22);
            student.setEmail("vinay@example.com");
            student.setMarks(97);
            student.setPhone(99999999);

            // STEP 4: Perform operation
            session.merge(student);

            // STEP 5: Commit transaction
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
