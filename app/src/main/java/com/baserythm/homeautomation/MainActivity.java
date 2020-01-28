package com.baserythm.homeautomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.baserythm.homeautomationubaid.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView txt1, txt2, txt3;
    ImageView iv1, iv2, iv3;
    String status1,status2,status3;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = (TextView) findViewById(R.id.txt1);
        iv1 = (ImageView) findViewById(R.id.iv1);

        txt2 = (TextView) findViewById(R.id.txt2);
        iv2 = (ImageView) findViewById(R.id.iv2);

        txt3 = (TextView) findViewById(R.id.txt3);
        iv3 = (ImageView) findViewById(R.id.iv3);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        setUpTextViews();
    }

    public void setUpTextViews(){
        mDatabase.child("toggle").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                    HashMap<String,Object> value = (HashMap<String, Object>) singleSnapshot.getValue();
                    String key = singleSnapshot.getKey();

                    if (key.equalsIgnoreCase("16")){
                        String val = ""+value.get("islighton");
                        if (val.equalsIgnoreCase("0")){
                            txt1.setText("Light is Off");
                            iv1.setColorFilter(getApplicationContext().getResources().getColor(R.color.colorBlack));
                            iv1.setAnimation(null);
                            txt1.setAnimation(null);
                        }
                        else {
                            txt1.setText("Light is On");
                            iv1.setColorFilter(getApplicationContext().getResources().getColor(R.color.colorYellow));
                            final Animation animation = new AlphaAnimation(1, 0);
                            animation.setDuration(500);
                            animation.setInterpolator(new LinearInterpolator());
                            animation.setRepeatCount(Animation.INFINITE);
                            animation.setRepeatMode(Animation.REVERSE);
                            iv1.startAnimation(animation);
                            txt1.startAnimation(animation);
                        }
                    }

                    else if (key.equalsIgnoreCase("27")){
                        String val = ""+value.get("islighton");
                        if (val.equalsIgnoreCase("0")){
                            txt2.setText("Light is Off");
                            iv2.setColorFilter(getApplicationContext().getResources().getColor(R.color.colorBlack));
                            iv2.setAnimation(null);
                            txt2.setAnimation(null);
                        }
                        else {
                            txt2.setText("Light is On");
                            iv2.setColorFilter(getApplicationContext().getResources().getColor(R.color.colorYellow));
                            final Animation animation = new AlphaAnimation(1, 0);
                            animation.setDuration(500);
                            animation.setInterpolator(new LinearInterpolator());
                            animation.setRepeatCount(Animation.INFINITE);
                            animation.setRepeatMode(Animation.REVERSE);
                            iv2.startAnimation(animation);
                            txt2.startAnimation(animation);
                        }
                    }

                    else if (key.equalsIgnoreCase("17")){
                        String val = ""+value.get("islighton");
                        if (val.equalsIgnoreCase("0")){
                            txt3.setText("Light is Off");
                            iv3.setColorFilter(getApplicationContext().getResources().getColor(R.color.colorBlack));
                            iv3.setAnimation(null);
                            txt3.setAnimation(null);
                        }
                        else {
                            txt3.setText("Light is On");
                            iv3.setColorFilter(getApplicationContext().getResources().getColor(R.color.colorYellow));
                            final Animation animation = new AlphaAnimation(1, 0);
                            animation.setDuration(500);
                            animation.setInterpolator(new LinearInterpolator());
                            animation.setRepeatCount(Animation.INFINITE);
                            animation.setRepeatMode(Animation.REVERSE);
                            iv3.startAnimation(animation);
                            txt3.startAnimation(animation);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void light1(View v){
        mDatabase.child("lights/16/status").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue().toString().equals("1")){
                    Map<String,Object> taskMap = new HashMap<String,Object>();
                    taskMap.put("status", 0);
                    mDatabase.child("lights").child("16").updateChildren(taskMap);
                }
                else {
                    Map<String,Object> taskMap = new HashMap<String,Object>();
                    taskMap.put("status", 1);
                    mDatabase.child("lights").child("16").updateChildren(taskMap);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void light2(View v){
        mDatabase.child("lights/27/status").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue().toString().equals("1")){
                    Map<String,Object> taskMap = new HashMap<String,Object>();
                    taskMap.put("status", 0);
                    mDatabase.child("lights").child("27").updateChildren(taskMap);
                }
                else {
                    Map<String,Object> taskMap = new HashMap<String,Object>();
                    taskMap.put("status", 1);
                    mDatabase.child("lights").child("27").updateChildren(taskMap);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void light3(View v){
        mDatabase.child("lights/17/status").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue().toString().equals("1")){
                    Map<String,Object> taskMap = new HashMap<String,Object>();
                    taskMap.put("status", 0);
                    mDatabase.child("lights").child("17").updateChildren(taskMap);
                }
                else {
                    Map<String,Object> taskMap = new HashMap<String,Object>();
                    taskMap.put("status", 1);
                    mDatabase.child("lights").child("17").updateChildren(taskMap);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
