package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button ko;
    private Button papir;
    private Button ollo;
    private ImageView kep_jatekos;
    private ImageView kep_gep;
    private Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ko = findViewById(R.id.ko);
        papir = findViewById(R.id.papir);
        ollo = findViewById(R.id.ollo);
        kep_jatekos = findViewById(R.id.kep_jatekos);
        kep_gep = findViewById(R.id.kep_gep);
        rand = new Random();


        ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kep_jatekos.setImageResource(R.drawable.rock);
                gepValaszt();
            }
        });

        papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kep_jatekos.setImageResource(R.drawable.paper);
                gepValaszt();
            }
        });
        ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kep_jatekos.setImageResource(R.drawable.scissors);
                gepValaszt();
            }
        });

    }
    public void gepValaszt()
    {
        int gepValaszt=rand.nextInt(3);
        //nemjo
        switch (gepValaszt)
        {
            case 0:
                kep_gep.setImageResource(R.drawable.rock);
                break;
            case 1:
                kep_gep.setImageResource(R.drawable.paper);
                break;
            case 2:
                kep_gep.setImageResource(R.drawable.scissors);
                break;
        }
    }
}