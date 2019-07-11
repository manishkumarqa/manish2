package com.inetbanking.utilities;

import java.io.File;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	 
	 
	static Properties pro;
	 
	public  ReadConfig()
	{
			File file=new File("./Configurations\\config.properties");
			
		try 
			{
			FileInputStream fis=new FileInputStream(file);
			pro=new Properties();
			pro.load(fis );
			}
		catch(Exception e) 
			{			
				System.out.println("Exception is"+e.getMessage());
			}
	}
	 
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseUrl");
		return url;
	}
	public String getUserName()
	{
		String uname=pro.getProperty("username");
		return uname;
	}
	public String getPassword()
	{
		String pwd=pro.getProperty("password");
		return pwd;
	}
	public String getChromePath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}  
	
	public String getIEPath()
	{
		String iepath=pro.getProperty("iepath");
		return iepath;
	}	
	
	public String getFirefoxPath()
	{
		String firefox=pro.getProperty("firefoxpath");
		return firefox;
	}
}