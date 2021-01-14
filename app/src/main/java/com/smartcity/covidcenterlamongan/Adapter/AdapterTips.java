package com.smartcity.covidcenterlamongan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import com.smartcity.covidcenterlamongan.R;
import com.smartcity.covidcenterlamongan.item.itemtips;
import com.smartcity.covidcenterlamongan.setting.Tools;
import com.smartcity.covidcenterlamongan.setting.ViewAnimation;

import java.util.ArrayList;

public class AdapterTips extends RecyclerView.Adapter<AdapterTips.ViewHolder>{
    private ArrayList<itemtips> dataList;
    private Context contex;
    NestedScrollView nestedScrollView;
    public AdapterTips(Context context, ArrayList<itemtips> data, NestedScrollView nestedScrollView)
    {
        this.dataList = data;
        this.contex = context;
        this.nestedScrollView=nestedScrollView;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemtips, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.judul.setText(dataList.get(position).getJudul());
        holder.penjelasan.setText(dataList.get(position).getIsi());
        holder.bt_toggle_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionText(holder.bt_toggle_text,holder.lyt_expand_text,nestedScrollView);
            }
        });
    }
    private void toggleSectionText(View view, final View v, final NestedScrollView vv) {
        boolean show = toggleArrow(view);
        if (show) {
            ViewAnimation.expand(v, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish() {
                    Tools.nestedScrollTo(vv, v);
                }
            });
        } else {
            ViewAnimation.collapse(v);
        }
    }
    public boolean toggleArrow(View view) {
        if (view.getRotation() == 0) {
            view.animate().setDuration(200).rotation(180);
            return true;
        } else {
            view.animate().setDuration(200).rotation(0);
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView judul, penjelasan;
        ImageButton bt_toggle_text;
        View lyt_expand_text;
        private ViewHolder(View itemView)
        {
            super(itemView);

            this.judul=itemView.findViewById(R.id.namaanggota);
            this.penjelasan=itemView.findViewById(R.id.textpenjelasan);
            this.bt_toggle_text = itemView.findViewById(R.id.bt_toggle_text);
            this.lyt_expand_text = itemView.findViewById(R.id.lyt_expand_text);
            this.lyt_expand_text.setVisibility(View.GONE);
        }
    }
}
