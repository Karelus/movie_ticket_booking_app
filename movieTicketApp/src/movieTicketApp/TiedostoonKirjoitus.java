package movieTicketApp;

import java.util.Scanner;

/*
 * 1. Numeroita ja kirjaimia
 * 2. Erikoismerkkejä (vähintään yksi)
 * 3. Isoja ja pieniä kirjaimia
 * 4. Vähintään 8 merkkiä
 * 5. Ei samoja merkkejä peräkkäin
 * 6. Ei välilyönti, ei tabulaattori
 * 
 * 1. Ei oman lemmikin nimeä / omaa nimeä
 * 2. Ei qwerty / 1234 / 0000 / salasana / password /
 * 3. Salasanassa esiintyy tasan kolme kappaletta a-kirjaimia
 */
public class TiedostoonKirjoitus {

	private static final Scanner lukija = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Anna salasanakandidaatti: ");
		String kandi = lukija.nextLine();
		System.out.println("Anna nimesi: ");
		String nimi = lukija.nextLine();
		System.out.println("Anna lemmikin nimi: ");
		String lemmikki = lukija.nextLine();
		System.out.println("\n\nSalasanatesteri tutkii kandidaattia: " +kandi);
		System.out.println("Numeroita ja kirjaimia: " +onkoNumeroitaJaKirjaimia(kandi));
		System.out.println("Erikoismerkkejä (vähintään yksi): " +onkoErikoismerkkeja(kandi));
		System.out.println("Isoja ja pieniä kirjaimia: " +onkoIsojaJaPienia(kandi));
		System.out.println("Vähintään 8 merkkiä: " +onkoVahintaan8Merkkia(kandi));
		System.out.println("Ei samoja merkkejä peräkkäin: " +onkoSamojaPerakkain(kandi));
		System.out.println("Ei välilyönti, ei tabulaattori: " +onkoValilyontiaTaiTabia(kandi));
		System.out.println("Ei lemmikin nimeä / omaa nimeä: " +onkoLemminkinTaiOmaNimi(kandi, nimi, lemmikki));
		System.out.println("Ei qwerty/1234/0000/salasana/password: " +onkoQwertyTms(kandi));
		System.out.println("Kolme kappaletta a-kirjaimia: " +onkoKolmeAata(kandi));
	}
	
	public static boolean onkoErikoismerkkeja(String mj) {
		//tama versio kokoaa kaikki mj:ssa esiintyvat erikoismerkit
		//kasittely olisi nopeampaa mikali metodista poistuttaisi heti kun etsitty loytyy
		String erikoismerkit = ""; //Tyhjä merkkijono
		for(int i = 0; i < mj.length(); i++) {
			char c = mj.charAt(i);
			if (!( Character.isLetter(c) || Character.isDigit(c)))
				erikoismerkit += c;
		}		
		return (erikoismerkit.length() >= 1);
	}
	
	public static boolean onkoKirjaimia(String mj) {
		for (int i=0; i<mj.length(); i++) {
			if (Character.isAlphabetic(mj.charAt(i)))
				return true;
		}
		return false;
	}
	
	public static boolean onkoKolmeAata(String mj) {
		//tama versio kokoaa kaikki mj:ssa esiintyvat a-kirjaimet
		//kasittely olisi nopeampaa mikali metodista poistuttaisi heti kun kpl > 3.
		//kehitysehdotus: seka etsittava merkki etta esiintymisen lkm pyydetaan kayttajalta.
		int kpl = 0;
		char etsittava = 'a';
		for(int i = 0; i < mj.length(); i++) {
			char c = mj.charAt(i);
			if (c == etsittava)
				kpl ++;
		}		
		return (kpl == 3);
	}
	
	public static boolean onkoLemminkinTaiOmaNimi(String kandi, String nimi, String lemmikki) {
		//tama versio kyttaa nimia ja kandia kokonaisuudessaan
		//kehitysideat: 1)tutki myos osamerkkijonot (IndexOf)
		//2) siirra nimen ja lemmikin nimen luku ohjelman alkuun OK
		// haaste: L1u2f3f4e
		
		if(lemmikki.equals(kandi) || nimi.equals(kandi))
			return false;
		else
			return true;
	}

	public static boolean onkoNumeroita(String mj) {
		for (int i=0; i<mj.length(); i++) {
			if (Character.isDigit(mj.charAt(i)))
				return true;
		}
		return false;
	}
	
	public static boolean onkoNumeroitaJaKirjaimia(String mj) {
		if (onkoKirjaimia(mj) && onkoNumeroita(mj))
			return true;
		else
			return false;
	}
	
	public static boolean onkoIsojaJaPienia(String mj) {
		return (onkoIsoja(mj) && onkoPienia(mj));
	}
	
	public static boolean onkoIsoja(String mj) {
		for (int i=0; i<mj.length(); i++) {
			if (Character.isUpperCase(mj.charAt(i)))
				return true;
		}
		return false;
	}
	
	public static boolean onkoPienia(String mj) {
		for (int i=0; i<mj.length(); i++) {
			if (Character.isLowerCase(mj.charAt(i)))
				return true;
		}
		return false;
	}
	
	public static boolean onkoQwertyTms(String kandi) {
		String[] pahatSanat = { "qwerty", "1234", "0000", "salasana", "password" };
		//tama versio kyttaa pahoja sanoja ja kandia kokonaisuudessaan
		//kehitysehdotus: tutki myos osamerkkijonot
		for (int i=0; i<pahatSanat.length; i++)
			if(kandi.equals(pahatSanat[i]))
				return false;
		return true;
	}
	
	public static boolean onkoSamojaPerakkain(String mj) {
		for (int i=0, j=1; i<mj.length()-1 && j<mj.length(); i++, j++) {
			if (mj.charAt(i) == mj.charAt(j))
				return false;
		}
		return true;
	}
	
	public static boolean onkoValilyontiaTaiTabia(String mj) {
		for (int i=0; i<mj.length(); i++) {
			if (Character.isSpaceChar(mj.charAt(i)))
				return false;
		}
		return true;
	}
	
	public static boolean onkoVahintaan8Merkkia(String mj) {
		return (mj.length() >= 8);
	}

}