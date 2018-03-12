package sr.unasat.financeapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import sr.unasat.financeapp.entities.Transaction;

public class TransactionDao {
    private Context context;
    ComfiDbHelper cmDbHelper;

    public TransactionDao(Context context) {
        this.context = context;
    }

    public long addTransaction(Transaction transaction){
        if(cmDbHelper == null){
            cmDbHelper = new ComfiDbHelper(context);
        }

        // Gets the data repository in write mode
        SQLiteDatabase db = cmDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ComfiContract.TransactionEntry.COLUMN_NAME_TYPE, transaction.getType());
        values.put(ComfiContract.TransactionEntry.COLUMN_NAME_TITLE, transaction.getTitle());
        values.put(ComfiContract.TransactionEntry.COLUMN_NAME_AMOUNT, transaction.getAmount());
        values.put(ComfiContract.TransactionEntry.COLUMN_NAME_DATE, transaction.getDate());

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(ComfiContract.TransactionEntry.TABLE_NAME, null, values);

        return newRowId;
    }

    public ArrayList<Transaction> getRecentExpenses(int dateInMiliSeconds){
        if(cmDbHelper == null){
            cmDbHelper = new ComfiDbHelper(context);
        }

        SQLiteDatabase db = cmDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                ComfiContract.TransactionEntry.COLUMN_NAME_ID,
                ComfiContract.TransactionEntry.COLUMN_NAME_TITLE,
                ComfiContract.TransactionEntry.COLUMN_NAME_AMOUNT,
                ComfiContract.TransactionEntry.COLUMN_NAME_DATE,
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = ComfiContract.TransactionEntry.COLUMN_NAME_TYPE + " = ?" + " AND " + ComfiContract.TransactionEntry.COLUMN_NAME_DATE + " <= " + dateInMiliSeconds;
        String[] selectionArgs = {ComfiContract.TransactionEntry.DEFAULT_EXPENSE_STRING};

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                ComfiContract.TransactionEntry.COLUMN_NAME_DATE + " ASC";

        Cursor cursor = db.query(
                ComfiContract.TransactionEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,          // don't group the rows
                null,           // don't filter by row groups
                sortOrder,              // The sort order
                "5"                   //limit
        );

        ArrayList<Transaction> recentExpenses = new ArrayList<>();
        while (cursor.moveToNext()){
            Transaction transaction = new Transaction(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4));
            recentExpenses.add(transaction);
        }
        cursor.close();

        return recentExpenses;
    }
}
