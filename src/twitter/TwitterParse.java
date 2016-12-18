package twitter;

import java.util.Date;
import java.util.Vector;

//import twitter.util.*;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusAdapter;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.*;

public class TwitterParse extends StatusAdapter implements Runnable {
	
	private String ConsumerKey = "rMdpRQFOWe1RxeTVnKdZqFyUT";
	private String ConsumerSecret = "T5kz3mrZILlUOzWHfeIXaErH4CBFGBSucsTAm81z1padE2ZQOJ";
	private String AccessToken = "804222665196064768-4YH3UmgMDPyNNbw51uTTSeLXR5ZRDXF";
	private String AccessTokenSecret = "skuWtv9bEbvKUFfisR7Mg0JrZ0FPdjCLXBTfmDdOkKTbR";
	
	private ConfigurationBuilder cb;
	//private String[] keywords={"¹®ÀçÀÎ","¹Ý±â¹®","ÀÌÀç¸í","¾ÈÃ¶¼ö","¹Ú±ÙÇý","¾ÈÈñÁ¤","¹Ú¿ø¼ø","±è¾îÁØ","À¯½Â¹Î","±è¹«¼º"};//,"¾ÈÈñÁ¤","¹Ú¿ø¼ø","¾ÈÃ¶¼ö","Ç×±³¾È","¹Ú±ÙÇý","±è¹«¼º","À¯½Â¹Î","±è¾îÁØ"};;
	private String[] keywords;
	private int[] keywordsInteger;
	
	//private LinkedList mother = new LinkedList();
	public ConfFileReader confFile;
	public ResultFileWriter resultWrite;
	public String resultString;
	
	public Thread thread;
	
	public TwitterParse()
	{
		TwitterLog.MAINDIR = System.getProperty("user.dir");
		//System.out.println(TwitterLog.MAINDIR + TwitterLog.CONF + TwitterLog.SRCHKEYWORDFILE);
		confFile = new ConfFileReader();
		keywordFileParser();
		resultWrite = new ResultFileWriter();	
		
		thread = new Thread("TwitterParse");
		thread.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		twitterSearchResult_To_FileWriter();
	}
	
	private void keywordFileParser()
	{
		keywords = confFile.getKeyWord();
	}


	
	private void twitterSearchResult_To_FileWriter()
	{
		
	}
}
