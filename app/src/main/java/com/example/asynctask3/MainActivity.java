package com.example.asynctask3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSomething abc = new doSomething();
                abc.execute();
            }
        });

    }

    private class doSomething extends AsyncTask<Void, String, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView.setText("Bắt đầu" + "\n");
        }

        @Override
        protected String doInBackground(Void... voids) {
            for (int i = 0; i<=10; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress("Cong viec " + i + "\n");
            }
            return "Đã xong.";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.append(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            textView.append(values[0]);
        }
    }
}