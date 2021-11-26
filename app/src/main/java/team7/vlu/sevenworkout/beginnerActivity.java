package team7.vlu.sevenworkout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import team7.vlu.sevenworkout.phong_interface.IClickItemUserListener;

public class beginnerActivity extends AppCompatActivity {

    private RecyclerView rcvData;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner);

        rcvData = findViewById(R.id.rcv_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvData.setLayoutManager(linearLayoutManager);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this , DividerItemDecoration.VERTICAL);
        rcvData.addItemDecoration(itemDecoration);

        userAdapter = new UserAdapter(getListUser(), new IClickItemUserListener() {
            @Override
            public void onClickItemUser(User user) {
                onClickGoToDetail(user);
            }
        });
        rcvData.setAdapter(userAdapter);

    }

    private List<User> getListUser() {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.ex_5, "Toe Touch", "30s"));
        list.add(new User(R.drawable.ex_6, "High Knees", "30s"));
        list.add(new User(R.drawable.ex_11, "Hand & Foot Touch", "30s"));
        list.add(new User(R.drawable.ex_12, "Jumping Jack", "30s"));
        list.add(new User(R.drawable.ex_22, "Stationary Lunge", "30s"));
        list.add(new User(R.drawable.ex_24, "Burpee", "30s"));
        list.add(new User(R.drawable.ex_25, "Side Lunge Touch", "30s"));
        list.add(new User(R.drawable.ex_27, "Step Ups", "30s"));
        return  list;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    private void onClickGoToDetail(User user) {
        Intent intent = new Intent(this, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_user", user);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}