package com.gdd.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class LinesFeed {

	private String root=null;
//	private String lines=null;
	private int linecount=0;
	private List<LineItem> linelist;
	
	public LinesFeed()
	{
		linelist=new Vector<LineItem>(0);
	}
	public int addLine(LineItem line)
	{
		linelist.add(line);
		linecount++;
		return linecount;
	}
	public LineItem getLine(int location)
	{
		return linelist.get(location);
	}
	public List<LineItem> getAllLines()
	{
		return linelist;
	}
	
	public List<Map<String, Object>> getAllLinesForListView(){
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		int size = linelist.size();
		for(int i=0;i<size;i++){
			HashMap<String, Object>	line = new HashMap<String, Object>();
			line.put(LineItem.NAME, linelist.get(i).getName());
			line.put(LineItem.STATS, linelist.get(i).getStats());
			data.add(line);
		}
		return data;
	}	
	

	int getLineCount()
	{
		return linecount;
	}
	public void setRoot(String root)
	{
		this.root = root;
	}
	public String getRoot()
	{
		return root;
	}

}
