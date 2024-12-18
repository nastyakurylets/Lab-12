package ua.ucu.edu.task1;

public class Money10 extends Money {

    public static final int DENOMINATION = 10;

    public Money10(Money nextmoney) {
        super(DENOMINATION, nextmoney);
    }
}