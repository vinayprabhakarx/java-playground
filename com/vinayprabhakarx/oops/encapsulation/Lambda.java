package com.vinayprabhakarx.oops.encapsulation;

public class Lambda {

    public static void main(String[] args) {

        // 1. Lambda with no parameters and no return value
        NoParam noParam = () -> System.out.println("No parameter lambda");
        noParam.execute();

        // 2. Lambda with single parameter (parentheses optional)
        SingleParam singleParam = msg -> System.out.println("Message: " + msg);
        singleParam.print("Hello Lambda");

        // 3. Lambda with multiple parameters and no return value
        MultiParam multiParam = (a, b) -> System.out.println("Sum = " + (a + b));
        multiParam.add(10, 20);

        // 4. Lambda with return value (expression body)
        ReturnValue returnValue = (x, y) -> x * y;
        System.out.println("Multiplication = " + returnValue.multiply(5, 4));

        // 5. Lambda with return value (block body)
        ReturnBlock returnBlock = (a, b) -> {
            int sum = a + b;
            return sum;
        };
        System.out.println("Addition = " + returnBlock.sum(15, 25));

        // 6. Lambda using built-in Runnable interface
        Runnable runnable = () -> System.out.println("Runnable lambda running");
        runnable.run();

        // 7. Lambda using built-in Consumer functional interface
        java.util.function.Consumer<String> consumer =
                text -> System.out.println("Consumed: " + text);
        consumer.accept("Functional Interface");

        // 8. Lambda capturing effectively final local variable
        int value = 100;
        Capture capture = () -> System.out.println("Captured value: " + value);
        capture.show();
    }
}

// Functional interface with no parameters and no return
@FunctionalInterface
interface NoParam {
    void execute();
}

// Functional interface with one parameter
@FunctionalInterface
interface SingleParam {
    void print(String message);
}

// Functional interface with multiple parameters
@FunctionalInterface
interface MultiParam {
    void add(int a, int b);
}

// Functional interface with return value (expression lambda)
@FunctionalInterface
interface ReturnValue {
    int multiply(int x, int y);
}

// Functional interface with return value (block lambda)
@FunctionalInterface
interface ReturnBlock {
    int sum(int a, int b);
}

// Functional interface for variable capture example
@FunctionalInterface
interface Capture {
    void show();
}
