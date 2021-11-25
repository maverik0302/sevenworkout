package team7.vlu.sevenworkout;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "team7")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Giờ tập đến rồi! <3")
                .setContentText("Hãy trở lại tập luyện nào")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        //NotificationManagerCompat notificationManagerCompat = new NotificationManagerCompat.from(context);
        //notificationManagerCompat.notify(200, builder());

        Intent ringtone = new Intent(context, Ringtone.class);
        context.startService(ringtone);




    }
}
