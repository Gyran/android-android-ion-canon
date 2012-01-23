package se.gyran.aio;

import java.net.InetAddress;
import java.util.ArrayList;

public class IonCanon {
	private String target;
	private int numBeams;
	
	private ArrayList<Thread> beams; // threads
	
	public IonCanon(int numBeams, String target)
	{ 
		this.target = target;
		this.numBeams = numBeams;
	}
	
	public IonCanon(int numBeams)
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
			beam.setPriority(Thread.MAX_PRIORITY);
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
