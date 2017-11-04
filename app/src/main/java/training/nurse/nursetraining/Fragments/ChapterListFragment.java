package training.nurse.nursetraining.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import training.nurse.nursetraining.ChaptersActivity;
import training.nurse.nursetraining.R;


public class ChapterListFragment extends Fragment {
    View view;
    ListView menuList;
    ArrayAdapter<CharSequence> adapter;
    String menuContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chapter_list, container, false);
        adapter = ArrayAdapter.createFromResource(getContext(), R.array.chapter_list, android.R.layout.simple_list_item_1);
        menuList = view.findViewById(R.id.chapterList);
        menuList.setAdapter(adapter);

        menuContext = getArguments().getString("menuContext");
        getActivity().setTitle(menuContext);

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        switch(menuContext){
                            case "Chapters":
                                goToChapters(i);
                                return;
                            case "Procedures":

                                return;
                            case "Practice Exam":

                                return;
                            case "Practical Exam":

                                return;
                            default:
                                return;
                        }
                    case 4:
                        removeFragment();
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        MenuListFragment menuListFragment = new MenuListFragment();

                        fragmentTransaction.replace(R.id.fragment_container, menuListFragment);

                        fragmentTransaction.commit();
                        return;
                    default:

                }
            }
        });

        return view;
    }

    public void goToChapters(int chapter){
        Intent intent = new Intent(getActivity(), ChaptersActivity.class);
        switch(chapter){
            case 0:
                intent.putExtra("chapter", "chapter1");
                getActivity().startActivity(intent);
                return;
            case 1:
                intent.putExtra("chapter", "chapter2");
                getActivity().startActivity(intent);
                return;
            case 2:
                intent.putExtra("chapter", "chapter3");
                getActivity().startActivity(intent);
                return;
            case 3:
                intent.putExtra("chapter", "chapter4");
                getActivity().startActivity(intent);
                return;
            default:
                return;
        }
    }

    public void removeFragment(){
        List<Fragment> fragments = getActivity().getSupportFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment != null)
                    getActivity().getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            }
        }
    }

}
