package com.example.lenovo.sliddingtab;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by Hassaan on 9/7/2016.
 */
public class FragmentA extends Fragment {
    TextView time;
    Date dt=new Date();
    int hr=dt.getHours(),min=dt.getMinutes(),sec=dt.getSeconds();
    Button show,hide;
    String ti="am";
    String s1, s2, s3;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show=(Button)getActivity().findViewById(R.id.show);
        hide=(Button)getActivity().findViewById(R.id.hide);
        time=(TextView)getActivity().findViewById(R.id.time);
        time.setVisibility(View.INVISIBLE);
        dt=new Date();
        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                hr=dt.getHours();
                if(hr>=12) {
                    ti = "pm";
                    if(hr>12)
                        hr-=12;
                }
                else if(hr==0){
                    ti="am";
                    hr=12;
                }
                s1 = Integer.toString(sec);
                s2 = Integer.toString(min);
                s3 = Integer.toString(hr);
                if (s1.length() == 1)
                    s1 = "0" + s1;
                if (s2.length() == 1)
                    s2 = "0" + s2;
                if (s3.length() == 1)
                    s3 = "0" + s3;
                time.setText(s3 + ":" + s2 + ":" + s1 + " " + ti);
                handler.postDelayed(this, 1000);
                sec++;
                if (sec == 60) {
                    sec = 0;
                    min++;
                }
                if (min == 60)
                    min = 0;

            }
        };
        handler.post(run);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time.setVisibility(View.VISIBLE);
            }
        });

        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time.setVisibility(View.INVISIBLE);
            }
        });
    }
}
