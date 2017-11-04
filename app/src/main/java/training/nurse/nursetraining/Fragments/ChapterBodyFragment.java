package training.nurse.nursetraining.Fragments;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import training.nurse.nursetraining.Adapters.ChapterAdapter;
import training.nurse.nursetraining.Models.Chapter;
import training.nurse.nursetraining.R;

import static java.lang.System.in;

public class ChapterBodyFragment extends Fragment {
    View view;
    String chapter;
    String lesson;
    String page;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_chapter_body, container, false);
        chapter = getArguments().getString("chapter","");
        lesson = getArguments().getString("lesson","");

        if (lesson.isEmpty())
            lesson = "l1";

        get_page();


        String json_result = loadJSONFromAsset(page);
        List<Chapter> chapters = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(json_result);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject row = jsonArray.getJSONObject(i);
                Chapter chapterModel = new Chapter();
                if (row.has("title"))
                    chapterModel.setTitle(row.getString("title"));
                else if(row.has("text"))
                    chapterModel.setText(row.getString("text"));
                else if(row.has("pic"))
                    chapterModel.setPhoto(row.getString("pic"));
                else if(row.has("next"))
                    chapterModel.setNext(row.getString("next"));
                else if(row.has("back"))
                    chapterModel.setBack(row.getString("back"));

                chapters.add(chapterModel);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        ListView lvChapters = (ListView) view.findViewById(R.id.lvChapters);

// get data from the table by the ListAdapter
        ChapterAdapter customAdapter = new ChapterAdapter(getContext(), R.layout.chapter_items, chapters);

        lvChapters .setAdapter(customAdapter);

        getActivity().setTitle(chapter);
        return view;
    }

    public String loadJSONFromAsset(String fileName) {
        String json = null;
        try {
            InputStream is = getContext().getAssets().open(fileName + ".json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    public void get_page(){
        switch(chapter){
            case "chapter1":
                page = "c1"+ lesson;
                return;
            case "chapter2":
                page = "c2"+ lesson;
                return;
            case "chapter3":
                page = "c3"+ lesson;
                return;
            case "chapter4":
                page = "c4"+ lesson;
                return;
            default:
                return;
        }
    }



}
