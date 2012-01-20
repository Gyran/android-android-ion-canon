package se.gyran.aio;

import java.util.ArrayList;

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
	
	public void setNumBeams(Integer numBeams)
	{
		this.numBeams = numBeams;
	}
	
	public void fire()
	{
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
