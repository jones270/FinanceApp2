package sr.unasat.financeapp.activities;

import android.content.Intent;
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
import android.widget.Toast;

import java.util.Date;

import sr.unasat.financeapp.R;
import sr.unasat.financeapp.dao.TransactionDao;
import sr.unasat.financeapp.entities.Transaction;

public class TransactionActivity extends AppCompatActivity {

    private TransactionDao transactionDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        Toolbar toolbar = (Toolbar) findViewById(R.id.transaction_toolbar);
        toolbar.setTitle("Create Transaction");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void addTransaction(View view) {
        Spinner transactionType = findViewById(R.id.spinnerTransactionType);
        EditText transactionTitle = findViewById(R.id.editTextTransactionTitle);
        EditText transactionAmount = findViewById(R.id.editTextTransactionAmount);

        String typeValue = transactionType.getSelectedItem().toString();
        String titleValue = transactionTitle.getText().toString();
        double amountValue = Double.parseDouble(transactionAmount.getText().toString());

        Transaction transaction = new Transaction(typeValue, titleValue, amountValue);

        transactionDao = new TransactionDao(this);
        boolean status = transactionDao.addTransaction(transaction);

        if(status){
            Toast.makeText(this, "Succesfully created transaction", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.putExtra("status",status);
            setResult(RESULT_OK, intent);
            finish();
        }else{
            Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT).show();
        }

    }
}
