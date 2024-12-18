package ua.ucu.edu.task1;

public class Money500 extends Money {

    public static final int DENOMINATION = 500;

    public Money500(Money nextmoney) {
        super(DENOMINATION, nextmoney);
    }
}