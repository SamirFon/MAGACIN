package MagacinGUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import MagacinKlase.Artikal;
import MagacinKlase.KancelarijskiMaterijal;
import MagacinKlase.Knjiga;
import MagacinKlase.KucnaHemija;
import MagacinKlase.Magacin;
import MagacinKlase.MagacinException;
import MagacinKlase.MagacinInterfejs;
import MagacinKlase.MagacinskiProstor;
import MagacinKlase.Prijemnica;
import MagacinKlase.StavkaOtpremnica;
import MagacinKlase.StavkaPrijemnica;

import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;

public class ArtikliGUI2Prijemnica extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField PrijemnicaID;
	private JTextField Dobavljac;

	private MagacinGUI mGUI = null;

	LinkedList<StavkaPrijemnica> stavPr = new LinkedList<StavkaPrijemnica>();

	DefaultListModel<StavkaPrijemnica> lm = new DefaultListModel<StavkaPrijemnica>();

	

	public ArtikliGUI2Prijemnica(MagacinGUI gp) {

		mGUI = gp;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 605, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSifraArtikla = new JLabel("SIFRA ARTIKLA");
		lblSifraArtikla.setBounds(26, 73, 116, 14);
		contentPane.add(lblSifraArtikla);

		textField = new JTextField();
		textField.setBounds(204, 70, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblKolicina = new JLabel("KOLICINA");
		lblKolicina.setBounds(26, 98, 92, 14);
		contentPane.add(lblKolicina);

		textField_2 = new JTextField();
		textField_2.setBounds(204, 95, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(26, 8, 169, 17);

		for (MagacinskiProstor mp : mGUI.magacin.vratiSveMagacinskeProstore()) {
			comboBox.addItem(mp.getLokacija());
		}

		contentPane.add(comboBox);

		JList list = new JList();
		list.setBounds(26, 191, 610, 292);
		contentPane.add(list);

		JButton btnSacuvaj = new JButton(" Sacuvaj stavke");
		btnSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int sifra = Integer.parseInt(textField.getText());
				int kolicina = Integer.parseInt(textField_2.getText());

				String pakovanje = null;
				String sastav = null;
				String isbn = null;

				List<MagacinskiProstor> mp = mGUI.magacin.vratiSveMagacinskeProstore();

				Artikal a = null;
				StavkaPrijemnica sp = new StavkaPrijemnica();

				boolean pronadjen = false;

				for (int i = 0; i < mp.size(); i++) {
					for (int j = 0; j < mp.get(i).getArtikli().size(); j++) {
						if ((mp.get(i).getArtikli().get(j).getSifra() == sifra)) {
							a = mp.get(i).getArtikli().get(j);
							pronadjen = true;
						}
					}
				}
				sp.setArtikliSifra(a);
				sp.setKolicina(kolicina);
				stavPr.add(sp);

				lm.addElement(sp);

				for (int i = 0; i < stavPr.size(); i++) {

					System.out.println(stavPr.get(i));
				}
				list.setModel(lm);

				if (!pronadjen) {
					JOptionPane.showMessageDialog(contentPane, "Artikal nije pronadjen");
				}

				textField.setText("");

				textField_2.setText("");

				System.out.println(stavPr.size());

			}
		});
		btnSacuvaj.setBounds(26, 142, 133, 23);
		contentPane.add(btnSacuvaj);

		JButton btnIzbrisi = new JButton("Izbrisi stavke");
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int i = list.getSelectedIndex();
				lm.removeElementAt(i);

				for (int j = 0; j < stavPr.size(); j++) {

					if (i == j) { // TODO Mora nesto da se popravi da izbacuje bas pravu stavkuPr
						stavPr.remove(j);
					}
				}

				for (int j = 0; j < stavPr.size(); j++) {

					System.out.println(stavPr.size()); // TODO sluzi za testiranje
					System.out.println(stavPr.get(i)); // TODO sluzi za testiranje
				}
			}
		});
		btnIzbrisi.setBounds(197, 142, 138, 23);
		contentPane.add(btnIzbrisi);

		JLabel lblPrijemnicaID = new JLabel("Prijemnica ID");
		lblPrijemnicaID.setBounds(322, 11, 86, 14);
		contentPane.add(lblPrijemnicaID);

		PrijemnicaID = new JTextField();
		PrijemnicaID.setBounds(463, 8, 86, 20);
		contentPane.add(PrijemnicaID);
		PrijemnicaID.setColumns(10);

		JLabel lblDobavljac = new JLabel("Dobavljac");
		lblDobavljac.setBounds(322, 50, 86, 14);
		contentPane.add(lblDobavljac);

		Dobavljac = new JTextField();
		Dobavljac.setBounds(463, 47, 86, 20);
		contentPane.add(Dobavljac);
		Dobavljac.setColumns(10);

		JButton btnSacuvajPrijemnicu = new JButton("Sacuvaj prijemnicu");
		btnSacuvajPrijemnicu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String Prijemnica = PrijemnicaID.getText();
				String dobavljac = Dobavljac.getText();

				Prijemnica pr = new Prijemnica();

				pr.setDatum(new GregorianCalendar());
				pr.setNazivDobavljaca(dobavljac);
				pr.setStavkePr(stavPr);
				pr.setPrijemnicaID(Prijemnica);

				List<MagacinskiProstor> mp = mGUI.magacin.vratiSveMagacinskeProstore();

				for (int i = 0; i < mp.size(); i++) {

					if (mp.get(i).getLokacija().equals(comboBox.getSelectedItem().toString())) {

						mGUI.magacin.primiRobu(mp.get(i).getMagacinskiProstorID(), pr);
						mGUI.magacin.sacuvajMagacin("SviMagacini");
					}
				}

				mGUI.osveziPrikaz();

				dispose();

				PrijemnicaID.setText(null);
				Dobavljac.setText(null);

			}
		});
		btnSacuvajPrijemnicu.setBounds(394, 142, 155, 23);
		contentPane.add(btnSacuvajPrijemnicu);

	}
}
