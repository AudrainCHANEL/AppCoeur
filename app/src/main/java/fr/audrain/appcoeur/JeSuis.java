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

        user = getIntent().getExtras().getParcelable("acti1to2");
        Log.d("Second Activity : ", user.toString());

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

    }

    public void go_back(View v) {
        finish();
    }

    //Toast.makeText(this, "Name field is empty.",Toast.LENGTH_SHORT).show();
    public void go_next(View v) {
        //Age vide
        if (age.getProgress() == 0) {
            Toast.makeText(this, "Age is incoherent.",Toast.LENGTH_SHORT).show();
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
                intent.putExtra("acti2to3", user);
                startActivity(intent);
            }
        }
    }


}