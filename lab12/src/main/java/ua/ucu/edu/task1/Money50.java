package ua.ucu.edu.task1;

public class Money50 extends Money {

    public static final int DENOMINATION = 50;

    public Money50(Money nextmoney) {
        super(DENOMINATION, nextmoney);
    }
}