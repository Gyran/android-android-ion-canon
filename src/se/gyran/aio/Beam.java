package se.gyran.aio;

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
		Log.v("BEAM", this.target);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.fire();
	}

}
