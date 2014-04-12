package it.setteemezzo;

public class Carta {

	public char suit;
	public int number;

	public Carta(char suit, int number) {
		this.suit = suit;
		this.number = number;
	}

	public String getSuitName() {
		String name = "";

		switch (this.suit) {
		case 's':
			name = "spade";
			break;
		case 'd':
			name = "denari";
			break;
		case 'b':
			name = "bastoni";
			break;
		case 'c':
			name = "coppe";
			break;
		}
		return name;
	}

	public char getSuit() {
		return suit;
	}

	public int getNumber() {
		return number;
	}

	public double getValue() {
		double value = number;

		if (number >= 8) {
			value = 0.5d;
		}

		return value;
	}

	public String getCardName() {
		int numCarta = getNumber();
		String carta = "";
		switch (numCarta) {
		case 1:
			carta = "Asso";
			break;
		case 8:
			carta = "Donna";
			break;
		case 9:
			carta = "Cavallo";
			break;
		case 10:
			carta = "Re";
			break;
		default:
			carta = Integer.toString(numCarta);
			break;
		}
		return carta + " di " + getSuitName();
	}

}
