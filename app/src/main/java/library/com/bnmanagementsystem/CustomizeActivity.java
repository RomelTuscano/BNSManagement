package library.com.bnmanagementsystem;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import library.com.bnmanagementsystem.util.DBOperator;
import library.com.bnmanagementsystem.view.TableView;

/**
 * Created by Romel on 4/26/2015.
 */
public class CustomizeActivity extends Activity implements
        AdapterView.OnItemSelectedListener {
    Spinner s1,s2;
    String att = "";
    String sp1 = " ";
    ScrollView scrollView;
    ListView EventList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.costomize);
        s1 = (Spinner)findViewById(R.id.widget40);
        s2 = (Spinner)findViewById(R.id.widget42);
        s1.setOnItemSelectedListener(this);
      //  EventList = (ListView) this.findViewById(R.id.eventListview);
        scrollView=(ScrollView)this.findViewById(R.id.cus_scrollView);
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                               long arg3) {
        // TODO Auto-generated method stub
        sp1= String.valueOf(s1.getSelectedItem());
        Toast.makeText(this, sp1, Toast.LENGTH_SHORT).show();
        if(sp1.contentEquals("Staff")) {
            List<String> list = new ArrayList<String>();
            list.add("Staff_FirstName");
            list.add("Staff_LastName");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);

            att = String.valueOf(s2.getSelectedItem());
        }
        if(sp1.contentEquals("Branch")) {
            List<String> list = new ArrayList<String>();
            list.add("Br_Name");
            list.add("Br_City");
            list.add("Br_Zip");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);
            att = String.valueOf(s2.getSelectedItem());
        }
        if(sp1.contentEquals("Supplier")) {
            List<String> list = new ArrayList<String>();
            list.add("S_Name");
            list.add("S_City");

            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);
            att = String.valueOf(s2.getSelectedItem());
        }
        if(sp1.contentEquals("Product")) {
            List<String> list = new ArrayList<String>();
            list.add("P_Name");

            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);
            att = String.valueOf(s2.getSelectedItem());
        }
         if(sp1.contentEquals("Customer")) {
            List<String> list = new ArrayList<String>();
            list.add("C_city");
            list.add("C_FirstName");
            list.add("C_State");
             list.add("C_LastName");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);
            att = String.valueOf(s2.getSelectedItem());
        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
    public void findItFromDatabase(View view) {
        scrollView.removeAllViews();
        EditText et = (EditText) findViewById(R.id.widget43);
        String txt = et.getText().toString();
        String sql =  "select * from "+ sp1 + " where " + att +" = "+ "'" + txt + "'";
        System.out.println(sql);
        Cursor cursor = DBOperator.getInstance().execQuery(sql);
        scrollView.addView(new TableView(this.getBaseContext(),cursor));


    }
    public void goBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

}
