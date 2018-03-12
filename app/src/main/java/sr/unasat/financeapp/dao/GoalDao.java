package sr.unasat.financeapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import sr.unasat.financeapp.entities.Goal;
import sr.unasat.financeapp.entities.Transaction;

/**
 * Created by Benito on 12-Mar-18.
 */

public class GoalDao {
    private Context context;
    ComfiDbHelper cmDbHelper;

    public GoalDao(Context context) {
        this.context = context;
    }

    public long addGoal(Goal goal){
        if(cmDbHelper == null){
            cmDbHelper = new ComfiDbHelper(context);
        }

        // Gets the data repository in write mode
        SQLiteDatabase db = cmDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ComfiContract.GoalEntry.COLUMN_NAME_AMOUNT, goal.getAmount());
        values.put(ComfiContract.GoalEntry.COLUMN_NAME_DATE, goal.getDate());

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(ComfiContract.GoalEntry.TABLE_NAME, null, values);

        return newRowId;
    }

//    public getTotalExpenses(int dateInMiliSeconds) {
//        if(cmDbHelper == null){
//            cmDbHelper = new ComfiDbHelper(context);
//        }
//
//        SQLiteDatabase db = cmDbHelper.getReadableDatabase();
//
//        // method to query sum of amount in table transactions where type = Expense
//        public Cursor sumFoodColumn(){
//            Cursor c = db.query(true, DATABASE_TABLE, ALL_KEYS, KEY_FOOD + "=?", new String[]{"sum(food)" + KEY_FOOD}, null, null, null, null);
//            if (c !=null) {
//                c.moveToFirst();
//            }
//            return c;
//        }
//
//        return totalExpenses;
//    }

//    public ArrayList<Transaction> getRecentExpenses(int dateInMiliSeconds){
//        if(cmDbHelper == null){
//            cmDbHelper = new ComfiDbHelper(context);
//        }
//
//        SQLiteDatabase db = cmDbHelper.getReadableDatabase();
//
//        // Define a projection that specifies which columns from the database
//        // you will actually use after this query.
//        String[] projection = {
//                ComfiContract.TransactionEntry.COLUMN_NAME_ID,
//                ComfiContract.TransactionEntry.COLUMN_NAME_TITLE,
//                ComfiContract.TransactionEntry.COLUMN_NAME_AMOUNT,
//                ComfiContract.TransactionEntry.COLUMN_NAME_DATE,
//        };
//
//        // Filter results WHERE "title" = 'My Title'
//        String selection = ComfiContract.TransactionEntry.COLUMN_NAME_TYPE + " = ?" + " AND " + ComfiContract.TransactionEntry.COLUMN_NAME_DATE + " <= " + dateInMiliSeconds;
//        String[] selectionArgs = {ComfiContract.TransactionEntry.DEFAULT_EXPENSE_STRING};
//
//        // How you want the results sorted in the resulting Cursor
//        String sortOrder =
//                ComfiContract.TransactionEntry.COLUMN_NAME_DATE + " ASC";
//
//        Cursor cursor = db.query(
//                ComfiContract.TransactionEntry.TABLE_NAME,   // The table to query
//                projection,             // The array of columns to return (pass null to get all)
//                selection,              // The columns for the WHERE clause
//                selectionArgs,          // The values for the WHERE clause
//                null,          // don't group the rows
//                null,           // don't filter by row groups
//                sortOrder,              // The sort order
//                "5"                   //limit
//        );
//
//        ArrayList<Transaction> recentExpenses = new ArrayList<>();
//        while (cursor.moveToNext()){
//            Transaction transaction = new Transaction(
//                    cursor.getInt(0),
//                    cursor.getString(1),
//                    cursor.getString(2),
//                    cursor.getString(3),
//                    cursor.getInt(4));
//            recentExpenses.add(transaction);
//        }
//        cursor.close();
//
//        return recentExpenses;
//    }
}
