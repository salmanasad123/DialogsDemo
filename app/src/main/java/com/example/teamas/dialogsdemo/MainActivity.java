package com.example.teamas.dialogsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FireMissilesDialog.DialogInteraction {

    private Button button;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.fire_missiles);
        button1 = findViewById(R.id.show_custom_dialog);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FireMissilesDialog fireMissilesDialog = new FireMissilesDialog();
                fireMissilesDialog.show(getSupportFragmentManager(), "AlertDialog");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogWithCustomLayout customLayout = new DialogWithCustomLayout();
                customLayout.show(getSupportFragmentManager(), "CustomDialog");
            }
        });

    }

    @Override
    public void onDialogPositiveClick(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDialogNegativeClick(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
}
