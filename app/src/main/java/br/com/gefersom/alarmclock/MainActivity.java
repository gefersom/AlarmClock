package br.com.gefersom.alarmclock;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private SimpleDateFormat simpleDateFormat;
    private TextView textView;
    private Handler handler;
    private Runnable timeRunnable;
    private Date date;

    public MainActivity(){
        this.handler = new Handler();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textView = (TextView) findViewById(R.id.textView);
        this.simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        this.date = new Date();

        this.timeRunnable = new Runnable() {
            @Override
            public void run() {
                textView.setText(getTime());
                handler.postDelayed(timeRunnable, 1000);
            }
        };

        handler.post(this.timeRunnable);
    }

    public String getTime(){
        this.date.setTime(System.currentTimeMillis());
        return simpleDateFormat.format(this.date);
    }
}
