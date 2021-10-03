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
 * Use the {@link BilanMonitoringFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BilanMonitoringFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private AppCompatActivity activity;
    private TextView cardioRisk, checkup, seeCradio;

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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        this.cardioRisk = (TextView) getView().findViewById(R.id.textView26);
        this.checkup = (TextView) getView().findViewById(R.id.textView27);
        this.seeCradio = (TextView) getView().findViewById(R.id.textView28);

        this.setValues();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bilan_monitoring, container, false);
        return view;
    }

    private void setValues() {
        Person user = activity.getIntent().getParcelableExtra("profil");
        if (user.getCardioRisk().equals(YesNoMaybe.YES)) {
            cardioRisk.setText(getString(R.string.yes));
        }
        else if (user.getCardioRisk().equals(YesNoMaybe.NO)) {
            cardioRisk.setText(getString(R.string.no));
        }
        else {
            cardioRisk.setText(getString(R.string.i_dont_know));
        }
        if (user.isCheckup()) {
            checkup.setText(getString(R.string.yes));
        }
        else {
            checkup.setText(getString(R.string.no));
        }
        if (user.isSeeCardio()) {
            seeCradio.setText(getString(R.string.yes));
        }
        else {
            seeCradio.setText(getString(R.string.no));
        }
    }
}