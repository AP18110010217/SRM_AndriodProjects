package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.snackbar.Snackbar;

public class MaterialDesign extends AppCompatActivity {

    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);

        /*This is Snackbar code*/
        findViewById(R.id.snackbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "This is Snackbar",
                        Snackbar.LENGTH_LONG);
                snackbar.setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MaterialDesign.this, "Retry", Toast.LENGTH_SHORT).show();
                    }
                });
                snackbar.setBackgroundTint(getResources().getColor(android.R.color.black));
                snackbar.setActionTextColor(getResources().getColor(android.R.color.white));
                snackbar.show();
            }
        });

        /*This is Date Picker Code*/
        findViewById(R.id.datePicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                MaterialDatePicker.Builder builderdate =
                        MaterialDatePicker.Builder.datePicker();
                final MaterialDatePicker materialDatePicker = builderdate.build();
                materialDatePicker.show(getSupportFragmentManager(), "");

                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {

                        snackbar = Snackbar.make(view, "" + materialDatePicker.getHeaderText(), Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                });


            }
        });
        /*This is Ranged Date Picker*/

        findViewById(R.id.rangedatePicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                MaterialDatePicker.Builder<Pair<Long, Long>> rangeDateBuilder =
                        MaterialDatePicker.Builder.dateRangePicker();
                final MaterialDatePicker materialDatePicker = rangeDateBuilder.build();
                materialDatePicker.show(getSupportFragmentManager(), "");

                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {

                        snackbar = Snackbar.make(view, "" + materialDatePicker.getHeaderText(), Snackbar.LENGTH_LONG);
                        snackbar.show();

                    }
                });

            }
        });
    }
}
