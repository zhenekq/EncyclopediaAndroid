package com.zhenekns.android.encyclopedia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhenekns.android.encyclopedia.R;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataHolder> {

    private Context context;
    private RecycleViewOnClickListener recycleViewOnClickListener;
    private List<ListItem> listItemArray;

    public DataAdapter(Context context, RecycleViewOnClickListener recycleViewOnClickListener, List<ListItem> listItemArray) {
        this.context = context;
        this.recycleViewOnClickListener = recycleViewOnClickListener;
        this.listItemArray = listItemArray;
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent, false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {
        holder.setData(listItemArray.get(position));
    }

    @Override
    public int getItemCount() {
        return listItemArray.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tvText;
        private ImageButton imButFav;

        public DataHolder(@NonNull View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tvText);
            imButFav = itemView.findViewById(R.id.imBut);
            itemView.setOnClickListener(this);
        }

        public void setData(ListItem listItem){
            tvText.setText(listItem.getText());
        }

        @Override
        public void onClick(View view) {
            recycleViewOnClickListener.onItemClicked(getAdapterPosition());
        }
    }
    public void updateList(List<ListItem> listArray){
        listItemArray.clear();
        listItemArray.addAll(listArray);
        notifyDataSetChanged();
    }
}

