package com.example.projetreservationsallereunion.data.modules.salles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetreservationsallereunion.R;
import com.example.projetreservationsallereunion.data.models.Salle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SallesAdapter extends RecyclerView.Adapter<SallesAdapter.MyViewHolder> {

    private List<Salle> listSalles;
    private  Context mContext;

    public SallesAdapter(List<Salle> listSalles, Context mContext) {
        this.listSalles = listSalles;
        this.mContext = mContext;
    }

    public void changeDataSource(ArrayList<Salle> listSalles) {
        this.listSalles = listSalles;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.const_item)
        ConstraintLayout mConstItem;
        @BindView(R.id.item_img_label)
        TextView mLabel;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    @NonNull
    @Override
    public SallesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_salle, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SallesAdapter.MyViewHolder holder, int position) {
        Salle salle = listSalles.get(position);

        holder.mLabel.setText(salle.getLibelle());
        holder.mConstItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((SallesActivity)mContext).startActivityReservations(salle.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listSalles.size();
    }
}
