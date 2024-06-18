package com.example.projetreservationsallereunion.data.modules.salles;

import static com.example.projetreservationsallereunion.utils.Constants.ID_SALLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetreservationsallereunion.R;
import com.example.projetreservationsallereunion.data.models.Reservation;
import com.example.projetreservationsallereunion.data.models.Salle;
import com.example.projetreservationsallereunion.data.repos.SalleRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SallesActivity extends AppCompatActivity {

    @BindView(R.id.btn_add)
    FloatingActionButton mBtnAdd;

    @BindView(R.id.rcv_salles)
    RecyclerView mRcv;

    @BindView(R.id.empty_view)
    ConstraintLayout mEmptyView;


    SalleRepository mSalleRepo;

    SallesAdapter mAdapterSalles;
    RecyclerView.LayoutManager mLayoutManager;

    List<Salle> sallesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_salles);
        ButterKnife.bind(this);

        initRepos();
        initData();
        initViews();
        handleClicks();
        initRecyclerView();
    }

    private void initViews() {
        if (sallesList.isEmpty()) {
            mEmptyView.setVisibility(View.VISIBLE);
            mRcv.setVisibility(View.GONE);
        } else {
            mEmptyView.setVisibility(View.GONE);
            mRcv.setVisibility(View.VISIBLE);
            initRecyclerView();
        }
    }

    private void initData() {
        sallesList = mSalleRepo.findAll();
    }

    private void initRepos() {
        mSalleRepo = new SalleRepository(getApplicationContext());
    }

    private void initRecyclerView() {
        mAdapterSalles = new SallesAdapter(sallesList, this);
        mLayoutManager = new LinearLayoutManager(this);
        mRcv.setLayoutManager(mLayoutManager);
        mRcv.setAdapter(mAdapterSalles);
    }

    private void updateRecycler(ArrayList<Salle> sallesList){
        mAdapterSalles.changeDataSource(sallesList);
    }

    private void handleClicks() {
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callPopUpAddSalle();
            }
        });
    }

    private void callPopUpAddSalle() {
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.pop_up_add_salle, null);
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(false);
        final AlertDialog alertDialog = dialogBuilder.create();

        EditText mEdtLabel = dialogView.findViewById(R.id.edt_label);
        Button mBtnSave = dialogView.findViewById(R.id.btn_add_salle);

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEdtLabel.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Veuillez rédiger le label de votre salle", Toast.LENGTH_LONG).show();
                } else {
                    Salle salle = new Salle();
                    salle.setId(System.currentTimeMillis());
                    salle.setLibelle(mEdtLabel.getText().toString());

                    mSalleRepo.insert(salle);
                    sallesList.add(salle);
                    updateRecycler((ArrayList<Salle>) sallesList);
                    alertDialog.dismiss();
                }

            }
        });

        alertDialog.show();
    }

    public void startActivityReservations(Long idSalle) {
        Intent intentReservations = new Intent(this, Reservation.class);
        intentReservations.putExtra(ID_SALLE, idSalle);
        startActivity(intentReservations);
    }
}
