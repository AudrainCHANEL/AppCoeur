package fr.audrain.appcoeur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MonAlimentation extends AppCompatActivity {
    private Person user;

    private CheckBox breakfast, vegetable, salt;
    private Spinner eatCustom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_alimentation);

        if (getIntent() != null) {
            Person qqn = getIntent().getParcelableExtra("profil");
            if (qqn != null) {
                this.user = qqn;
            }
        }

        breakfast = findViewById(R.id.checkBox);
        vegetable = findViewById(R.id.checkBox2);
        salt = findViewById(R.id.checkBox3);

        eatCustom = findViewById(R.id.spinner3);

        this.setValues();
    }


    public void go_back(View v) {
        Intent intent = new Intent(this, MonSuiviCardiaque.class);
        intent.putExtra("profil", this.user);
        startActivity(intent);
    }

    public void go_next (View v) {
        this.user.setBreakfast(breakfast.isChecked());
        this.user.setVegetable(vegetable.isChecked());
        this.user.setSalt(salt.isChecked());
        this.user.setEatCustom(EatCustom.values()[eatCustom.getSelectedItemPosition()]);

        Intent intent = new Intent(this, Bilan.class);
        intent.putExtra("profil", user);
        startActivity(intent);
        /**
         * Intent intent = new Intent(this, );
         * intent.putExtra("profil", this.user);
         * startActivity(intent);
         */
    }

    private void setValues () {
        this.breakfast.setChecked(this.user.isBreakfast());
        this.vegetable.setChecked(this.user.isVegetable());
        this.salt.setChecked(this.user.isSalt());

        this.eatCustom.setSelection(this.user.getEatCustom().ordinal());
    }
}
