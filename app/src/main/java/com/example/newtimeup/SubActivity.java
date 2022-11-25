package com.example.newtimeup;

//package your.package.name;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class SubActivity extends AppCompatActivity {


    private SoundPool soundPool;
    private int Soundhuurin;
    private Timer timer;
    // 'Handler()' is deprecated as of API 30: Android 11.0 (R)
    private final Handler handler = new Handler(Looper.getMainLooper());

    private TextView timerText;
    public static int count;
    private long delay, period;
    private int re;
    public int porocount;



    private final SimpleDateFormat dataFormat =
            new SimpleDateFormat("mm:ss.S", Locale.US);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_activity);
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                // USAGE_MEDIA
                // USAGE_GAME
                .setUsage(AudioAttributes.USAGE_GAME)
                // CONTENT_TYPE_MUSIC
                // CONTENT_TYPE_SPEECH, etc.
                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                .build();

        soundPool = new SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                // ストリーム数に応じて
                .setMaxStreams(1)
                .build();
        Soundhuurin = soundPool.load(this, R.raw.one, 1);
        soundPool.setOnLoadCompleteListener((soundPool, sampleId, status) -> {
            Log.d("debug", "sampleId=" + sampleId);
            Log.d("debug", "status=" + status);
        });


        delay = 0;
        period = 100;

        Button startButton = findViewById(R.id.start_button);
        Button finishButton = findViewById(R.id.finish_button);


        timerText = findViewById(R.id.timer);
        timerText.setText(dataFormat.format(0));

        startButton.setOnClickListener(v -> {
            if (null != timer) {
                timer.cancel();
                timer = null;
            }

            // Timer インスタンスを生成
            timer = new Timer();

            // カウンター
            count = 0;
            re = 0;
            porocount = 0;
            timerText.setText(dataFormat.format(0));

            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    // handlerdを使って処理をキューイングする
                    handler.post(() -> {
                        count++;
                        porocount++;
                        timerText.setText(dataFormat.
                                format(count * period));
                        if (porocount == 3000)//10ms*60*5 5分の時のcountの値
                        {
                            poromodetime();
                        }

                    });

                }

                public void poromodetime() {
                    soundPool.play(Soundhuurin, 1.0f, 1.0f, 1, 0, 1);
                }
            }, delay, period);


        });


        finishButton.setOnClickListener(v -> {
            if (porocount >= 3000) {
                finish();
                if (null != timer) {
                    // Cancel
                    timer.cancel();
                    timer = null;
                    timerText.setText(dataFormat.format(0));

                }
            }
        });


    }
}
