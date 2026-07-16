package thread;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bank bank1 = new Bank("StateBank");
		Bank bank2 = new Bank("\tCentralBank");
		Bank bank3 = new Bank("\t\tPostBank");
		Bank bank4 = new Bank("\t\t\tHDFCBank");
		
		
		 bank1.start();
		 bank2.start();
		 bank3.start();
		 bank4.start();

	}

}

 class Bank extends Thread{
	
	 String model;
	 Bank(String m){
		 model = m;
		 
		 
	 }
	 public void run() {
	 for(int i=0; i<=50; i++) {
		 System.out.println(model + " is your Bank");
		 try {
			Thread.sleep(100);
		} catch (InterruptedException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 }
	 
	 
}
