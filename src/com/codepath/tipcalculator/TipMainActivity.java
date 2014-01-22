package com.codepath.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TipMainActivity extends Activity {
	
	private Button button10, button15, button20;
	TextView tipTotal;
	EditText billAmmount;
	double tipPercent;
	String defaultTipText = "Tip is: ";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tip_calculator);
        button10 = (Button) findViewById(R.id.btn_10);
        button15 = (Button) findViewById(R.id.btn_15);
        button20 = (Button) findViewById(R.id.btn_20);
        billAmmount = (EditText) findViewById(R.id.et_total);
        tipTotal = (TextView) findViewById(R.id.tv_tip);
        tipPercent = 0;
        
        button10.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				tipPercent = 0.1;
				calculateTip();
			}
		});
        
        button15.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				tipPercent = 0.15;
				calculateTip();
			}
		});
        
        button20.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				tipPercent = 0.2;
				calculateTip();
			}
		});
        
        billAmmount.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence billString, int arg1, int arg2, int arg3) {
				if(billString.length() > 0){
					calculateTip();
				} else {
					tipTotal.setText(defaultTipText);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}
		});
    }

    public void calculateTip() {
    	if(billAmmount.getText().length() > 0){
    		double totalBill = Double.parseDouble(billAmmount.getText().toString());
    		if(totalBill > 0){
    	    	double tip = totalBill * tipPercent;
    	    	tipTotal.setText(defaultTipText + String.format("%.2f", tip));
        	}
    	}
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
