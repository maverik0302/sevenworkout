package team7.vlu.sevenworkout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import team7.vlu.sevenworkout.phong_interface.IClickItemUserListener;

public class beginnerActivity extends AppCompatActivity {

    private RecyclerView rcvData;
    private BeginnerAdapter beginnerAdapter;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner);

        rcvData = findViewById(R.id.rcv_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvData.setLayoutManager(linearLayoutManager);


        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this , DividerItemDecoration.VERTICAL);
        rcvData.addItemDecoration(itemDecoration);

        beginnerAdapter = new BeginnerAdapter(getListUser(), new IClickItemUserListener() {
            @Override
            public void onClickItemUser(Exercise exercise) {
                onClickGoToDetail(exercise);
            }
        });
        rcvData.setAdapter(beginnerAdapter);

    }

    private List<Exercise> getListUser() {
        List<Exercise> list = new ArrayList<>();
        list.add(new Exercise(R.drawable.ex_5, "Toe Touch", "30s"));
        list.add(new Exercise(R.drawable.ex_6, "High Knees", "30s"));
        list.add(new Exercise(R.drawable.ex_11, "Hand & Foot Touch", "30s"));
        list.add(new Exercise(R.drawable.ex_12, "Jumping Jack", "30s"));
        list.add(new Exercise(R.drawable.ex_22, "Stationary Lunge", "30s"));
        list.add(new Exercise(R.drawable.ex_24, "Burpee", "30s"));
        list.add(new Exercise(R.drawable.ex_25, "Side Lunge Touch", "30s"));
        list.add(new Exercise(R.drawable.ex_27, "Step Ups", "30s"));
        return  list;


        //Navigation bar
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    private void onClickGoToDetail(Exercise exercise) {
        Intent intent = new Intent(this, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_user", exercise);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}