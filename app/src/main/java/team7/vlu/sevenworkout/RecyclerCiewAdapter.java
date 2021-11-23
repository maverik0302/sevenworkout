package team7.vlu.sevenworkout;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import team7.vlu.sevenworkout.ui.MainActivity;

public class RecyclerCiewAdapter extends RecyclerView.Adapter<RecyclerCiewAdapter.MyViewHolder> {
    private Context mContext;
    private List<Type> mData;

    public RecyclerCiewAdapter(Context mContext, List<Type> mData) {
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
                Intent intent = new Intent(mContext, ListPractice.class);
                mContext.startActivity(intent);
                Log.d(TAG, "onClick: ");
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
