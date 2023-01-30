package atletika.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class AtletikaFoAblak {

	private JFrame frmAtletika;
	private JList lstAranyLista;
	private JList lstVersenySzam;
	private JLabel lblNev;
	private JLabel lblEredmeny;
	private JLabel lblNemzet;
	private JSpinner spnErem;
	private List<Versenyzo> versenyzok;
	private DefaultListModel<String> lModelArany;
	private DefaultListModel<String> lModelVersenySzam;

	private Set<String> versenySzamok;
	private Set<String> aranyErmesLista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					AtletikaFoAblak window = new AtletikaFoAblak();
					window.frmAtletika.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AtletikaFoAblak() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAtletika = new JFrame();
		frmAtletika.getContentPane().setBackground(new Color(192, 255, 255));
		frmAtletika.getContentPane().setLayout(null);

		versenyzok = new ArrayList<Versenyzo>();
		lModelArany = new DefaultListModel<String>();
		lModelVersenySzam = new DefaultListModel<String>();

		aranyErmesLista = new HashSet<String>();
		versenySzamok = new HashSet<String>();

		versenyzok = FajlKezeles.FajlBeolvasas("F:\\Kurs\\Feladatok\\Atletika\\ferfiAtletika2017.txt", ";");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 61, 400, 500);
		frmAtletika.getContentPane().add(scrollPane);

		lstAranyLista = new JList();
		lstAranyLista.setForeground(new Color(0, 0, 139));
		lstAranyLista.setFont(new Font("Verdana", Font.PLAIN, 12));
		scrollPane.setViewportView(lstAranyLista);

		JLabel lblAranyosNemzet = new JLabel("Aranyérmet szerzett nemzetek:");
		lblAranyosNemzet.setHorizontalAlignment(SwingConstants.CENTER);
		lblAranyosNemzet.setForeground(new Color(0, 0, 139));
		lblAranyosNemzet.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblAranyosNemzet.setBounds(120, 20, 220, 25);
		frmAtletika.getContentPane().add(lblAranyosNemzet);

		JButton btnAranyosNemzetek = new JButton("aranyos - nemzetek");
		btnAranyosNemzetek.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				AranyEremListaFeltoltes();
				btnAranyosNemzetek.setVisible(false);

			}
		});
		btnAranyosNemzetek.setForeground(new Color(0, 0, 139));
		btnAranyosNemzetek.setBackground(new Color(192, 255, 255));
		btnAranyosNemzetek.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnAranyosNemzetek.setBounds(160, 595, 160, 30);
		frmAtletika.getContentPane().add(btnAranyosNemzetek);

		JScrollPane scrollPaneMeter = new JScrollPane();
		scrollPaneMeter.setBounds(533, 61, 260, 150);
		frmAtletika.getContentPane().add(scrollPaneMeter);

		lstVersenySzam = new JList();
		lstVersenySzam.setForeground(new Color(0, 0, 139));
		lstVersenySzam.setFont(new Font("Verdana", Font.PLAIN, 12));
		scrollPaneMeter.setViewportView(lstVersenySzam);

		JLabel lblVersenySzam = new JLabel("Válassza ki a versenyszámot:");
		lblVersenySzam.setHorizontalAlignment(SwingConstants.CENTER);
		lblVersenySzam.setForeground(new Color(0, 0, 139));
		lblVersenySzam.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblVersenySzam.setBounds(553, 20, 220, 25);
		frmAtletika.getContentPane().add(lblVersenySzam);

		spnErem = new JSpinner();
		spnErem.setModel(new SpinnerNumberModel(Integer.valueOf(1), null, null, Integer.valueOf(1)));
		spnErem.setForeground(new Color(0, 0, 139));
		spnErem.setFont(new Font("Verdana", Font.PLAIN, 12));
		spnErem.setBounds(533, 275, 65, 25);
		frmAtletika.getContentPane().add(spnErem);

		VersenySzamok();
		AranyNemzetek();
		VersenySzamListaFeltoltes();

		JLabel lblHelyezés = new JLabel("Válassza ki az érmes helyezést:");
		lblHelyezés.setHorizontalAlignment(SwingConstants.LEFT);
		lblHelyezés.setForeground(new Color(0, 0, 139));
		lblHelyezés.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblHelyezés.setBounds(533, 238, 220, 25);
		frmAtletika.getContentPane().add(lblHelyezés);

		JButton btnKeress = new JButton("keresés");
		btnKeress.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (lstVersenySzam.getSelectedIndex() != -1) {

					if ((int) spnErem.getValue() >= 1 && (int) spnErem.getValue() <= 3) {
						Kereses();
					} else {
						JOptionPane.showMessageDialog(frmAtletika, "Csak érmes helyezéseket tartalmaz a statisztika!",
								"Hiba", JOptionPane.WARNING_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(frmAtletika, "Nem választott ki versenyszámot!", "Hiba",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnKeress.setForeground(new Color(0, 0, 139));
		btnKeress.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnKeress.setBackground(new Color(192, 255, 255));
		btnKeress.setBounds(533, 354, 100, 30);
		frmAtletika.getContentPane().add(btnKeress);

		JLabel lblAdatok = new JLabel("Versenyző adatai:");
		lblAdatok.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdatok.setForeground(new Color(0, 0, 139));
		lblAdatok.setFont(new Font("Verdana", Font.BOLD, 12));
		lblAdatok.setBounds(562, 416, 140, 25);
		frmAtletika.getContentPane().add(lblAdatok);

		JLabel lblVersenyzoNev = new JLabel("Neve:");
		lblVersenyzoNev.setHorizontalAlignment(SwingConstants.LEFT);
		lblVersenyzoNev.setForeground(new Color(0, 0, 139));
		lblVersenyzoNev.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblVersenyzoNev.setBounds(533, 461, 90, 25);
		frmAtletika.getContentPane().add(lblVersenyzoNev);

		lblNev = new JLabel("");
		lblNev.setHorizontalAlignment(SwingConstants.CENTER);
		lblNev.setForeground(new Color(0, 0, 139));
		lblNev.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNev.setBounds(633, 461, 140, 25);
		frmAtletika.getContentPane().add(lblNev);

		JLabel leblVersenyzoEredmeny = new JLabel("Eredménye:");
		leblVersenyzoEredmeny.setHorizontalAlignment(SwingConstants.LEFT);
		leblVersenyzoEredmeny.setForeground(new Color(0, 0, 139));
		leblVersenyzoEredmeny.setFont(new Font("Verdana", Font.PLAIN, 12));
		leblVersenyzoEredmeny.setBounds(533, 511, 90, 25);
		frmAtletika.getContentPane().add(leblVersenyzoEredmeny);

		JLabel lebelVersenyzoNemzete = new JLabel("Nemzete:");
		lebelVersenyzoNemzete.setHorizontalAlignment(SwingConstants.LEFT);
		lebelVersenyzoNemzete.setForeground(new Color(0, 0, 139));
		lebelVersenyzoNemzete.setFont(new Font("Verdana", Font.PLAIN, 12));
		lebelVersenyzoNemzete.setBounds(533, 558, 90, 25);
		frmAtletika.getContentPane().add(lebelVersenyzoNemzete);

		lblEredmeny = new JLabel("");
		lblEredmeny.setHorizontalAlignment(SwingConstants.CENTER);
		lblEredmeny.setForeground(new Color(0, 0, 139));
		lblEredmeny.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblEredmeny.setBounds(633, 511, 140, 25);
		frmAtletika.getContentPane().add(lblEredmeny);

		lblNemzet = new JLabel("");
		lblNemzet.setHorizontalAlignment(SwingConstants.CENTER);
		lblNemzet.setForeground(new Color(0, 0, 139));
		lblNemzet.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNemzet.setBounds(633, 558, 140, 25);
		frmAtletika.getContentPane().add(lblNemzet);
		frmAtletika.setTitle("Férfiak eredménye a 2017-es atletikai VB-n");
		frmAtletika.setForeground(new Color(255, 255, 255));
		frmAtletika.setFont(new Font("Segoe UI", Font.BOLD, 13));
		frmAtletika.setBounds(100, 100, 1000, 700);
		frmAtletika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void Kereses() {

		int i = 0;

		while (i < versenyzok.size() && !((versenyzok.get(i).getVersenySzam().equals(lstVersenySzam.getSelectedValue())
				&& versenyzok.get(i).getHelyezes() == (int) spnErem.getValue()))) {
			i++;
		}
		if (i < versenyzok.size()) {

			lblNev.setText(versenyzok.get(i).getVersenyzoNeve());
			lblEredmeny.setText(versenyzok.get(i).getEredmeny());
			lblNemzet.setText(versenyzok.get(i).getNemzet());

		} else {
			JOptionPane.showMessageDialog(frmAtletika, "Nincsen ilyen versenyző!", "Információ",
					JOptionPane.PLAIN_MESSAGE);
		}

	}

	private void AranyNemzetek() {

		for (Versenyzo versenyzo : versenyzok) {
			if (versenyzo.getHelyezes() == 1) {
				aranyErmesLista.add(versenyzo.getNemzet());
			}
		}

	}

	private void VersenySzamok() {

		for (Versenyzo versenyzo : versenyzok) {
			versenySzamok.add(versenyzo.getVersenySzam());
		}
	}

	private void VersenySzamListaFeltoltes() {

		for (String item : versenySzamok) {
			lModelVersenySzam.addElement(item);
		}
		lstVersenySzam.setModel(lModelVersenySzam);

	}

	private void AranyEremListaFeltoltes() {

		for (String item : aranyErmesLista) {
			lModelArany.addElement(item);
		}
		lstAranyLista.setModel(lModelArany);

	}
}
