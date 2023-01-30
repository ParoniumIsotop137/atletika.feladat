package atletika.feladat1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import atletika.gui.FajlKezeles;
import atletika.gui.Versenyzo;

public class AtletikaFoProgram {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {

		List<Versenyzo> versenyzok = new ArrayList<Versenyzo>();

		versenyzok = FajlKezeles.FajlBeolvasas("F:\\Kurs\\Feladatok\\Atletika\\atletikaVB2017.csv", ";");

		// versenyzok.forEach(System.out::println);

		Feladatok feladat = new Feladatok();
		System.out.println("3. feladat:\n\t");
		feladat.KiirVersenySzamok(versenyzok);
		System.out.println();
		System.out.println("4. feladat:\n");
		feladat.AranySzazalek(versenyzok);
		System.out.println();

		String nemzetNeve = "";
		int helyezes = 0;
		boolean rendben = false;

		System.out.println("5. feladat:\n");

		do {
			try {

				System.out.print("Adja meg a nemzet nevét: ");
				nemzetNeve = br.readLine();
				System.out.print("Adja meg a helyezést (1-3 egész szám): ");
				helyezes = Integer.parseInt(br.readLine());
				rendben = true;

			} catch (Exception e) {
				System.err.println("Helytelen számformátum!\n");
			}

		} while (!rendben);

		System.out.println("\n6.feladat:\n");

		feladat.Kereses(versenyzok, nemzetNeve, helyezes);
		System.out.println("\n7. feladat:\n");
		FajlKezeles.FajlbaIras(versenyzok, "noi_csucsok.txt", "\t");
	}

}
