package com.linburgtech.synthesizer_linburg;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    private Button button1;
    private Button button2;
    private Button button3;
    private MediaPlayer mpE;
    private MediaPlayer mpF;
    private MediaPlayerThread mpt;
    private int[] notesarray = {R.raw.scalee, R.raw.scalefs, R.raw.scalegs, R.raw.scalea, R.raw.scaleb, R.raw.scalecs, R.raw.scaleds, R.raw.scalee};
    private int[] challenge5array = {R.raw.scalea, R.raw.scalea, R.raw.scalehighe, R.raw.scalehighe, R.raw.scalehighfs, R.raw. scalehighfs, R.raw.scalehighe, R.raw.scaled, R.raw.scaled, R.raw.scalecs, R.raw.scalecs, R.raw.scaleb, R.raw.scaleb, R.raw.scalea};
    private int[] challenge8Array = {700, 700, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600};
    private int [] challenge9array = {R.raw.scalehighe, R.raw.scalehighe, R.raw.scaled, R.raw.scaled, R.raw.scalecs, R.raw.scalecs, R.raw.scaleb};
    private CheckBox challenge11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        mpt = new MediaPlayerThread(MainActivity.this);
        challenge11 = (CheckBox) findViewById(R.id.checkBox);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  mpt.playNote(R.raw.scalea, 1000);
              //  mpt.playNote(R.raw.scaleb, 1000);
                for (int note : notesarray){
                    mpt.playNote(note, 500);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "Button 2 Clicked");
                for(int i=0; i<challenge5array.length; i++){
                    mpt.playNote(challenge5array[i],challenge8Array[i]);
                }

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "Button 3 Clicked");
                for (int i = 0; i < challenge5array.length; i++) {
                    mpt.playNote(challenge5array[i], challenge8Array[i]);
                    if (challenge11.isChecked()) {
                        for (int j = 0; j < challenge9array.length; j++) {
                            mpt.playNote(challenge5array[j], challenge8Array[j]);
                        }
                    }
                }
            }
        });

    }
}