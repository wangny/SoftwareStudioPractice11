package com.csclab.softwarestudiopractice11;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mei on 5/24/16.
 */

public class Activity2 extends Activity{

    private TextView nameText;
    private ImageView dino;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        /** To Do:
         * (1) Find the UI element on xml file
         * (2) Use Bundle to retrieve name string
         * (3) Display "Welcome 'username' "
         * (4) Set image resource (Hint: drawable) and its touch listener **/
        nameText = (TextView) findViewById(R.id.nameTextView);
        dino = (ImageView) findViewById(R.id.imageView);

        savedInstanceState = this.getIntent().getExtras();
        String name =  savedInstanceState.getString("name");

        nameText.setText("welcome "+name);
        dino.setImageResource(R.drawable.dino);
        dino.setOnTouchListener(imgListener ) ;
    }

    private OnTouchListener imgListener = new OnTouchListener() {
        private float x, y; //The x, y position that image exist
        private int mx, my; // The distance from original position to finger dragging




        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch(event.getAction()){
                case MotionEvent.ACTION_DOWN:

                    break;
                case MotionEvent.ACTION_MOVE:
                    mx = (int)(event.getRawX() - x);
                    my = (int)(event.getRawY() - 50 - y);
                    v.layout( (int)x+mx, (int)y+my, (int)x+mx+dino.getWidth(), (int)y+my+dino.getHeight());


                    break;

            }
            return true;
        }
    };

}
