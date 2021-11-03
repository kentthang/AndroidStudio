package com.example.labb1java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout parentView = new LinearLayout(this);
        LinearLayout childView1 = new LinearLayout(this);
        LinearLayout childView2 = new LinearLayout(this);

        parentView.setOrientation(LinearLayout.HORIZONTAL);

        setContentView(parentView);

        childView1.setOrientation(LinearLayout.VERTICAL);
        childView2.setOrientation(LinearLayout.VERTICAL);

        TextView namnLabel = new TextView(this);
        namnLabel.setText("Namn");
        namnLabel.setTextSize(20);
        namnLabel.setPadding(0,10,20,0);

        TextView passwordLabel = new TextView(this);
        passwordLabel.setText("Lösenord");
        passwordLabel.setTextSize(20);
        passwordLabel.setPadding(0,70,0,0);

        TextView epostLabel = new TextView(this);
        epostLabel.setText("Epost");
        epostLabel.setTextSize(20);
        epostLabel.setPadding(0,60,0,0);

        TextView ålderLabel = new TextView(this);
        ålderLabel.setText("Ålder");
        ålderLabel.setTextSize(20);
        ålderLabel.setPadding(0,70,0,0);

        EditText namnEditText = new EditText(this);
        namnEditText.setText("Anders");
        namnEditText.setTextSize(20);
        namnEditText.setWidth(800);

        EditText passwordEditText = new EditText(this);
        passwordEditText.setText("●●●●●●●●●");
        passwordEditText.setTextSize(20);
        passwordEditText.setWidth(800);

        EditText epostEditText = new EditText(this);
        epostEditText.setText("anders.froberg@liu.se");
        epostEditText.setTextSize(20);
        epostEditText.setWidth(800);

        SeekBar ålderBar = new SeekBar(this);
        ålderBar.setPadding(0,50,0,0);
        ålderBar.setProgress(40);

        childView1.addView(namnLabel);
        childView1.addView(passwordLabel);
        childView1.addView(epostLabel);
        childView1.addView(ålderLabel);
        childView2.addView(namnEditText);
        childView2.addView(passwordEditText);
        childView2.addView(epostEditText);
        childView2.addView(ålderBar);

        parentView.addView(childView1);
        parentView.addView(childView2);


    }
}