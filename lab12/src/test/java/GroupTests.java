import org.junit.jupiter.api.Test;

import ua.ucu.edu.task2.*;

import static org.junit.jupiter.api.Assertions.*;


public class GroupTests {

    @Test
    void testGroupStamping() {
        Group<Integer> group = new Group<>();
        Signature<Integer> sig1 = new Signature<>(System.out::println);
        Signature<Integer> sig2 = new Signature<>(x -> System.out.println("Squared: " + x * x));

        group.addTask(sig1).addTask(sig2);

        group.apply(10);

        assertNotNull(group.groupUuid, "Group UUID should not be null after apply");
        assertEquals(group.groupUuid, sig1.getHeader("groupId"), "Group UUID should match Signature 1's groupId");
        assertEquals(group.groupUuid, sig2.getHeader("groupId"), "Group UUID should match Signature 2's groupId");
    }

    @Test
    void testNestedGroupStamping() {
        Group<Integer> nestedGroup = new Group<>();
        Signature<Integer> sig1 = new Signature<>(System.out::println);
        nestedGroup.addTask(sig1);

        Group<Integer> parentGroup = new Group<>();
        parentGroup.addTask(nestedGroup);

        parentGroup.apply(10);

        assertNotNull(parentGroup.groupUuid, "Parent group UUID should not be null after apply");
    }

    @Test
    void testMultipleSignaturesInGroup() {
        Group<Integer> group = new Group<>();
        Signature<Integer> sig1 = new Signature<>(x -> System.out.println("Task 1: " + x));
        Signature<Integer> sig2 = new Signature<>(x -> System.out.println("Task 2: " + x * 2));
        Signature<Integer> sig3 = new Signature<>(x -> System.out.println("Task 3: " + x * 3));

        group.addTask(sig1).addTask(sig2).addTask(sig3);

        group.apply(5);

        assertEquals(group.groupUuid, sig1.getHeader("groupId"), "Group UUID should match Signature 1's groupId");
        assertEquals(group.groupUuid, sig2.getHeader("groupId"), "Group UUID should match Signature 2's groupId");
        assertEquals(group.groupUuid, sig3.getHeader("groupId"), "Group UUID should match Signature 3's groupId");
    }
}
