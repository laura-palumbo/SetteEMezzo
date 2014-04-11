package it.setteemezzo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
	
	public static void main(String[] args) {
		
		Carta[] mazzo;
		Carta[] computer = new Carta[15];
		Carta[] player = new Carta[15];
		Carta c;
		mazzo = Mazzo.popolaMazzo();
		int j = 0;				
		int k = 0;			
		double sumP;
		double sumC;
		BufferedReader br;
		String _String;
		char _char = ' ';
		
		System.out.println("Per iniziare la partita premi un tasto...");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sumP = Game.setCardAndReturnSumPlayer(mazzo); // the first card from deck is for player
		sumC = Game.setCardAndReturnSumComputer(mazzo); // the second card from deck is for computer
		double sumP1 = sumP; //prima carta del player
		boolean passa = false;
		boolean baluffo = false;
		while(((_char!='c') || (_char!='p')) && (passa==false) && (baluffo==false)){
			System.out.println("Per pescare una carta premi C, per passare P");

			br = new BufferedReader(new InputStreamReader(System.in));
			try
			{
				_String = br.readLine();
				if (_String.length() > 1)
					throw new NumberFormatException();

				_char = _String.charAt(0);
			}
			catch (IOException e1)
			{
				System.out.println ("errore di flusso");
			}
			catch (NumberFormatException e2)
			{
				System.out.println ("errore di input da tastiera");
				//_char = 'd';
			}

			switch (_char){
			case 'c': 
				sumP = Game.setCardAndReturnSumPlayer(mazzo);
				baluffo = Game.checkSumPlayer(sumP);
				break;
				
			case 'p':
				passa = true;
				System.out.println("somma computer: " +sumC);
				System.out.println("somma player: " +sumP);
				System.out.println("carte scoperte player: " + (sumP - sumP1));

 				sumC = Game.computerPlayer(sumP-sumP1, mazzo); // QUI ESPLODE !!!!
				break;
				
			default: _char = 'p';
            	break;
			}
		}

				
//			try {
//				System.in.read();
//				System.out.println(c.getCardName() + "questa è la prima carta estratta");
//	
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//
//			for(int i=0; i<mazzo.length; i++){	
//				if (mazzo[i] == null) {
//					System.out.println("non è presente");
//				} else {
//					System.out.println(mazzo[i].getCardName());
//				}
//			}
//			c=Mazzo.getRandomCard(mazzo);
		
	}
	
	
	

}
