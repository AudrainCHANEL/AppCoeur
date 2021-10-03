package fr.audrain.appcoeur;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BilanHeartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BilanHeartFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private Person user;
    private TextView heartCondition, cholesterol, diabet, hypertension, family;

    public static BilanHeartFragment newInstance(int page, Person user) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        BilanHeartFragment fragment = new BilanHeartFragment();
        fragment.setArguments(args);
        fragment.user = user;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
        this.setValues();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bilan_heart, container, false);
        return view;
    }

    private void setValues() {
        if (this.user.isHeart_condition()){
            Log.d(this.toString(), getString(R.string.yes));
            this.heartCondition.setText(getString(R.string.yes));
        }
        else {
            this.heartCondition.setText(getString(R.string.no));
        }
    }
}