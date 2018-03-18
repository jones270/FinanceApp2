package sr.unasat.financeapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sr.unasat.financeapp.entities.Transaction;

public class TransactionDao {
    Context context;
    ComfiDbHelper cmDbHelper;
    SQLiteDatabase db;

    public TransactionDao(Context context) {
        this.context = context;
        cmDbHelper = new ComfiDbHelper(context);
    }

    public boolean addTransaction(Transaction transaction){
        try{
            // Gets the data repository in write mode
            db = cmDbHelper.getWritableDatabase();

            // Create a new map of values, where column names are the keys
            ContentValues values = new ContentValues();
            values.put(ComfiContract.TransactionEntry.COLUMN_NAME_TYPE, transaction.getType());
            values.put(ComfiContract.TransactionEntry.COLUMN_NAME_TITLE, transaction.getTitle());
            values.put(ComfiContract.TransactionEntry.COLUMN_NAME_AMOUNT, transaction.getAmount());
            values.put(ComfiContract.TransactionEntry.COLUMN_NAME_DATE, new Date().getTime());

            // Insert the new row, returning the primary key value of the new row
            long newRowId = db.insert(ComfiContract.TransactionEntry.TABLE_NAME, null, values);
            if (newRowId > 0) {
                return true;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cmDbHelper.close();
        }

        return false;
    }

    public ArrayList<Transaction> getRecentExpenses(String selectedDate){
        ArrayList<Transaction> recentExpenses = new ArrayList<>();

        try {
            db = cmDbHelper.getReadableDatabase();

            // Define a projection that specifies which columns from the database
            // you will actually use after this query.
            String[] projection = {
                    ComfiContract.TransactionEntry.COLUMN_NAME_ID,
                    ComfiContract.TransactionEntry.COLUMN_NAME_TITLE,
                    ComfiContract.TransactionEntry.COLUMN_NAME_AMOUNT,
                    ComfiContract.TransactionEntry.COLUMN_NAME_DATE,
            };

            // Filter results WHERE "title" = 'My Title'
            String selection = ComfiContract.TransactionEntry.COLUMN_NAME_TYPE + " = ?" + " AND " + ComfiContract.TransactionEntry.COLUMN_NAME_DATE + " <= strftime('%d-%m-%Y,"  + selectedDate + ")";
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

            while (cursor.moveToNext()){
                Transaction transaction = new Transaction(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4));
                recentExpenses.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cmDbHelper.close();
        }

        return recentExpenses;
    }

    public float getBalance(String date){
        float total = (float) 0.00;

        db = cmDbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT SUM(" + ComfiContract.TransactionEntry.COLUMN_NAME_AMOUNT + ") as Total FROM " + ComfiContract.TransactionEntry.TABLE_NAME + " WHERE " + ComfiContract.TransactionEntry.COLUMN_NAME_DATE + " <=  strftime('%d-%m-%Y'," + date + ");", null);

        if (cursor.moveToFirst()) {
            total = (float) cursor.getInt(cursor.getColumnIndex("Total"));// get final total
        }

        System.out.println("Total: " + total);

        try{

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cmDbHelper.close();
        }

        return total;
    }
}
