package team7.vlu.sevenworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class DetailActivity extends AppCompatActivity {

    private TextView timeText;
    private SeekBar seekBar;
    private Button start;
    private Boolean counterisActive = false;
    private CountDownTimer countDownTimer;
    private MediaPlayer backgroudMusic;

    public void resetTimer(){
        timeText.setText("00:20");
        seekBar.setProgress(20);
        seekBar.setEnabled(true);
        countDownTimer.cancel();
        start.setText("START");
        counterisActive = false;
    }

    public void buttonCliked(View view){
        if(counterisActive){
            resetTimer();
        }else {
            backgroudMusic = MediaPlayer.create(getApplicationContext(), R.raw.ex_background);
            backgroudMusic.start();

            counterisActive = true;
            seekBar.setEnabled(false);

            countDownTimer = new CountDownTimer(seekBar.getProgress() * 1000 + 100, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    updateTimer((int) millisUntilFinished/1000);
                }

                @Override
                public void onFinish() {
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.endex);
                    mediaPlayer.start();
                    resetTimer();

                    backgroudMusic.stop();



                }
            }.start();
        }
    }

    public void updateTimer(int secondsleft){
        int minutes = secondsleft / 60;
        int seconds = secondsleft - (minutes * 60);
        String secondString = Integer.toString(seconds);
        if (seconds <= 9){
            secondString = "0" + secondString;
        }
        timeText.setText(Integer.toString(minutes) + ":" + secondString);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }

        Exercise exercise = (Exercise) bundle.get("object_user");
        TextView tvNameUser = findViewById(R.id.tv_name_user);
        tvNameUser.setText(exercise.getName());

        GifImageView gifImageView = findViewById(R.id.img_gif);
        gifImageView.setImageResource(exercise.getResourceId());
        tvNameUser.setText(exercise.getName());

        //CountDown
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        timeText = (TextView) findViewById(R.id.txtime);
        start = (Button) findViewById(R.id.button);
        seekBar.setMax(60*25);
        seekBar.setProgress(20);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (backgroudMusic.isPlaying() == true){
            backgroudMusic.stop();
        }
        super.onBackPressed();
    }
}