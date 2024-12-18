package ua.ucu.edu.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class Task<T> {
    private String id;
    private final Map<String, String> headers = new HashMap<>();

    public abstract void apply(T arg);

    public void freeze() {
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    protected void setHeader(String header, String headerValue) {
        headers.put(header, headerValue);
    }

    public String getHeader(String header) {
        return headers.get(header);
    }
}
