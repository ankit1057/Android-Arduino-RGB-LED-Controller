package dk.meznik.led_controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

/**
 * Created by ghost on 4/5/15.
 */
public class ConnectionSettingsDialog extends Dialog implements View.OnClickListener {
    public MainActivity activity;
    public Dialog dialog;
    public Button buttonOk;
    public EditText editTextIp;
    public EditText editTextPort;

    public String ip = "";
    public int port = 0;
    public boolean changed = false;

    public ConnectionSettingsDialog(MainActivity a)
    {
        super(a);
        this.activity = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_connection_settings);

        buttonOk = (Button)findViewById(R.id.button_dialog_ok);
        editTextIp = (EditText)findViewById(R.id.edittext_ip);
        editTextPort = (EditText)findViewById(R.id.edittext_port);

        buttonOk.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
            // Should I verify for valid IP?
            if(editTextIp.length() != 0) {
               ip = editTextIp.getText().toString();
                changed = true;
            }

            if(editTextPort.length() != 0) {
                port = Integer.parseInt(editTextPort.getText().toString());
                changed = true;
            }
        dismiss();
    }
}
