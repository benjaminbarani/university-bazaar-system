package com.example.signup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class BazaarAdapter extends RecyclerView.Adapter<BazaarAdapter.BazaarViewHolder> implements Filterable {
    private ArrayList<BazaarItem> mBazaarList;
    private ArrayList<BazaarItem> mBazaarListFull;

    public static class BazaarViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;


        public BazaarViewHolder(View itemView) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.titleID);
            mTextView2 = itemView.findViewById(R.id.descriptionID);
            mTextView3 = itemView.findViewById(R.id.postTypeID);

        }
    }

    public BazaarAdapter(ArrayList<BazaarItem> BazaarList) {
        mBazaarList = BazaarList;
        mBazaarListFull = new ArrayList<>(BazaarList);
    }

    @Override
    public BazaarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example, parent, false);
        BazaarViewHolder evh = new BazaarViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(BazaarViewHolder holder, int position) {
        BazaarItem currentItem = mBazaarList.get(position);

        holder.mTextView1.setText(currentItem.getTitleString());
        holder.mTextView2.setText(currentItem.getDescriptionString());
        holder.mTextView3.setText(currentItem.getPostString());
    }

    @Override
    public int getItemCount() {
        return mBazaarList.size();
    }

    @Override
    public Filter getFilter() {
        return bazaarFilter;
    }

    public Filter bazaarFilter = new Filter() {
        @Override
        //automatically performs filtering in a background thread
        protected FilterResults performFiltering(CharSequence constraint)
        {
            ArrayList<BazaarItem> filteredArray = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredArray.addAll(mBazaarListFull);
            } else {
                String filtered = constraint.toString().toLowerCase().trim();
                for (BazaarItem item : mBazaarListFull) {
                    if (item.getTitleString().toLowerCase().contains(filtered) || item.getDescriptionString().toLowerCase().contains(filtered) || item.getPostString().toLowerCase().contains(filtered)) {
                        filteredArray.add(item);
                    }
                }
            }
            FilterResults matches = new FilterResults();
            matches.values = filteredArray;
            return matches;
        }
        //published results from background filter
        @Override
        protected void publishResults(CharSequence constraint, FilterResults matches)
        {
            mBazaarList.clear();
            mBazaarList.addAll((ArrayList) matches.values);
            notifyDataSetChanged();
        }
    };
}
