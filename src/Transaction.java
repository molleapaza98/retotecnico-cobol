public class Transaction {

    Integer id;
    String type;
    Double amount;

    public Transaction(int id, String type, double amount) {
        this.id = id;
        this.type = type;
        this.amount = amount;
    }
}
