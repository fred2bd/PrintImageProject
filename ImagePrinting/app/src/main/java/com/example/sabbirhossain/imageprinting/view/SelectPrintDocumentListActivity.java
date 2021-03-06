package com.example.sabbirhossain.imageprinting.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.sabbirhossain.imageprinting.R;
import com.example.sabbirhossain.imageprinting.utility.AppConstant;

public class SelectPrintDocumentListActivity extends AppCompatActivity {

    CheckBox customerPhoto, customerId, nomineePhoto, nomineeId;
    Button proceedBtn;
    String TAG = "SelectPrintDocumentListActivity";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_print_document_list);
        customerPhoto = (CheckBox) findViewById(R.id.customerPhoto);
        customerId = (CheckBox) findViewById(R.id.customerId);
        nomineeId = (CheckBox) findViewById(R.id.nomeneeId);
        nomineePhoto = (CheckBox) findViewById(R.id.nomineePhoto);


        proceedBtn = (Button) findViewById(R.id.proceed);
        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (customerId.isChecked() || customerPhoto.isChecked() || nomineeId.isChecked() || nomineePhoto.isChecked()) {

                    if (customerId.isChecked()) {
                        AppConstant.customerIdFlag =true;
                    }
                    if (customerPhoto.isChecked()) {
                        AppConstant.customerPhotoFlag =true;

                    }
                    if (nomineeId.isChecked()) {
                        AppConstant.nomineeIdFlag =true;

                    }
                    if (nomineePhoto.isChecked()) {
                        AppConstant.nomineePhotoFlag =true;

                    }
                    Intent intent=new Intent(SelectPrintDocumentListActivity.this,CaptureDocumentsActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(SelectPrintDocumentListActivity.this,"select something",Toast.LENGTH_LONG).show();
                }


            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        AppConstant.nomineeIdFlag =false;
        AppConstant.nomineePhotoFlag =false;
        AppConstant.customerIdFlag =false;
        AppConstant.customerPhotoFlag =false;
    }
}
