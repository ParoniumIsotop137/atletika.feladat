package atletika.gui;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FajlKezeles {

	public static List<Versenyzo> FajlBeolvasas(String fajlnev, String elvalaszto) {

		List<Versenyzo> ferfiLista = new ArrayList<Versenyzo>();

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev), "UTF-8"));

			while (br.ready()) {

				String elertCsucs = "";

				String[] sor = br.readLine().split(elvalaszto);

				if (sor[5].equals("")) {
					elertCsucs = "nem ért el még csúcsot";
				} else {
					elertCsucs = sor[5];
				}

				Versenyzo v = new Versenyzo(sor[0], sor[1].charAt(0), sor[2], sor[3], sor[4], elertCsucs,
						Integer.parseInt(sor[6]));
				ferfiLista.add(v);
			}

			br.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hiba lépet fel az adatok beolvasásakor: " + e.getMessage(), "Hiba",
					JOptionPane.ERROR_MESSAGE);
		}

		return ferfiLista;

	}

	public static void FajlbaIras(List<Versenyzo> versenyzok, String fajlnev, String elvalaszto) {

		try {
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fajlnev, false), "UTF-8");

			String fejlec = "Név" + elvalaszto + "versenyszám" + elvalaszto + "nemzet";

			out.write(fejlec + "\n");

			for (Versenyzo versenyzo : versenyzok) {
				if ((Character.toLowerCase(versenyzo.getVersenyzoNeme())) == 'n'
						&& !versenyzo.getElertCsucs().equals("")) {

					String kiir = versenyzo.getVersenyzoNeve() + elvalaszto + versenyzo.getVersenySzam() + elvalaszto
							+ versenyzo.getNemzet();
					out.write(kiir + "\n");

				}
			}
			out.close();

		} catch (Exception e) {
			System.err.println("Hiba lépett fel az adatok fájlba íárásakor!");
		}

		System.out.println("női csúcsok a fájlba írva.");

	}

}
