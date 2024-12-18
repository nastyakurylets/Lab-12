package ua.ucu.edu.task1;
public class ATM {

    private final Money money;

    public ATM() {
        this.money = new Money500(new Money200(new Money100(new Money10(null))));
    }

    public int getMoney(int money) {
        return this.money.receiveCoins(money);
    }
}