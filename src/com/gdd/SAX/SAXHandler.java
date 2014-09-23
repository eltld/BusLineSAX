package com.gdd.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.gdd.data.LineItem;
import com.gdd.data.LinesFeed;

public class SAXHandler extends DefaultHandler {
	
	LineItem lineitem;
	LinesFeed linesfeed;
	
	String lastElementName = "";
	final int NAME=1;
	final int STATS= 2;
	
	
	int currentstate = 0;

	public SAXHandler()
	{
	}
	
	public LinesFeed getFeed()
	{
		return linesfeed;
		
	}
	@Override
	public void startDocument() throws SAXException {
		
		linesfeed=new LinesFeed();
		lineitem=new LineItem();
				
	}

	@Override
	public void endDocument() throws SAXException 
	{
	}



	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if(localName.equals("root"))
		{
			currentstate=0;
			return;
		}
		if(localName.equals("lines"))
		{
			currentstate=0;
			return;
		}
		if(localName.equals("line"))
		{
			lineitem=new LineItem();
		}
		if(localName.equals("name"))
		{
			currentstate=NAME;
			return;
		}
		if(localName.equals("stats"))
		{
			currentstate=STATS;
			return;
		}
	}

	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(localName.equals("line"))
		{
			linesfeed.addLine(lineitem);
			return;
		}
		
		
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String theString = new String(ch,start,length);
		
		switch(currentstate)
		{
		case NAME:
			lineitem.setName(theString);
			currentstate=0;
			break;
		case STATS:
			lineitem.setStats(theString);
			currentstate=0;
			break;
			default:
				return;
			
			
			
			
			
		}
		
		
		
		
	}

	
	
	
}
