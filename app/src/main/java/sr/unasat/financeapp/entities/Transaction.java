package sr.unasat.financeapp.entities;

/**
 * Created by Benito on 09-Mar-18.
 */

public class Transaction {
    public String transactionId;
    public String id;
    public String type;
    public String title;
    public String category;
    public String amount;
    public String date;
    public int recurring;
    public String frequency;
    public String startDate;
    public String endDate;

    public Transaction(String transactionId,
                                    String id,
                                    String type,
                                    String title,
                                    String category,
                                    String amount,
                                    String date,
                                    int recurring,
                                    String frequency,
                                    String startDate,
                                    String endDate) {
        this.transactionId = transactionId;
        this.id = id;
        this.type = type;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.recurring = recurring;
        this.frequency = frequency;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}