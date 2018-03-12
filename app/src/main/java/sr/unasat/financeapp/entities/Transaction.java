package sr.unasat.financeapp.entities;

/**
 * Created by Benito on 09-Mar-18.
 */

public class Transaction {
    public int id;
    public String type;
    public String title;
    public String amount;
    public int date;

    public Transaction(int id, String type, String title, String amount, int date) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}