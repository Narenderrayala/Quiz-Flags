package com.example.naren.assignment_3;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by naren on 11-03-2017.
 */

public class Main extends AppCompatActivity {
    boolean [] selectedRegions=new boolean[20];
    Button btn;
    double width;
    double height;
    ImageView iv,iv1,iv2,iv3;
    Button b1;
    TextView t1;
    TextView t2;
    ImageView view1;
    int n12;
    ArrayList<Integer> final1 = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0));
    int []final2={0,0,0,0,0,0,0,0,0,0,0,0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        iv = (ImageView) findViewById(R.id.imageView2);



        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textView2);
    //    btn=(Button)findViewById(R.id.button) ;
      //  btn.setOnClickListener(new View.OnClickListener() {
            //@//Override
            //public void onClick(View v) {

            //}
        //);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;
        height = dm.heightPixels;
        FrameLayout.LayoutParams pp = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .2));
        pp.setMargins((int) (width * .30), (int) (height * .30), 0, 0);
        iv.setLayoutParams(pp);

        FrameLayout.LayoutParams pp2 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .15));
        pp2.setMargins((int) (width * .35), (int) (height * .25), 0, 0);
        t2.setLayoutParams(pp2);

        FrameLayout.LayoutParams pp3 = new FrameLayout.LayoutParams((int) (width * .4), (int) (height * .15));
        pp3.setMargins((int) (width * .40), (int) (height * .55), 0, 0);
        t1.setLayoutParams(pp3);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.themenu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        View backg = findViewById(R.id.main);// get Any child View
        switch (item.getItemId()) {
            case R.id.Categories:
                maked2();
               // backg.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.red_menu:
                Toast.makeText(Main.this,"You are Awesome, Lets start the Quiz!!!",Toast.LENGTH_LONG).show();
                // backg.setBackgroundColor(Color.RED);
                //Log.d("options","yellow happened");
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    void maked2()
    {
        String [] Regionslist=new String[]{

                "Africa",
                "Asia",
                "Europe",
                "North_America",
                "South_America"

        };

        final List<String> Regions = Arrays.asList(Regionslist);
        AlertDialog.Builder build=new AlertDialog.Builder(Main.this);
        build.setTitle("Pick a Region");
       n12=0;
        build.setMultiChoiceItems(Regionslist,null,new DialogInterface.OnMultiChoiceClickListener()
                {
                    public void onClick(DialogInterface dialog, int which,boolean isChecked){
                        if(isChecked)
                        {
                            selectedRegions[which]=true;
                            n12++;
                        }
                        else
                        {
                            selectedRegions[which]=false;
                        }
                    }
                }

        );
        build.setPositiveButton("OK",new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        //Toast.makeText(MainActivity.this,"Is ok!",Toast.LENGTH_LONG).show();
                        if((selectedRegions[0]==false&&(selectedRegions[1]==false||selectedRegions[2]==false||selectedRegions[3]==false||selectedRegions[4]==false))||(selectedRegions[1]==false&&(selectedRegions[0]==false||selectedRegions[2]==false||selectedRegions[3]==false||selectedRegions[4]==false))||(selectedRegions[2]==false&&(selectedRegions[1]==false||selectedRegions[0]==false||selectedRegions[3]==false||selectedRegions[4]==false))||(selectedRegions[3]==false&&(selectedRegions[1]==false||selectedRegions[2]==false||selectedRegions[0]==false||selectedRegions[4]==false))||(selectedRegions[4]==false&&(selectedRegions[1]==false||selectedRegions[2]==false||selectedRegions[3]==false||selectedRegions[0]==false))||(selectedRegions[0]==true&&selectedRegions[1]==true&&selectedRegions[2]==true&&selectedRegions[3]==true&&selectedRegions[4]==true))
                        {
                            Toast.makeText(Main.this,"Exactly Four Regions Must be picked before continuing:",Toast.LENGTH_LONG).show();
                            selectedRegions[0]=false;selectedRegions[1]=false;selectedRegions[2]=false;selectedRegions[3]=false;selectedRegions[4]=false;
                        }
                        else
                        {
                           // Toast.makeText(Main.this,"Great",Toast.LENGTH_LONG).show();
                            Intent firstpage = new Intent(Main.this, MainActivity.class);
                            //firstpage.putExtra("key",selectedRegions);
                            Bundle extras = new Bundle();
                            extras.putInt("key1",1);
                            extras.putBooleanArray("key",selectedRegions);
                            extras.putIntegerArrayList("key2",final1);
                            extras.putIntArray("key3",final2);
                            firstpage.putExtras(extras);
                            startActivity(firstpage);

                        }
                    }
                }
        );
        AlertDialog done=build.create();
        done.show();





}




}




