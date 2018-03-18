package sr.unasat.financeapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sr.unasat.financeapp.R;
import sr.unasat.financeapp.entities.Transaction;
import sr.unasat.financeapp.interfaces.Updateable;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExpenseTransactionFragment extends Fragment implements Updateable{


    public ExpenseTransactionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_expense_transaction, container, false);
    }


    @Override
    public void update(String date) {

    }
}
