package wrestlingcardGame;
import java.util.*;



public class Wrestlers {
	public String name;
	public int rank;
	public double height;
	public double weight; 
	
	public Wrestlers(String name, int rank, double height,double weight){
		this.name=name;
		this.rank=rank;
		this.height=height;
		this.weight=weight;
	}
	
	public String toString(){
		return " Name: " + this.name + "\n Rank: " + this.rank + "\n Height: "
				+ this.height + "\n Weight: " + this.weight;
	}
	public static List<Wrestlers> defaultDeck() {
		List<Wrestlers> deck = new ArrayList<Wrestlers>();

		deck.add(new Wrestlers("Roman Reigns", 1, 1.93, 120.0));
		deck.add(new Wrestlers("Daniel Bryan", 2, 1.78, 90.71));
		deck.add(new Wrestlers("Dean Ambrose", 4, 1.92, 102.0));
		deck.add(new Wrestlers("Brock Lesnar", 5, 1.91, 134.0));
		deck.add(new Wrestlers("Undertaker", 3, 2.08, 136.0));
		deck.add(new Wrestlers("John Cena", 6, 1.85, 114.0));
		deck.add(new Wrestlers("Bray Wyatt", 7, 1.90, 136.0));
		deck.add(new Wrestlers("Seth Rollins",8, 1.85, 93.0));
		deck.add(new Wrestlers("Nikki Bella", 10, 1.68, 57.0));
		return deck;
	}
	
		public static  boolean play(int choice, Wrestlers obj1, Wrestlers obj2) {

			boolean result = false;
			switch (choice) {
			case 1:
				if (obj1.rank < obj2.rank)
					result = true;
				else
					result = false;
				break;

			case 2:
				if (obj1.height > obj2.height)
					result = true;
				else
					result = false;
				break;

			case 3:
				if (obj1.weight > obj2.weight)
					result = true;
				else
					result = false;
				break;

			}
			return result;
		}
	}






