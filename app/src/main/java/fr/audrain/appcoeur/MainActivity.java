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

        name = findViewById(R.id.PersonName);

        user = new Person();
    }
    
    public void launchTest(View v) {
        if (name.getText().toString().isEmpty()) {
            Toast.makeText(this, "Name field is empty.",Toast.LENGTH_SHORT).show();
        }
        else {
            user.setName(name.getText().toString());

            Intent intent = new Intent(this, JeSuis.class);
            intent.putExtra("acti1to2", user);
            Log.d("MainActivity : ", user.toString());
            startActivity(intent);
        }
    }
}