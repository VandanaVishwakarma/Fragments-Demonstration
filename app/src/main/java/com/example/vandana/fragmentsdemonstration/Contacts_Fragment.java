package com.example.vandana.fragmentsdemonstration;


import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;


import java.util.ArrayList;

public class Contacts_Fragment extends Fragment{
   private ListView lv;
   private ArrayList<String> contacts;


    public Contacts_Fragment() { }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_contacts_, container, false);
        calls(getContext().getContentResolver());
        lv=(ListView) view.findViewById(R.id.contact_lst);


        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,contacts);

        lv.setAdapter(adapter);
               lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                PopupMenu popupMenu=new PopupMenu(getActivity(),lv);
                popupMenu.getMenuInflater().inflate(R.layout.call_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getContext(),"menuClicked"+item,Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
                popupMenu.show();

            }
        });

        setHasOptionsMenu(true);

        //code for search View

       EditText et = (EditText)view.findViewById(R.id.searchBar);
       et.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
               adapter.getFilter().filter(s);
           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });

        return view;
    }
    public void calls(ContentResolver contentResolver) {

        Cursor cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");

        contacts=new ArrayList<String>();


            while(cursor.moveToNext()) {

                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phno = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                       contacts.add("Name: "+name+"\nNumber:"+phno);

            }

        cursor.close();


    }

}
