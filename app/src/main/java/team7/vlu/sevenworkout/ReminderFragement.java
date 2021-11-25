package team7.vlu.sevenworkout;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.Calendar;
import java.util.Date;

import team7.vlu.sevenworkout.databinding.FragmentReminderBinding;

public class ReminderFragement extends Fragment {

    private ReminderViewModel reminderViewModel;
    private TextView textTime1, textTime2;
    private SwitchCompat iSwitch1, iSwitch2;
    private TimePickerDialog.OnTimeSetListener timeSetListener;
    private FragmentReminderBinding binding;
    private AlarmManager alarmManager;

    public static final String MY_PREPS = "preps";
    public static final String TEXT = "text";
    public String textPrep;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        reminderViewModel = new ViewModelProvider(this).get(ReminderViewModel.class);

        binding = FragmentReminderBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        textTime1 = (TextView) root.findViewById(R.id.texttimereimnider);
        iSwitch1 = (SwitchCompat) root.findViewById(R.id.switch_alarm1);

        SharedPreferences settings = root.getContext().getSharedPreferences(MY_PREPS, 0);
        boolean switchStatus = settings.getBoolean("switchkey", false);

        iSwitch1.setChecked(switchStatus);


        alarmManager = (AlarmManager) root.getContext().getSystemService(Context.ALARM_SERVICE);



        iSwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)  {
                    Calendar calendar = Calendar.getInstance();
                    int hour = calendar.get(Calendar.HOUR_OF_DAY);
                    int minute = calendar.get(Calendar.MINUTE);

                    TimePickerDialog dialog = new TimePickerDialog(root.getContext(),
                            timeSetListener, hour, minute, DateFormat.is24HourFormat(root.getContext()));
                    dialog.show();
                    startAlarm(calendar);

                    //saveData

                } else {
                    cancelAlarm();


                }
                SharedPreferences settings = root.getContext().getSharedPreferences(MY_PREPS, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString(TEXT, textTime1.getText().toString());
                editor.putBoolean("switchkey", isChecked);
                editor.commit();
                //shared Preferences

                
            }

            private void updateView() {
            }

            private void startAlarm(Calendar calendar) {
                AlarmManager alarmManager = (AlarmManager) root.getContext().getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(root.getContext(), AlarmReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(root.getContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            }

            private void cancelAlarm() {
                AlarmManager alarmManager = (AlarmManager) root.getContext().getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(root.getContext(), AlarmReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(root.getContext(), 1, intent, 0);
                alarmManager.cancel(pendingIntent);

            }
        });


        timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                String am_pm = (hourOfDay < 12) ? "AM" : "PM";
                String timeText = hourOfDay + ":" + minute + " " + am_pm;
                textTime1.setText(timeText);



                updateView();



            }

            private void updateView() {
                SharedPreferences settings = root.getContext().getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString(TEXT, textTime1.getText().toString());
                editor.commit();
            }


        };
        return root;
    }


}