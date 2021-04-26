package com.example.zouploreveil;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class MainActivity extends AppCompatActivity {
    private Handler myHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        String date_Hours = new SimpleDateFormat("H", Locale.getDefault()).format(new Date());
        String date_Mins = new SimpleDateFormat("mm", Locale.getDefault()).format(new Date());



        TextView tvHeure  = (TextView) findViewById(R.id.tvHeure);
        TextView tvH  = (TextView) findViewById(R.id.tvH);
        TextView tvMin  = (TextView) findViewById(R.id.tvMin);

        ImageView HPlus  = (ImageView) findViewById(R.id.HPlus);
        ImageView HMoins  = (ImageView) findViewById(R.id.HMoins);

        ImageView MPlus  = (ImageView) findViewById(R.id.MPlus);
        ImageView MMoins  = (ImageView) findViewById(R.id.MMoins);

        Button btValider = (Button) findViewById(R.id.btValider);



        myHandler = new Handler();
        myHandler.postDelayed(myRunnable,5000); // on redemande toute les 500ms

        tvHeure.setText(date_Hours);
        tvMin.setText(date_Mins);


        HPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(tvHeure.getText().toString())<24)
                {
                   int newH= Integer.parseInt(String.valueOf(tvHeure.getText().toString()));
                   newH++;
                    tvHeure.setText(String.valueOf(newH));
                }

                else
                    tvHeure.setText("0");
            }
        });

        HMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(tvHeure.getText().toString())>0)
                {
                    int newH= Integer.parseInt(String.valueOf(tvHeure.getText().toString()));
                    newH--;
                    tvHeure.setText(String.valueOf(newH));
                }

                else
                    tvHeure.setText("24");
            }
        });


        MPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(tvMin.getText().toString())<60)
                {
                    int newMin= Integer.parseInt(String.valueOf(tvMin.getText().toString()));
                    newMin++;
                    tvMin.setText(String.valueOf(newMin));
                }

                else
                    tvMin.setText("0");
            }
        });
        MMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(tvMin.getText().toString())>0)
                {
                    int newMin= Integer.parseInt(String.valueOf(tvMin.getText().toString()));
                    newMin--;
                    tvMin.setText(String.valueOf(newMin));

                }

                else
                    tvMin.setText("60");
            }
        });
        btValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR,Integer.parseInt(tvHeure.getText().toString()));
                intent.putExtra(AlarmClock.EXTRA_MINUTES,Integer.parseInt(tvMin.getText().toString()));
                intent.putExtra(AlarmClock.EXTRA_MESSAGE,"Reveille toi !!!!!");

                startActivity(intent);
            }
        });
    }

    private Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            ImageView imgZouple =(ImageView) findViewById(R.id.imgZouple);
            // Code à éxécuter de façon périodique
            flipImg(imgZouple);
            myHandler.postDelayed(this,5000);
        }
    };

    public static void flipImg (ImageView img){
        long animationDuration=500;
        //ObjectAnimator animator = ObjectAnimator.ofFloat(btSuccess, "translationX", -50f);

        ObjectAnimator animator =ObjectAnimator.ofFloat(img,"rotation",0f,360f);
        animator.setDuration(animationDuration);
        animator.start();

        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation, ImageView img) {
                long animationDuration = 500;
                ObjectAnimator animator2 =ObjectAnimator.ofFloat(img,"rotation",360f,0f);
                //ObjectAnimator animator2 = ObjectAnimator.ofFloat(btSuccess, "translationX", 25f);
                animator2.setDuration(animationDuration);
                animator2.start();
            }
        });
    }




    public void onPause() {
        super.onPause();
        if(myHandler != null)
            myHandler.removeCallbacks(myRunnable); // On arrete le callback
    }
}