package team7.vlu.sevenworkout;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import team7.vlu.sevenworkout.ui.MainActivity;

public class PushNotifycationService extends FirebaseMessagingService {

    public static int NOTIFICATION_ID = 1;
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {

        generateNotification(remoteMessage.getNotification().getBody(),remoteMessage.getNotification().getTitle());



       /* remoteMessage.getNotification().getTitle();
        String title = remoteMessage.getNotification().getTitle();
        String text = remoteMessage.getNotification().getBody();
        final String CHANEL_ID = "HEADS_UP_NOTIFICATION";
        NotificationChannel channel = new NotificationChannel(
                CHANEL_ID,
                "Heads Up Notification",
                NotificationManager.IMPORTANCE_HIGH
        );

        getSystemService(NotificationManager.class).createNotificationChannel(channel);
        Notification.Builder notification = new Notification.Builder(this, CHANEL_ID)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(R.drawable.ic_fintness)
                .setAutoCancel(true);

        NotificationManagerCompat.from(this).notify(1, notification.build());

        super.onMessageReceived(remoteMessage);*/
    }

    private void generateNotification(String body, String title) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri sounduri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBulder = new NotificationCompat.Builder(this)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.drawable.ic_fintness)
                .setAutoCancel(true)
                .setSound(sounduri)
                .setContentIntent(pendingIntent);


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if(NOTIFICATION_ID > 1073741824){
            NOTIFICATION_ID = 0;
        }

        notificationManager.notify(NOTIFICATION_ID++, notificationBulder.build());


    }
}
