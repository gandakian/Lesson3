package com.almightyamir.assignment3;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText input1;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layoutMain = new LinearLayout(this);
        layoutMain.setOrientation(LinearLayout.VERTICAL);
        layoutMain.setBackgroundColor(Color.CYAN);

        LinearLayout layoutTitle = new LinearLayout(this);
        layoutTitle.setOrientation(LinearLayout.VERTICAL);
        layoutTitle.setGravity(Gravity.TOP);
        layoutMain.addView(layoutTitle);

        TextView heading = new TextView(this);
        heading.setText("TEASPOON AND TABLESPOON CALCULATOR");
        heading.setHeight(100);
        heading.setGravity(Gravity.TOP | Gravity.CENTER);
        heading.setBackgroundColor(Color.YELLOW);
        heading.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        heading.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
        layoutTitle.addView(heading);

        LinearLayout layoutBody = new LinearLayout(this);
        layoutBody.setOrientation(LinearLayout.VERTICAL);
        layoutBody.setGravity(Gravity.CENTER_HORIZONTAL);
        layoutMain.addView(layoutBody);

        TextView label1 = new TextView(this);
        label1.setText("Enter the number of cups here");
        label1.setHeight(50);
        label1.setGravity(Gravity.CENTER);
        label1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        label1.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
        layoutBody.addView(label1);

        input1 = new EditText(this);
        input1.setHeight(50);
        input1.setInputType(InputType.TYPE_CLASS_NUMBER);
        input1.setGravity(Gravity.CENTER);
        layoutBody.addView(input1);

        Button btn1 = new Button(this);
        btn1.setWidth(10);
        btn1.setGravity(Gravity.CENTER);
        btn1.setText("Calculate");
        layoutBody.addView(btn1);

        result = new TextView(this);
        result.setHeight(200);
        result.setGravity(Gravity.CENTER);
        result.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        result.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
        layoutBody.addView(result);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cupsString = input1.getText().toString();

                if(!cupsString.matches("")){
                    Double cupsDouble = Double.parseDouble(cupsString);

                    Double tablespoons = 16 * cupsDouble;
                    String res = String.valueOf(tablespoons);

                    result.setText(res + " TableSpoons");
                }
                else{
                    result.setText("Please enter the value for cups !!!");
                }


            }
        });

        setContentView(layoutMain);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
