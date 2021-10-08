import java.util.Scanner;

public class Player {
	private int damage;
	private int health;
	private int defaultHealth;
	private int money;
	private String name;
	private String charType;
	private Inventory inv;
	private Scanner input = new Scanner(System.in);
	public Player(String name) {
		
		this.name = name;
		this.inv = new Inventory();
	}

	
	public void selectChar() {
		CharType charList[] = {new Samurai(), new Archer(), new Knight()};
		
		System.out.println("Karakterler :");
		for(CharType ct : charList) {
			//System.out.println(" \t " + ct.getName() +" \t Hasar: " + ct.getDamage() + " \t Saglik: " + ct.getHealth() + " \t Para: " + ct.getMoney());
			System.out.printf(" \t ID: %d \t %10.10s \t Hasar: %d \t Saglik: %d \t Para: %d\n", ct.getId(), ct.getName(), ct.getDamage(), ct.getHealth(), ct.getMoney());
		}

		int selectedChar;
		System.out.print("Sectiginiz Karakteri Beliritiniz: ");
		selectedChar = input.nextInt();
		switch(selectedChar) {
			case 1:
				initPlayer(new Samurai()); break;
			case 2:
				initPlayer(new Archer()); break;
			case 3:
				initPlayer(new Knight()); break;
			default: initPlayer(new Samurai()); break;
		}
		System.out.println(this.getName() + " oyuna " + this.getCharType() + " karakterini secerek basladin.");
	}

	
	public void initPlayer(CharType ct) {
		
		this.setDamage(ct.getDamage());
		this.setHealth(ct.getHealth());
		this.setMoney(ct.getMoney());
		this.setCharType(ct.getName());
		this.setDefaultHealth(ct.getHealth());
	}

	public void printInfo() {
		System.out.printf("  %s oyuncusunun Silahi: %s, Zirhi: %s \t Engellemesi: %d \t Hasari: %d \t Sagligi: %d \t Parasi: %d\n", this.getName(), 
																								this.getInv().getWeapon().getName(), 
																								this.getInv().getArmor().getName(),
																								this.getInv().getArmor().getBlock(), 
																								this.getTotalDamage(), this.getHealth(), 
																								this.getMoney());
	}
	
	public int getTotalDamage() {
		return this.getDamage() + this.getInv().getWeapon().getDamage();
	}
	
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCharType() {
		return charType;
	}
	public void setCharType(String charType) {
		this.charType = charType;
	}
	public Inventory getInv() {
		return inv;
	}
	public void setInv(Inventory inv) {
		this.inv = inv;
	}
	public int getDefaultHealth() {
		return defaultHealth;
	}
	public void setDefaultHealth(int defaultHealth) {
		this.defaultHealth = defaultHealth;
	}
	
}
