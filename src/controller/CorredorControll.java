package controller;

import java.util.concurrent.Semaphore;

public class CorredorControll 
{
	private int id;
	private int distI = 0;
	private final int distF = 200;
	private Semaphore porta;
	
	public CorredorControll(int id, Semaphore porta)
	{
		this.id = id;
		this.porta = porta;
	}
	
	public void caminho()
	{
		new Thread()
		{
			public void run() 
			{
				movePessoa();
				try {
					porta.acquire();
					Thread.sleep((int) (Math.random() * 1001) + 1000);
					openTheDoor();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					porta.release();
				}
			}
		}.start();
	}
	
	public void movePessoa()
	{
		while(this.distI < this.distF)
		{
			this.distI += (int) ((Math.random() * 3) + 4) ;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			System.out.println("A pessoa n°" + id + " andou " + this.distI);
		}
	}
	
	public void openTheDoor()
	{
		System.out.println("A pessoa n°" + id + " abriu a porta.");
	}

}
