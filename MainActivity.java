package com.example.nfp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private EditText nameEntry;
    private EditText ageEntry;
    private Button changeActivityButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeActivityButton = findViewById(R.id.change_activity);
        nameEntry = findViewById(R.id.name_entry);
        ageEntry = findViewById(R.id.age_entry);

        changeActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = MainActivity.this;
                Class nextActivity = MainActivity2.class;
                Intent firstIntent = new Intent(context, nextActivity);
                startActivity(firstIntent);
                String message = "Ваши данные сохранены";
                Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}