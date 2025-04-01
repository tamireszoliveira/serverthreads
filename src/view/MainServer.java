package view;
import controller.serverthreads;
public class MainServer {
	public static void main(String[] args) {
		
        for (int i = 1; i <= 21; i++) {
        	
            new serverthreads(i).start();
        }

        System.out.println("Threads foram iniciadas, mas o programa pode finalizar antes delas.");
    }

}
