package com.example.teamas.dialogsdemo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import java.util.Objects;

public class FireMissilesDialog extends DialogFragment {
    private DialogInteraction dialogInteraction;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Fire Missiles")
                .setPositiveButton("Fire", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialogInteraction.onDialogPositiveClick("Positive Button Clicked");
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialogInteraction.onDialogNegativeClick("Negative Button Clicked");
                    }
                });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DialogInteraction) {
            dialogInteraction = (DialogInteraction) context;
        }
    }

    public interface DialogInteraction {
        void onDialogPositiveClick(String data);

        void onDialogNegativeClick(String data);
    }
}
