package ua.ucu.edu.task1;

public class Money100 extends Money{

    public static final int DENOMINATION = 500;

    public Money100(Money nextmoney) {
        super(DENOMINATION, nextmoney);
    }
}