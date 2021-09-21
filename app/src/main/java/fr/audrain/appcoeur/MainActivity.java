package fr.audrain.appcoeur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name.findViewById(R.id.PersonName);
    }
    
    public void launchTest(View v) {
        if (name.getText().toString().isEmpty()) {
            Toast.makeText(this, "Name field is empty.",Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, JeSuis.class);
            //TODO transfert de données + Création Objet Person
            startActivity(intent);
        }
    }
}