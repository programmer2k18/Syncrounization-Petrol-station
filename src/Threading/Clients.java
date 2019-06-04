package Threading;
import java.io.IOException;
import java.util.Random ;
public class Clients extends Thread {

	public String name; 
	public int pumpnum;
	public PetrolStation petrol; 
	public Random r = new Random () ;
	int wait_time  =  r.nextInt(1000) + 1 ;
	public Clients( String name  , PetrolStation rest  )
	{
		this.name = name ;
		this.petrol = rest ;
		pumpnum = 0 ;
	}
	public void arrive() throws IOException, InterruptedException
	{
	  pumpnum = petrol.P(name) ;
	  Thread.sleep(wait_time);
	}
	public void Serving() throws IOException, InterruptedException
	{
		System.out.println("pump " + (pumpnum+1) +" : "+this.name + " is being served");
		Thread.sleep(wait_time);
	}
	public void Paying() throws IOException, InterruptedException
	{
		System.out.println("pump " + (pumpnum+1) +" : "+this.name + " is paying");
		Thread.sleep(wait_time);
	}
	public void leave() throws IOException, InterruptedException
	{
		petrol.V(name, pumpnum);
		Thread.sleep(wait_time);
	}
	public void run()
	{
		try
		{
			arrive();
			Serving();
			try{
				Thread.sleep(wait_time);
			}
			catch( InterruptedException e) {System.out.println("Error Exception");}
			Paying();
			leave() ;
		}catch(IOException | InterruptedException e) { }
	}
}
