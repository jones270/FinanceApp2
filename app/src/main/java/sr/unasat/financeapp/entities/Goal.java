package sr.unasat.financeapp.entities;

/**
 * Created by Benito on 11-Mar-18.
 */

public class Goal {
    public int id;
    public String amount;
    public int date;

    public Goal(int id, String amount, int date) {
        this.id = id;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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