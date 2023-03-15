package view;

import java.util.concurrent.Semaphore;

import controller.CorredorControll;

public class Main 
{
	public static void main(String[] args)
	{
		
		
		Semaphore porta = new Semaphore(1);
		
		for(int i = 0; i < 4; i++)
		{
			CorredorControll pessoa = new CorredorControll(i+1, porta);
			pessoa.caminho();
			
		}
		
		
		
	}
}
