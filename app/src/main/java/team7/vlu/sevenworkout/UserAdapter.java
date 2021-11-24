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

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> mlistUser;
    private IClickItemUserListener iClickItemUserListener;

    public UserAdapter(List<User> mlistUser, IClickItemUserListener listener) {

        this.mlistUser = mlistUser;
        this.iClickItemUserListener = listener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_practice, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mlistUser.get(position);
        if (user == null) {
            return;
        }
        holder.imgAvatar.setImageResource(user.getResourceId());
        holder.txt_name.setText(user.getName());
        holder.txt_address.setText(user.getAddress());
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickItemUserListener.onClickItemUser(user);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mlistUser != null) {
            return mlistUser.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout layoutItem;
        private ImageView imgAvatar;
        private TextView txt_name, txt_address;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.item_pt);
            imgAvatar = itemView.findViewById(R.id.imgBeginnerList);
            txt_name = itemView.findViewById(R.id.textView1);
            txt_address = itemView.findViewById(R.id.textView2);
        }
    }
}
