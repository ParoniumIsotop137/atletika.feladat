package atletika.feladat1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import atletika.gui.Versenyzo;

public class Feladatok {

	public void KiirVersenySzamok(List<Versenyzo> versenyzok) {

		Set<String> versenySzamok = new HashSet<String>();

		for (Versenyzo item : versenyzok) {
			versenySzamok.add(item.getVersenySzam());
		}

		System.out.println("A 2017 londoni VB-n összesen: " + versenyzok.size() + " éremt osztottak ki a "
				+ versenySzamok.size() + " versenyszámban.");

	}

	public void AranySzazalek(List<Versenyzo> versenyzok) {

		double aranyErem = 0.0;
		double amerikai = 0.0;

		for (Versenyzo versenyzo : versenyzok) {
			if (versenyzo.getNemzet().equalsIgnoreCase("Egyesült Államok")) {
				amerikai++;
				if (versenyzo.getHelyezes() == 1) {
					aranyErem++;
				}
			}
		}

		double eredmeny = (amerikai / aranyErem) * 10;

		String kiiras = String.format("Az amerikai érmek %.1f", eredmeny);

		System.out.println(kiiras + "%-a arany.");

	}

	public void Kereses(List<Versenyzo> versenyzok, String nemzetNeve, int helyezes) {

		int i = 0;
		String erem = "";

		if (helyezes == 1) {
			erem = "aranyérmet";
		} else if (helyezes == 2) {
			erem = "ezüstérmet";
		} else if (helyezes == 3) {
			erem = "bronzérmet";
		}

		while (i < versenyzok.size() && !(versenyzok.get(i).getNemzet().equalsIgnoreCase(nemzetNeve)
				&& versenyzok.get(i).getHelyezes() == helyezes)) {
			i++;
		}
		if (i < versenyzok.size()) {

			System.out.println(
					nemzetNeve + " egyik " + erem + " szerzett versenyzője:\n" + versenyzok.get(i).getVersenyzoNeve()
							+ " " + versenyzok.get(i).getVersenySzam() + " versenyszámban.");

		} else {
			System.out.println(nemzetNeve + " nem szerzett " + erem + " a VB-n.");
		}

	}
}
