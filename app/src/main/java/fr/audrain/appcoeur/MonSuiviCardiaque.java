package fr.audrain.appcoeur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MonSuiviCardiaque extends AppCompatActivity {
    private Person user;

    private Spinner cardioRisk;
    private ToggleButton checkup, seeCardio;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_suivi_cardiaque);

        if (getIntent() != null) {
            Person qqn = getIntent().getParcelableExtra("profil");
            if (qqn != null) {
                this.user = qqn;
            }
        }

        cardioRisk = findViewById(R.id.spinner2);
        checkup = findViewById(R.id.toggleButton);
        seeCardio = findViewById(R.id.toggleButton2);

        setValues();
    }

    public void go_back(View v) {
        Intent intent = new Intent(this, MonCoeur.class);
        intent.putExtra("profil", user);
        startActivity(intent);
    }

    public void go_next(View v) {
        user.setCardioRisk(YesNoMaybe.values()[cardioRisk.getSelectedItemPosition()]);
        user.setCheckup(checkup.getText() == checkup.getTextOn());
        user.setSeeCardio(seeCardio.getText() == seeCardio.getTextOn());

        Intent intent = new Intent(this, MonAlimentation.class);
        intent.putExtra("profil", user);
        startActivity(intent);
    }

    private void setValues() {
        cardioRisk.setSelection(user.getCardioRisk().ordinal());

        if (user.isCheckup()) {
            checkup.setText(checkup.getTextOn());
        }
        else {
            checkup.setText(checkup.getTextOff());
        }

        if (user.isSeeCardio()) {
            seeCardio.setText(seeCardio.getTextOn());
        }
        else {
            seeCardio.setText(seeCardio.getTextOff());
        }
    }
}
