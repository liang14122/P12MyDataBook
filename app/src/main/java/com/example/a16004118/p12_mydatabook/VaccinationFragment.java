package com.example.a16004118.p12_mydatabook;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VaccinationFragment extends Fragment {


    public VaccinationFragment() {
        // Required empty public constructor
    }

    private Button btnVaccination;
    private TextView tvVaccination;
    private SharedPreferences prefs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_vaccination, container, false);

        btnVaccination = view.findViewById(R.id.btnVaccination);
        tvVaccination = view.findViewById(R.id.tvVaccination);
        prefs = view.getContext().getSharedPreferences("p12", Context.MODE_PRIVATE);

        tvVaccination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater =
                        (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                assert inflater != null;
                @SuppressLint("InflateParams") LinearLayout passPhrase =
                        (LinearLayout) inflater.inflate(R.layout.edit_layout, null);
                final EditText etEdit = passPhrase.findViewById(R.id.etEdit);
                final TextView tvTitle = passPhrase.findViewById(R.id.tvTitle);
                tvTitle.setText("Edit Vaccination");
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Please Enter")
                        .setView(passPhrase)
                        .setPositiveButton("OK", new DialogInterface
                                .OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putString("vaccination", etEdit.getText().toString());
                                editor.apply();
                                update();
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        update();
    }

    private void update() {

        String bio = prefs.getString("vaccination", "No Vaccination record");
        tvVaccination.setText(bio);

    }
}
