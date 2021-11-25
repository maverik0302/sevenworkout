package team7.vlu.sevenworkout;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class Ringtone extends Service {
    MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       mediaPlayer = MediaPlayer.create(this, R.raw.short_message_beep);
       mediaPlayer.start();
        return START_NOT_STICKY;
    }
}
