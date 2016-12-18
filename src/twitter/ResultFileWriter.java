package twitter;

import java.io.*;
import java.util.Calendar;

public class ResultFileWriter {

	Calendar mcalendar;
	PrintWriter printWrite;
	String outFileName;
	File isOpen;
	
	public ResultFileWriter()
	{
		mcalendar = Calendar.getInstance();
	}
	
	public void ResultWrite(String wmessage)
	{
		
		try {
			synchronized(this){
				
				outFileName = getCurrFileName();
				isOpen = new File(TwitterLog.MAINDIR + TwitterLog.RESULT + "\\" + outFileName + ".txt");
				
				if( !isOpen.exists() )
				{
					if( printWrite != null){
						printWrite.close();
					}
					try {
						printWrite = new PrintWriter( new FileWriter( isOpen.getAbsoluteFile().toString() , true));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				//System.out.println(wmessage);
				if( printWrite == null){
					printWrite = new PrintWriter( new FileWriter( isOpen.getAbsoluteFile().toString() , true));
				}
				System.out.println("##"+getYearMonth()+wmessage);
				printWrite.println("##"+getYearMonth()+wmessage);
					//printWrite.flush();
				//}
			}//synchronized(this){
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//public void ResultWrite()
	
	
	public String getCurrFileName()
	{
		mcalendar = Calendar.getInstance();
		return (mcalendar.get(Calendar.YEAR) + "" + mcalendar.get(Calendar.MONTH) + "" + mcalendar.get(Calendar.DAY_OF_MONTH) + "_" + mcalendar.get(Calendar.HOUR_OF_DAY)).toString();
	}
	
	public String getYearMonth()
	{
		mcalendar = Calendar.getInstance();
		return (mcalendar.get(Calendar.YEAR) + "" + mcalendar.get(Calendar.MONTH) + "" + mcalendar.get(Calendar.DAY_OF_MONTH) + "_" + mcalendar.get(Calendar.HOUR_OF_DAY) + ":" + mcalendar.get(Calendar.MINUTE) + ":" + mcalendar.get(Calendar.SECOND)).toString();
			
	}
	
	public String getCurrTime()
	{
		mcalendar = Calendar.getInstance();
		return (mcalendar.get(Calendar.HOUR_OF_DAY) + ":" + mcalendar.get(Calendar.MINUTE) + ":" + mcalendar.get(Calendar.SECOND)).toString();
	}
	
	
	
}

