package com.gdd;

//import java.io.InputStream;
//import java.net.URL;
//import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.protocol.HTTP;
//import org.apache.http.util.EntityUtils;
//import org.xml.sax.InputSource;
//import org.xml.sax.XMLReader;

import com.gdd.SAX.SAXHandler;
import com.gdd.data.LineItem;
import com.gdd.data.LinesFeed;
import com.gdd.db.DbHelper;


import android.app.Activity;
//import android.content.ContentValues;
import android.content.Intent;
//import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class BusLineSAXActivity extends Activity implements OnItemClickListener {
    /** Called when the activity is first created. */
	
	public final String URL = "http://openapi.aibang.com/bus/lines?app_key=c9a65fd26b602d08a8aa939881e9fe56";
	public final String tag = "BusLine";
	
	private String str1=null;
	private String str2=null;
//	private String str3=null;
	private String url0=null;
//	private String url1=null;
	
//	SQLiteDatabase db;
//	public String table_name="busline";
//	public String db_name="city.sql";
//	final DbHelper helper=new DbHelper(this, db_name, null, 1);
	
	Button bt1=null;
	Button bt2=null;
	EditText ed1=null;
	EditText ed2=null;
				

	private LinesFeed feed=null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
//		db=helper.getWritableDatabase();
		
		
        ed1=(EditText)findViewById(R.id.city);
        ed2=(EditText)findViewById(R.id.bus);
        bt1=(Button)findViewById(R.id.search);
        bt2=(Button)findViewById(R.id.update);
        bt1.setOnClickListener(new OnClickListener (){

			public void onClick(View v1) {
				
		        str1=null;
		        str2=null;
				str1=ed1.getText().toString();
				str2=ed2.getText().toString();
				url0=URL+"&city="+str1+"&q="+str2;
//				Toast.makeText(getApplicationContext(), url0, Toast.LENGTH_LONG).show();
		        feed = getFeed(url0);
		        showlist();	

			}
        	
        });
//        bt2.setOnClickListener(new OnClickListener()
//        {
//        	public void onClick(View v2)
//        	{
////   SimpleAdapter adapter = new SimpleAdapter(this, feed.getAllLinesForListView(),
////      android.R.layout.simple_list_item_2, new String[] { LineItem.NAME,LineItem.STATS },
////      new int[] { android.R.id.text1 , android.R.id.text2});        		
//        		int my_num=0;
//        		url1=URL+"&city=宁波&q=";
//
//        		for(my_num=0;my_num<10;my_num++)
//        		{
//            		int temp;
//        			temp=my_num;
//        			str3=""+temp;
//        			feed=getFeed(url1+str3);
//        			if(feed.getAllLines()!=null)
//        			{
//        			
//        				ContentValues cv=new ContentValues();
//        				cv.put("name", feed.getLine(0).getName());
//        				cv.put("stats", feed.getLine(0).getStats());
//        				db.insert(table_name, "", cv);
//        			
//        			}
//        		}
//    			Cursor c=db.query(table_name, null, null, null, null, null, null);
//    			for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
//    				Toast.makeText(getApplicationContext(),
//    						c.getInt(0)+",name:"+c.getString(1)+",number:"+c.getInt(2)+".",
//    						Toast.LENGTH_SHORT).show();   
//        		Cursor c=db.query(table_name, null, null, null, null, null, null);
//        		for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
//        		{
//        			Toast.makeText(getApplicationContext(),
//        					"name:"+c.getString(1)+"/nstats:"+c.getString(2)+";",
//        					Toast.LENGTH_LONG).show();
//        		}
//        	}
//        });

        
//        feed = getFeed(URL);
//        showlist();
        
    }

	private void showlist() 
	{
		
        ListView itemlist = (ListView) findViewById(R.id.itemlist);     
        if (feed == null)
        {
        	setTitle("访问的api无效");
        	return;
        }

        SimpleAdapter adapter = new SimpleAdapter(this, feed.getAllLinesForListView(),
       		 android.R.layout.simple_list_item_2, new String[] { LineItem.NAME,LineItem.STATS },
       		 new int[] { android.R.id.text1 , android.R.id.text2});
        itemlist.setAdapter(adapter);
        itemlist.setOnItemClickListener(this);  
        itemlist.setSelection(0);
		
		
		
	}
	private LinesFeed getFeed(String url1) {
		try
    	{
//    	   URL url = new URL(url1);
    	   HttpGet request = null;
    	   HttpResponse resp = null;
//    	   InputStream is = null;
    	   DefaultHttpClient client = new DefaultHttpClient();
    	   request =new HttpGet(url1);
//    	   ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
//    	   params.add(new BasicNameValuePair("bookname", "The first test of smart"));
//    	   request.setEntity(new UrlEncodedFormEntity(null, HTTP.UTF_8));
    	   resp = client.execute(request);
    	   if(resp.getStatusLine().getStatusCode() != HttpStatus.SC_OK)
    	   {
    		   Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
    	   }
//    	   if(resp.getStatusLine().getStatusCode() == 200)
//    	   {
////    		   String result = EntityUtils.toString(resp.getEntity());
//    		   
//    		   
//    		   is = resp.getEntity().getContent();
////    		  InputSource is1=new InputSource(is);
//    		   
//    	   }
    	   

           SAXParserFactory factory = SAXParserFactory.newInstance();
           SAXParser parser = factory.newSAXParser();
           
           
           SAXHandler lineHandler = new SAXHandler();  
           
           
           parser.parse(resp.getEntity().getContent(), lineHandler);
           
           
//           XMLReader xmlreader = parser.getXMLReader();
           

//           xmlreader.setContentHandler(lineHandler);
//
//           InputSource is1 = new InputSource(is);
		//           InputSource is = new InputSource(url.openStream());   
//          InputSource is = new InputSource(this.getClassLoader().getResourceAsStream("bus.xml"));
//           xmlreader.parse(is1);
  
           return lineHandler.getFeed();
    	}
    	catch (Exception ee)
    	{

    		return null;
    	}
	}
    public void onItemClick(AdapterView<?> parent, View v, int position, long id)
    {
   	 Intent itemintent = new Intent(this,ActivityShowDescription.class);
        
   	 Bundle b = new Bundle();
   	 b.putString("name", feed.getLine(position).getName());
   	 b.putString("stats", feed.getLine(position).getStats());
   	 
   	 itemintent.putExtra("android.intent.extra.lineItem", b);
        startActivityForResult(itemintent, 0);
    }
}