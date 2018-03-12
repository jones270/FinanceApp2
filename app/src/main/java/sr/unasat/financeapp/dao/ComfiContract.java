package sr.unasat.financeapp.dao;


import android.provider.BaseColumns;

public final class ComfiContract {

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private ComfiContract() {};

    public static class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME_ID = "user_id";
        public static final String COLUMN_NAME__USER_NAME = "username";
        public static final String COLUMN_NAME__EMAIL = "email";
    }

    public static  class TransactionEntry implements BaseColumns {
        public static final String TABLE_NAME = "transactions";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_TYPE = "type";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_AMOUNT = "amount";
        public static final String COLUMN_NAME_DATE = "date";

        public static final String DEFAULT_EXPENSE_STRING = "expense";
        public static final String DEFAULT_INCOME_STRING = "income";
    }

    public static class GoalEntry implements BaseColumns {
        public static final String TABLE_NAME = "goal";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_AMOUNT = "amount";
        public static final String COLUMN_NAME_DATE = "date";

    }
}
