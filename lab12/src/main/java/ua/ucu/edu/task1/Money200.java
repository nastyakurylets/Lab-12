package ua.ucu.edu.task1;

public class Money200 extends Money {

    public static final int DENOMINATION = 200;

    public Money200(Money nextmoney) {
        super(DENOMINATION, nextmoney);
    }
}