
public class Inventory {
	//private int wDamage;
	//private String wName;
	private Weapon weapon;
	private Armor armor;
	public Inventory() {
		//this.wDamage = 0;
		//this.wName = null;
		this.weapon = new Weapon(0, "Yumruk", 0, 0);
		this.armor = new Armor(0, "Pacavra", 0, 0);
	}
	
	
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}


	public Armor getArmor() {
		return armor;
	}
	public void setArmor(Armor armor) {
		this.armor = armor;
	}
	
	
}
