package wrestlingcardGame;

import java.util.*;

public class Main {
	public static void main(String[] args) {

		int c = 0;
		boolean result;
		Scanner ch = new Scanner(System.in);
		System.out.println("Welcome to the Wrestling Game!!!\n");
		System.out.println("Enter first player's name");
		ch.hasNext();
		Players firstPlayer = new Players(ch.nextLine());

		System.out.println("Enter second player's name");
		ch.hasNext();
		Players secondPlayer = new Players(ch.nextLine());

		List<Wrestlers> wrestlers = Wrestlers.defaultDeck();
		Collections.shuffle(wrestlers);

		int i = 0;
		for (Wrestlers someWrestlers : wrestlers) {
			if (i % 2 == 0) {
				firstPlayer.currentDeck.add(someWrestlers);
			} else {
				secondPlayer.currentDeck.add(someWrestlers);
			}
			i++;
		}
		int lastIndex1 = firstPlayer.noOfCards() - 1;
		int lastIndex2 = secondPlayer.noOfCards() - 1;
		int toss = (int) (Math.random() * 2);

		while (firstPlayer.currentDeck.size() != 0
				&& secondPlayer.currentDeck.size() != 0) {

			Collections.shuffle(firstPlayer.currentDeck);
			Collections.shuffle(secondPlayer.currentDeck);

			if (toss % 2 == 0) {
				System.out.println("\n" + firstPlayer.name + "'s turn");

				System.out.println(firstPlayer.currentDeck.get(lastIndex1)
						.toString());

				System.out
						.println("\n On which attribute you want to play???\n");
				System.out.println(" 1.Rank\n 2.Height\n 3.Weight\n");

				ch.hasNextInt();
				int attribute = ch.nextInt();
				while (attribute >= 4 || attribute <= 0) {
					System.out.println("Please Enter correct choice");
					ch.hasNextInt();
					attribute = ch.nextInt();
				}

				System.out.println(secondPlayer.currentDeck.get(lastIndex2)
						.toString());
				result = Wrestlers.play(attribute,
						firstPlayer.currentDeck.get(lastIndex1),
						secondPlayer.currentDeck.get(lastIndex2));
			} else {
				System.out.println("\n" + secondPlayer.name + "'s turn\n");

				System.out.println(secondPlayer.currentDeck.get(lastIndex2)
						.toString());

				System.out
						.println("\n On which attribute you want to play???\n");
				System.out.println(" 1.Rank\n 2.Height\n 3.Weight\n");

				ch.hasNextInt();
				int attribute = ch.nextInt();
				while (attribute >= 4 || attribute <= 0) {
					System.out.println("Please Enter correct choice");
					ch.hasNextInt();
					attribute = ch.nextInt();
				}

				System.out.println(firstPlayer.currentDeck.get(lastIndex1)
						.toString());
				result = Wrestlers.play(attribute,
						firstPlayer.currentDeck.get(lastIndex1),
						secondPlayer.currentDeck.get(lastIndex2));

			}

			if (result) {
				System.out.println("\n" + firstPlayer.name
						+ " won this round...\n");
				Wrestlers removedCard = secondPlayer.currentDeck
						.remove(lastIndex2);
				firstPlayer.currentDeck.add(removedCard);
			} else {
				System.out.println("\n" + secondPlayer.name
						+ " won this round...\n");
				Wrestlers removedCard = firstPlayer.currentDeck
						.remove(lastIndex1);
				secondPlayer.currentDeck.add(removedCard);
			}

			lastIndex1 = firstPlayer.noOfCards() - 1;
			lastIndex2 = secondPlayer.noOfCards() - 1;

			toss++;
			if (firstPlayer.noOfCards() == 0) {
				System.out.println(secondPlayer.name + " has won the game...");
			} else if (secondPlayer.noOfCards() == 0) {
				System.out.println(firstPlayer.name + " has won the game...");
			}
		}
		System.out.println("\nThanks for playing...");

		ch.close();
	}
}
