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

        if(date_Hours.length()==1)
            date_Hours="0"+date_Hours;
        if(date_Mins.length()==1)
            date_Mins="0"+date_Hours;
        TextView tvMessage  = (TextView) findViewById(R.id.tvMessage);

        TextView tvHeure  = (TextView) findViewById(R.id.tvHeure);
        TextView tvH  = (TextView) findViewById(R.id.tvH);
        TextView tvMin  = (TextView) findViewById(R.id.tvMin);

        ImageView HPlus  = (ImageView) findViewById(R.id.HPlus);
        ImageView HMoins  = (ImageView) findViewById(R.id.HMoins);

        ImageView MPlus  = (ImageView) findViewById(R.id.MPlus);
        ImageView MMoins  = (ImageView) findViewById(R.id.MMoins);

        Button btValider = (Button) findViewById(R.id.btValider);
        TextView tvMessageZouple = (TextView) findViewById(R.id.tvMessageZouple);
        tvMessageZouple.setText("Oh non si tu mets un réveil ca va me reveiller viens on n'en met pas");

        myHandler = new Handler();
        myHandler.postDelayed(myRunnable,5000); // on redemande toute les 500ms

        tvHeure.setText(date_Hours);
        tvMin.setText(date_Mins);


        String finalDate_Hours = date_Hours;
        String finalDate_Hours1 = date_Hours;
        String finalDate_Mins = date_Mins;
        HPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(tvHeure.getText().toString())<23)
                {
                   int newH= Integer.parseInt(String.valueOf(tvHeure.getText().toString()));
                   newH++;

                    tvHeure.setText(String.valueOf(newH));
                    if(tvHeure.length()==1)
                        tvHeure.setText("0"+tvHeure.getText());

                }

                else
                    tvHeure.setText("00");
                //if(tvHeure.getText()== finalDate_Hours &&tvMin.getText()== finalDate_Mins)
                  //  tvMessageZouple.setText("Etranzrzazihazihaizhioazhio a l'heure de maintenant  ");
                if(Integer.parseInt(String.valueOf(tvHeure.getText()))==0 &&Integer.parseInt(String.valueOf(tvMin.getText()))==0)
                    tvMessageZouple.setText("T'es un rigolo toi a mettre un réveil a minuit ");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>0 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=3||Integer.parseInt(String.valueOf(tvHeure.getText()))==0 && Integer.parseInt(String.valueOf(tvMin.getText()))>0)
                  tvMessageZouple.setText("PARDON !!!! MAIS C'EST SUPER TOT !! ");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>3 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=6)
                    tvMessageZouple.setText("Encore un réveil qui va piquer ! ");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>6 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=9)
                    tvMessageZouple.setText("C'est tot mais on ferra avec ");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>9 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=12)
                    tvMessageZouple.setText("Enfin un réveil de qualité avec un peu de sommeil");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>12 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=14)
                    tvMessageZouple.setText("C'est l'heure de bouffer pas de dormir");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>14 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=16)
                    tvMessageZouple.setText("La petite sieste de l'aprem ?");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>16 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=18)
                    tvMessageZouple.setText("T'as pas honte de mettre un reveil a cette heure la ?");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>18 && Integer.parseInt(String.valueOf(tvHeure.getText()))<24)
                    tvMessageZouple.setText("Je crois que tu n'as pas compris le concept d'un réveil");
                if(Integer.parseInt(String.valueOf(tvMin.getText()))==05)
                    tvMessageZouple.setText(tvMessageZouple.getText()+"Les 5mins servent tellement a rien");

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
                    if(tvHeure.length()==1)
                        tvHeure.setText("0"+tvHeure.getText());
                }

                else
                    tvHeure.setText("23");

                if(Integer.parseInt(String.valueOf(tvHeure.getText()))==0 &&Integer.parseInt(String.valueOf(tvMin.getText()))==0)
                    tvMessageZouple.setText("T'es un rigolo toi a mettre un réveil a minuit ");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>0 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=3||Integer.parseInt(String.valueOf(tvHeure.getText()))==0 && Integer.parseInt(String.valueOf(tvMin.getText()))>0)
                    tvMessageZouple.setText("PARDON !!!! MAIS C'EST SUPER TOT !! ");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>3 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=6)
                    tvMessageZouple.setText("Encore un réveil qui va piquer ! ");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>6 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=9)
                    tvMessageZouple.setText("C'est tot mais on ferra avec ");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>9 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=12)
                    tvMessageZouple.setText("Enfin un réveil de qualité avec un peu de sommeil");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>12 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=14)
                    tvMessageZouple.setText("C'est l'heure de bouffer pas de dormir");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>14 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=16)
                    tvMessageZouple.setText("La petite sieste de l'aprem ?");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>16 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=18)
                    tvMessageZouple.setText("T'as pas honte de mettre un reveil a cette heure la ?");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>18 && Integer.parseInt(String.valueOf(tvHeure.getText()))<24)
                    tvMessageZouple.setText("Je crois que tu n'as pas compris le concept d'un réveil");
                if(Integer.parseInt(String.valueOf(tvMin.getText()))==05)
                    tvMessageZouple.setText(tvMessageZouple.getText()+"Les 5mins servent tellement a rien");
            }
        });


        MPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(tvMin.getText().toString())<59)
                {
                    int newMin= Integer.parseInt(String.valueOf(tvMin.getText().toString()));
                    newMin++;
                    tvMin.setText(String.valueOf(newMin));
                    if(tvMin.length()==1)
                        tvMin.setText("0"+tvMin.getText());
                }

                else {
                    if(Integer.parseInt(tvHeure.getText().toString())==23)
                        tvHeure.setText("00");
                    tvMin.setText("00");

                }

                if(Integer.parseInt(String.valueOf(tvHeure.getText()))==0 &&Integer.parseInt(String.valueOf(tvMin.getText()))==0)
                    tvMessageZouple.setText("T'es un rigolo toi a mettre un réveil a minuit ");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>0 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=3||Integer.parseInt(String.valueOf(tvHeure.getText()))==0 && Integer.parseInt(String.valueOf(tvMin.getText()))>0)
                    tvMessageZouple.setText("PARDON !!!! MAIS C'EST SUPER TOT !! ");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>3 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=6)
                    tvMessageZouple.setText("Encore un réveil qui va piquer ! ");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>6 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=9)
                    tvMessageZouple.setText("C'est tot mais on ferra avec ");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>9 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=12)
                    tvMessageZouple.setText("Enfin un réveil de qualité avec un peu de sommeil");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>12 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=14)
                    tvMessageZouple.setText("C'est l'heure de bouffer pas de dormir");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>14 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=16)
                    tvMessageZouple.setText("La petite sieste de l'aprem ?");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>16 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=18)
                    tvMessageZouple.setText("T'as pas honte de mettre un reveil a cette heure la ?");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>18 && Integer.parseInt(String.valueOf(tvHeure.getText()))<24)
                    tvMessageZouple.setText("Je crois que tu n'as pas compris le concept d'un réveil");
                if(Integer.parseInt(String.valueOf(tvMin.getText()))==05)
                    tvMessageZouple.setText(tvMessageZouple.getText()+"Les 5mins servent tellement a rien");
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
                    if(tvMin.length()==1)
                        tvMin.setText("0"+tvMin.getText());


                }

                else
                    tvMin.setText("59");

                if(Integer.parseInt(String.valueOf(tvHeure.getText()))==0 &&Integer.parseInt(String.valueOf(tvMin.getText()))==0)
                    tvMessageZouple.setText("T'es un rigolo toi a mettre un réveil a minuit ! ");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>0 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=3||Integer.parseInt(String.valueOf(tvHeure.getText()))==0 && Integer.parseInt(String.valueOf(tvMin.getText()))>0)
                    tvMessageZouple.setText("PARDON !!!! MAIS C'EST SUPER TOT !! ");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>3 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=6)
                    tvMessageZouple.setText("Encore un réveil qui va piquer ! ");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>6 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=9)
                    tvMessageZouple.setText("C'est tot mais on ferra avec ");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>9 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=12)
                    tvMessageZouple.setText("Enfin un réveil de qualité avec un peu de sommeil ! ");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>12 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=14)
                    tvMessageZouple.setText("C'est l'heure de bouffer pas de dormir ! ");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>14 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=16)
                    tvMessageZouple.setText("La petite sieste de l'aprem ? ");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>16 && Integer.parseInt(String.valueOf(tvHeure.getText()))<=18)
                    tvMessageZouple.setText("T'as pas honte de mettre un reveil a cette heure la ? ");
                else if(Integer.parseInt(String.valueOf(tvHeure.getText()))>18 && Integer.parseInt(String.valueOf(tvHeure.getText()))<24)
                    tvMessageZouple.setText("Je crois que tu n'as pas compris le concept d'un réveil ! ");
                if(Integer.parseInt(String.valueOf(tvMin.getText()))==05)
                    tvMessageZouple.setText(tvMessageZouple.getText()+"Les 5mins servent tellement a rien !");
            }
        });
        btValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR,Integer.parseInt(tvHeure.getText().toString()));
                intent.putExtra(AlarmClock.EXTRA_MINUTES,Integer.parseInt(tvMin.getText().toString()));
                intent.putExtra(AlarmClock.EXTRA_MESSAGE,tvMessage.getText().toString());
                intent.putExtra(AlarmClock.EXTRA_ALARM_SNOOZE_DURATION,2);

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