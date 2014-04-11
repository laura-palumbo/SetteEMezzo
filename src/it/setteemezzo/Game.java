package it.setteemezzo;

public class Game {
	static double sumPlayer = 0;
	static double sumComputer = 0;
	static Carta[] computer = new Carta[15];
	static Carta[] player = new Carta[15];

	static int j = 0; //indice computer[j];
	static int k = 0; //indice player[k];


	
	public static double setCardAndReturnSumPlayer(Carta mazzo[]){
		int k = 0;
		Carta c;
//		Carta[] giocatore = new Carta[15];

		c=Mazzo.getRandomCard(mazzo);  //take a card from the deck
		player[k]=c;
		sumPlayer = sumPlayer + player[k].getValue();
		System.out.println("******* NOME CARTA PESCATA ******");
		System.out.println(player[k].getCardName());// show the card to the user player
		k++;
		return sumPlayer;
	}
	
	public static double setCardAndReturnSumComputer(Carta mazzo[]){
		Carta c;
//		Carta[] computer = new Carta[15];
		c=Mazzo.getRandomCard(mazzo);  //take a card from the deck
		computer[j]=c;
		sumComputer = sumComputer + computer[j].getValue();
		System.out.println("******* CARTA PESCATA DAL COMPUTER ******");
		System.out.println(computer[j].getCardName()); // show the card to the user computer
		j++;
		return sumComputer;
	}
	
	public static boolean checkSumPlayer(double sumCardsVisiblePlayer, Carta[] mazzo, double sumPlayer){
		boolean baluffo = false;
		if(sumPlayer>=8){
			baluffo = true;
			System.out.println("\nHAI TOTALIZZATO " + sumPlayer + ", QUINDI HAI FATTO BALUFFO !!!");
			System.out.println("\n*******************************");
			System.out.println("****** YOU HAVE LOST :-(( *****");
			System.out.println("*******************************");
		}else if (sumPlayer==7.5) {
			System.out.println("HAI TOTALIZZATO : " + sumPlayer + "PASSI IL GIOCO AL COMPUTER");
			Game.computerPlayer(sumCardsVisiblePlayer, mazzo);
			// CHIAMATA computePlayer()
		}else {
			System.out.println("SOMMA PLAYER: " + sumPlayer);
		}		
		return baluffo;
	}
	
	
	public static double computerPlayer(double sumCardsVisiblePlayer, Carta[] mazzo){
		//	System.out.println("player[0].getValue(): " +player[0].getValue() );
		//	sumCardsVisiblePlayer = sumPlayer - player[1].getValue(); 
		
		double sumC = 0;
		
		if (sumPlayer==7.5){
			while(sumComputer < 7.5){
				sumC = Game.setCardAndReturnSumComputer(mazzo); 
				System.out.println("Totale computer: " + sumC);
			}
		} /*else {
			while((sumCardsVisiblePlayer==0) && (sumC<5)){
				sumC = Game.setCardAndReturnSumComputer(mazzo); 
				System.out.println("Totale computer: " + sumC);
			}
		}*/
		
		
		else if ((sumCardsVisiblePlayer==sumComputer) && (5 <= sumComputer) && (sumComputer < 7)) {
			System.out.println("sumComputer: " + sumComputer);
				sumC = Game.setCardAndReturnSumComputer(mazzo);
				System.out.println("Totale computer: " + sumC);
				
		}else if ((sumCardsVisiblePlayer<=4.5) && (5 <= sumComputer)) {
			System.out.println("sumComputer: " + sumComputer);
			sumC = Game.setCardAndReturnSumComputer(mazzo);
			System.out.println("Totale computer: " + sumC);
		}else if ((sumCardsVisiblePlayer>=4) && (sumCardsVisiblePlayer<6.5)) {
			System.out.println("sumComputer: " + sumComputer);
			while(sumComputer <= 6.5){
				sumC = Game.setCardAndReturnSumComputer(mazzo);
				System.out.println("Totale computer: " + sumC);
			}
		} else if (sumCardsVisiblePlayer==6.5) {
			while(sumComputer <=7){
				sumC = Game.setCardAndReturnSumComputer(mazzo);
				System.out.println("Totale computer: " + sumC);
			}
		}else if ((sumCardsVisiblePlayer==0) && (sumComputer<5)) {
			while(sumComputer <=7){
				sumC = Game.setCardAndReturnSumComputer(mazzo);
				System.out.println("Totale computer: " + sumC);
			}
		}
		return sumComputer;
	}
	
	
	public static void checkFinal(double sumComputer, double sumPlayer){
		if ((sumComputer<sumPlayer) || (sumComputer>7.5)){
			System.out.println("**********************************");
			System.out.println("****** YOU HAVE WON !!! :-D ******");
			System.out.println("**********************************");		
		} else {
			System.out.println("*******************************");
			System.out.println("****** YOU HAVE LOST :-(( *****");
			System.out.println("*******************************");
		}
	}
	
}
