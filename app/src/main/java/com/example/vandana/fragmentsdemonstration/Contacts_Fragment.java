package com.example.vandana.fragmentsdemonstration;


import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;

public class Contacts_Fragment extends Fragment {
   private ListView lv;
   private ArrayList<String> contacts;

    public Contacts_Fragment() { }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.fragment_contacts_, container, false);

        lv=(ListView) view.findViewById(R.id.contact_lst);

        calls();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,contacts);
        Log.d("Debug Amrita lv", String.valueOf(lv));
        Log.d("Debug Amrita adapter", String.valueOf(adapter));

        lv.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }
    public void calls() {
        Context applicationContext=MainActivity.getContextOfApp();
        //ContentResolver resolver = context.getContentResolver();
        Cursor cursor = applicationContext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null,ContactsContract.Contacts.DISPLAY_NAME+"ASC");

        contacts=new ArrayList<String>();


            while(cursor.moveToNext()) {
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID));
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phno = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                       contacts.add("id: "+id+"\nname "+name+"number"+phno);

            }

        cursor.close();


    }

}
