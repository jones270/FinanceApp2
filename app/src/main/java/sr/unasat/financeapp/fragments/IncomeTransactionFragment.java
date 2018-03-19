package sr.unasat.financeapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import sr.unasat.financeapp.R;
import sr.unasat.financeapp.activities.MainActivity;
import sr.unasat.financeapp.dao.TransactionDao;
import sr.unasat.financeapp.entities.Transaction;
import sr.unasat.financeapp.helpers.DateHelper;
import sr.unasat.financeapp.helpers.TransactionAdapter;
import sr.unasat.financeapp.interfaces.Updateable;

/**
 * A simple {@link Fragment} subclass.
 */
public class IncomeTransactionFragment extends Fragment implements Updateable{
    View view;
    TransactionDao transactionDao;
    ArrayList<Transaction> income;
    TransactionAdapter listAdapter;
    ListView incomeListView;

    public IncomeTransactionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_income_transaction, container, false);

        incomeListView = view.findViewById(R.id.listview_income);
        update(DateHelper.dateToMiliseconds(MainActivity.selectedDate));
        return view;
    }

    @Override
    public void update(long date) {
        if(transactionDao == null){
            transactionDao = new TransactionDao(super.getActivity());
        }

        income = transactionDao.getAllIncome(date);
        listAdapter = new TransactionAdapter(getActivity(), income);
        incomeListView.setAdapter(listAdapter);

    }
}
