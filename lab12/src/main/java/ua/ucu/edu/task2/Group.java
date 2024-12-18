package ua.ucu.edu.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


public class Group<T> extends Task<T> {
    public String groupUuid;
    private final List<Task<T>> tasks = new ArrayList<>();

    public Group<T> addTask(Task<T> task) {
        tasks.add(task);
        return this;
    }

    @Override
    public void freeze() {
        if (isFrozen()) return;

        super.freeze();
        groupUuid = UUID.randomUUID().toString();

        for (Task<T> task : tasks) {
            if (task instanceof Signature) {
                task.setHeader("groupId", groupUuid);
            }
            task.freeze();
        }
    }

    @Override
    public void apply(T arg) {
        if (!isFrozen()) {
            freeze();
        }

        for (Task<T> task : Collections.unmodifiableList(tasks)) {
            task.apply(arg);
        }
    }

    public boolean isFrozen() {
        return groupUuid != null;
    }

    public String getGroupUuid() {
        return groupUuid;
    }
}
