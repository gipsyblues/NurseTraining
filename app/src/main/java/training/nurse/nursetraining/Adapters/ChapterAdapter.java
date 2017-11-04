package training.nurse.nursetraining.Adapters;

import android.content.ClipData;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by phmima on 11/4/2017.
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import training.nurse.nursetraining.Models.Chapter;
import training.nurse.nursetraining.R;

public class ChapterAdapter extends ArrayAdapter<Chapter> {

    private String page;
    public ChapterAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ChapterAdapter(Context context, int resource, List<Chapter> items) {
        super(context, resource, items);
    }

    public void setPage(String page) {this.page = page;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.chapter_items, null);
        }

        Chapter chapter = getItem(position);

        if (chapter != null) {
            TextView tvText = (TextView) v.findViewById(R.id.tvText);
            TextView tvTitle = (TextView) v.findViewById(R.id.tvTitle);
            TextView tvLeftItalic = (TextView) v.findViewById(R.id.tvLeftItalic);
            FrameLayout flPic = (FrameLayout) v.findViewById(R.id.flPic);
            ImageView ivPic = (ImageView) v.findViewById(R.id.ivPic);
            Button btnNext = (Button) v.findViewById(R.id.btnNext);
            Button btnBack = (Button) v.findViewById(R.id.btnBack);

            try {
                if (!chapter.getTitle().isEmpty()) {
                    tvTitle.setText(chapter.getTitle());
                    tvTitle.setVisibility(View.VISIBLE);
                }
            }
            catch(NullPointerException e){}

            try {
                if (!chapter.getLeftItalic().isEmpty()) {
                    tvLeftItalic.setText(chapter.getLeftItalic());
                    tvLeftItalic.setVisibility(View.VISIBLE);
                }
            }
            catch(NullPointerException e){}

            try {
                if (!chapter.getText().isEmpty()) {
                    tvText.setText(chapter.getText());
                    tvText.setVisibility(View.VISIBLE);
                }
            }
            catch(NullPointerException e){}

            try {
                if (!chapter.getNext().isEmpty()) {
                    btnNext.setVisibility(View.VISIBLE);
                }
            }
            catch(NullPointerException e){}

            try {
                if (!chapter.getBack().isEmpty()) {
                    btnBack.setVisibility(View.VISIBLE);
                }
            }
            catch(NullPointerException e){}

            try {
                if (!chapter.getPhoto().isEmpty()) {
                    flPic.setVisibility(View.VISIBLE);
                    InputStream ims = getContext().getAssets().open(chapter.getPhoto());
                    Drawable d = Drawable.createFromStream(ims, null);
                    ivPic.setImageDrawable(d);
                    ims .close();
                }
            }
            catch(NullPointerException e){} catch (IOException e) {
                e.printStackTrace();
            }
        }
        return v;
    }




}