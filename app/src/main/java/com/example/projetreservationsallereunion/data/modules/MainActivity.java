package com.example.projetreservationsallereunion.data.modules;

import static com.example.projetreservationsallereunion.utils.Constants.IS_ADMIN;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.projetreservationsallereunion.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.const_admin)
    ConstraintLayout mConstAdmin;

    @BindView(R.id.const_user)
    ConstraintLayout mConstUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        handleClicks();
    }

    private void handleClicks() {
        mConstAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSalles = new Intent(getApplicationContext(), SallesActivity.class);
                intentSalles.putExtra(IS_ADMIN, true);
                startActivity(intentSalles);
            }
        });
        mConstUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSalles = new Intent(getApplicationContext(), SallesActivity.class);
                intentSalles.putExtra(IS_ADMIN, false);
                startActivity(intentSalles);
            }
        });
    }
}