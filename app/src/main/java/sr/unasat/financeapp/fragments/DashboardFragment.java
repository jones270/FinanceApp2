package sr.unasat.financeapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sr.unasat.financeapp.R;
import sr.unasat.financeapp.activities.MainActivity;
import sr.unasat.financeapp.dao.TransactionDao;
import sr.unasat.financeapp.entities.Transaction;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {
    TransactionDao transactionDao;
    View view;
    TextView balance;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // do something such as init data
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        final ArrayList<Transaction> recipeList = Recipe.getRecipesFromFile("recipes.json", this);
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        transactionDao = new TransactionDao(getActivity());
        updateView();
        return view;
    }

    public void updateView(){
        balance = view.findViewById(R.id.balans);
        if(transactionDao == null){
            transactionDao = new TransactionDao(getActivity());
        }
        balance.setText(Float.toString(transactionDao.getBalance(MainActivity.selectedDate)));
    }

}
