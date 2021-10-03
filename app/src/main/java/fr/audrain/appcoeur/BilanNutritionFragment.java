package fr.audrain.appcoeur;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BilanNutritionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BilanNutritionFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private AppCompatActivity activity;

    public static BilanNutritionFragment newInstance(int page, AppCompatActivity activity) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        BilanNutritionFragment fragment = new BilanNutritionFragment();
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
        View view = inflater.inflate(R.layout.fragment_bilan_nutrition, container, false);
        return view;
    }
}