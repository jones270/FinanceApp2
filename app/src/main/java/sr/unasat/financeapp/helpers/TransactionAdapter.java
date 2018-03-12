package sr.unasat.financeapp.helpers;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import sr.unasat.financeapp.R;
import sr.unasat.financeapp.entities.Transaction;

public class TransactionAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Transaction> mDataSource;

    public TransactionAdapter(Context context, ArrayList<Transaction> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get view for row item
        View rowView = mInflater.inflate(R.layout.list_item_transaction, parent, false);

        // Get title element
        TextView titleTextView = rowView.findViewById(R.id.transaction_item_title);

        // Get date element
        TextView dateTextView = rowView.findViewById(R.id.transaction_item_date);

        // Get amount element
        TextView amountTextView = rowView.findViewById(R.id.transaction_item_amount);

        Transaction transaction = (Transaction) getItem(position);

        titleTextView.setText(transaction.title);
        dateTextView.setText(transaction.date);
        amountTextView.setText(transaction.amount);

        return rowView;
    }
}
