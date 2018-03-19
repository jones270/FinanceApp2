package sr.unasat.financeapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sr.unasat.financeapp.R;
import sr.unasat.financeapp.activities.MainActivity;
import sr.unasat.financeapp.helpers.DateHelper;
import sr.unasat.financeapp.interfaces.Updateable;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoalFragment extends Fragment implements Updateable{
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // do something such as init data
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_goal, container, false);
        update(DateHelper.dateToMiliseconds(MainActivity.selectedDate));
        return view;
    }

    @Override
    public void update(long date) {
        System.out.println("updating goal fragment");
    }
}
