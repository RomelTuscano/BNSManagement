package library.com.bnmanagementsystem;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import library.com.bnmanagementsystem.util.DBOperator;


/**
 * Created by Romel on 4/27/2015.
 */
public class CustomeraddActivity extends Activity {
    String lastname;
    String firstname;
    String state;
    String city;
    String zip;
    String Phone;
    String age;
    String gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.customeradd);
        //copy database file
        try{
            DBOperator.copyDB(getBaseContext());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void svaetoDB(View v) {
        lastname = ((EditText) findViewById(R.id.C_LastName)).getText().toString();
        firstname = ((EditText) findViewById(R.id.C_FirstName)).getText().toString();
        state = ((EditText) findViewById(R.id.C_State)).getText().toString();
        city = ((EditText) findViewById(R.id.C_city)).getText().toString();
        zip = ((EditText) findViewById(R.id.C_Zip)).getText().toString();
        Phone = ((EditText) findViewById(R.id.C_PhoneNumber)).getText().toString();
        age = ((EditText) findViewById(R.id.C_Age)).getText().toString();
        gender = ((EditText) findViewById(R.id.C_Gender)).getText().toString();

        if(Phone == null || Phone.isEmpty()){
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Warning");
            alertDialog.setMessage("Phone Number cant be empty");
            // alertDialog.setIcon(R.drawable.welcome);

            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                }
            });

            alertDialog.show();
        }else{
            int ag = 0;
            int zi = 0;
            int ph = Integer.parseInt(Phone);
            if(age != null  && !age.isEmpty()){
                ag = Integer.parseInt(age);
            }
            if(zip != null && !zip.isEmpty()){
                zi = Integer.parseInt(zip);
            }
            String sql = "Insert into Customer (C_ID,C_LastName,C_FirstName,C_State,C_city,C_Zip,C_PhoneNumber,C_Age,C_Gender) values (" + null+ "," +lastname+ "," +firstname+ "," +state+ "," + city+ "," + zi+ "," +ph + "," +ag+ " ," +gender+ ")";
            Cursor cursor = DBOperator.getInstance().execQuery(sql);
            Toast.makeText(getBaseContext(), "Done",
                    Toast.LENGTH_SHORT).show();

        }
    }

    public void gotopri(View v) {
        Intent intent = new Intent(this, CustomerActivity.class);
        this.startActivity(intent);
    }

}
