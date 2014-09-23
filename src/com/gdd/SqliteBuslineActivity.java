package com.gdd;



//import android.R;
import java.io.UnsupportedEncodingException;

import com.gdd.R;
import com.gdd.db.DbHelper;

import android.app.Activity;
//import android.content.ContentValues;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//import com.gdd.SAX.SAXHandler;
//import com.gdd.data.LineItem;
//import com.gdd.data.LinesFeed;

public class SqliteBuslineActivity extends Activity {
	
	private Button bt1=null;
	private Button bt2=null;
	private EditText db_et1=null;
	private EditText db_et2=null;
//	private ListView db_lv1=null;
	private TextView db_tv1=null;
	
	private String db_str1=null;
	private String db_str2=null;
	private String db_str3=null;
	
	private String sn=null;
	
//	private final String DB_URL="http://openapi.aibang.com/bus/lines?app_key=c9a65fd26b602d08a8aa939881e9fe56";
//	private LinesFeed feed=null;
	SQLiteDatabase db;
	
	public String table_name="busline";
	public String db_name="city.sqlite";
	public String db_name1="dalian.db";
	public String table_name1="site";
	public String db_name2="mydalian.db";
	public String table_name2="bus_line";
	
	
	final DbHelper helper=new DbHelper(this, db_name2, null, 1);


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_lay);
		bt1=(Button)findViewById(R.id.db_bt1);
		bt2=(Button)findViewById(R.id.db_bt2);
		db_et1=(EditText)findViewById(R.id.db_et1);
		db_et2=(EditText)findViewById(R.id.db_et2);
//		db_lv1=(ListView)findViewById(R.id.db_search_list);
		db_tv1=(TextView)findViewById(R.id.db_tv1);
		
		
		db=helper.getWritableDatabase();
		
//		
		Cursor c_test=db.query(table_name2, null, null, null, null, null, null);
		if(!c_test.moveToFirst())
		{
        initdatabase(db);
		}
//	Cursor c=db.query(table_name, null, null, null, null, null, null);
//	for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
//		Toast.makeText(getApplicationContext(),
//				c.getInt(0)+",name:"+c.getString(1)+",number:"+c.getInt(2)+".",
//				Toast.LENGTH_SHORT).show();   
//	Cursor c=db.query(table_name, null, null, null, null, null, null);
//	for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
//	{
//		Toast.makeText(getApplicationContext(),
//				"name:"+c.getString(1)+"/nstats:"+c.getString(2)+";",
//				Toast.LENGTH_SHORT).show();
//	}
	bt1.setOnClickListener(new OnClickListener()
	{
		public void onClick(View v)
		{
			Cursor c1=db.query(table_name2, null, "_id<8", null, null, null, null);	
			for(c1.moveToFirst();!c1.isAfterLast();c1.moveToNext())
			{
				 byte bytes[]=c1.getBlob(2);                
				 try {
					sn=new String(bytes,"gb2312");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				 finally{
//				Toast.makeText(getApplicationContext(),
//						"site_bus_id:"+c1.getInt(1)+"site_name:"+sn,
//						Toast.LENGTH_SHORT).show();
					 Toast.makeText(getApplicationContext(), 
							 "site_bus_id:"+c1.getInt(1)+"site_name:"+c1.getString(2),
							 Toast.LENGTH_SHORT).show();
				 }
			}
		}
	});
	
	
	
	bt2.setOnClickListener(new OnClickListener()
	{
		public void onClick(View v3)
		{
			
//			int tag=0;
			int i=1;
			db_str1="bus_site ="+"'"+db_et1.getText().toString()+"'";
			db_str2="bus_site ="+"'"+db_et2.getText().toString()+"'";
			for(i=1;i<2;i++)
			{
				
				try
				{

				
				Cursor c2=db.query(table_name2, null, db_str1, null, null, null, null);
				Cursor c3=db.query(table_name2, null, db_str2, null, null, null, null);

				
				
				switch(i)
				{
				case 1:
					for(c2.moveToFirst();!c2.isAfterLast();c2.moveToNext())
					{
						for(c3.moveToFirst();!c3.isAfterLast();c3.moveToNext())
						{
							try{
								
								if(c2.getInt(1)==c3.getInt(1))
									break;
							}
							catch(Exception e){
//								tag=1;
							}

						}
						
//						try{}
//						catch(Exception e){
//							
//						}	
						try{
							
							if(c2.getInt(1)==c3.getInt(1))
								break;
						}
						catch(Exception e){
//							tag=1;
						}

						
						
					}
//					if(tag==0)
					if(!c2.isAfterLast()&&!c3.isAfterLast()&&c2.getInt(1)==c3.getInt(1))
					{
//						Integer I1=new Integer(c2.getInt(1));
//						db_str3=I1.toString();
						db_str3=String.valueOf(c2.getInt(1));
						db_tv1.setText("请乘坐："+db_str3+"路车");
//						tag=0;

					}
					else{
						Toast.makeText(getApplicationContext(), "请用2次喽",
								Toast.LENGTH_LONG).show();
					}
				
					break;
				case 2:
					break;
					default:
						break;
					
				}
				
				
			}
			catch(Exception e)
			{
				
				Toast.makeText(getApplicationContext(), "没有站，请重新输入。",
						Toast.LENGTH_SHORT).show();
				return;
			}
				
			}
			

	
			
		}
	});
		
	}



private void initdatabase(SQLiteDatabase db2) {
		// TODO Auto-generated method stub
	ContentValues cv=new ContentValues();

	cv.put("bus_id", 406);
	cv.put("bus_site", "大连理工大学");
	db.insert(table_name2, null, cv);

	cv.put("bus_id", 406);
	cv.put("bus_site", "黑石礁");
	db.insert(table_name2, null, cv);
	
	cv.put("bus_id", 406);
	cv.put("bus_site", "海事大学");
	db.insert(table_name2, null, cv);

	cv.put("bus_id", 406);
	cv.put("bus_site", "希望广场");
	db.insert(table_name2, null, cv);

	cv.put("bus_id", 406);
	cv.put("bus_site", "和平广场");
	db.insert(table_name2, null, cv);

	cv.put("bus_id", 23);
	cv.put("bus_site", "东财");
	db.insert(table_name2, null, cv);
	
	cv.put("bus_id", 23);
	cv.put("bus_site", "理工东门");
	db.insert(table_name2, null, cv);

	cv.put("bus_id", 23);
	cv.put("bus_site", "数码广场");
	db.insert(table_name2, null, cv);
	
	cv.put("bus_id", 23);
	cv.put("bus_site", "青泥洼桥");
	db.insert(table_name2, null, cv);
	
	cv.put("bus_id", 23);
	cv.put("bus_site", "星海浴场");
	db.insert(table_name2, null, cv);
		
	}



//	private void initdatabase(SQLiteDatabase db2) {
//		
//		
////		ContentValues cv=new ContentValues();
////		cv.put("name", "gongdongdong");
////		cv.put("number", 201081759);
////		db2.insert(table_name, "", cv);
////		int my_no=0;
//		
//		ContentValues cv=new ContentValues();
//		
////		for(my_no=0;my_no<10;my_no++)
////		{
////			cv.put("name", getFeed());
////		}
//		cv.put("name", "12");
//		cv.put("stats", "六灶；二造");
//		db.insert(table_name, "", cv);
//
//		cv.put("name", "13");
//		cv.put("stats", "六灶；二造");
//		db.insert(table_name, "", cv);
//		
//		
//	}
	public void onDestory(){
		super.onDestroy();
		db.delete(table_name, null, null);
		
		
		
	}
	
}
