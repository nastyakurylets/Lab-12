package ua.ucu.edu.task2;

public class Main {
    public static void main(String[] args) {
        Group<Integer> nestedGroup = new Group<>();
        nestedGroup
            .addTask(new Signature<>(System.out::println))
            .addTask(new Signature<>(x -> System.out.println("Squared: " + (x * x))));

        Group<Integer> group = new Group<>();
        group
            .addTask(nestedGroup)
            .addTask(new Signature<>(x -> System.out.println("Cubed: " + (x * x * x))));

        group.apply(5);
    }
}
