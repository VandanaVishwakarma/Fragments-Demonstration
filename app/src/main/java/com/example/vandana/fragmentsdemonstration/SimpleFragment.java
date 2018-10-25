package com.example.vandana.fragmentsdemonstration;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class SimpleFragment extends Fragment {

private Button btn_Image,btn_Notes, btn_Contacts;
private Fragment fragment;
private  Context context;



    public SimpleFragment() {}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_simple, container, false);
        context = getContext();



        btn_Image=(Button) view.findViewById((R.id.btnImage));
        btn_Notes=(Button) view.findViewById(R.id.btnNotes);
        btn_Contacts=(Button) view.findViewById(R.id.btnContacts);

        btn_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment=new ImageFragment();
                ((MainActivity) context).addFragment(fragment);
            }
        });

        btn_Notes.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            fragment=new BlankFragment();
            ((MainActivity) context).addFragment(fragment);

            //Toast.makeText(context, "working", Toast.LENGTH_SHORT).show();
        }
    });

    btn_Contacts.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            fragment=new Contacts_Fragment();
            ((MainActivity) context).addFragment(fragment);
        }
    });

        return view;

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

   /* public void addFragment(int i,Fragment fragment)
    {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(i,fragment);
        fragmentTransaction.commit();
    }*/


}
