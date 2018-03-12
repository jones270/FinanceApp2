package sr.unasat.financeapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sr.unasat.financeapp.R;
import sr.unasat.financeapp.entities.Transaction;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {


    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final ArrayList<Transaction> recipeList = Recipe.getRecipesFromFile("recipes.json", this);
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }



}
