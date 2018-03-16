package com.example.harshu.imagetospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ImageButton imagebutton_obj;
    ImageButton imagebutton_mango;
    TextToSpeech textspeech_obj;
    Toast toastapple_obj;
    EditText text_obj;
    Button button_obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textspeech_obj = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textspeech_obj.setLanguage(Locale.US);
                }
            }
        });
        imagebutton_obj = (ImageButton) findViewById(R.id.apple_id);
        imagebutton_mango = (ImageButton) findViewById(R.id.mango_id);
        button_obj = (Button) findViewById(R.id.button_id);
        text_obj = (EditText) findViewById(R.id.input_text);


        imagebutton_obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = getString(R.string.apple_button);
                //toastapple_obj = Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT);
                //toastapple_obj.show();
                //toastapple_obj.setMargin(300,470);
                //toastapple_obj.setGravity(Gravity.TOP | Gravity.END, 0, 0);
                textspeech_obj.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        button_obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String toSpeak = text_obj.getText().toString();
                Log.v("tospeak", toSpeak);
                //toastapple_obj = Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT);
                //toastapple_obj.show();
                //toastapple_obj.setMargin(300,470);
                //toastapple_obj.setGravity(Gravity.TOP | Gravity.END, 0, 0);
                textspeech_obj.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        imagebutton_mango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = getString(R.string.mango_button);
                //toastapple_obj = Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT);
                //toastapple_obj.show();
                //toastapple_obj.setGravity(Gravity.TOP | Gravity.END, 0, 0);
                textspeech_obj.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

            }
        });
    }

    public void onPause() {
        if (textspeech_obj != null) {
            textspeech_obj.stop();
            textspeech_obj.shutdown();
        }
        super.onPause();
    }

}

