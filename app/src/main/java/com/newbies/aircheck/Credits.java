package com.newbies.aircheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.Scanner;

public class Credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        final TextView textView = (TextView) findViewById(R.id.creditView);
        textView.setMovementMethod(new ScrollingMovementMethod());


        Runnable runnable = new Runnable() {
            String algo="Team Members\n\n"+
                    "Maliha Tashfia Islam\n" +
                    "Hosneara Ahmed\n" +
                    "Tanvir Shahriar Rifat\n" +
                    "Md.Fahim Arefin\n";
            @Override
            public void run() {

                String printer="";
                Scanner sc = new Scanner(algo);
                while(sc.hasNext()){
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    printer+=sc.nextLine()+"\n";
                    final String temp = printer;
                    textView.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(temp);
                        }
                    });
                }
            }
        };

        new Thread(runnable).start();

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}