package fr.audrain.appcoeur;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BilanNutritionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BilanNutritionFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private AppCompatActivity activity;
    private TextView breakfast, vegetable, salt, eatCustom;

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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        this.breakfast = (TextView) getView().findViewById(R.id.textView33);
        this.vegetable = (TextView) getView().findViewById(R.id.textView34);
        this.salt = (TextView) getView().findViewById(R.id.textView35);
        this.eatCustom = (TextView) getView().findViewById(R.id.textView36);

        this.setValues();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bilan_nutrition, container, false);
        return view;
    }

    private void setValues() {
        Person user = activity.getIntent().getParcelableExtra("profil");
        if (user.isBreakfast()) {
            breakfast.setText(getString(R.string.yes));
        }
        else {
            breakfast.setText(getString(R.string.no));
        }
        if (user.isVegetable()) {
            vegetable.setText(getString(R.string.yes));
        }
        else {
            vegetable.setText(getString(R.string.no));
        }
        if (user.isSalt()) {
            salt.setText(getString(R.string.yes));
        }
        else {
            salt.setText(getString(R.string.no));
        }
        if (user.getEatCustom().equals(EatCustom.PREPARED)) {
            eatCustom.setText(getString(R.string.prepared));
        }
        else if (user.getEatCustom().equals(EatCustom.COOKED)) {
            eatCustom.setText(getString(R.string.cooked));
        }
        else {
            eatCustom.setText(getString(R.string.can));
        }
    }
}