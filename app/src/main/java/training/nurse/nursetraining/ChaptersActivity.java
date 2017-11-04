package training.nurse.nursetraining;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import training.nurse.nursetraining.Fragments.ChapterBodyFragment;
import training.nurse.nursetraining.Fragments.MenuListFragment;

public class ChaptersActivity extends AppCompatActivity {

    String chapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);

        Bundle extras = getIntent().getExtras();
        chapter = extras.getString("chapter");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = new Bundle();
        bundle.putString("chapter", chapter);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ChapterBodyFragment chapterBodyFragment = new ChapterBodyFragment();
        chapterBodyFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragment_container, chapterBodyFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
