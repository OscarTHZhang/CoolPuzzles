package com.example.shihaochen.coolpuzzles;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.support.v7.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.widget.Toast;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onClick2(View view)
    {
        AlertDialog.Builder builder = new Builder(this);
        builder.setTitle("Tutorial");
        builder.setMessage("1. Upload your picture!\n2. Start!\n3. Put all fragments together!");
        builder.setPositiveButton("Got it!", new OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(MainActivity.this, "Now start!", Toast.LENGTH_SHORT).show();

            }
        });
        AlertDialog b=builder.create();
        b.show();
    }

    public void onClick3(View view){
        final EditText et = new EditText(this);
        new AlertDialog.Builder(this).setTitle("Please enter the number of pieces (a perfect square number) you would like to spilt: ")
                .setView(et)
                .setPositiveButton("Finished", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).setNegativeButton("Cancel",null).show();
    }

}
