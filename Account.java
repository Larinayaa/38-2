import java.math.BigDecimal;

// Класс Account - представляет банковский счет
class Account {
    private String iban;
    private BigDecimal balance;
    private Person owner;
    public Account(String iban, BigDecimal balance, Person owner) {
        this.iban = iban;
        this.balance = balance;
        this.owner = owner;
    }
    public Person getOwner() {
        return owner;
    }
    @Override
    public String toString() {
        return "Account{" + "iban='" + iban + '\'' + ", balance=" + balance + ", owner=" + owner + '}';
    }
}

