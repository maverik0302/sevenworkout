package team7.vlu.sevenworkout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

import team7.vlu.sevenworkout.databinding.ActivityAboutInfomationBinding;

public class AboutInfomation extends AppCompatActivity {

    private ActivityAboutInfomationBinding binding;
    private Button btnGithub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAboutInfomationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Chức năng đang trong quá trình hoàn thiện", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnGithub = (Button) findViewById(R.id.btnGithub);
        btnGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://github.com/maverik0302/sevenworkout"));
                startActivity(intent);
            }
        });
    }
}