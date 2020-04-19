package com.example.isupportlockdown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    RecyclerView r1;
    String i1[];
    String s1[];
    String s2[];
    EditText editText,editText2,editText4;
    MyAdapter ad;
    Button button_send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1 = (RecyclerView)findViewById(R.id.MyRecycler);

        i1 = getResources().getStringArray(R.array.Sr_no);
        s1 = getResources().getStringArray(R.array.e1);
        s2 = getResources().getStringArray(R.array.e2);
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText4 = (EditText)findViewById(R.id.editText4);
        ad = new MyAdapter(this,i1,s1,s2 );
        r1.setAdapter(ad);
        r1.setLayoutManager(new LinearLayoutManager(this));
        Button button_send = (Button)findViewById(R.id.button_send);


        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                String address = editText2.getText().toString();
                String name_and_address = name+"\n"+address;
                String contact = "91" +editText4.getText().toString().trim();


                try {
                    Intent sendintent = new Intent();
                    sendintent.setAction(Intent.ACTION_SEND);
                    sendintent.setType("text/plain");
                    sendintent.putExtra(Intent.EXTRA_TEXT,name_and_address + "\n");
                    sendintent.putExtra("jid",contact + "@s.whatsapp.net");
                    sendintent.setPackage("com.whatsapp");
                    startActivity(sendintent);
                }catch (ActivityNotFoundException ex){

                }
            }
        });




    }
}
