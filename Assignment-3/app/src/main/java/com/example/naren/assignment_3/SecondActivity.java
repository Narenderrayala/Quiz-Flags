package com.example.naren.assignment_3;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by naren on 13-03-2017.
 */

public class SecondActivity extends AppCompatActivity {

    ImageView i1;
    int width,i=0,j=0,a=0;
    int n,n1,numofimages=0;
    int height,f,x=0;
    int num12,n2=3;
    Animation rotate;
    Animator shake;
    TextView txt,txt1,txt2;
    Button b[]=new Button[10];

    boolean [] selectedRegions=new boolean[20];

    String[] regions=new String[]{
            "Africa",
            "Asia",
            "Europe",
            "North_America",
            "South_America"
    };
    String[] regions1=new String[]{
            "Africa/",
            "Asia/",
            "Europe/",
            "North_America/",
            "South_America/"
    };
    ArrayList<Integer> num2 = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4));
    ArrayList<Integer> num1 = new ArrayList<Integer>(Arrays.asList(0,1,2,3));
    ArrayList<Integer> final1 = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0));
    //ArrayList<Integer> final2 = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0));
    int final2[]=new int[12];
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        txt=(TextView)findViewById(R.id.textView4);
        txt1=(TextView)findViewById(R.id.textView5);
        txt2=(TextView)findViewById(R.id.textView7);
        shake = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.shake);

        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);


        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            selectedRegions = extras.getBooleanArray("key");
            f=extras.getInt("key1");
            final1=extras.getIntegerArrayList("key2");
            final2=extras.getIntArray("key3");
            //The key argument here must match that used in the other activity
        }
        txt.setText("Question " + String.valueOf(f)+ "of 10");

        for(int i=0;i<5;i++)
        {
            if(selectedRegions[i]==false)
            {
                j=i;
            }

        }
        num2.remove(j);

        Random rand = new Random();
        n = rand.nextInt(num2.size());

        //Toast.makeText(SecondActivity.this,String.valueOf(n),Toast.LENGTH_LONG).show();
        AssetManager assets;
        InputStream imageStream;
        String[] paths=new String[100];
        Drawable theflag;

        if(n==0)
        {
            numofimages=53;
        }
        if(n==1)
        {
            numofimages=52;
        }
        if(n==2)
        {
            numofimages=48;
        }
        if(n==3)
        {
            numofimages=32;
        }
        if(n==3)
        {
            numofimages=16;
        }
        i1=(ImageView)findViewById(R.id.imageView6);
        try {
            assets=getAssets();

                n1 = rand.nextInt(numofimages);
                paths = assets.list(regions[n]);

                imageStream = assets.open(regions1[n] + paths[n1]);
                theflag = Drawable.createFromStream(imageStream, null);

                    i1.setImageDrawable(theflag);


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



        //Toast.makeText(SecondActivity.this,paths[n1],Toast.LENGTH_LONG).show();
        b[0]=(Button)findViewById(R.id.button5) ;
        b[1]=(Button)findViewById(R.id.button6) ;
        b[2]=(Button)findViewById(R.id.button7) ;
        b[3]=(Button)findViewById(R.id.button8) ;
        num12 = rand.nextInt(num1.size());
        b[num12].setText(paths[n1].substring(paths[n1].indexOf('-') + 1).replace(".png", ""));

       // Toast.makeText(SecondActivity.this,String.valueOf(num12),Toast.LENGTH_LONG).show();

               while(n2>=0)
                {
                    if(n2==num12)
                    {
                        n2--;
                    }
                else
                    {
                        //Toast.makeText(SecondActivity.this,"IN else",Toast.LENGTH_LONG).show();
                        b[n2].setText(paths[n2].substring(paths[n2].indexOf('-') + 1).replace(".png", ""));
                        n2--;
                    }
                }

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;
        height = dm.heightPixels;




        FrameLayout.LayoutParams im1 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .2));
        im1.setMargins((int) (width * .30), (int) (height * .2), 0, 0);
        i1.setLayoutParams(im1);

        FrameLayout.LayoutParams tx = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx.setMargins((int) (width * .01), (int) (height * .01), 0, 0);
        txt.setLayoutParams(tx);

        FrameLayout.LayoutParams tx1 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx1.setMargins((int) (width * .4), (int) (height * .05), 0, 0);
        txt1.setLayoutParams(tx1);

        FrameLayout.LayoutParams tx2 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx2.setMargins((int) (width * .35), (int) (height * .5), 0, 0);
        txt2.setLayoutParams(tx2);

        FrameLayout.LayoutParams bt1 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .07));
        bt1.setMargins((int) (width * .05), (int) (height * .60), 0, 0);
        b[0].setLayoutParams(bt1);

        FrameLayout.LayoutParams bt2 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .07));
        bt2.setMargins((int) (width * .55), (int) (height * .60), 0, 0);
        b[1].setLayoutParams(bt2);

        FrameLayout.LayoutParams bt3 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .07));
        bt3.setMargins((int) (width * .05), (int) (height * .70), 0, 0);
        b[2].setLayoutParams(bt3);

        FrameLayout.LayoutParams bt4 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .07));
        bt4.setMargins((int) (width * .55), (int) (height * .70), 0, 0);
        b[3].setLayoutParams(bt4);

    }


    public void onClick(View v) {

        int c = 0;
        Button btn1 = (Button) v;
        b[0].setEnabled(false);
        b[1].setEnabled(false);
        b[2].setEnabled(false);
        b[3].setEnabled(false);
        while(btn1.getId()!=b[c].getId())
        {
            c++;
        }
        if(b[c].getText()==b[num12].getText())
        {
            txt1.setVisibility(View.VISIBLE);
            txt1.setText("Correct");

            i1.startAnimation(rotate);
            txt1.setTextColor(Color.GREEN);

            if(f<10) {

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
            public void run() {
                Intent Thirdpage = new Intent(SecondActivity.this, MainActivity.class);

                Bundle extras = new Bundle();
                f++;
                extras.putInt("key1", f);
                extras.putBooleanArray("key", selectedRegions);
                extras.putIntegerArrayList("key2",final1);
                extras.putIntArray("key3",final2);
                Thirdpage.putExtras(extras);
                startActivity(Thirdpage);
            }
            }, 3000);



            }
            else
            {
               // Toast.makeText(SecondActivity.this,"Finished",Toast.LENGTH_LONG).show();
                Intent Fourthpage = new Intent(SecondActivity.this, FourthActivity.class);
                Bundle extras = new Bundle();
                //extras.putIntegerArrayList("key2",final1);
                extras.putIntArray("key3",final2);
                Fourthpage.putExtras(extras);
                startActivity(Fourthpage);


            }
        }
        else
        {
            txt1.setVisibility(View.VISIBLE);
        txt1.setText("InCorrect");
        txt1.setTextColor(Color.RED);
            shake.setTarget(i1);
            shake.start();

            x=final2[f-1];
            x++;
            final2[f-1]=x;
           // Toast.makeText(SecondActivity.this,String.valueOf(final2[f-1]),Toast.LENGTH_LONG).show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                b[0].setEnabled(true);
                b[1].setEnabled(true);
                b[2].setEnabled(true);
                b[3].setEnabled(true);
            }
        }, 1000);



    }


    }

}
