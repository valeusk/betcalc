package com.example.bettcalc;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	//поля
	EditText editText1;
	EditText editText2;
	EditText editText3;
	//отображение
	TextView tvres1;
	TextView textView2;
	TextView tvsum2;
	TextView tv4;
	TextView tVprocent;
	Button button1;
	
	String oper = "";
	
	private static float round(float number, int scale) {
        int pow = 10;
        for (int i = 1; i < scale; i++)
            pow *= 10;
        float tmp = number * pow;
        return (float) (int) ((tmp - (int) tmp) >= 0.5f ? tmp + 1 : tmp) / pow;
    }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		editText1 = (EditText) findViewById(R.id.k2);
		editText2 = (EditText) findViewById(R.id.k1);
		editText3 = (EditText) findViewById(R.id.sum1);
		
		tvres1 = (TextView) findViewById(R.id.res1);
		tvsum2 = (TextView) findViewById(R.id.textView4);
		tv4 = (TextView) findViewById(R.id.textView3);
		tVprocent = (TextView) findViewById(R.id.textView1);
		button1 = (Button) findViewById(R.id.button1);
		
		// прописываем обработчик
		button1.setOnClickListener(this);
	}

	@Override
	  public void onClick(View v) {
	    // TODO Auto-generated method stub
	    float vk1 = 0;//коэффициент 1
	    float vk2 = 0;//коэффициент 2
	    float vs1 = 0;//сумма ставки 1
	    
	    float sum2 = 0;
	    float procent = 0;
	    float allsum = 0;
	    
	    // Проверяем поля на пустоту
	    if (TextUtils.isEmpty(editText1.getText().toString())
	        || TextUtils.isEmpty(editText2.getText().toString())||TextUtils.isEmpty(editText3.getText().toString())) {
	      return;}
	 // читаем EditText и заполняем переменные числами
	    vk2 = Float.parseFloat(editText1.getText().toString());
	    vk1 = Float.parseFloat(editText2.getText().toString());
	    vs1 = Float.parseFloat(editText3.getText().toString());
	    
	    switch (v.getId()) {
	    case R.id.button1:
	      oper = "=";
	      sum2 = (vk1 * vs1)/vk2;
	      break;
	    /*case R.id.btnSub:
	      oper = "-";
	      sum2 = num1 - num2;
	      break;
	    case R.id.btnMult:
	      oper = "*";
	      result = num1 * num2;
	      break;
	    case R.id.btnDiv:
	      oper = "/";
	      result = num1 / num2;
	      break;*/
	    default:
	      break;
	    }
	    //доделать логику
	    
	    allsum = sum2 + vs1 ;
	    procent = ((vk1*vs1- allsum)/allsum)*100;
	    
	    tvsum2.setText("СТ2 = " + Float.toString(round(sum2, 2)));
	    tv4.setText(Float.toString(round((vk1*vs1 - allsum), 2)));//профит
	    tvres1.setText(" = " + Float.toString(round((vk1*vs1),2)));
	    
	    tVprocent.setText(Float.toString(round(procent,2)) + " %");
	    
	}
	    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
