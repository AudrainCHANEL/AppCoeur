package fr.audrain.appcoeur;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BilanMonitoringFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BilanMonitoringFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private AppCompatActivity activity;

    public static BilanMonitoringFragment newInstance(int page, AppCompatActivity activity) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        BilanMonitoringFragment fragment = new BilanMonitoringFragment();
        fragment.setArguments(args);
        fragment.activity = activity;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bilan_monitoring, container, false);
        return view;
    }
}