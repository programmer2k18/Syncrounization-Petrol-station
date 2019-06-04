package Threading;

import java.util.Vector;

public class PetrolStation {

	private int pumpnum;
	public Vector<Integer> pumps=new Vector<Integer>();
	protected PetrolStation() {
		pumpnum=0;
	}
	public PetrolStation(int num) {
		this.pumpnum = num;
		for(int i=0;i<this.pumpnum;i++) {
			pumps.addElement(1);
		}
	}
	public  synchronized int P(String name) {
		System.out.println(name +  " arrives") ;
		pumpnum-- ;
		if(pumpnum<0) {
			System.out.println(name +  " is waiting");
			try {
				wait();
			}catch(InterruptedException e)
			{
				int usedpump = pumps.indexOf(1);
				System.out.println("pump " + (usedpump+1) +" : "+name + " occupied");
				pumps.set(usedpump, 0);
				return usedpump;
			}
		}
		//to get index of this free pump
		int usedpump=pumps.indexOf(1);
		System.out.println("pump " + (usedpump+1) +" : "+ name + " occupied");	
		//mark it as used pump in the station
		pumps.set(usedpump, 0);
		return usedpump;
	}
	public synchronized void V(String name, int pump) {
		System.out.println("pump " + (pump+1) +" : "+name + " is leaving " ) ;
		pumps.set(pump, 1) ;
		pumpnum ++ ;
		if( pumpnum <= 0 )
		{
			notify() ;
		}
	}
}
