package fr.audrain.appcoeur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_je_suis);

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
            //On passe au sexe
            if (!man.isChecked() && !woman.isChecked() && !other.isChecked()) {
                Toast.makeText(this, "Select an answer for the sex field.",Toast.LENGTH_SHORT).show();
            }
            else {
                //TODO sexe
                if (man.isChecked()) {
                    //Un homme
                }
                else if (woman.isChecked()) {
                    //Une femme
                }
                else {
                    //Autre
                }
                Intent intent = new Intent(this, MonCoeur.class);
                //TODO transfert de données
                startActivity(intent);
            }
        }
    }


}