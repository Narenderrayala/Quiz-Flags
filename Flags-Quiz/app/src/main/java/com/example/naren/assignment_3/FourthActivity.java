package com.example.naren.assignment_3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by naren on 13-03-2017.
 */

public class FourthActivity extends AppCompatActivity {
    //ArrayList<Integer> final1 = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0));
    int final2[]=new int[12];
    int width,height;
    Button b1;
    TextView t[]=new TextView[22];
    int output=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth);
        b1=(Button)findViewById(R.id.button9) ;
        t[0] = (TextView) findViewById(R.id.textView8);
        t[1] = (TextView) findViewById(R.id.textView9);
        t[2] = (TextView) findViewById(R.id.textView10);
        t[3] = (TextView) findViewById(R.id.textView11);
        t[4] = (TextView) findViewById(R.id.textView12);
        t[5] = (TextView) findViewById(R.id.textView13);
        t[6] = (TextView) findViewById(R.id.textView14);
        t[7] = (TextView) findViewById(R.id.textView15);
        t[8] = (TextView) findViewById(R.id.textView16);
        t[9] = (TextView) findViewById(R.id.textView17);
        t[10] = (TextView) findViewById(R.id.textView18);
        t[11] = (TextView) findViewById(R.id.textView19);
        t[12] = (TextView) findViewById(R.id.textView20);
        t[13] = (TextView) findViewById(R.id.textView21);
        t[14] = (TextView) findViewById(R.id.textView22);
        t[15] = (TextView) findViewById(R.id.textView23);
        t[16] = (TextView) findViewById(R.id.textView24);
        t[17] = (TextView) findViewById(R.id.textView25);
        t[18] = (TextView) findViewById(R.id.textView26);
        t[19] = (TextView) findViewById(R.id.textView27);
        t[20] = (TextView) findViewById(R.id.textView28);
        t[21] = (TextView) findViewById(R.id.textView29);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            //final1 = extras.getIntegerArrayList("key2");
            final2 = extras.getIntArray("key3");

        }
        //Toast.makeText(FourthActivity.this,String.valueOf(final1.get(1)),Toast.LENGTH_LONG).show();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;
        height = dm.heightPixels;


        FrameLayout.LayoutParams tx = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx.setMargins((int) (width * .01), (int) (height * .05), 0, 0);
        t[0].setLayoutParams(tx);

        FrameLayout.LayoutParams tx1 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx1.setMargins((int) (width * .01), (int) (height * .12), 0, 0);
        t[1].setLayoutParams(tx1);

        FrameLayout.LayoutParams tx2 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx2.setMargins((int) (width * .01), (int) (height * .19), 0, 0);
        t[2].setLayoutParams(tx2);

        FrameLayout.LayoutParams tx3 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx3.setMargins((int) (width * .01), (int) (height * .26), 0, 0);
        t[3].setLayoutParams(tx3);

        FrameLayout.LayoutParams tx4 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx4.setMargins((int) (width * .01), (int) (height * .33), 0, 0);
        t[4].setLayoutParams(tx4);

        FrameLayout.LayoutParams tx5 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx5.setMargins((int) (width * .01), (int) (height * .40), 0, 0);
        t[5].setLayoutParams(tx5);

        FrameLayout.LayoutParams tx6 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx6.setMargins((int) (width * .01), (int) (height * .47), 0, 0);
        t[6].setLayoutParams(tx6);

        FrameLayout.LayoutParams tx7 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx7.setMargins((int) (width * .01), (int) (height * .54), 0, 0);
        t[7].setLayoutParams(tx7);

        FrameLayout.LayoutParams tx8 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx8.setMargins((int) (width * .01), (int) (height * .61), 0, 0);
        t[8].setLayoutParams(tx8);

        FrameLayout.LayoutParams tx9 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx9.setMargins((int) (width * .01), (int) (height * 67), 0, 0);
        t[9].setLayoutParams(tx9);


        FrameLayout.LayoutParams tx10 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx10.setMargins((int) (width * .3), (int) (height * .05), 0, 0);
        t[10].setLayoutParams(tx10);

        FrameLayout.LayoutParams tx11 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx11.setMargins((int) (width * .3), (int) (height * .12), 0, 0);
        t[11].setLayoutParams(tx11);

        FrameLayout.LayoutParams tx12 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx12.setMargins((int) (width * .3), (int) (height * .19), 0, 0);
        t[12].setLayoutParams(tx12);

        FrameLayout.LayoutParams tx13 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx13.setMargins((int) (width * .3), (int) (height * .26), 0, 0);
        t[13].setLayoutParams(tx13);

        FrameLayout.LayoutParams tx14 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx14.setMargins((int) (width * .3), (int) (height * .33), 0, 0);
        t[14].setLayoutParams(tx14);

        FrameLayout.LayoutParams tx15 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx15.setMargins((int) (width * .3), (int) (height * .40), 0, 0);
        t[15].setLayoutParams(tx15);

        FrameLayout.LayoutParams tx16 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx16.setMargins((int) (width * .3), (int) (height * .47), 0, 0);
        t[16].setLayoutParams(tx16);

        FrameLayout.LayoutParams tx17 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx17.setMargins((int) (width * .3), (int) (height * .54), 0, 0);
        t[17].setLayoutParams(tx17);

        FrameLayout.LayoutParams tx18 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx18.setMargins((int) (width * .3), (int) (height * .61), 0, 0);
        t[18].setLayoutParams(tx18);

        FrameLayout.LayoutParams tx19 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx19.setMargins((int) (width * .3), (int) (height * .68), 0, 0);
        t[19].setLayoutParams(tx19);

        FrameLayout.LayoutParams tx20 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx20.setMargins((int) (width * .01), (int) (height * .68), 0, 0);
        t[20].setLayoutParams(tx20);


        FrameLayout.LayoutParams tx21 = new FrameLayout.LayoutParams((int) (width * .9), (int) (height * .1));
        tx21.setMargins((int) (width * .01), (int) (height * .75), 0, 0);
        t[21].setLayoutParams(tx21);


        FrameLayout.LayoutParams b12 = new FrameLayout.LayoutParams((int) (width * .2), (int) (height * .1));
        b12.setMargins((int) (width * .3), (int) (height * .78), 0, 0);
        b1.setLayoutParams(b12);

        t[10].setText(String.valueOf(final2[0]));
        t[11].setText(String.valueOf(final2[1]));
        t[12].setText(String.valueOf(final2[2]));
        t[13].setText(String.valueOf(final2[3]));
        t[14].setText(String.valueOf(final2[4]));
        t[15].setText(String.valueOf(final2[5]));
        t[16].setText(String.valueOf(final2[6]));
        t[17].setText(String.valueOf(final2[7]));
        t[18].setText(String.valueOf(final2[8]));
        t[19].setText(String.valueOf(final2[9]));
       // output=final2[0]+final2[1]+final2[2]+final2[3]+final2[4]+final2[5]+final2[6]+final2[7]+final2[8]+final2[9];

        for(int i=0;i<10;i++)
        {
            if(final2[i]!=0)
            {
                output++;
            }
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {

            maked2();
            }
        }, 2000);
    }
    public void onClick(View v)
{
    Button b= (Button)v;
    Intent secondpage1 = new Intent(FourthActivity.this, Main.class);
    startActivity(secondpage1);

}
        void maked2()
    {
        AlertDialog.Builder build=new AlertDialog.Builder(FourthActivity.this);
        build.setTitle("Summary");
        build.setMessage("Number of Questions Made wrong =  " + String.valueOf(output));
        build.setPositiveButton("OK",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(FourthActivity.this,"Awesome!..Good Play",Toast.LENGTH_LONG).show();


            }

        });
        AlertDialog done=build.create();
        done.show();

    }


}
