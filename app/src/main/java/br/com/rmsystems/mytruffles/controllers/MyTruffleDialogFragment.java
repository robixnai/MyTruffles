package br.com.rmsystems.mytruffles.controllers;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;

import br.com.rmsystems.mytruffles.R;

public class MyTruffleDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.dialog_car, null))
                // Add action buttons
                .setPositiveButton("Sign", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MyTruffleDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }



    /*private TextView mTextViewFlavor, mTextViewValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_truffle);

        *//*this.bindElements();

        Intent intent = getIntent();
        Truffle truffleSelected = AppUtil.get(intent.getSerializableExtra("truffle"));

        mTextViewFlavor.setText(truffleSelected.getFlavor());

        final DecimalFormat decimalFormat = AppUtil.get(NumberFormat.getNumberInstance(Locale.US));
        decimalFormat.applyPattern("#.00");
        mTextViewValue.setText(decimalFormat.format(truffleSelected.getValue()));*//*

    }

    private void bindElements() {
        mTextViewFlavor = AppUtil.get(this.findViewById(R.id.textViewFlavor));
        mTextViewValue = AppUtil.get(this.findViewById(R.id.textViewValue));
    }*/

}