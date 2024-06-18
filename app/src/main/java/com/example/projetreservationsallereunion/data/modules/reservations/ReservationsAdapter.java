package com.example.projetreservationsallereunion.data.modules.reservations;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetreservationsallereunion.R;
import com.example.projetreservationsallereunion.data.models.Reservation;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ReservationsAdapter extends RecyclerView.Adapter<ReservationsAdapter.MyViewHolder> {

    private List<Reservation> lisetReservations;
    private Context mContext;

    public ReservationsAdapter(List<Reservation> lisetReservations, Context mContext) {
        this.lisetReservations = lisetReservations;
        this.mContext = mContext;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_date_debut_label)
        TextView mDateDebut;

        @BindView(R.id.item_date_fin_label)
        TextView mDateFin;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    @NonNull
    @Override
    public ReservationsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_reservation, parent, false);

        return new ReservationsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Reservation reservation = lisetReservations.get(position);

        holder.mDateFin.setText(Reservation.dateTimeStringFromTimeStamp(reservation.getDateFin()));
        holder.mDateDebut.setText(Reservation.dateTimeStringFromTimeStamp(reservation.getDateDebut()));
    }

    @Override
    public int getItemCount() {
        return lisetReservations.size();
    }
}

