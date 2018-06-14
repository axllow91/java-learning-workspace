package thread_indexer;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class HttpConnect {	
	
	public static String download(String sourceUrl) throws MalformedURLException, URISyntaxException {
		System.out.println("Downloading: " + sourceUrl);
		URL url = new URI(sourceUrl).toURL();		
		
		try {
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			int responseCode = con.getResponseCode();	
			
			if(responseCode >= 200 && responseCode < 300) { // ok
				return IOUtil.read(con.getInputStream());		        
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static String download(InputStream in) {
		return IOUtil.read(in);
	}


	public static InputStream getInputStream(String sourceUrl) throws MalformedURLException, URISyntaxException {
		System.out.println("Downloading: " + sourceUrl);
		URL url = new URI(sourceUrl).toURL();
		InputStream in = null;

		try {
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			int responseCode = con.getResponseCode();

			if(responseCode >= 200 && responseCode < 300) { // which means is ok
				/*
				* public java.io.InputStream getInputStream()
                                  throws java.io.IOException
				* Returns an input stream that reads from this open connection.
				* A SocketTimeoutException can be thrown when reading from the returned input stream if the read timeout expires before data is available for read.
				* Returns:
				* an input stream that reads from this open connection.*/
				in = con.getInputStream();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return in;
	}
}

