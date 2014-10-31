
public class Card {
	private String name;
	private int number;
	private String suit;
	private String proxy;
	
	public Card(String s, int num) {
		this.suit = s;
		this.number = num;
		this.proxy = "";
	}
	
	public String getSuit() {
		return suit;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setSuit(String s) {
		this.suit = s;
	}
	
	public void setNumber(int n) {
		this.number = n;
	}
	
	public void setName() {
		if(this.proxy == "") {
			name = "" + number + " of " + suit;
		}
		else {
			name = proxy + " of " + suit;
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setProxy(String s) {
		this.proxy = s;
	}
	
	public String getProxy() {
		return proxy;
	}
	
	public boolean hasProxy() {
		if(this.proxy == "") {
			return false;
		}
		else
			return true;
	}
}
