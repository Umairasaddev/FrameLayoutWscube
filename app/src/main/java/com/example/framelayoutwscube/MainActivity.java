package com.example.framelayoutwscube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button button1,button2 , button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //by default aiuk fragment to dekhana ha jesy activity open ho to
        loadFragment(new bFragment(),0);//jab flag 0 milay ga to addd karna wrna replace karna

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadFragment(new AFragment(),1);


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadFragment(new bFragment(),1);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadFragment(new cFragment(),1);
            }
        });

    }

    //method is liye bnaya k bar bar manager or transactions ka code likhna parna tha to us say bachny k liye

    public void loadFragment(Fragment fragment,int flag)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        if (flag == 0)
        fragmentTransaction.add(R.id.container,fragment);////can also call like AFragment aFragment = new AFragment(); directly afragment ka object bnaya or is main pass kar                                                 //fragment ka object is liye bnaya k jo object call karain gy  usi ki fragment load ho g
        else
            fragmentTransaction.replace(R.id.container,fragment);
        fragmentTransaction.commit();
    }

}