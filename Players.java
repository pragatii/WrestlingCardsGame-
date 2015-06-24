
package wrestlingcardGame;
import java.util.*;
public class Players {
	String name;
	List<Wrestlers> currentDeck= new ArrayList<Wrestlers>();
	
	public Players(String name){
		this.name=name;
	}
	public int noOfCards(){
		return this.currentDeck.size();
	}

}
