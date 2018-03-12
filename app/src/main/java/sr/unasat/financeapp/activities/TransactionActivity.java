package sr.unasat.financeapp.activities;

import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import sr.unasat.financeapp.R;
import sr.unasat.financeapp.entities.Transaction;

public class TransactionActivity extends AppCompatActivity {

//    private SQLiteDatabase SQLiteConnection;
//    private Spinner ChooseType;
//    private EditText editTextTitle, editTextAmount;
//    private String TitleHolder, AmountHolder, SQLiteDataBaseQueryHolder;
//    private Button SaveTransaction;
//    private Boolean EditTextEmptyHold;

//    //Declaration Spinner
//    private Spinner chooseType;
//
//    //Declaration EditTexts
//    private TextInputEditText insertTitle, insertAmount;
//
//    //Declaration TextInputLayout
//    private TextInputLayout textInputLayoutTitle, textInputLayoutAmount;
//
//    //Declaration Button
//    private Button saveTransaction;
//
//    //Declaration SqliteHelper
//    private SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

//        SaveTransaction = (Button)findViewById(R.id.button);
//        editTextTitle = (EditText)findViewById(R.id.editText);
//        editTextAmount = (EditText)findViewById(R.id.editText2);

    }

}


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        EnterData = (Button)findViewById(R.id.button);
//        ButtonDisplayData = (Button)findViewById(R.id.button2);
//        editTextName = (EditText)findViewById(R.id.editText);
//        editTextPhoneNumber = (EditText)findViewById(R.id.editText2);
//
//        EnterData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                SQLiteDataBaseBuild();
//
//                SQLiteTableBuild();
//
//                CheckEditTextStatus();
//
//                InsertDataIntoSQLiteDatabase();
//
//                EmptyEditTextAfterDataInsert();
//
//
//            }
//        });
//
//        ButtonDisplayData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(MainActivity.this, DisplaySQLiteDataActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//    }
//
//    public void SQLiteDataBaseBuild(){
//
//        sqLiteDatabaseObj = openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);
//
//    }
//
//    public void SQLiteTableBuild(){
//
//        sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+SQLiteHelper.Table_Column_ID+" PRIMARY KEY AUTOINCREMENT NOT NULL, "+SQLiteHelper.Table_Column_1_Name+" VARCHAR, "+SQLiteHelper.Table_Column_2_PhoneNumber+" VARCHAR);");
//
//    }
//
//    public void CheckEditTextStatus(){
//
//        NameHolder = editTextName.getText().toString() ;
//        NumberHolder = editTextPhoneNumber.getText().toString();
//
//        if(TextUtils.isEmpty(NameHolder) || TextUtils.isEmpty(NumberHolder)){
//
//            EditTextEmptyHold = false ;
//
//        }
//        else {
//
//            EditTextEmptyHold = true ;
//        }
//    }
//
//    public void InsertDataIntoSQLiteDatabase(){
//
//        if(EditTextEmptyHold == true)
//        {
//
//            SQLiteDataBaseQueryHolder = "INSERT INTO "+SQLiteHelper.TABLE_NAME+" (name,phone_number) VALUES('"+NameHolder+"', '"+NumberHolder+"');";
//
//            sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);
//
//            sqLiteDatabaseObj.close();
//
//            Toast.makeText(MainActivity.this,"Data Inserted Successfully", Toast.LENGTH_LONG).show();
//
//        }
//        else {
//
//            Toast.makeText(MainActivity.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();
//
//        }
//
//    }
//
//    public void EmptyEditTextAfterDataInsert(){
//
//        editTextName.getText().clear();
//
//        editTextPhoneNumber.getText().clear();
//
//    }
//