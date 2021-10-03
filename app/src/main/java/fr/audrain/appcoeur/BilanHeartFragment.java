package fr.audrain.appcoeur;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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
    private AppCompatActivity activity;
    private TextView heartCondition, cholesterol, diabet, hypertension, bmi, family;

    public static BilanHeartFragment newInstance(int page, AppCompatActivity activity) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        BilanHeartFragment fragment = new BilanHeartFragment();
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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        this.heartCondition = (TextView) getView().findViewById(R.id.textView16);
        this.diabet = (TextView) getView().findViewById(R.id.textView17);
        this.cholesterol = (TextView) getView().findViewById(R.id.textView18);
        this.hypertension = (TextView) getView().findViewById(R.id.textView19);
        this.bmi = (TextView) getView().findViewById(R.id.textView20);
        this.family = (TextView) getView().findViewById(R.id.textView22);

        this.setValues();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bilan_heart, container, false);
        return view;
    }

    private void setValues() {
        Person user = activity.getIntent().getParcelableExtra("profil");
        if (user.isHeart_condition()) {
            heartCondition.setText(getString(R.string.yes));
        }
        else {
            heartCondition.setText(getString(R.string.no));
        }
        if (user.isDiabetic()) {
            diabet.setText(getString(R.string.yes));
        }
        else {
            diabet.setText(getString(R.string.no));
        }
        if (user.isCholesterol()) {
            cholesterol.setText(getString(R.string.yes));
        }
        else {
            cholesterol.setText(getString(R.string.no));
        }
        if (user.isHypertension()) {
            hypertension.setText(getString(R.string.yes));
        }
        else {
            hypertension.setText(getString(R.string.no));
        }
        if (user.isImc()) {
            bmi.setText(getString(R.string.yes));
        }
        else {
            bmi.setText(getString(R.string.no));
        }
        if (user.getAvc().equals(YesNoMaybe.YES)) {
            family.setText(getString(R.string.yes));
        }
        else if (user.getAvc().equals(YesNoMaybe.NO)) {
            family.setText(getString(R.string.no));
        }
        else {
            family.setText(getString(R.string.i_dont_know));
        }
    }
}