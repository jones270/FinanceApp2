package sr.unasat.financeapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sr.unasat.financeapp.R;
import sr.unasat.financeapp.activities.MainActivity;
import sr.unasat.financeapp.dao.TransactionDao;
import sr.unasat.financeapp.entities.Transaction;
import sr.unasat.financeapp.helpers.CurrencyHelper;
import sr.unasat.financeapp.helpers.DateHelper;
import sr.unasat.financeapp.helpers.TransactionAdapter;
import sr.unasat.financeapp.interfaces.Updateable;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment implements Updateable{
    TransactionDao transactionDao;
    View view;
    TextView balanceText, incomeText, expenseText;

    TransactionAdapter listAdapter;
    ListView recentExpenseListView;

    Button recentAccordionButton;

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
        balanceText = view.findViewById(R.id.balans);
        incomeText = view.findViewById(R.id.total_income);
        expenseText = view.findViewById(R.id.total_expense);
        recentExpenseListView = view.findViewById(R.id.recent_expenses_content);
        recentAccordionButton = view.findViewById(R.id.button_recents);

        recentAccordionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(recentExpenseListView.getVisibility() != View.VISIBLE){
                    recentExpenseListView.setVisibility(View.VISIBLE);
                    return;
                }

                recentExpenseListView.setVisibility(View.GONE);
            }
        });
        update(MainActivity.selectedDate);
        return view;
    }

    @Override
    public void update(String date){
        System.out.println("updating dashboard fragment");

        if(transactionDao == null){
            transactionDao = new TransactionDao(getActivity());
        }

        //update balance view
        double totalIncome = transactionDao.getTotalIncome(DateHelper.dateToMiliseconds(date));
        double totalExpense = transactionDao.getTotalExpense(DateHelper.dateToMiliseconds(date));
        double balance = totalIncome - totalExpense;

        incomeText.setText(CurrencyHelper.returnStringCurrency(totalIncome));
        expenseText.setText(CurrencyHelper.returnStringCurrency(totalExpense));
        balanceText.setText(CurrencyHelper.returnStringCurrency(balance));


        //update recent expenses view
        ArrayList<Transaction> recentExpenses = transactionDao.getRecentExpenses(DateHelper.dateToMiliseconds(date));

        listAdapter = new TransactionAdapter(getActivity(), recentExpenses);
        recentExpenseListView.setAdapter(listAdapter);
    }


}
