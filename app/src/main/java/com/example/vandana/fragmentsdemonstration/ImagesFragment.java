/*
package com.example.vandana.fragmentsdemonstration;


import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;


import java.util.ArrayList;

public class ImagesFragment extends Fragment {
    private ListView lv;
    private ArrayList<String> photos;

    public ImagesFragment() { }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.imagesfragment, container, false);
        calls(getContext().getContentResolver());
        lv=(ListView) view.findViewById(R.id.imgList);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,photos);

        lv.setAdapter(adapter);


        */
/*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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




                //Toast.makeText(getContext(),"itemClicked"+position,Toast.LENGTH_LONG).show();
            }
        });*//*

        return view;
    }
    public void calls(ContentResolver contentResolver) {

        Cursor cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, ContactsContract.DisplayPhoto.Phone.DISPLAY_NAME + " ASC");

        photos=new ArrayList<String>();


        while(cursor.moveToNext()) {

            // String id = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID));
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phno = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            photos.add("Name: "+name+"\nNumber:"+phno);

        }

        cursor.close();


    }

}

*/
