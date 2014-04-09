package it.setteemezzo;

public class Mazzo {
	
	public static Carta[] mazzo = new Carta[40];


	public static Carta[] popolaMazzo(){
		char[] semi = {'c','d','b','s'};
		int number;

		for (int i=0; i<semi.length; i++){
			number = 1;
			for (int j=(10*i); j<(10*i)+10; j++){
				mazzo[j] = new Carta(semi[i], number);
				number++;
			}				
		}
		return mazzo;
	}

	public static Carta getRandomCard(Carta mazzo[]) {
		Carta c = null;
		while(c==null){
			int index = (int) getRandomNumber(0, 39);
			c=mazzo[index];
			mazzo[index]=null;
		}
		return c;	
	}
	
	private static int getRandomNumber(int from, int to) {
		int r = (int) Math.floor(Math.random()*(to-from)+from);
		return r;
	}

}



