package com.example.bettcalc;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	final int MENU_RESET_ID = 1;
	final int MENU_QUIT_ID = 2;
	
	EditText etk2;
	EditText etk1;
	EditText etsum1;
	TextView tvres1;
	TextView textView2;
	TextView tvsum2;
	TextView profit;
	TextView tVprocent;
	Button count;
	Button clr;
	
	
	String oper = "";
	
	private static float round(float number, int scale) {
        int pow = 10;
        for (int i = 1; i < scale; i++)
            pow *= 10;
        float tmp = number * pow;
        return (float) (int) ((tmp - (int) tmp) >= 0.5f ? tmp + 1 : tmp) / pow;
    }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_main);
			    //Объявление
				etk2 = (EditText) findViewById(R.id.etk2);
		        etk1 = (EditText) findViewById(R.id.etk1);
				etsum1 = (EditText) findViewById(R.id.etsum1);
				
				//tvres1 = (TextView) findViewById(R.id.res1);
				tvsum2 = (TextView) findViewById(R.id.tvsum2);
				profit = (TextView) findViewById(R.id.tvProfit);
				tVprocent = (TextView) findViewById(R.id.tvProc);
				count = (Button) findViewById(R.id.btcount);
				clr = (Button) findViewById(R.id.btnCl);
				// прописываем обработчик
				count.setOnClickListener(this);
				clr.setOnClickListener(this);
			}

	@Override
	  public void onClick(View v) 
	{
	    // TODO Auto-generated method stub
	    float vk1 = 0;//коэффициент 1
	    float vk2 = 0;//коэффициент 2
	    float vs1 = 0;//сумма ставки 1
	    
	    float sum2 = 0;
	    float procent = 0;
	    float allsum = 0;
	    
	    // Проверяем поля на пустоту
	    if (TextUtils.isEmpty(etk2.getText().toString())
	        || TextUtils.isEmpty(etk1.getText().toString())||TextUtils.isEmpty(etsum1.getText().toString())) {
	      return;}
	 // читаем EditText и заполняем переменные числами
	    vk2 = Float.parseFloat(etk2.getText().toString());
	    vk1 = Float.parseFloat(etk1.getText().toString());
	    vs1 = Float.parseFloat(etsum1.getText().toString());
	    
	    switch (v.getId()) {
	    case R.id.btcount:
	      
	      sum2 = (vk1 * vs1)/vk2;
	      allsum = sum2 + vs1 ;
		    procent = ((vk1*vs1- allsum)/allsum)*100;
		    if (procent < 0)
		    	{
		    	tVprocent.setTextColor(getResources().getColor(R.color.Attention));
		    	profit.setTextColor(getResources().getColor(R.color.Attention));
		    	}
		    else
		    	{
		    	tVprocent.setTextColor(getResources().getColor(R.color.Green));
		    	profit.setTextColor(getResources().getColor(R.color.Green));
		    	}
		    tvsum2.setText("СТ2 = " + Float.toString(round(sum2, 2)));
		    profit.setText(Float.toString(round((vk1*vs1 - allsum), 2)));
		    tVprocent.setText(Float.toString(round(procent,2)) + " %");
	      break;
	    case R.id.btnCl:
	    	tVprocent.setText("");
	    	tvsum2.setText("");
		    profit.setText("");
		    etk2.setText("");
			etk1.setText("");
			etsum1.setText("");
	      break;
	   
	    default:
	      break;
	    }
	    //доделать логику
	    
	    
	    
	}
	    @Override
	public boolean onCreateOptionsMenu(Menu menu) 
	    {
	    	menu.add(0, MENU_RESET_ID, 0, "Сброс");
	    	menu.add(0, MENU_QUIT_ID, 0, "Выход");
	    	return super.onCreateOptionsMenu(menu);
	    }

	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) 
	    {
	    // TODO Auto-generated method stub
	    switch (item.getItemId()) 
		    {
		    case MENU_RESET_ID:
		    // очищаем поля
		    	tvsum2.setText("");
			    profit.setText("");
			    tVprocent.setText("");
		    	etk2.setText("");
				etk1.setText("");
				etsum1.setText("");
		    break;
		    case MENU_QUIT_ID:
		    // выход из приложения
		    finish();
		    break;
		    }
	    return super.onOptionsItemSelected(item);
	    }    
	    
}
