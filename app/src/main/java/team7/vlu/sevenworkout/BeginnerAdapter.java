package team7.vlu.sevenworkout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import team7.vlu.sevenworkout.phong_interface.IClickItemUserListener;

public class BeginnerAdapter extends RecyclerView.Adapter<BeginnerAdapter.BeginnerViewHolder> {

    private List<Exercise> mlistExercise;
    private IClickItemUserListener iClickItemUserListener;

    public BeginnerAdapter(List<Exercise> mlistExercise, IClickItemUserListener listener) {

        this.mlistExercise = mlistExercise;
        this.iClickItemUserListener = listener;
    }

    @NonNull
    @Override
    public BeginnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_practice, parent, false);
        return new BeginnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BeginnerViewHolder holder, int position) {
        Exercise exercise = mlistExercise.get(position);
        if (exercise == null) {
            return;
        }
        holder.imgAvatar.setImageResource(exercise.getResourceId());
        holder.txt_name.setText(exercise.getName());
        holder.txt_address.setText(exercise.getAddress());
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickItemUserListener.onClickItemUser(exercise);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mlistExercise != null) {
            return mlistExercise.size();
        }
        return 0;
    }

    public class BeginnerViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout layoutItem;
        private ImageView imgAvatar;
        private TextView txt_name, txt_address;

        public BeginnerViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.item_pt);
            imgAvatar = itemView.findViewById(R.id.imgBeginnerList);
            txt_name = itemView.findViewById(R.id.textView1);
            txt_address = itemView.findViewById(R.id.textView2);
        }
    }
}
