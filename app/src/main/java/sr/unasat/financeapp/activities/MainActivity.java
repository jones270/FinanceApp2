package sr.unasat.financeapp.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

import sr.unasat.financeapp.R;
import sr.unasat.financeapp.fragments.DashboardFragment;
import sr.unasat.financeapp.fragments.DatePickerFragment;
import sr.unasat.financeapp.fragments.TransactionFragment;
import sr.unasat.financeapp.fragments.GoalFragment;
import sr.unasat.financeapp.fragments.ProfileFragment;
import sr.unasat.financeapp.helpers.DateHelper;

public class MainActivity extends AppCompatActivity {

    Button dateButton;
    private DialogFragment dateDialogfragment;

    private static int[] tabIcons = {
            R.drawable.ic_dashboard_white_24dp, //tab icon at postition 1
            R.drawable.ic_attach_money_white_24dp, //tab icon at postition 2
            R.drawable.ic_stars_white_24dp, //tab icon at postition 3
            R.drawable.ic_person_white_24dp //tab icon at postition 4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        dateButton = findViewById(R.id.dateButton);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        //Attach the SectionsPagerAdapter to the ViewPager
        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);

        //Attach the ViewPager to the TabLayout
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }

    /**
     * Handle the new set date here.
     * @param year
     * @param month
     * @param day
     */
    public void onDateSet(int year, int month, int day){
        Calendar c = Calendar.getInstance();
        if(year == c.get(Calendar.YEAR) && month == c.get(Calendar.MONTH)) {
            dateButton.setText(R.string.this_month);
        }
        else {
            dateButton.setText(new DateHelper().monthIntToString(month)+" "+year);
        }
    }

    private void showDatePickerDialog(){
        if(dateDialogfragment == null) {
            dateDialogfragment = new DatePickerFragment();
        }
        dateDialogfragment.show(getSupportFragmentManager(), "datePicker");
    }

    // Option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Logout:
                logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void logout() {
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    public void onClickAdd(View view) {
        Intent intentTransaction = new Intent(this, TransactionActivity.class);
        startActivity(intentTransaction);
    }


    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return 4;
        }
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new DashboardFragment();
                case 1:
                    return new TransactionFragment();
                case 2:
                    return new GoalFragment();
                case 3:
                    return new ProfileFragment();
            }
            return null;
        }

    }

}