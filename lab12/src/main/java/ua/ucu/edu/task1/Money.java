package ua.ucu.edu.task1;
public abstract class Money {

    private final Money nextmoney;
    private final int denomination;
    

    public Money(int denomination, Money nextmoney) {
        this.denomination = denomination;
        this.nextmoney = nextmoney;
    }

    public int receiveCoins(int amount) {
        int quantity = amount / denomination;
        int residual = amount % denomination;

        if (quantity > 0) {
            System.out.printf("Received %d money of %d denomination %n", quantity, denomination);
        }

        if (hasNext()) {
            quantity += nextmoney.receiveCoins(residual);
        } else if (residual > 0) {
            throw new IllegalArgumentException("Can not give this amount");
        }
        return quantity;
    }
    public boolean hasNext() {
        return nextmoney != null;
    }
}