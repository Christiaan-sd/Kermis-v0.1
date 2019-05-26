import java.util.Scanner;
import java.util.stream.Stream;

public class Kermis  {
	Scanner sc = new Scanner(System.in);
	Atractie botsautos = new Atractie();
	Atractie spin = new Atractie();
	Atractie spiegelpaleis = new Atractie();
	Atractie spookhuis = new Atractie();
	Atractie hawaii = new Atractie();
	Atractie ladderklimmen = new Atractie();

	public static void main(String[] args) {
		Kermis kermis = new Kermis();
		kermis.run();
	}

	void run() {
		dashLine();
		System.out.println("\r\n" + 
				"   ▄█   ▄█▄    ▄████████    ▄████████   ▄▄▄▄███▄▄▄▄    ▄█     ▄████████ \r\n" + 
				"  ███ ▄███▀   ███    ███   ███    ███ ▄██▀▀▀███▀▀▀██▄ ███    ███    ███ \r\n" + 
				"  ███▐██▀     ███    █▀    ███    ███ ███   ███   ███ ███▌   ███    █▀  \r\n" + 
				" ▄█████▀     ▄███▄▄▄      ▄███▄▄▄▄██▀ ███   ███   ███ ███▌   ███        \r\n" + 
				"▀▀█████▄    ▀▀███▀▀▀     ▀▀███▀▀▀▀▀   ███   ███   ███ ███▌ ▀███████████ \r\n" + 
				"  ███▐██▄     ███    █▄  ▀███████████ ███   ███   ███ ███           ███ \r\n" + 
				"  ███ ▀███▄   ███    ███   ███    ███ ███   ███   ███ ███     ▄█    ███ \r\n" + 
				"  ███   ▀█▀   ██████████   ███    ███  ▀█   ███   █▀  █▀    ▄████████▀  \r\n" + 
				"  ▀                        ███    ███                                   \r\n" + 
				"");
		System.out.println("Welke Atracties wil je ?");
		String[] Atracties = { "1. Botsautos      4. Spookhuis", "2. Spin           5. Hawaii",
				"3. Spiegelpaleis  6. Ladderklimmen" };
		Stream.of(Atracties).filter(elem -> elem != null).forEach(System.out::println);
		System.out.println(
				"\nKeuzes:\nMet 1-6 laat je een Atractie draaien.\nMet \"o\" toon je de omzet.\nMet \"k\" toon je het aantal verkochte kaartjes.");
		dashLine();
		validateUserInput();
	}

	String userInput() {
		System.out.print("Keuze: ");
		String input = sc.nextLine();
		return input;
	}

	void validateUserInput() {
		String input;
		boolean validInput = true;
		while (validInput) {
			input = userInput();
			if (input.equalsIgnoreCase("k")) {
				totaalKaartjes();
			} else if (input.equals("o")) {
				totaalOmzet();
			} else if (isNummer(input)) {
				AtractieDraaien(Integer.parseInt(input));
			} else if (input.equalsIgnoreCase("exit")) {
				dashLine();
				System.out.println("Je verlaat nu de kermis.");
				System.out.println("Bedankt voor je bezoek en tot de volgende keer!.");
				dashLine();
				validInput = false;
			} else {
				System.out.println("De gegeven input bevat geen Atractie ID, \"o\" of \"k\". Probeer het nog eens.");
			}
		}
	}

	boolean isNummer(String str) {
		try {
			double decimaal = Double.parseDouble(str);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	void AtractieDraaien(int i) {
		switch (i) {
		case 1:
			botsautos.draaien("botsautos", 2.50);
			break;
		case 2:
			spin.draaien("spin", 2.25);
			break;
		case 3:
			spiegelpaleis.draaien("spiegelpaleis", 2.75);
			break;
		case 4:
			spookhuis.draaien("spookhuis", 3.20);
			break;
		case 5:
			hawaii.draaien("hawaii", 2.90);
			break;
		case 6:
			ladderklimmen.draaien("ladderklimmen", 5);
			break;
		default:
			System.out.println("De gegeven invoer is geen getal tussen de 1 en 6. Probeer het nog eens.");
		}

	}

	void totaalKaartjes() {
		dashLine();
		System.out.println("Kaartverkoop:");
		System.out.println("1. Botsautos: ");
		botsautos.totaalTickets();
		System.out.println("2. Spin: ");
		spin.totaalTickets();
		System.out.println("3. Spiegelpaleis");
		spiegelpaleis.totaalTickets();
		System.out.println("4. Spookhuis: ");
		spookhuis.totaalTickets();
		System.out.println("5. Hawaii: ");
		hawaii.totaalTickets();
		System.out.println("6. Ladderklimmen: ");
		ladderklimmen.totaalTickets();
		int ticketTotaal = botsautos.ticket + spin.ticket + spiegelpaleis.ticket + spookhuis.ticket + hawaii.ticket
				+ ladderklimmen.ticket;
		System.out.println("\nTotaal verkochte tickets: " + ticketTotaal);
		dashLine();
	}

	void totaalOmzet() {
		dashLine();
		System.out.println("Atractieomzet:");
		System.out.println("1. Botsautos: ");
		botsautos.totaalOmzet();
		System.out.println("2. Spin: ");
		spin.totaalOmzet();
		System.out.println("3. Spiegepaleis");
		spiegelpaleis.totaalOmzet();
		System.out.println("4. Spookhuis: ");
		spookhuis.totaalOmzet();
		System.out.println("5. Hawaii: ");
		hawaii.totaalOmzet();
		System.out.println("6. Ladderklimmen: ");
		ladderklimmen.totaalOmzet();
		double kermisOmzet = botsautos.omzet + spin.omzet + spiegelpaleis.omzet + spookhuis.omzet + hawaii.omzet
				+ ladderklimmen.omzet;
		System.out.println("\nTotale Omzet: " + kermisOmzet);
		dashLine();
	}

	void dashLine() {
		System.out.println("-----------------------------------");
	}
}

interface Draaibaar {
	public abstract void draaien();

	public abstract void totaal();
}

abstract class Atracties {
	int ticket;
	double omzet;

	void draaien() {
	}

	void totaalTickets() {
		System.out.println("Totaal tickets verkocht: " + this.ticket);
	}

	void totaalOmzet() {
		System.out.println("Atractie omzet: " + this.omzet);
	}
}

class Atractie extends Atracties {
	void draaien(String naam, double toegangsprijs) {
		System.out.println("Atractie " + naam + " draait.");
		
		if (this.ticket > 5 && naam.equals("spin")){
			System.out.println("ONDERHOUDT NODIG MAN MAN MAN");
			
		};
		
		if (this.ticket > 10 && naam.equals("hawai")){
			System.out.println("ONDERHOUDT NODIG MAN MAN MAN ");
		};
		
		this.ticket++;
		
		this.omzet = this.omzet + toegangsprijs;
	}

	void totaalTickets(int tickets) {
		int tickettotaal = tickets;
	}

	void totaalOmzet(int omzet) {
		double tickettotaal = omzet;
	}
}
