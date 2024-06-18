package com.example.projetreservationsallereunion.data.modules.reservations;

import static com.example.projetreservationsallereunion.utils.Constants.ID_SALLE;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetreservationsallereunion.R;
import com.example.projetreservationsallereunion.data.models.Reservation;
import com.example.projetreservationsallereunion.data.repos.ReservationRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReservationsActivity extends AppCompatActivity {

    @BindView(R.id.empty_view)
    ConstraintLayout mEmptyView;

    @BindView(R.id.rcv_reservation)
    RecyclerView mRcv;

    @BindView(R.id.btn_add)
    FloatingActionButton mBtnAdd;

    ReservationRepository reservationRepository;
    List<Reservation> reservationsList = new ArrayList<>();
    ReservationsAdapter mAdapterReservation;
    RecyclerView.LayoutManager mLayoutManager;

    Long idSalle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);
        ButterKnife.bind(this);

        initRepos();
        initExtras();
        initData();
        initViews();
        handleClicks();
    }

    private void handleClicks() {
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void initViews() {
        if (reservationsList.isEmpty()) {
            mEmptyView.setVisibility(View.VISIBLE);
            mRcv.setVisibility(View.GONE);
        } else {
            mEmptyView.setVisibility(View.GONE);
            mRcv.setVisibility(View.VISIBLE);
            initRecyclerView();
        }
    }

    private void initRecyclerView() {
        mAdapterReservation = new ReservationsAdapter(reservationsList, this);
        mLayoutManager = new LinearLayoutManager(this);
        mRcv.setLayoutManager(mLayoutManager);
        mRcv.setAdapter(mAdapterReservation);
    }

    private void initData() {
        try {
            reservationsList = reservationRepository.findAllByIdSalle(idSalle);
        } catch (Exception e) {
            Log.e("ReservationsActivity", e.getMessage());
        }
    }

    private void initExtras() {
        idSalle = getIntent().getLongExtra(ID_SALLE, 0);
    }

    private void initRepos() {
        reservationRepository = new ReservationRepository(this);
    }
}
