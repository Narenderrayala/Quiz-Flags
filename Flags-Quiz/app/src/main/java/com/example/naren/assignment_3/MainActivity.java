package com.example.naren.assignment_3;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView view1,iv1,iv2,iv3;
    int width;
    int height;
    Animation rotate;
    Animator shake;
    String value;
    int numofimages,n1;
    int j,l=0;
    int a=0;
    int n,f=0,x=0;
    int n3;
    TextView txt,txt1,txt2;
    Button b[]=new Button[10];
    ArrayList<Integer> final1 = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0));
    boolean [] selectedRegions=new boolean[20];
   int  final2[]=new int[12];
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
    ArrayList<Integer> num = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);
        b[0]=(Button)findViewById(R.id.button) ;
        b[1]=(Button)findViewById(R.id.button2) ;
        b[2]=(Button)findViewById(R.id.button3) ;
        b[3]=(Button)findViewById(R.id.button4) ;
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
            //The key argument here must match that used in the other activity.
        for(int i=0;i<5;i++)
        {
            if(selectedRegions[i]==false)
            {
                j=i;
                //Toast.makeText(MainActivity.this,regions[i],Toast.LENGTH_LONG).show();
            }
            else
            {
                b[a].setText(regions[i]);
                a++;
            }
        }
        num.remove((Integer)j);




        //Toast.makeText(MainActivity.this,String.valueOf(j),Toast.LENGTH_LONG).show();






        Random rand = new Random();


         n= rand.nextInt(num.size());

        while(true)
        {
            if(n==j)
            {
                n= rand.nextInt(num.size());
            }
            else
            {
                break;
            }
        }


       // Toast.makeText(MainActivity.this,String.valueOf(n),Toast.LENGTH_LONG).show();
        AssetManager assets;
        InputStream imageStream;
        txt=(TextView)findViewById(R.id.textView2);
        txt1=(TextView)findViewById(R.id.textView3);
        txt2=(TextView)findViewById(R.id.textView6);
        txt.setText("Question " + String.valueOf(f)+ "of 10");
        String[] paths;


        Drawable theflag;

        view1= (ImageView)findViewById(R.id.imageView);
        iv1 = (ImageView) findViewById(R.id.imageView3);
        iv2 = (ImageView) findViewById(R.id.imageView4);
        iv3 = (ImageView) findViewById(R.id.imageView5);
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

        try {
                assets=getAssets();
                while(l<4) {
                    n1 = rand.nextInt(numofimages);

                    paths = assets.list(regions[n]);

                    imageStream = assets.open(regions1[n] + paths[n1]);
                    theflag = Drawable.createFromStream(imageStream, null);
                    if(l==0)
                    view1.setImageDrawable(theflag);
                    if(l==1)
                    iv1.setImageDrawable(theflag);
                    if(l==2)
                    iv2.setImageDrawable(theflag);
                    if(l==3) {
                        iv3.setImageDrawable(theflag);
                        l=0;
                        break;
                    }
                    l++;
                }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;
        height = dm.heightPixels;
        Log.d("size",width+","+height);

        FrameLayout.LayoutParams tx = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx.setMargins((int) (width * .01), (int) (height * .01), 0, 0);
        txt.setLayoutParams(tx);

        FrameLayout.LayoutParams tx1 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx1.setMargins((int) (width * .4), (int) (height * .05), 0, 0);
        txt1.setLayoutParams(tx1);

        FrameLayout.LayoutParams tx2 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .1));
        tx2.setMargins((int) (width * .35), (int) (height * .5), 0, 0);
        txt2.setLayoutParams(tx2);

        FrameLayout.LayoutParams im1 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .13));
        im1.setMargins((int) (width * .05), (int) (height * .1), 0, 0);
        view1.setLayoutParams(im1);

        FrameLayout.LayoutParams im2 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .13));
        im2.setMargins((int) (width * .50), (int) (height * .1), 0, 0);
        iv1.setLayoutParams(im2);

        FrameLayout.LayoutParams im3 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .13));
        im3.setMargins((int) (width * .05), (int) (height * .30), 0, 0);
        iv2.setLayoutParams(im3);

        FrameLayout.LayoutParams im4 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .13));
        im4.setMargins((int) (width * .50), (int) (height * .30), 0, 0);
        iv3.setLayoutParams(im4);






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

    public void onClick(View v)  {

        int c=0;
    Button btn1=(Button)v;
        b[0].setEnabled(false);
        b[1].setEnabled(false);
        b[2].setEnabled(false);
        b[3].setEnabled(false);
        while(btn1.getId()!=b[c].getId())
        {
            c++;
        }
        if(btn1.getId()==b[c].getId())
        {

           /* b[0].setEnabled(true);
            b[1].setEnabled(true);
            b[2].setEnabled(true);
            b[3].setEnabled(true);*/
            if(b[c].getText()==regions[n])
            {
               // Toast.makeText(MainActivity.this,"Hello im in",Toast.LENGTH_LONG).show();
                txt1.setVisibility(View.VISIBLE);
                txt1.setText("Correct");
                b[c].startAnimation(rotate);

                txt1.setTextColor(Color.GREEN);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                Intent secondpage = new Intent(MainActivity.this, SecondActivity.class);
                Bundle extras = new Bundle();
                f++;
                extras.putInt("key1",f);
                extras.putBooleanArray("key",selectedRegions);
                extras.putIntegerArrayList("key2",final1);
                extras.putIntArray("key3",final2);
                secondpage.putExtras(extras);
                startActivity(secondpage);

                    }
                }, 3000);


            }
            else
            {
                txt1.setVisibility(View.VISIBLE);
                txt1.setText("InCorrect");
                txt1.setTextColor(Color.RED);

                shake.setTarget(b[c]);
                shake.start();

                x=final2[f-1];

                x++;
                final2[f-1]=x;
               // Toast.makeText(MainActivity.this,String.valueOf(final2[f-1]),Toast.LENGTH_LONG).show();

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



}

