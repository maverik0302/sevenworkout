package team7.vlu.sevenworkout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

public class beginnerActivity extends AppCompatActivity {
    int alo = 5;
    ListView listView;
        String mTitleB[] = {"Toe Touch", "High Knees", "Hand & Foot Touch", "Jumping Jack", "Stationary Lunge", "Burpee", "Side Lunge Touch", "Step Ups"};
    String mDescriptionB[] = {"20s", "20s", "15s", "30s", "25s", "20s", "25s", "30s"};
    int mImgageB [] ={R.drawable.ex_5, R.drawable.ex_6, R.drawable.ex_11, R.drawable.ex_12, R.drawable.ex_22,R.drawable.ex_24,R.drawable.ex_25, R.drawable.ex_27};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner);

        listView = findViewById(R.id.list_pratice);

        //create Adapter
        MyAdapter adapter = new MyAdapter(this, mTitleB, mDescriptionB, mImgageB);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(beginnerActivity.this, "Twitter Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  1) {
                    Toast.makeText(beginnerActivity.this, "Twitter Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  2) {
                    Toast.makeText(beginnerActivity.this, "Twitter Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  3) {
                    Toast.makeText(beginnerActivity.this, "Instagram Description", Toast.LENGTH_SHORT).show();
                }
                if (position ==  4) {
                    Toast.makeText(beginnerActivity.this, "Youtube Description", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitleB[];
        String rDesB[];
        int rImage[];

        public MyAdapter(Context c, String TitleB[], String Description[], int ImgageB[]) {
            super(c, R.layout.item_practice, R.id.textView1, TitleB);
            this.context = c;
            this.rTitleB = TitleB;
            this.rDesB = Description;
            this.rImage = ImgageB;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater =(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.item_practice, parent, false);
            ImageView images = view.findViewById(R.id.imgBeginnerList);
            TextView myTitle = view.findViewById(R.id.textView1);
            TextView myDescription = view.findViewById(R.id.textView2);
            return view;
        }
    }
}