package team7.vlu.sevenworkout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragement extends Fragment {
    private RecyclerView mRecyclerview;
    private View mView;
    private List<Type> lstType;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragement() {
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
    public static HomeFragement newInstance(String param1, String param2) {
        HomeFragement fragment = new HomeFragement();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstType = new ArrayList<>();
        lstType.add(new Type("Beginner", R.drawable.beginner));
        lstType.add(new Type("Intermediate", R.drawable.intermediate));
        lstType.add(new Type("Advanced", R.drawable.advanced));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragement_home, container, false);
        mRecyclerview = (RecyclerView) mView.findViewById(R.id.rcv_view);
        HomeAdapter recyclerCiewAdapter = new HomeAdapter(getContext(), lstType);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerview.setAdapter(recyclerCiewAdapter);
        return mView;
    }


}