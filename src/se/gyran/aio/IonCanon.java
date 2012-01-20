package se.gyran.aio;

import java.util.ArrayList;

import android.content.Context;
import android.widget.Toast;

public class IonCanon {
	private String target;
	private Integer numBeams;
	
	private ArrayList<Thread> beams; // threads
	
	public IonCanon(Integer numBeams, String target)
	{ 
		this.target = target;
		this.numBeams = numBeams;
	}
	
	public IonCanon(Integer numBeams)
	{
		this(numBeams, null);
	}
	
	public IonCanon()
	{
		this(1);
	}
	
	public void setTarget(String target)
	{
		this.target = target;
	}
	
	private void charge()
	{
		this.beams = new ArrayList<Thread>();
		for(int i = 0; i<this.numBeams;++i)
		{
			beams.add(new Thread(new Beam(this.target)));
		}
	}
	
	public void setNumBeams(Integer numBeams)
	{
		this.numBeams = numBeams;
	}
	
	public void fire()
	{
		this.charge();
		
		for(Thread beam : this.beams)
		{
			beam.start();
		}
	}
	
	public void cease()
	{
		for(Thread beam : this.beams)
		{
			beam.stop();
		}
	}
}
