package com.vinayprabhakarx.annotation.builtin;

public class BuiltInAnnotation {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        ChildService childService = new ChildService();

        childService.start();
        childService.oldProcess();
        childService.printUncheckedWarningExample();
        childService.printNames(
                java.util.List.of("Vinay", "Prabhakar"),
                java.util.List.of("Java", "Annotation")
        );

        Calculator calculator = (a, b) -> a + b;
        System.out.println("Sum: " + calculator.add(10, 20));
    }
}

class ParentService {
    public void start() {
        System.out.println("Parent service started");
    }
}

class ChildService extends ParentService {
    // @Override checks that this method is really overriding a parent method.
    @Override
    public void start() {
        System.out.println("Child service started");
    }

    // @Deprecated marks code that should not be used in new develpment.
    @Deprecated(since = "1.0", forRemoval = false)
    public void oldProcess() {
        System.out.println("Old process running");
    }

    // @SuppressWarnings hides a specific compiler warning for this method.
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void printUncheckedWarningExample() {
        java.util.List names = new java.util.ArrayList();
        names.add("Vinay");
        System.out.println(names);
    }

    // @SafeVarargs tells the compiler this varargs method does not perform unsafe operations.
    @SafeVarargs
    public final void printNames(java.util.List<String>... nameGroups) {
        for (java.util.List<String> names : nameGroups) {
            System.out.println(names);
        }
    }
}

// @FunctionalInterface ensures this interface has exactly one abstract method.
@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}
