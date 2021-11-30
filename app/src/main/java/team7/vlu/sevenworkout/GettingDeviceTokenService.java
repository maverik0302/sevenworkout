package team7.vlu.sevenworkout;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class GettingDeviceTokenService extends FirebaseMessagingService {
    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        getSharedPreferences("_", MODE_PRIVATE).edit().putString("fb", s).apply();
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
    }

    public static String getToken(Context    context) {
        return context.getSharedPreferences("_", MODE_PRIVATE).getString("fb", "empty");
    }
}