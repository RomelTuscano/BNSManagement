package library.com.bnmanagementsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import library.com.bnmanagementsystem.util.DBOperator;


public class MainActivity extends Activity implements View.OnClickListener {

    private ImageButton Quick_lookup_btn;
    private ImageView Order_inforamtion_btn;
    private ImageView Inventory_information_btn;
    private ImageView Supplier_information_btn;
    private ImageButton Customer_information_btn;
    private ImageButton Customerize_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        Quick_lookup_btn = (ImageButton) findViewById(R.id.Lookup_pic);
        Customer_information_btn =(ImageButton) findViewById(R.id.Customer_pic);
        Customerize_btn =(ImageButton) findViewById(R.id.customize_pic);

        Quick_lookup_btn.setOnClickListener(this);
        Customer_information_btn.setOnClickListener(this);
        Customerize_btn.setOnClickListener(this);

        try{
            DBOperator.copyDB(getBaseContext());
        }catch(Exception e){
            e.printStackTrace();
        }


    }


        @Override
        public void onClick(View v) {

            switch (v.getId()){

                case R.id.Lookup_pic:

                    Intent Lookupgo = new Intent (MainActivity.this, Quick_Lookup_activity.class);
                    startActivity(Lookupgo);
                    break;

                case R.id.Customer_pic:
                    Intent Customergo = new Intent (MainActivity.this, CustomerActivity.class);
                    startActivity(Customergo);
                    break;

                case R.id.customize_pic:
                    Intent customerizego = new Intent (MainActivity.this,CustomizeActivity.class);
                    startActivity(customerizego);
                    break;

            }



        }
}

