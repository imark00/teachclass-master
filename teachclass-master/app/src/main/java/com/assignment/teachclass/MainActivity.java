package com.assignment.teachclass;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private EditText redvalue, greenvlaue, bluevalue;
    Model color;
    private int redcolor, greencolor, bluecolor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        color = new Model(255, 255, 255);
        setContentView(R.layout.activity_main);

        redvalue = (EditText) findViewById(R.id.red);
        greenvalue = (EditText) findViewById(R.id.green);
        bluevalue = (EditText) findViewById(R.id.blue);

        TextChangeHandler tch = new TextChangeHandler();
        redvalue.addTextChangedListener(tch);
        greenvalue.addTextChangedListener(tch);
        bluevalue.addTextChangedListener(tch);
    }
    public void colorchage(){
        String redstring = redvalue.getText().toString();
        String greenstring = greenvalue.getText().toString();
        String bluestring = bluevalue.getText().toString();

        TextView label = (TextView) findViewById(R.id.label_text);

        try {
            int red = Integer.parseInt(redstring);
            int green = Integer.parseInt(greenstring);
            int blue = Integer.parseInt(bluestring);

            color.setredcolor(red);
            color.setgreencolor(green);
            color.setbluevalue(blue);

            redcolor = color.getredcolor();
            greencolor = color.getgreencolor();
            bluecolor = color.getbluecolor();

            label.setBackgroundColor(Color.rgb(redcolor, greencolor, bluecolor));
        }
        catch (NumberFormatException nfe){ }
    }

    private class TextChangeHandler implements TextWatcher{
        @Override
        public void afterTextChanged(Editable editable) {
            colorchange();
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
    }
}