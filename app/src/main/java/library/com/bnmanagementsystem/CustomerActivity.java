package library.com.bnmanagementsystem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;


import library.com.bnmanagementsystem.util.DBOperator;
import library.com.bnmanagementsystem.view.TableView;


public class CustomerActivity extends ActionBarActivity {
    ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        scrollView=(ScrollView)this.findViewById(R.id.scrollView2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_customer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void searchCus(View view){
        scrollView.removeAllViews();
        String sql = "";
        int et11 = 0;
        EditText et1 = (EditText) findViewById(R.id.editText_CustomerID);
        if(et1.getText().toString() !=null && !et1.getText().toString().isEmpty() ) {
             et11 = Integer.parseInt(et1.getText().toString());
        }
        EditText et2 = (EditText) findViewById(R.id.editText_CustomerF);
        String et22 = et2.getText().toString();
        EditText et3 = (EditText) findViewById(R.id.editText_CustomerL);
        String et33 = et3.getText().toString();
        if((et11!=0 && !et22.isEmpty()) || (!et22.isEmpty() && !et33.isEmpty()) || (et11!=0 && !et33.isEmpty())){
            System.out.println("m here");
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Multiple criteria selected");
            alertDialog.setMessage("Please use only one criteria while searching");

            // alertDialog.setIcon(R.drawable.welcome);

            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                }
            });

            alertDialog.show();
        }else if(et11 != 0 ){
            sql = "Select * from Customer where C_ID = " + et11;
            Cursor cursor= DBOperator.getInstance().execQuery(sql);
            scrollView.addView(new TableView(this.getBaseContext(),cursor));
        }else if(et22 != null && !et22.isEmpty()){
            sql = "Select * from Customer where C_FirstName = '" + et22 + "'";
            Cursor cursor= DBOperator.getInstance().execQuery(sql);
            scrollView.addView(new TableView(this.getBaseContext(),cursor));
        }else if(et33 != null && !et33.isEmpty()){
            sql = "Select * from Customer where C_LastName = '" + et33 + "'";
            Cursor cursor= DBOperator.getInstance().execQuery(sql);
            scrollView.addView(new TableView(this.getBaseContext(),cursor));
        }else {

             AlertDialog alertDialog = new AlertDialog.Builder(this).create();
             alertDialog.setTitle("Hey ! Don't be lazy");
             alertDialog.setMessage("Put some value in Search Box.");
             // alertDialog.setIcon(R.drawable.welcome);

             alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface dialog, int which) {
                     Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                 }
             });

             alertDialog.show();
         }

    }
    public void goBackMer(View view){
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }
    public void delCus(View view){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Are you sure about it?");
        alertDialog.setMessage("Once Deleted, Always deleted!");
        // alertDialog.setIcon(R.drawable.welcome);

        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Gone Forever", Toast.LENGTH_SHORT).show();

            }
        });

        alertDialog.show();
        String sql = "";
        int et11 = 0;
        EditText et1 = (EditText) findViewById(R.id.editText_CustomerID);
        if(et1.getText().toString() !=null && !et1.getText().toString().isEmpty() ) {
            et11 = Integer.parseInt(et1.getText().toString());
        }
        EditText et2 = (EditText) findViewById(R.id.editText_CustomerF);
        String et22 = et2.getText().toString();
        EditText et3 = (EditText) findViewById(R.id.editText_CustomerL);
        String et33 = et3.getText().toString();
        if(et11 != 0 ){
            Cursor cursor;

            sql = "Delete from Customer where C_ID = " + et11;
            System.out.print(sql);
            cursor= DBOperator.getInstance().execQuery(sql);


        }else if(et22 != null && !et22.isEmpty()){
            sql = "Delete from Customer where C_FirstName = '" + et22 + "'";
            Cursor cursor= DBOperator.getInstance().execQuery(sql);

        }else if(et33 != null && !et33.isEmpty()) {
            sql = "Delete from Customer where C_LastName = '" + et33 + "'";
            Cursor cursor = DBOperator.getInstance().execQuery(sql);

        }
    }
 public void edittable(View view){

 }
    public void addcus(View view){
        Intent intent = new Intent(this, CustomeraddActivity.class);
        this.startActivity(intent);
    }

    }

