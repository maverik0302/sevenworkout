package team7.vlu.sevenworkout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeeklyFragement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeeklyFragement extends Fragment {

    private RecyclerView wRecyclerview;
    private View wView;
    private List<Daily> listDaily;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WeeklyFragement() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BeginnerFragement.
     */
    // TODO: Rename and change types and number of parameters
    public static WeeklyFragement newInstance(String param1, String param2) {
        WeeklyFragement fragment = new WeeklyFragement();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    ScrollView scrollView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listDaily = new ArrayList<>();
        listDaily.add(new Daily("1", "Day 1"));
        listDaily.add(new Daily("2", "Day 2"));
        listDaily.add(new Daily("3", "Day 3"));
        listDaily.add(new Daily("4", "Day 4"));
        listDaily.add(new Daily("5", "Day 5"));
        listDaily.add(new Daily("6", "Day 6"));
        listDaily.add(new Daily("7", "Day 7"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        wView =  inflater.inflate(R.layout.fragment_weekly, container, false);
        wRecyclerview = (RecyclerView) wView.findViewById(R.id.listDays);
        WeeklyAdapter weeklyAdapter = new WeeklyAdapter(getContext(), listDaily);
        wRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        wRecyclerview.setAdapter(weeklyAdapter);
        return wView;
    }
}