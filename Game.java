import java.util.Scanner;

public class Game {
	private Scanner input = new Scanner(System.in);
	
	public void start() {
		
		System.out.println("Macera Oyununa Hosgeldiniz!");
		System.out.print("Isim Seciniz : "); 
		String playerName = "Zeki";//input.nextLine();
		Player player = new Player(playerName);
		System.out.println(player.getName() + " Maceraya Hosgeldin.");
		System.out.println("Karakter tipini secerek oyuna baslayalim..");
		player.selectChar();
		
		{
			Location loc = null;
			int i = 5;
			while(true) {
				player.printInfo();
				if(i==5) {
				System.out.println("Bolgeler:\n \t 0- oyun sonu\n \t 1- guvenli ev\n \t 2- magaza\n"
						+ " \t 3- magara\n \t 4- orman\n \t 5- nehir\n");
				i =0;
				}
				++i;
				System.out.println("Gitmek istediginiz bolgeyi seciniz: ");
				int selectedLoc; selectedLoc = input.nextInt();
				switch(selectedLoc) {
					case 0:
						loc = null; break;
					case 1:
						loc = new SafeHouse(player); break;
					case 2:
						loc = new ToolStore(player); break;
					case 3:
						loc = new Cave(player); break;
					case 4:
						loc = new Forest(player); break;
					case 5:
						loc = new River(player); break;
					default: System.out.print("Gecerli bir bolge kodu giriniz..: "); break;
				}
				if(loc == null) {
					System.out.println("Oyun bitti.");
					break;
				}
				if(!loc.onLocation()) {
					System.out.println("Oldunuz!");
					break;
				}
			}
		}
	}
}
