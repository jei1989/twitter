package twitter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.JTextArea;


public class TwitterLog {
	
	public static String MAINDIR = "";
	public static String LOG = "\\logs";
	public static String RESULT = "\\result";
	public static String CONF = "\\conf";
	public static String SRCHKEYWORDFILE = "\\srchkeyword.txt";
	public static String CAPTURE_GIF = "./capture.gif";
	public static String CAPTURE_PNG = "./capture.PNG";
	
	static boolean istrue = true;
	static Calendar mcalendar = Calendar.getInstance();
	public static JTextArea txtarea;
	//static FileWriter fos = new FileWriter("./"+LogDirectory+"/"+filename, true); 
	public static void trace(Object obj,String trace)
	{
		if(istrue){
			String msg = "[" + getCurrTime() + "] : " + obj.getClass().toString() + " :: " + trace;
			//System.out.println( msg );
			if( txtarea != null )
			{
				txtarea.append( msg +"\r\n");
				txtarea.setCaretPosition(txtarea.getText().length());
				commonLogWrite(msg+"\r\n");
			}
		}
	}
	
	
	public static void trace(Object obj, Object objt)
	{
		
		if(istrue){
			String msg = "[" + getCurrTime() + "] : " + obj.getClass().toString() + " :: " + objt.toString();
			//System.out.println( msg );
			if( txtarea != null )
			{
				txtarea.append( msg +"\r\n");
				txtarea.setCaretPosition(txtarea.getText().length());
				commonLogWrite(msg+"\r\n");
			}
		}
	}
	public static void errtrace(Object obj, Exception ex)
	{
		if(istrue){
			String msg = "[" + getCurrTime() + "] : " + obj.getClass().toString() + " :: " + ex.getMessage();
			//System.out.println( msg );
			if( txtarea != null )
			{
				txtarea.append( msg +"\r\n");
				txtarea.setCaretPosition(txtarea.getText().length());
				errorLogWrite(msg+"\r\n");
			}
		}
	}
	/*********************/
	public static void errtrace(Object obj, String printStack)
	{
		if(istrue){
			String msg = "[" + getCurrTime() + "] : " + obj.getClass().toString() + " :: " + printStack.toString();
			//System.out.println( msg );
			if( txtarea != null )
			{
				txtarea.append( msg +"\r\n");
				txtarea.setCaretPosition(txtarea.getText().length());
				errorLogWrite(msg+"\r\n");
			}
		}
	}
	/*********************/
	public static String getCurrTime()
	{
		mcalendar = Calendar.getInstance();
		return (mcalendar.get(Calendar.HOUR_OF_DAY) + ":" + mcalendar.get(Calendar.MINUTE) + ":" + mcalendar.get(Calendar.SECOND)).toString();
	}
		
	public static void commonLogWrite(String msg)
	{
		checkDirectory();
		
		String filename = String.valueOf(mcalendar.get(Calendar.YEAR)) +String.valueOf(mcalendar.get(Calendar.MONTH)+1) +String.valueOf(mcalendar.get(Calendar.DATE)) +"_log.txt";
		//String prefix = String.valueOf(mcalendar.get(Calendar.YEAR)) +String.valueOf(mcalendar.get(Calendar.MONTH)+1) +String.valueOf(mcalendar.get(Calendar.DATE)) + "_" 
		//				+ String.valueOf(mcalendar.get(Calendar.HOUR_OF_DAY)) + ":" + String.valueOf(mcalendar.get(Calendar.MINUTE)) + ":" + String.valueOf(mcalendar.get(Calendar.SECOND));

		try{
			FileWriter fos = new FileWriter("./"+LOG+"/"+filename, true);
			//fos.write( "[ " +prefix + "] " + msg);	
			fos.write( msg );
			fos.close();		   
	    }catch(IOException iex){
	    	System.out.println("ioex :: " + iex);
	    }
	}
	
	public static void errorLogWrite(String errormsg)
	{
		checkDirectory();
		String filename = String.valueOf(mcalendar.get(Calendar.YEAR)) +String.valueOf(mcalendar.get(Calendar.MONTH)+1) +String.valueOf(mcalendar.get(Calendar.DATE)) +"_errorlog.txt";
		//String prefix = String.valueOf(mcalendar.get(Calendar.YEAR)) +String.valueOf(mcalendar.get(Calendar.MONTH)+1) +String.valueOf(mcalendar.get(Calendar.DATE)) + "_" 
		//				+ String.valueOf(mcalendar.get(Calendar.HOUR_OF_DAY)) + ":" + String.valueOf(mcalendar.get(Calendar.MINUTE)) + ":" + String.valueOf(mcalendar.get(Calendar.SECOND));
		try{
			FileWriter fos = new FileWriter("./"+LOG+"/"+filename, true);
			//fos.write( "[ " +prefix + "] " + errormsg);			
			fos.write( errormsg );
			fos.close();		   
	    }catch(IOException iex){
	    	System.out.println("ioex :: " + iex);
	    }
	}
	
	public static void checkDirectory()
	{
		File mfile = new File("./"+LOG);
		if( !mfile.exists() )
		{
			mfile.mkdir();
		}
	}
}
