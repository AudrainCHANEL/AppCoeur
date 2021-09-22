package fr.audrain.appcoeur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class JeSuis extends AppCompatActivity {
    private SeekBar age;
    private RadioButton man, woman, other;
    private TextView displayAge;

    private Person user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_je_suis);

        if (getIntent() != null) {
            Person user = getIntent().getParcelableExtra("profil");
            if (user != null) {
                this.user = user;
            }
            else {
                Log.d("JE SUIS ACTIVITY :", "user is null");
            }
        }
        else {
            Log.d("JE SUIS ACTIVITY :", "bundle is null");
        }

        age = findViewById(R.id.seekBar2);
        man = findViewById(R.id.radioButton2);
        woman = findViewById(R.id.radioButton4);
        other = findViewById(R.id.radioButton3);
        displayAge = findViewById(R.id.textView3);

        age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                displayAge.setText("Your Age : "+String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        setValues();
    }

    public void go_back(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("profil", user);
        startActivity(intent);
    }

    //Toast.makeText(this, "Name field is empty.",Toast.LENGTH_SHORT).show();
    public void go_next(View v) {
        //Age vide
        if (age.getProgress() == 0) {
            Toast.makeText(this, "Age is not coherent.",Toast.LENGTH_SHORT).show();
        }
        else {
            user.setAge(age.getProgress());
            //On passe au sexe
            if (!man.isChecked() && !woman.isChecked() && !other.isChecked()) {
                Toast.makeText(this, "Select an answer for the sex field.",Toast.LENGTH_SHORT).show();
            }
            else {
                if (man.isChecked()) {
                    user.setSexe(Sexe.HOMME);
                }
                else if (woman.isChecked()) {
                    user.setSexe(Sexe.FEMME);
                }
                else {
                    user.setSexe(Sexe.AUTRE);
                }

                Intent intent = new Intent(this, MonCoeur.class);
                intent.putExtra("profil", user);
                startActivity(intent);
            }
        }
    }

    public void setValues() {
        age.setProgress(user.getAge());

        if (user.getSexe() != Sexe.UNDEFINED) {
            if (user.getSexe() == Sexe.HOMME) {
                man.setChecked(true);
            }
            else if (user.getSexe() == Sexe.FEMME) {
                woman.setChecked(true);
            }
            else {
                other.setChecked(true);
            }
        }
    }
}