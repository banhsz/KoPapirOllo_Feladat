package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity  {

    //gombok
    private Button ko;
    private Button papir;
    private Button ollo;
    //kepek
    private ImageView kep_jatekos;
    private ImageView kep_gep;
    private ImageView gep_heart_1;
    private ImageView gep_heart_2;
    private ImageView gep_heart_3;
    private ImageView jatekos_heart_1;
    private ImageView jatekos_heart_2;
    private ImageView jatekos_heart_3;
    //text
    private TextView text_dontetlen;
    //egyéb
    private Random rand;
    private int dontetlen;
    private Toast toast;
    private int jatekosElet;
    private int gepElet;
    //alert
    private AlertDialog alertDialog;
    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kep_jatekos.setImageResource(R.drawable.rock);
                int gep = gepValaszt();
                switch (gep){
                    case 0:
                        //döntetlen kő-kő
                        toast.makeText(MainActivity.this,String.format("Döntetlen kör."),Toast.LENGTH_SHORT).show();
                        dontetlen++;
                        text_dontetlen.setText(String.format("Döntetlenek száma: %d",dontetlen));
                        break;
                    case 1:
                        //jatekos:kő, gép: papir gép nyer
                        toast.makeText(MainActivity.this,String.format("Gép nyerte a kört."),Toast.LENGTH_SHORT).show();
                        JatekosSebzodik();
                        break;
                    case 2:
                        //játékos kő, gép olló, játékos nyer
                        toast.makeText(MainActivity.this,String.format("Játékos nyerte a kört."),Toast.LENGTH_SHORT).show();
                        GepSebzodik();
                        break;
                    default:
                        break;
                }
            }
        });

        papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kep_jatekos.setImageResource(R.drawable.paper);
                int gep = gepValaszt();
                switch (gep){
                    case 0:
                        //papir-kő jatekos nyer
                        toast.makeText(MainActivity.this,String.format("Játékos nyerte a kört."),Toast.LENGTH_SHORT).show();
                        GepSebzodik();
                        break;
                    case 1:
                        //jatekos: papir papir dontetlen
                        toast.makeText(MainActivity.this,String.format("Döntetlen kör."),Toast.LENGTH_SHORT).show();
                        dontetlen++;
                        text_dontetlen.setText(String.format("Döntetlenek száma: %d",dontetlen));
                        break;
                    case 2:
                        //játékos papir, gép olló, gép nyer
                        toast.makeText(MainActivity.this,String.format("Gép nyerte a kört."),Toast.LENGTH_SHORT).show();
                        JatekosSebzodik();
                        break;
                    default:
                        break;
                }
            }
        });
        ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kep_jatekos.setImageResource(R.drawable.scissors);
                int gep = gepValaszt();
                switch (gep){
                    case 0:
                        //ollo-kő gép nyer
                        toast.makeText(MainActivity.this,String.format("Gép nyerte a kört."),Toast.LENGTH_SHORT).show();
                        JatekosSebzodik();
                        break;
                    case 1:
                        //jatekos: ollo papir jatekos nyer
                        text_dontetlen.setText(String.format("Döntetlenek száma: %d",dontetlen));
                        toast.makeText(MainActivity.this,String.format("Játékos nyerte a kört."),Toast.LENGTH_SHORT).show();
                        GepSebzodik();
                        break;
                    case 2:
                        //olló- olló dontetlen
                        toast.makeText(MainActivity.this,String.format("Döntetlen kör."),Toast.LENGTH_SHORT).show();
                        dontetlen++;
                        break;
                    default:
                        break;
                }
            }
        });

    }

    public int gepValaszt() {
        int gepValaszt=rand.nextInt(3);
        switch (gepValaszt)
        {
            case 0:
                kep_gep.setImageResource(R.drawable.rock);
                return 0;
            case 1:
                kep_gep.setImageResource(R.drawable.paper);
                return 1;
            case 2:
                kep_gep.setImageResource(R.drawable.scissors);
                return 2;
            default:
                return 0;
        }
    }
    public void init() {
        //ko-papir-ollo gombok
        ko = findViewById(R.id.ko);
        papir = findViewById(R.id.papir);
        ollo = findViewById(R.id.ollo);
        //kepek
        kep_jatekos = findViewById(R.id.kep_jatekos);
        kep_gep = findViewById(R.id.kep_gep);
        //text
        text_dontetlen = findViewById(R.id.text_dontetlen);
        text_dontetlen.setText("Döntetlenek száma: 0");
        //egyeb
        rand = new Random();
        dontetlen = 0;
        jatekosElet = 3;
        gepElet = 3;
        gep_heart_1 = findViewById(R.id.gep_heart_1);
        gep_heart_1.setImageResource(R.drawable.heart2);
        gep_heart_2 = findViewById(R.id.gep_heart_2);
        gep_heart_2.setImageResource(R.drawable.heart2);
        gep_heart_3 = findViewById(R.id.gep_heart_3);
        gep_heart_3.setImageResource(R.drawable.heart2);
        jatekos_heart_1 = findViewById(R.id.jatekos_heart_1);
        jatekos_heart_1.setImageResource(R.drawable.heart2);
        jatekos_heart_2 = findViewById(R.id.jatekos_heart_2);
        jatekos_heart_2.setImageResource(R.drawable.heart2);
        jatekos_heart_3 = findViewById(R.id.jatekos_heart_3);
        jatekos_heart_3.setImageResource(R.drawable.heart2);
    }
    public void JatekosSebzodik()
    {
        switch (jatekosElet)
        {
            case 3:
                jatekosElet--;
                jatekos_heart_3.setImageResource(R.drawable.heart1);
                break;
            case 2:
                jatekosElet--;
                jatekos_heart_2.setImageResource(R.drawable.heart1);
                break;
            case 1:
                jatekosElet--;
                jatekos_heart_1.setImageResource(R.drawable.heart1);
                //gép nyert
                AlertHandle();
                break;
            default:
                break;

        }
    }
    public void GepSebzodik()
    {
        switch (gepElet)
        {
            case 3:
                gepElet--;
                gep_heart_3.setImageResource(R.drawable.heart1);
                break;
            case 2:
                gepElet--;
                gep_heart_2.setImageResource(R.drawable.heart1);
                break;
            case 1:
                gepElet--;
                gep_heart_1.setImageResource(R.drawable.heart1);
                //jatekos nyert
                AlertHandle();
                break;
            default:
                break;

        }
    }
    public void AlertHandle() {
        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        String eredmeny;
        if (jatekosElet==0)
        {
             eredmeny = "Vesztettél.";
        }
        else
        {
             eredmeny = "Nyertél!";
        }
        alertDialogBuilder.setMessage(eredmeny+" Szeretnél uj játékot?")
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        init();
                    }
                })
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //kilépés
                        //alkalmazás bezárása (activity)
                        finish();
                    }
                })
                .setTitle("Játék vége")
                .setCancelable(false);
        alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}