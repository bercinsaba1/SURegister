package com.example.finalproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class ClassListFragment extends Fragment {
    private String catid;
    ExecutorService srv;
    RecyclerView recClass;
    ProgressBar prgClass;


    public ClassListFragment() {}
    public ClassListFragment(String catid, ExecutorService srv) {
        this.catid = catid;
        this.srv = srv;
    }
    Handler dataHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {

            List<ClassItem> data = (List<ClassItem>)msg.obj;

            ClassRecViewAdapter adp = new ClassRecViewAdapter(data,getActivity());
            recClass.setAdapter(adp);
            recClass.setLayoutManager(new LinearLayoutManager(getActivity()));
            prgClass.setVisibility(View.INVISIBLE);
            recClass.setVisibility(View.VISIBLE);
            return true;
        }
    });

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        View root = inflater.inflate(R.layout.fragment_listener,container,false);
        recClass = root.findViewById(R.id.recNews);
        prgClass = root.findViewById(R.id.prgNews);
        prgClass.setVisibility(View.VISIBLE);
        recClass.setVisibility(View.INVISIBLE);

        ClassRepository repo = new ClassRepository();
        repo.ClassItemsByCategoryId(srv, dataHandler, catid);
        // categoriler dedigimiz ders adları cs math mgmt gibi


        return root;
    }


}
