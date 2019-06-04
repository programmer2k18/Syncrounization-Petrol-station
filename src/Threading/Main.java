package Threading;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numOfPumps=0,numOfClients=0;
		System.out.println("Enter number of pumps:");
		//System.out.println("Enter number of dddddddddddddddddddddddddddddddddddddddddddddddd:");
		numOfPumps=new Scanner(System.in).nextInt();
		System.out.println("Enter number of clients:");
		numOfClients=new Scanner(System.in).nextInt();
		System.out.println("Enter names of clients:");
		String arrNames[]=new String[numOfClients];
		PetrolStation  p = new PetrolStation(numOfPumps) ;
		for(int i=0;i<numOfClients;i++) {
			arrNames[i]=new Scanner(System.in).nextLine();
		}
		for(int i=0;i<numOfClients;i++) {
			Clients c = new Clients (arrNames[i] , p);
			c.start();
		}
	}
}
