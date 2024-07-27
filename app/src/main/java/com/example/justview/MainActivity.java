package com.example.justview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button twoscreen, fourscreen, sixscreen, eightscreen;
    private int numberOfWebViews = 0;
    private EditText minute_text_input, second_text_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.textvieww);
        twoscreen = findViewById(R.id.twoscreen);
        fourscreen = findViewById(R.id.fourscreen);
        sixscreen = findViewById(R.id.sixscreen);
        eightscreen = findViewById(R.id.Eightscreen);
        minute_text_input = findViewById(R.id.minute_text_input);
        second_text_input = findViewById(R.id.second_text_input);

        twoscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfWebViews = 2;
                intent();
                Toast.makeText(MainActivity.this, "Selected 2 Window", Toast.LENGTH_SHORT).show();
            }
        });

        fourscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfWebViews = 4;
                intent();
                Toast.makeText(MainActivity.this, "Selected 4 Window", Toast.LENGTH_SHORT).show();
            }
        });

        sixscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfWebViews = 6;
                intent();
                Toast.makeText(MainActivity.this, "Selected 6 Window", Toast.LENGTH_SHORT).show();
            }
        });

        eightscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfWebViews = 8;
                intent();
                Toast.makeText(MainActivity.this, "Selected 8 Window", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void intent() {
        {
            if (numberOfWebViews == 0) {
                Toast.makeText(MainActivity.this, "Please select the number of Window", Toast.LENGTH_SHORT).show();
            } else {
                String youtubeLink = editText.getText().toString();
                String minutes = minute_text_input.getText().toString();
                String seconds = second_text_input.getText().toString();

                if (minutes.isEmpty() || seconds.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both minutes and seconds", Toast.LENGTH_SHORT).show();
                    return;
                }

                int minuteValue = Integer.parseInt(minutes);
                int secondValue = Integer.parseInt(seconds);

                if (minuteValue > 59 || secondValue > 59) {
                    Toast.makeText(MainActivity.this, "Please enter valid values for minutes and seconds (0-59)", Toast.LENGTH_SHORT).show();
                    return;
                }

                int interval = (minuteValue * 60 + secondValue) * 1000;

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("YOUTUBE_LINK", youtubeLink);
                intent.putExtra("NUMBER_OF_WEBVIEWS", numberOfWebViews);
                intent.putExtra("INTERVAL", interval);
                startActivity(intent);
            }
        }
    }
}
