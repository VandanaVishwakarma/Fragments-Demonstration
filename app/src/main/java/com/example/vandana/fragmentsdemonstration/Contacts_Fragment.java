package com.example.vandana.fragmentsdemonstration;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
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

        setHasOptionsMenu(true);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                /////////////////////

               /* final String selectedNumberList=lv.getItemAtPosition(position).toString();

                Toast.makeText(getActivity(),"number clicked"+selectedNumberList+position,Toast.LENGTH_LONG).show();

               *//* Button call_btn=(Button)view.findViewById(R.id.btn_call);
                call_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //String selectedFromList = (lv.getItemAtPosition(position));
                        Toast.makeText(getActivity(),"number clicked"+selectedNumberList+position,Toast.LENGTH_LONG).show();
                       //call(lv.getSelectedView(),selectedNumberList);

                    }
                });*/
                /////////////////////
                PopupMenu popupMenu=new PopupMenu(getActivity(),lv);
                popupMenu.getMenuInflater().inflate(R.layout.call_menu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {


                        call(lv,item.toString());
                       Toast.makeText(getActivity(),"item clicked"+item.getTitle().toString(),Toast.LENGTH_LONG).show();
                        return true;
                   }
               });
                popupMenu.show();
            }
        });

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

                        TextView txt_name=new TextView(getActivity());
                        txt_name.setText(name);

                        TextView txt_contact=new TextView(getActivity());
                        txt_contact.setText(phno);
                       contacts.add(txt_name.getText().toString()+"\n"+txt_contact.getText().toString());

            }

        cursor.close();

    }

    public void call(View view, String num)

    {
        String[]phn_get=num.split("\\+",10);
        Log.d("split ",phn_get[0]);
        String phoneNum = num.toString();

        if(!TextUtils.isEmpty(phoneNum)) {
            String dial = "tel:" + phoneNum;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }else {
            Toast.makeText(getActivity(), "Please enter a valid telephone number", Toast.LENGTH_SHORT).show();
        }

    }
}
