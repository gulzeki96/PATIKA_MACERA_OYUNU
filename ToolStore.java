
public class ToolStore extends NormalLoc{

	public ToolStore(Player player) {
		super(player, "Magaza");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onLocation() {
		// TODO Auto-generated method stub

		boolean showMenu = true;
		while(showMenu) {
			System.out.println("Magazaya Hosgeldin..\n \t 1- Silahlar\n \t 2- Zirhlar\n \t 3- Cikis Yap");
			System.out.print("Seciminiz: ");
			int selectedCase = input.nextInt();
			while(selectedCase < 1 || selectedCase > 3) {
				System.out.print("Seciminizi tekrarlayiniz: ");
				selectedCase = input.nextInt();
			}
			switch(selectedCase) {
				case 1:
					printWeapon(); break;
				case 2:
					printArmor(); buyArmor(); break;
				case 3:
					System.out.println("Yine bekleriz!"); return true;
			}
		}
			
		return true;
	}

	public void printWeapon() {
		System.out.println("Silahlar");
		for(Weapon w : Weapon.weapons()) {
			System.out.printf("%d %10.10s \t Hasar: %d \t Deger: %d\n", w.getId(), w.getName(), w.getDamage(), w.getPrice());
		}
		System.out.println("0 - Cikis Yap");
		buyWeapon();	
	}
	
	public void buyWeapon() {
		System.out.print("Seciminiz: ");
		int selectedWeapon = input.nextInt();
		while(selectedWeapon < 0 || selectedWeapon > Weapon.weapons().length) {
			System.out.print("Seciminizi tekrarlayiniz: ");
			selectedWeapon = input.nextInt();
		}
		if(selectedWeapon != 0) {
			Weapon pWeapon = Weapon.getWeaponByID(selectedWeapon);
			if(pWeapon != null) {
				if(pWeapon.getPrice() > this.getPlayer().getMoney()) {
					System.out.println("Bakiyeniz yetersiz.");
				} else {
					System.out.println(pWeapon.getName() + " silahiniz aldiniz.");
					this.getPlayer().setMoney(this.getPlayer().getMoney() - pWeapon.getPrice());
					System.out.println("Kalan paraniz: " + this.getPlayer().getMoney());
					System.out.println("Onceki silahiniz: "+ this.getPlayer().getInv().getWeapon().getName());
					this.getPlayer().getInv().setWeapon(pWeapon);
					System.out.println("Yeni silahiniz: "+ this.getPlayer().getInv().getWeapon().getName());
				}
			}
		}
	}
	
	
	public void printArmor() {
		System.out.println("Zirhlar");
		for(Armor a : Armor.armors()) {
			System.out.printf("%d %10.10s \t Hasar: %d \t Deger: %d\n", a.getId(), a.getName(), a.getBlock(), a.getPrice());
		}	
		System.out.println("0 - Cikis Yap");
	}
	
	public void buyArmor() {
		System.out.print("Seciminiz: ");
		int selectedArmor = input.nextInt();
		while(selectedArmor < 0 || selectedArmor > Armor.armors().length) {
			System.out.print("Seciminizi tekrarlayiniz: ");
			selectedArmor = input.nextInt();
		}
		if(selectedArmor != 0) {
			Armor pArmor = Armor.getArmorByID(selectedArmor);
			if(pArmor != null) {
				if(pArmor.getPrice() > this.getPlayer().getMoney()) {
					System.out.println("Bakiyeniz yetersiz.");
				} else {
					System.out.println(pArmor.getName() + " silahiniz aldiniz.");
					this.getPlayer().setMoney(this.getPlayer().getMoney() - pArmor.getPrice());
					System.out.println("Kalan paraniz: " + this.getPlayer().getMoney());
					System.out.println("Onceki zirhiniz: "+ this.getPlayer().getInv().getArmor().getName());
					this.getPlayer().getInv().setArmor(pArmor);
					System.out.println("Yeni zirhiniz: "+ this.getPlayer().getInv().getArmor().getName());
				}
			}
		}
	}

}
