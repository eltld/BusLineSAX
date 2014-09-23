package com.gdd.data;

public class LineItem {

	public static final String NAME = "name";
	public static final String STATS = "stats";
	private String name=null;
	private String stats=null;
//	private String info=null;
	
	public LineItem()
	{
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setStats(String stats)
	{
		this.stats=stats;
	}
	public String getName()
	{
		return name;
	}
	public String getStats()
	{
		return stats;
	}



}
