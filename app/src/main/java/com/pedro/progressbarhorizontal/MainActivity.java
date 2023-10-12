package com.pedro.progressbarhorizontal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int progress = 0;
    ProgressBar simpleProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleProgressBar = (ProgressBar) findViewById(R.id.simpleprogressbar);
        Button btniniciar = (Button) findViewById(R.id.btn_iniciar);
        btniniciar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ){
                setProgressValue(progress);
            }
        });
    }
    private void setProgressValue (final int progress){
        simpleProgressBar.setProgress(progress);
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run(){
                try {

                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                setProgressValue(progress + 10);
            }

        });
        thread.start();
    }
}
