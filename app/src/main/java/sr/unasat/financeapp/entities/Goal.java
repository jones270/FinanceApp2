package sr.unasat.financeapp.entities;

/**
 * Created by Benito on 11-Mar-18.
 */

public class Goal {
    public String goalId;
    public String goalAmount;
    public String goalStart;
    public String goalEnd;

    public Goal(String goalId,
                String goalAmount,
                String goalStart,
                String goalEnd) {
        this.goalId = goalId;
        this.goalAmount = goalAmount;
        this.goalStart = goalStart;
        this.goalEnd = goalEnd;
    }
}