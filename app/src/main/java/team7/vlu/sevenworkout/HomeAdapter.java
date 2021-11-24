package team7.vlu.sevenworkout;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import team7.vlu.sevenworkout.ui.MainActivity;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private final Context mContext;
    private List<Type> mData;

    public HomeAdapter(Context mContext, List<Type> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_type, parent, false);
        MyViewHolder vHolder = new MyViewHolder(view);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //
        final Type type = mData.get(position);
        if(type == null){
            return;
        }


        holder.txtBanner.setText(mData.get(position).getName());
        holder.imgBanner.setImageResource(mData.get(position).getPhoto());
        //listenner
        holder.imgBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent;
                switch (holder.getAdapterPosition()){
                    case 0:
                        intent =  new Intent(mContext, DetailActivity.class);
                        break;

                    case 1:
                        intent =  new Intent(mContext, intermediateActivity.class);
                        break;
                    case 2:
                        intent =  new Intent(mContext, AdvancedActivity.class);
                        break;
                    default:
                        intent =  new Intent(mContext, MainActivity.class);
                        break;
                }
                mContext.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView txtBanner;
        private ImageView imgBanner;
        LinearLayout mainLayout;
        //khai bao cardview
        CardView cardView;
        //stackOverflow
        final Context context;
        //ClickItem
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtBanner = itemView.findViewById(R.id.text_type);
            imgBanner = itemView.findViewById(R.id.imgType);
            context = itemView.getContext();
            //findIDcardview
            cardView = (CardView) itemView.findViewById(R.id.type_item);
            mainLayout = (LinearLayout) itemView.findViewById(R.id.linear_item);

        }

    }

}
