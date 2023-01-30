package atletika.gui;

public class Versenyzo {

	private String versenySzam;
	private char versenyzoNeme;
	private String nemzet;
	private String versenyzoNeve;
	private String eredmeny;
	private String elertCsucs;
	private int helyezes;

	public Versenyzo(String versenySzam, char versenyzoNeme, String nemzet, String versenyzoNeve, String eredmeny,
			String elertCsucs, int helyezes) {
		this.versenySzam = versenySzam;
		this.versenyzoNeme = versenyzoNeme;
		this.nemzet = nemzet;
		this.versenyzoNeve = versenyzoNeve;
		this.eredmeny = eredmeny;
		this.elertCsucs = elertCsucs;
		this.helyezes = helyezes;
	}

	public String getVersenySzam() {
		return versenySzam;
	}

	public char getVersenyzoNeme() {
		return versenyzoNeme;
	}

	public String getNemzet() {
		return nemzet;
	}

	public String getVersenyzoNeve() {
		return versenyzoNeve;
	}

	public String getEredmeny() {
		return eredmeny;
	}

	public String getElertCsucs() {
		return elertCsucs;
	}

	public int getHelyezes() {
		return helyezes;
	}

	@Override
	public String toString() {
		return "Versenyzo [versenySzam=" + versenySzam + ", versenyzoNeme=" + versenyzoNeme + ", nemzet=" + nemzet
				+ ", versenyzoNeve=" + versenyzoNeve + ", eredmeny=" + eredmeny + ", elertCsucs=" + elertCsucs
				+ ", helyezes=" + helyezes + "]";
	}

}
