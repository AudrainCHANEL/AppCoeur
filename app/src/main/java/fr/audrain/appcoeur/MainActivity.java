package fr.audrain.appcoeur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private Person user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent() != null) {
            Person user = getIntent().getParcelableExtra("profil");
            if (user != null) {
                this.user = user;
            }
            else {
                this.user = new Person();
            }
        }
        else {
            this.user = new Person();
        }

        name = findViewById(R.id.PersonName);
        this.setValues();
    }
    
    public void launchTest(View v) {
        if (name.getText().toString().isEmpty()) {
            Toast.makeText(this, "Name field is empty.",Toast.LENGTH_SHORT).show();
        }
        else {
            user.setName(name.getText().toString());

            Intent intent = new Intent(this, JeSuis.class);
            intent.putExtra("profil", user);
            startActivity(intent);
        }
    }

    public void setValues() {
        name.setText(this.user.getName());
    }
}