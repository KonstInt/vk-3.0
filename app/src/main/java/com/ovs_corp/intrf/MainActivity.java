package com.ovs_corp.intrf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView message1, message2;
    EditText editText;
    Sicfer sic = new Sicfer();
    String key = "лол";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message1 = findViewById(R.id.message_body);
        message2 = findViewById(R.id.message_body2);
        editText = findViewById(R.id.editText);
    }

    public void sendMessage(View view) {
        message1.setText(sic.encrypt(editText.getText().toString(), key));
    }
}