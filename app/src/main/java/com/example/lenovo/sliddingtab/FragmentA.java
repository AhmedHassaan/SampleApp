package com.example.lenovo.sliddingtab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Hassaan on 9/7/2016.
 */
public class FragmentA extends Fragment {
    TextView textView;
    Button btn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView=(TextView)getActivity().findViewById(R.id.textViewA);
        btn=(Button)getActivity().findViewById(R.id.click);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Done!!");
                textView.setScaleY(0f);
                textView.setScaleX(0f);
                textView.animate().cancel();
                textView.animate().scaleX(1).scaleY(1).setDuration(500).start();
            }
        });
    }
}
