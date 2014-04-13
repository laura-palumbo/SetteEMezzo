package it.setteemezzo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {


	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Carta[] mazzo;
		mazzo = Mazzo.popolaMazzo();			
		double sumP;
		double sumC;
		BufferedReader br;
		String _String = " ";
		char _char = ' ';

		do{
			sumP = Game.setCardAndReturnSumPlayer(mazzo); // the first card from deck is for player
			sumC = Game.setCardAndReturnSumComputer(mazzo); // the second card from deck is for computer
			double sumP1 = sumP; //prima carta del player
			boolean passa = false;
			boolean sballato = false;

			while(((_char!='c') || (_char!='p')) && (passa==false) && (sballato==false)){
				System.out.println("Premi C seguito da INVIO per prendere una carta");
				System.out.println("Premi P seguito da INVIO per passare il turno");
				br = new BufferedReader(new InputStreamReader(System.in));
				try
				{
					_String = br.readLine();
					if (_String.length() > 1)
						throw new NumberFormatException();

					try {
						_char = _String.charAt(0);

					} catch (Exception e) {
						_char = 'd';				
					}
				}
				catch (IOException e1)
				{
					System.out.println ("errore di flusso");
					_char = 'd';
				}
				catch (NumberFormatException e2)
				{
					System.out.println ("errore di input da tastiera");
					_char = 'd';
				}

				switch (_char){
				case 'c': 
					sumP = Game.setCardAndReturnSumPlayer(mazzo);
					sballato = Game.checkSumPlayer(sumP-sumP1, mazzo);
					break;

				case 'p':
					passa = true;

					System.out.println("* **** **** **** **** **** **** **** **** **** *");
					System.out.println("Hai passato il turno al computer con: " +sumP);
					System.out.println("* **** **** **** **** **** **** **** **** **** *");
					//System.out.println("carte scoperte player: " + (sumP - sumP1));
					sumC = Game.computerPlayer(sumP-sumP1, mazzo); 
					Game.checkFinal();
					break;

				default: _char = 'p';
				break;
				}
			}
			System.out.println(" * * * * * * * * * * * * * * * * * * * * * * * * ");
			System.out.println(" * * * * Vuoi giocare un'altra partita? c/p  * * ");
			System.out.println(" * * * * * * * * * * * * * * * * * * * * * * * * ");
			System.out.println("Premi C seguito da INVIO per prendere continuare ");
			System.out.println("Premi P seguito da INVIO per terminare la partita");
			

			br = new BufferedReader(new InputStreamReader(System.in));
			try
			{
				_String = br.readLine();
				if (_String.length() > 1)
					throw new NumberFormatException();

				try {
					_char = _String.charAt(0);

				} catch (Exception e) {
					_char = 'd';				
				}
			}
			catch (IOException e1)
			{
				System.out.println ("errore di flusso");
				_char = 'd';
			}
			catch (NumberFormatException e2)
			{
				System.out.println ("errore di input da tastiera");
				_char = 'd';
			}
				Game.azzera();
		}while(_char =='c');restart(args);
	}
	
	private static void restart(String[] strArr)
	{
	    main(strArr);
	}
}
