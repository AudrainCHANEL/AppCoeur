package fr.audrain.appcoeur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Switch;

public class MonCoeur extends AppCompatActivity {
    private Switch heart_condition, diabetic, cholesterol, hypertension, imc;
    private Spinner avc;

    private Person user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_coeur);

        if (getIntent() != null) {
            Person qqn = getIntent().getParcelableExtra("profil");
            if (qqn != null) {
                user = qqn;
            }
        }

        heart_condition = findViewById(R.id.switch1);
        diabetic = findViewById(R.id.switch2);
        cholesterol = findViewById(R.id.switch3);
        hypertension = findViewById(R.id.switch5);
        imc = findViewById(R.id.switch4);

        avc = findViewById(R.id.spinner);

        this.setValues();
    }

    public void go_next (View v) {
        user.setHeart_condition(heart_condition.isChecked());
        user.setDiabetic(diabetic.isChecked());
        user.setCholesterol(cholesterol.isChecked());
        user.setHypertension(hypertension.isChecked());
        user.setImc(imc.isChecked());

        user.setAvc(YesNoMaybe.values()[avc.getSelectedItemPosition()]);

        //Intent intent = new Intent(this, );

    }

    public void go_back(View v) {
        Intent intent = new Intent(this, JeSuis.class);
        intent.putExtra("profil", user);
        startActivity(intent);
    }

    public void setValues() {
        heart_condition.setChecked(user.isHeart_condition());
        diabetic.setChecked(user.isDiabetic());
        cholesterol.setChecked(user.isCholesterol());
        hypertension.setChecked(user.isHypertension());
        imc.setChecked(user.isImc());

        avc.setSelection(user.getAvc().ordinal());
    }
}