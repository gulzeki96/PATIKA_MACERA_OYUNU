import java.util.Random;

public abstract class BattleLoc extends Location {
	private Obstacle obstacle;
	private String award;
	private int maxObs;
	public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObs) {
		super(player, name);
		this.obstacle = obstacle;
		this.award = award;
		this.maxObs = maxObs;
	}

	@Override
	public boolean onLocation() {
		int obsNumber = this.randomObstacleNumber();
		System.out.println("Dikkatli ol, suan " + this.getName() + " bolgesindesiniz.");
		System.out.println("Ve burada " + obsNumber + " tane " + this.getObstacle().getName() + " yasar!");
		System.out.print("<s>avas veya <k>ac :");
		String  selectedCase = input.nextLine().toUpperCase();
		if(selectedCase.equals("S")) {
			System.out.println("Savas basliyor...");
			if(combat(obsNumber)) {
				System.out.println("Dusmanlari yendiniz.");
				return true;
			}
		}
		
		if(this.getPlayer().getHealth() < 0) {
			System.out.println("Oldunuz.!");
			return false;
		} else {
			System.out.println("Gidip evinde dinlenebilirsin kahraman.");
		}
		return true;
	}
	
	public boolean combat(int obsNumber) {
		int i;
		for(i =1; i<= obsNumber; i++) {
			this.getObstacle().setHealth(this.getObstacle().getDefaultHealth());
			while(this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0) {
				playerStats();
				obstacleStats(i);
				System.out.print("<v>ur veya <k>ac: ");
				String selectedCase = input.nextLine().toUpperCase();
				if(selectedCase.equals("V")) {
					System.out.println("Vurdunuz.");
					this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
					System.out.println("Hasar aldiniz");
					int obsArmoredDamage = this.getObstacle().getDamage() - this.getPlayer().getInv().getArmor().getBlock();
					if(obsArmoredDamage>0)
						this.getPlayer().setHealth(this.getPlayer().getHealth() - (this.getObstacle().getDamage()));
					else
						System.out.println("Hasari blockladiniz.");
				}else {
					return false;
				}
			}
			if(this.getPlayer().getHealth() < 0) {
				System.out.println("Oldunuz.!");
				return false;
			} else {
				System.out.println("Sanli bir zafer sonucunda " + this.getObstacle().getAward() + " para kazandiniz.");
				this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
				System.out.println("Guncel bakiyen " + this.getPlayer().getMoney() + "kadardir.");
			}
		}
		return true;
	}
	
	public void playerStats() {
		System.out.println("Oyuncu saglik degeri: " + 
							"\n  Saglik: " + this.getPlayer().getHealth());
		
	}
	
	public void obstacleStats(int i) {
		System.out.println(i+ ". "+ this.getObstacle().getName() + " saglik degeri: " + 
							"\n  Saglik: " + this.getObstacle().getHealth());
		
	}

	public int randomObstacleNumber() {
		Random r = new Random();
		return r.nextInt(this.getMaxObs())+1;
	}
	public Obstacle getObstacle() {
		return obstacle;
	}
	public void setObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}
	public String getAward() {
		return award;
	}
	public void setAward(String award) {
		this.award = award;
	}
	public int getMaxObs() {
		return maxObs;
	}
	public void setMaxObs(int maxObs) {
		this.maxObs = maxObs;
	}
	

}
