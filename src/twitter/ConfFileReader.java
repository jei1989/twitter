package twitter;

import java.io.*;
import java.util.Vector;

public class ConfFileReader {

	BufferedReader buffReader;
	public String[] srchKeyWord;
	
	public ConfFileReader()
	{
		keywordParse();
	}
	
	public String[] getKeyWord()
	{
		
		return this.srchKeyWord;
	}
	
	private void keywordParse()
	{
		try {
			buffReader = new BufferedReader(new FileReader(TwitterLog.MAINDIR + TwitterLog.CONF + TwitterLog.SRCHKEYWORDFILE));
			
			String[] temp = null;
			Vector vec = new Vector();
			
			while(true)
			{
				
				String line;
				
				try {
					
					line = buffReader.readLine();
					if( line == null) break;
					vec.add(line);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//TwitterLog.trace(this, e);
				}
				
			}//while(true)
			
			try {
				
				buffReader.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//TwitterLog.trace(this, e);
			}
			
			srchKeyWord = new String[vec.size()];
			
			for( int cnt = 0; cnt < vec.size() ; cnt++ )
			{
				srchKeyWord[cnt] = vec.elementAt(cnt).toString();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//TwitterLog.trace(this, e);
		}	
		
	}//private String[] keywordParse()
	
}
