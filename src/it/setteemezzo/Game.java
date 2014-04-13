package it.setteemezzo;

public class Game {
	static double sumPlayer = 0;
	static double sumComputer = 0;
	static Carta[] computer = new Carta[15];
	static Carta[] player = new Carta[15];

	static int j = 0; //indice computer[j];
	static int k = 0; //indice player[k];



	public static double setCardAndReturnSumPlayer(Carta mazzo[]){
		int k=0;
		Carta c;
		c=Mazzo.getRandomCard(mazzo);  //take a card from the deck
		player[k]=c;
		sumPlayer += player[k].getValue();
		System.out.println("* **** **** **** **** **** **** **** **** **** *");
		System.out.println("                CARTA GIOCATORE                 ");
		System.out.println("* **** **** **** **** **** **** **** **** **** *");
		System.out.println(player[k].getCardName());// show the card to the user player
		System.out.println("* **** **** **** **** **** **** **** **** **** *");
		k++;
		return sumPlayer;
	}

	public static double setCardAndReturnSumComputer(Carta mazzo[]){
		Carta c;
		c=Mazzo.getRandomCard(mazzo);  //take a card from the deck
		computer[j]=c;
		sumComputer = sumComputer + computer[j].getValue();
		System.out.println("* **** **** **** **** **** **** **** **** **** *");
		System.out.println("                CARTA COMPUTER                 ");
		System.out.println("* **** **** **** **** **** **** **** **** **** *");
		if (j==0){
			System.out.println("* **** **** **** **** **** **** **** **** **** *");
			System.out.println("Carta Coperta PC"); 
			System.out.println("* **** **** **** **** **** **** **** **** **** *");// show the card to the user computer
			j++;
		}else if (j==1){
			System.out.println("Carta coperta PC:"+computer[0].getCardName()+" "+"+"+"\n"+computer[1].getCardName());
			System.out.println("* **** **** **** **** **** **** **** **** **** *");
			System.out.println("PUNTI giocatore:"+" "+sumPlayer);
		}else if (j==2){
			System.out.println("Carta coperta PC:"+computer[0].getCardName()+" "+"+"+"\n"+computer[1].getCardName()+" "+"+"+"\n"+computer[2].getCardName());
			System.out.println("* **** **** **** **** **** **** **** **** **** *");
			System.out.println("PUNTI giocatore:"+" "+sumPlayer);
			}
		return sumComputer;
	}

	public static boolean checkSumPlayer(double sumCardsVisiblePlayer, Carta[] mazzo){
		boolean baluffo = false;
		if(sumPlayer>=8){
			baluffo = true;
			System.out.println("\nHAI TOTALIZZATO " + sumPlayer + ", QUINDI HAI FATTO BALUFFO !!!");
			System.out.println("\n * ** **** **** **** **** **** **** **** **** *");
			System.out.println("* **** **** **** YOU HAVE LOST :-(( **** **** *");
			System.out.println("* **** **** **** **** **** **** **** **** **** *");
		}else if (sumPlayer==7.5) {
			System.out.println("HAI TOTALIZZATO : " + sumPlayer );
			System.out.println("PASSI IL GIOCO AL COMPUTER");
			Game.computerPlayer(sumCardsVisiblePlayer, mazzo);
			baluffo = true;
		}else {
			System.out.println("* **** **** **** **** **** **** **** **** **** *");
			System.out.println("PUNTI Giocatore: " + sumPlayer);
			System.out.println("* **** **** **** **** **** **** **** **** **** *");
		}		
		return baluffo;
	}


	public static double computerPlayer(double sumCardsVisiblePlayer, Carta[] mazzo){

		@SuppressWarnings("unused")
		double sumC=0;

		if (sumPlayer==7.5){//PROVARE PER CREDERE
			do {
				sumC = Game.setCardAndReturnSumComputer(mazzo); 
				System.out.println("PUNTI computer: " + sumComputer);
			}while (sumComputer<=7.5);checkFinal();
		}else if(sumComputer==7){
			sumC = Game.setCardAndReturnSumComputer(mazzo);
			System.out.println("PUNTI computer: " + sumComputer);
			checkFinal();
		}else if(sumComputer==6.5){
			sumC = Game.setCardAndReturnSumComputer(mazzo);
			System.out.println("PUNTI computer: " + sumComputer);
		}else if(sumComputer==6){
			sumC = Game.setCardAndReturnSumComputer(mazzo);
			System.out.println("PUNTI computer: " + sumComputer);
			checkFinal();
		}else if((sumComputer==5.5)&&(sumPlayer==0)){
			sumC = Game.setCardAndReturnSumComputer(mazzo);
			System.out.println("PUNTI computer: " + sumComputer);
			checkFinal();
		}else if (sumComputer==5){
			sumC = Game.setCardAndReturnSumComputer(mazzo);
			System.out.println("PUNTI computer: " + sumComputer);
			checkFinal();
		}else if(sumComputer<5){
			do {
				sumC = Game.setCardAndReturnSumComputer(mazzo);
				System.out.println("PUNTI computer: " + sumComputer);
			} while (sumComputer<=5);checkFinal();

			//ROVARE PRE CREDERE
		}return sumComputer;
	}

	public static void checkFinal(){
		if ((sumComputer<sumPlayer) || (sumComputer>7.5)){
			System.out.println("* **** **** **** **** **** **** **** **** **** *");
			System.out.println("* **** **** * YOU HAVE WON !!! :-D * **** **** *");
			System.out.println("* **** **** **** **** **** **** **** **** **** *");		
		} else {
			System.out.println("* **** **** **** **** **** **** **** **** **** *");
			System.out.println("* **** **** ** YOU HAVE LOST :-(( ** **** **** *");
			System.out.println("* **** **** **** **** **** **** **** **** **** *");
		}
	}

	public static void azzera(){
		sumPlayer=0;
		sumComputer=0;
	}
}
