package com.gdd;

import com.gdd.SqliteBuslineActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MenuTextActivity extends Activity {


	
	public static final int ITEM0=Menu.FIRST;//ϵͳֵ
	public static final int ITEM1=Menu.FIRST+1;
	public static final int ITEM2=Menu.FIRST+2;
	public static final int ITEM3=Menu.FIRST+3;

	// private Menu menu;
	// private Menu menu

	/** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.mymenu);

//	        
	    }
	    
	    
	    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
	  super.onCreateOptionsMenu(menu);
	  menu.add(0, ITEM0, 0,"��ѯ��");
	  menu.add(0, ITEM1,0,"��ѯ·��");
	  menu.add(0, ITEM2,0,"����");
	  menu.add(0, ITEM3,0,"�˳�");
	  menu.findItem(ITEM1);//�������ð�ť�ı���
	  return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	  
	  switch (item.getItemId()) {
	  case ITEM0:
	   actionClickMenuItem1();
	   break;
	  case ITEM1:
	   actionClickMenuItem2();
	   break;
	  case ITEM2:
	   actionClickMenuItem3();
	   break;
	  case ITEM3:
	   actionClickMenuItem4();
	   break;
	  }
	  
	  return super.onOptionsItemSelected(item);
	}

	//��һ���¼��ķ���

	   private void actionClickMenuItem1(){
//		  	 Intent itemintent = new Intent(this,ActivityShowDescription.class);
		   
		   Intent my_intent0=new Intent(this,BusLineSAXActivity.class);
		   startActivity(my_intent0);
	   }
	   //��2���¼��ķ���
	   private void actionClickMenuItem2(){

		   Intent my_intent1=new Intent(this,SqliteBuslineActivity.class);
		   startActivity(my_intent1);
	    
	   }
	   private void actionClickMenuItem3(){
		   
		   



	   
	    
	    
	  }
	   
	   private void actionClickMenuItem4(){

		  System.exit(0);
	    
	   }
	    
	}