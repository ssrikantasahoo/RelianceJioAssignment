package com.RelianceJio.srikanta.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class DataReader {
	
	FileInputStream proFileName;
	File sTempFile;
	String sValue;
	Properties objproperties = new Properties();

	
	public String getProperty(String sKey) throws IOException
	{
		sTempFile = new File(System.getProperty("user.dir")+"//config//srikanta.properties"); 
		proFileName = new FileInputStream(sTempFile.getPath());
		objproperties.load(proFileName);
		sValue =  objproperties.getProperty(sKey);
		
		return sValue;
	}
	public static void main (String args[]) throws IOException{
		DataReader test = new DataReader();
		
		test.getProperty("srikanta.recording.dir");
		
		
	}
}
