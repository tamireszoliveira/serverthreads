package view;
import 
public class MainServer {
	public static void main(String[] args) {
		new server()
        for (int i = 1; i <= 21; i++) {
        	
            new server(i).start();
        }

        System.out.println("Threads foram iniciadas, mas o programa pode finalizar antes delas.");
    }

}
