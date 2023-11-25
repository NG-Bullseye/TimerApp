package com.example.myapplication;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity  {
    private TextView textView;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Calendar c = Calendar.getInstance();
        System.out.println("Erst "+c.getTime()+" Uhr");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm:ss");
        String formattedDate = simpleDateFormat.format(c.getTime());
        Toast.makeText(this,formattedDate, Toast.LENGTH_SHORT).show();
        this.textView =new TextView(this);
        textView.setText("Current Time: "+formattedDate);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
        setContentView(textView);

        Thread thread1 = null;
        Runnable runnable=new CountDownRunner();
        thread1 = new Thread(runnable);
        thread1.start();

    }

    public void doWork(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try{
                    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm:ss");
                    String formattedDate = simpleDateFormat.format(Calendar.getInstance().getTime());
                    textView.setText("Current Time: "+formattedDate);
                    setContentView(textView);

                } catch (Exception e) {

                }
            }
        });
    }

    class CountDownRunner implements Runnable{
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                try {
                    doWork();
                    Thread.sleep(1000);
                }catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }catch (Exception e){
                }
            }
        }
    }
}
