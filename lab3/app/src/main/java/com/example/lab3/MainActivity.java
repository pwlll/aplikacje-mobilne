package com.example.lab3;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View; import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.lab3.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        Button btn1 = findViewById(R.id.bName);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SecondaryActivity.class);
                startActivity(intent);
            }
        });
        Button btn2 = findViewById(R.id.bAdres);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                EditText tempAdres=(EditText) findViewById(R.id.textUrl);
                Intent myIntent = new Intent(Intent.ACTION_VIEW,Uri.parse((tempAdres.getText().toString())));
                startActivity(myIntent);
            }
        });
        Button btn3 = findViewById(R.id.bGeo);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent myIntent = new Intent(MainActivity.this,ThirdActivity.class);
                startActivity(myIntent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

}