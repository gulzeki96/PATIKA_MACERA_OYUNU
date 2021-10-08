
public class SafeHouse extends NormalLoc{

	public SafeHouse(Player player) {
		super(player, "Safe House");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onLocation() {
		// TODO Auto-generated method stub
		System.out.println("Guvenli evdesiniz, Caniniz yenilendi..");
		this.getPlayer().setHealth(this.getPlayer().getDefaultHealth());
		return true;
	}

}
