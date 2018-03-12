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

        Transaction transaction = (Transaction) getItem(position);

        ViewHolder holder;

// 1
        if(convertView == null) {

            convertView = mInflater.inflate(R.layout.list_item_transaction, parent, false);

            holder = new ViewHolder();
            holder.titleTextView = (TextView) convertView.findViewById(R.id.transaction_item_title);
            holder.dateTextView = (TextView) convertView.findViewById(R.id.transaction_item_date);
            holder.amountTextView = (TextView) convertView.findViewById(R.id.transaction_item_amount);

            convertView.setTag(holder);
        }
        else{

            holder = (ViewHolder) convertView.getTag();
        }


        TextView titleTextView = holder.titleTextView;
        TextView dateTextView = holder.dateTextView;
        TextView amountTextView = holder.amountTextView;

        return convertView;
    }

    private static class ViewHolder {
        public TextView titleTextView;
        public TextView dateTextView;
        public TextView amountTextView;
    }
}
