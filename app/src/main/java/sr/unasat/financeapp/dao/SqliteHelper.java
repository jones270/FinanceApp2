package sr.unasat.financeapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import sr.unasat.financeapp.entities.Transaction;
import sr.unasat.financeapp.entities.User;

public class SqliteHelper extends SQLiteOpenHelper {

    //DATABASE NAME
    public static final String DATABASE_NAME = "finance";

    //DATABASE VERSION
    public static final int DATABASE_VERSION = 1;

    //TABLE NAME
    public static final String TABLE_USERS = "users";
    public static final String TABLE_TRANSACTIONS = "transactions";

    //TABLE USERS COLUMNS
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_USER_NAME = "username";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_GOAL = "goal";

    //TABLE TRANSACTIONS COLUMNS
    public static final String KEY_TRANSACTION_ID = "transaction_id";
    public static final String KEY_TYPE = "type";
    public static final String KEY_TITLE = "title";
    public static final String KEY_CATEGORY = "category";
    public static final String KEY_AMOUNT = "amount";
    public static final String KEY_DATE = "date";
    public static final String KEY_RECURRING = "recurring";
    public static final String KEY_FREQUENCY = "frequency";
    public static final String KEY_START_DATE = "start_date";
    public static final String KEY_END_DATE = "end_date";

    //SQL for creating users table
    public static final String SQL_TABLE_USERS = " CREATE TABLE " + TABLE_USERS
            + " ( "
            + KEY_USER_ID + " INTEGER PRIMARY KEY, "
            + KEY_USER_NAME + " TEXT, "
            + KEY_EMAIL + " TEXT, "
            + KEY_PASSWORD + " TEXT, "
            + KEY_GOAL + " REAL"
            + " ) ";

    //SQL for creating transactions table
    public static final String SQL_TABLE_TRANSACTIONS = " CREATE TABLE " + TABLE_TRANSACTIONS
            + " ( "
            + KEY_TRANSACTION_ID + " INTEGER PRIMARY KEY, "
            + KEY_TYPE + " TEXT, "
            + KEY_TITLE + " TEXT, "
            + KEY_CATEGORY + " TEXT, "
            + KEY_AMOUNT + " REAL, "
            + KEY_DATE + " TEXT, "
            + KEY_RECURRING + " INTEGER, "
            + KEY_FREQUENCY + " TEXT, "
            + KEY_START_DATE + " TEXT, "
            + KEY_END_DATE + " TEXT "
            + " ) ";

    public SqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Create Table when oncreate gets called
        sqLiteDatabase.execSQL(SQL_TABLE_USERS);
        sqLiteDatabase.execSQL(SQL_TABLE_TRANSACTIONS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //drop table to create new one if database version updated
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_USERS);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_TRANSACTIONS);
    }

    //using this method we can add users to user table
    public void addUser(User user) {

        //get writable database
        SQLiteDatabase db = this.getWritableDatabase();

        //create content values to insert
        ContentValues values = new ContentValues();

        //Put username in  @values
        values.put(KEY_USER_NAME, user.userName);
        //Put email in  @values
        values.put(KEY_EMAIL, user.email);
        //Put password in  @values
        values.put(KEY_PASSWORD, user.password);
        //Put password in  @values
        values.put(KEY_GOAL, user.goal);

        // insert row
        long todo_id = db.insert(TABLE_USERS, null, values);
    }

    //using this method we can add transactions to transaction table
    public void addUser(Transaction transaction) {

        //get writable database
        SQLiteDatabase db = this.getWritableDatabase();

        //create content values to insert
        ContentValues values = new ContentValues();

        //Put username in  @values
        values.put(KEY_TYPE, transaction.type);
        //Put email in  @values
        values.put(KEY_TITLE, transaction.title);
        //Put password in  @values
        values.put(KEY_CATEGORY, transaction.category);
        //Put password in  @values
        values.put(KEY_AMOUNT, transaction.amount);
        //Put password in  @values
        values.put(KEY_DATE, transaction.date);
        //Put password in  @values
        values.put(KEY_RECURRING, transaction.recurring);
        //Put password in  @values
        values.put(KEY_FREQUENCY, transaction.frequency);
        //Put password in  @values
        values.put(KEY_START_DATE, transaction.startDate);
        //Put password in  @values
        values.put(KEY_END_DATE, transaction.endDate);

        // insert row
        long todo_id = db.insert(TABLE_TRANSACTIONS, null, values);
    }

    public User Authenticate(User user) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS,// Selecting Table
                new String[]{KEY_USER_ID, KEY_USER_NAME, KEY_EMAIL, KEY_PASSWORD, KEY_GOAL},//Selecting columns want to query
                KEY_EMAIL + "=?",
                new String[]{user.email},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email
            User user1 = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));

            //Match both passwords check they are same or not
            if (user.password.equalsIgnoreCase(user1.password)) {
                return user1;
            }
        }

        //if user password does not matches or there is no record with that email then return @false
        return null;
    }

    public boolean isEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS,// Selecting Table
                new String[]{KEY_USER_ID, KEY_USER_NAME, KEY_EMAIL, KEY_PASSWORD},//Selecting columns want to query
                KEY_EMAIL + "=?",
                new String[]{email},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email so return true
            return true;
        }

        //if email does not exist return false
        return false;
    }
}