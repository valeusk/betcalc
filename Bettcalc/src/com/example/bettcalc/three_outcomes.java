

package com.example.bettcalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class three_outcomes extends Activity implements OnClickListener {
	
	final int MENU_RESET_ID = 1;
	final int MENU_QUIT_ID = 2;
	
	EditText etk2;//коэффициент 1
	EditText etk1;//коэфициент 2
	EditText etk3;//коэффициент 3
	EditText etsum1;//сумма 1
	EditText etsum2;//сумма 2
	TextView sum3;//сумма 3
	
	TextView procent1;//процент 1
	TextView procent2;//процент 2
	TextView procent3;//процент 3
	TextView profit1;//прибыль 1
	TextView profit2;//прибыль 2
	TextView profit3;//прибыль 3
	Button count;//считать
	Button clr;//ичистить
	
	//округление
	private static float round(float number, int scale) 
	{
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
				setContentView(R.layout.three_outcomes);
			    //Объявление
				etk1 = (EditText) findViewById(R.id.etk1);
				etk2 = (EditText) findViewById(R.id.etk2);
		        etk3 = (EditText) findViewById(R.id.etk3);
		        
		        etsum1 = (EditText) findViewById(R.id.etsum1);
		        etsum2 = (EditText) findViewById(R.id.etsum2);
				sum3 = (TextView) findViewById(R.id.tvsum3);
		        
				procent1 = (TextView) findViewById(R.id.tvProcent1);
				procent2 = (TextView) findViewById(R.id.tvProcent2);
				procent3 = (TextView) findViewById(R.id.tvProcent3);
		        
				profit1 = (TextView) findViewById(R.id.tvProfit1);
				profit2 = (TextView) findViewById(R.id.tvProfit2);
				profit3 = (TextView) findViewById(R.id.tvProfit3);
				
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
	    float vk3 = 0;
	    
	    float vs1 = 0;
	    float vs2 = 0;
	    float vs3 = 0;
	    
	    float V1 = 0;
	    float V2 = 0;
	    float V3 = 0;
	    	    
	    float procent = 0;
	    float vprocent1 = 0;
	    float vprocent2 = 0;
	    float vprocent3 = 0;
	    
	    float vprof1 = 0;
	    float vprof2 = 0;
	    float vprof3 = 0;
	    
	    float allsum = 0;
	    
	    // Проверяем поля на пустоту
	    if (TextUtils.isEmpty(etk1.getText().toString())||
	    	TextUtils.isEmpty(etk2.getText().toString())||
	    	TextUtils.isEmpty(etk3.getText().toString())||
	    	
	    	TextUtils.isEmpty(etsum1.getText().toString())||
	    	TextUtils.isEmpty(etsum2.getText().toString())) 
	    {
	      return;
	    }
	    //читаем EditText и заполняем переменные числами
	    vk1 = Float.parseFloat(etk1.getText().toString());
	    vk2 = Float.parseFloat(etk2.getText().toString());
	    vk3 = Float.parseFloat(etk3.getText().toString());
	    
	    vs1 = Float.parseFloat(etsum1.getText().toString());
	    vs2 = Float.parseFloat(etsum2.getText().toString());
	    
	    //обработка нажатий
	    switch (v.getId()) 
	    {
	    case R.id.btcount:
	      V1 = vk1*vs1;
	      V2 = vk2*vs2;
	      vs3 = ((V1 + V2)/2)/vk3;
	      V3 = vk3*vs3;
	      allsum = vs2 + vs1 + vs3;
	      
	      vprof1 = V1 - allsum;
	      vprof2 = V2 - allsum;
	      vprof3 = V3 - allsum;
		  
	      sum3.setText("СТ3 = " + Float.toString(round(vs3, 2)));  
	      vprocent1 = ((V1 - allsum)/allsum)*100;
		  procent1.setText(Float.toString(round(vprocent1, 2)));
		  profit1.setText(Float.toString(round(vprof1, 2)));
		     if (vprocent1 < 0)
			       	{
			    	procent1.setTextColor(getResources().getColor(R.color.Attention));
			    	profit1.setTextColor(getResources().getColor(R.color.Attention));
			       	}
			    else
			    	{
			    	procent1.setTextColor(getResources().getColor(R.color.Green));
			    	profit1.setTextColor(getResources().getColor(R.color.Green));
			    	}
		    	
				    vprocent2 = ((V2 - allsum)/allsum)*100;
				    procent2.setText(Float.toString(round(vprocent2, 2)));
				    profit2.setText(Float.toString(round(vprof2, 2)));
					    if (vprocent2 < 0)
					       	{
					    	procent2.setTextColor(getResources().getColor(R.color.Attention));
					    	profit2.setTextColor(getResources().getColor(R.color.Attention));
					       	}
					    else
					    	{
					    	procent2.setTextColor(getResources().getColor(R.color.Green));
					    	profit2.setTextColor(getResources().getColor(R.color.Green));
					    	}
		    
							    vprocent3 = ((V3 - allsum)/allsum)*100;
							    procent3.setText(Float.toString(round(vprocent1, 2)));
							    profit3.setText(Float.toString(round(vprof3, 2)));
								    if (vprocent3 < 0)
								       	{
								    	procent3.setTextColor(getResources().getColor(R.color.Attention));
								    	profit3.setTextColor(getResources().getColor(R.color.Attention));
								       	}
								    else
								    	{
								    	procent3.setTextColor(getResources().getColor(R.color.Green));
								    	profit3.setTextColor(getResources().getColor(R.color.Green));
								    	}
							    
		    
	      break;
	    case R.id.btnCl:
	    	etk1.setText("");
	    	etk2.setText("");
	    	etk3.setText("");
	    	etsum1.setText("");
	    	etsum2.setText("");
	    	
	    	sum3.setText("");
	    	procent1.setText("");
	    	procent2.setText("");
	    	procent3.setText("");
	    	profit1.setText("");
	    	profit2.setText("");
	    	profit3.setText("");
	      break;
	   
	    default:
	      break;
	    }
	 
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
		    	/*etk1.setText("");
		    	etk2.setText("");
		    	etk3.setText("");
		    	etsum1.setText("");
		    	etsum2.setText("");
		    	
		    	sum3.setText("");
		    	procent1.setText("");
		    	procent2.setText("");
		    	procent3.setText("");
		    	profit1.setText("");
		    	profit2.setText("");
		    	profit3.setText("");*/
		    	Intent intent = new Intent(this, MainActivity.class);
			    startActivity(intent);
		    break;
		    case MENU_QUIT_ID:
		    // выход из приложения
		    finish();
		    break;
		    }
	    return super.onOptionsItemSelected(item);
	    }    
	    
}
