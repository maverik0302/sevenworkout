package team7.vlu.sevenworkout;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import team7.vlu.sevenworkout.ui.MainActivity;

public class WeeklyAdapter extends RecyclerView.Adapter<WeeklyAdapter.WeeklyViewHolder>{

    private final Context mWContext;
    private List<Daily> listWeekly;

    public WeeklyAdapter(Context mWContext, List<Daily> listWeekly) {
        this.mWContext = mWContext;
        this.listWeekly = listWeekly;
    }

    @NonNull
    @Override
    public WeeklyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View w = LayoutInflater.from(mWContext).inflate(R.layout.item_days, parent, false);
        WeeklyViewHolder weeklyViewHolder= new WeeklyViewHolder(w);
        return weeklyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeeklyViewHolder wholder, int position) {

        final Daily daily = listWeekly.get(position);
        if(daily == null){
            return;
        }

        wholder.number.setText(listWeekly.get(position).getNumber());
        wholder.textnumber.setText(listWeekly.get(position).getTextNumber());

        //create Listener days
        //Remembertochange
        wholder.wCarview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent;
                switch (wholder.getAdapterPosition()){
                    case 0:
                        intent =  new Intent(mWContext, beginnerActivity.class);
                        break;

                    case 1:
                        intent =  new Intent(mWContext, intermediateActivity.class);
                        break;
                    case 2:
                        intent =  new Intent(mWContext, AdvancedActivity.class);
                        break;
                    default:
                        intent =  new Intent(mWContext, MainActivity.class);
                        break;
                }
                mWContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listWeekly.size();
    }


    public static class WeeklyViewHolder extends RecyclerView.ViewHolder{
        private TextView number;
        private TextView textnumber;

        //cardview
        final private CardView wCarview;
        private LinearLayout wLinearLayout;

        //context
        final Context wContext;
        public WeeklyViewHolder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.numberdays);
            textnumber = itemView.findViewById(R.id.textDays);
            wContext = itemView.getContext();

            wCarview = itemView.findViewById(R.id.item_days);
        }
    }
}
