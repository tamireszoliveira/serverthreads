package controller;
import java.util.concurrent.Semaphore;
import java.util.Random;

public class serverthreads extends Thread{
	private static final Semaphore semaforo = new Semaphore(1); // apenas uma thread acessa obd por vez
	private final int id;
	
	public serverthreads(int id) {
		this.id = id;
	}
	

	private void calculo(long min, long max) throws InterruptedException{
		
	Random random = new Random();
		long time = min + random.nextInt((int) (max - min +1)); // gerando num aleatorio entre min e maximo
		System.out.println("thread " + id + " realizando cálculos por " + time + "ms");
		Thread.sleep(time);
	}
	private void transacao(long time) throws InterruptedException{
		semaforo.acquire();
		System.out.println("Thread " + id + " realizando transação no BD por " + time + "ms");
		Thread.sleep(time);
		semaforo.release();
	}
	
	@Override
	public void run() {
		try {
			if(id % 3 == 1) {
				calculo(200, 1000);
				transacao(1000);
				calculo(200, 1000);
				transacao(1000);
			} else if(id %3 == 2) {
				calculo(500, 1500);
				transacao(1500);
				calculo(500, 1500);
				transacao(1500);
				calculo(500, 1500);
				transacao(1500);
			} else {
				calculo(1000, 2000);
				transacao(1500);
				calculo(1000, 2000);
				transacao(1500);
				calculo(1000, 2000);
				transacao(1500);
			}
			System.out.println("Thread " + id + " finalizou.");
		}catch(InterruptedException e) {
		Thread.currentThread().interrupt();
		}
	}
}
