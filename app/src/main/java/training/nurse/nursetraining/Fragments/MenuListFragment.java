package training.nurse.nursetraining.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

import java.util.ArrayList;
import java.util.List;

import training.nurse.nursetraining.R;


public class MenuListFragment extends Fragment {
    View view;
    ListView menuList;
    ArrayAdapter<CharSequence> adapter;
    FloatingActionButton fab;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Main Menu");
        view = inflater.inflate(R.layout.fragment_menu_list, container, false);
        adapter = ArrayAdapter.createFromResource(getContext(), R.array.menu_list, android.R.layout.simple_list_item_1);

        menuList = view.findViewById(R.id.menuList);

        menuList.setAdapter(adapter);


        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ChapterListFragment chapterListFragment = new ChapterListFragment();
                FragmentManager fragmentManager;
                FragmentTransaction fragmentTransaction;
                Bundle bundle = new Bundle();

                switch(i){
                    case 0:
                        removeFragment();
                        bundle.putString("menuContext", "Chapters");
                        chapterListFragment.setArguments(bundle);
                        fragmentManager = getActivity().getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, chapterListFragment);
                        fragmentTransaction.commit();
                        return;
                    case 1:
                        removeFragment();
                        bundle.putString("menuContext", "Procedures");
                        chapterListFragment.setArguments(bundle);
                        fragmentManager = getActivity().getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, chapterListFragment);
                        fragmentTransaction.commit();
                        return;
                    case 2:
                        removeFragment();
                        bundle.putString("menuContext", "Practice Exam");
                        chapterListFragment.setArguments(bundle);
                        fragmentManager = getActivity().getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, chapterListFragment);
                        fragmentTransaction.commit();
                        return;
                    case 3:
                        removeFragment();
                        bundle.putString("menuContext", "Practical Exam");
                        chapterListFragment.setArguments(bundle);
                        fragmentManager = getActivity().getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, chapterListFragment);
                        fragmentTransaction.commit();
                        return;
                    case 4:
                        removeFragment();
                        fab = getActivity().findViewById(R.id.fab);
                        fab.setVisibility(View.VISIBLE);
                        getActivity().setTitle("Nurse Training Application");
                        return;
                    default:

                }
            }
        });

        return view;
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
