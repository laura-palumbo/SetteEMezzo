package it.setteemezzo;

import java.io.IOException;

public class Start {
	
	public static void main(String[] args) {
		
		Carta[] mazzo;
		Carta c;
		mazzo = Mazzo.popolaMazzo();
		
		try {
			System.out.println("pesca carta");
			System.in.read();
			c=Mazzo.getRandomCard(mazzo);
			System.out.println(c.getCardName());

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		for(int i=0; i<mazzo.length; i++){	
			if (mazzo[i] == null) {
				System.out.println("non è presente");
			} else {
				System.out.println(mazzo[i].getCardName());
			}
		}
		
		//c=Mazzo.getRandomCard(mazzo);
		
	}
	
	
	

}
