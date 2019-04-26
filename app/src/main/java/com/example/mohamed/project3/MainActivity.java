package com.example.mohamed.project3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button sub;
    CheckBox add;
    CheckBox multiple;
    CheckBox tennis;
    EditText adding;
    EditText ans;
    TextView scoring;
    RadioGroup rGroup;
    int scores = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sub = (Button) findViewById(R.id.sub);
        add = (CheckBox) findViewById(R.id.add);
        multiple = (CheckBox) findViewById(R.id.mult);
        tennis = (CheckBox) findViewById(R.id.tennis);
        adding = (EditText) findViewById(R.id.enteryTXT);
        ans = (EditText) findViewById(R.id.enteryTXT2);
        scoring = (TextView) findViewById(R.id.scoreTXT);
        rGroup = (RadioGroup) findViewById(R.id.radioGroup1);


        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean multiplecheck = multiple.isChecked();
                boolean addcheck = add.isChecked();
                boolean tennisCheck = tennis.isChecked();

                String adds = adding.getText().toString();
                String minuts = ans.getText().toString();

                if (multiplecheck && addcheck && !tennisCheck) {
                    scores += 1;
                }

                if (!multiplecheck && !addcheck && !tennisCheck) {
                    Toast.makeText(MainActivity.this, "please answer question 2 ", Toast.LENGTH_SHORT).show();
                }

                if (adds.equals("507")) {
                    scores += 1;
                }
                if (adds.equals("")) {
                    Toast.makeText(MainActivity.this, "please answer question 3 ", Toast.LENGTH_SHORT).show();

                }
                if (minuts.equals("220")) {
                    scores += 1;
                }

                if (minuts.equals("")) {
                    Toast.makeText(MainActivity.this, "please answer question 4 ", Toast.LENGTH_SHORT).show();
                }

                if (scores < 2) {
                    Toast.makeText(getBaseContext(), "final score is :" + scores + "  please check ur answer ", Toast.LENGTH_SHORT).show();
                    scoring.setText(scores + " ");

                } else {
                    Toast.makeText(getBaseContext(), "final score is :" + scores + " ", Toast.LENGTH_SHORT).show();
                    scoring.setText(scores + " ");
                }
                scores = 0;
                rGroup.clearCheck();
                adding.setText("");
                ans.setText("");
                multiple.setChecked(false);
                add.setChecked(false);
                tennis.setChecked(false);
            }
        });

    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.A:
                if (checked)
                    scores += 1;
                break;
        }
    }
}
