package com.example.harshu.imagetospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ImageButton imagebutton_obj;
    ImageButton imagebutton_mango;
    TextToSpeech textspeech_obj;
    Toast toastapple_obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagebutton_obj = (ImageButton) findViewById(R.id.apple_id);
        imagebutton_mango = (ImageButton) findViewById(R.id.mango_id);
        textspeech_obj = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textspeech_obj.setLanguage(Locale.UK);
                }
            }
        });

        imagebutton_obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = getString(R.string.apple_button);
                toastapple_obj = Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT);
                toastapple_obj.show();
                //toastapple_obj.setMargin(300,470);
                toastapple_obj.setGravity(Gravity.TOP | Gravity.RIGHT, 0, 0);
                textspeech_obj.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        imagebutton_mango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = getString(R.string.mango_button);
                toastapple_obj = Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT);
                toastapple_obj.show();
                toastapple_obj.setGravity(Gravity.TOP | Gravity.RIGHT, 0, 0);
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

