package sr.unasat.financeapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import sr.unasat.financeapp.entities.User;

/**
 * Created by Mitchell Jones on 3/12/2018.
 */

public class UserDao {

    private Context context;
    ComfiDbHelper cmDbHelper;

    public UserDao(Context context) {
        this.context = context;
    }

    public long adUser(User user) {
        if (cmDbHelper == null) {
            cmDbHelper = new ComfiDbHelper(context);

        }
        // Gets the data repository in write mode
        SQLiteDatabase db = cmDbHelper.getWritableDatabase();


        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ComfiContract.UserEntry.COLUMN_NAME_ID, user.getId());
        values.put(ComfiContract.UserEntry.COLUMN_NAME__USER_NAME, user.getUserName());
        values.put(ComfiContract.UserEntry.COLUMN_NAME__EMAIL, user.getEmail());

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(ComfiContract.TransactionEntry.TABLE_NAME, null, values);



        return newRowId;
    }


public void CreateUser (User user){



    }
}
