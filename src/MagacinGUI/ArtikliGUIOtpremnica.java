package MagacinGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import MagacinKlase.*;
import javax.swing.JComboBox;

public class ArtikliGUIOtpremnica extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTextField BrOtpremnice;
	private JTextField Kupac;

	private MagacinGUI mGUI = null;

	private JButton btnSacuvajOtpremnicu;

	LinkedList<StavkaOtpremnica> stavOt = new LinkedList<StavkaOtpremnica>();

	List<Otpremnica> otpremnice;

	public ArtikliGUIOtpremnica(MagacinGUI mGUI) {

		otpremnice = mGUI.magacin.vratiSveOtpremnice();

		this.mGUI = mGUI;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 605, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSifraArtikla = new JLabel("SIFRA ARTIKLA");
		lblSifraArtikla.setBounds(29, 83, 116, 14);
		contentPane.add(lblSifraArtikla);

		textField = new JTextField();
		textField.setBounds(204, 77, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNazivArtikla = new JLabel("NAZIV ARTIKLA");
		lblNazivArtikla.setBounds(29, 155, 92, 14);
		contentPane.add(lblNazivArtikla);

		textField_1 = new JTextField();
		textField_1.setBounds(204, 115, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblKolicina = new JLabel("KOLICINA");
		lblKolicina.setBounds(29, 118, 92, 14);
		contentPane.add(lblKolicina);

		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(204, 152, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JComboBox comboBox = new JComboBox();

		for (MagacinskiProstor mp : mGUI.magacin.vratiSveMagacinskeProstore())
			comboBox.addItem(mp.getLokacija().toString());

		comboBox.setBounds(29, 11, 127, 20);
		contentPane.add(comboBox);

		table = new JTable();

		table.setModel(new DefaultTableModel(new Object[][] { { "SIFRA", "NAZIV", "KOLICINA", }, },
				new String[] { "New column", "New column", "New column", }

		));

		table.setBounds(31, 287, 532, 159);
		contentPane.add(table);

		JButton btnSacuvaj = new JButton(" Sacuvaj stavke");
		btnSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int sifra = Integer.parseInt(textField.getText());
				String naziv = textField_2.getText();
				int kolicina = Integer.parseInt(textField_1.getText());

				DefaultTableModel model = (DefaultTableModel) table.getModel();

				List<MagacinskiProstor> mp = mGUI.magacin.vratiSveMagacinskeProstore();

				for (int i = 0; i < mp.size(); i++) {
					if (comboBox.getSelectedItem().equals(mp.get(i).getLokacija())) {
						for (int j = 0; j < mp.get(i).getArtikli().size(); j++) {
							if (mp.get(i).getArtikli().get(j).getSifra() == sifra) {
								textField_2.setText(mp.get(i).getArtikli().get(j).getNaziv().toString());
							}
						}
					}
				}

				if (textField.getText().equals("") || textField_1.getText().equals("")
						|| textField_2.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Popunite sva polja");
				} else {
					model.addRow(new Object[] { Integer.parseInt(textField.getText()), textField_2.getText(),
							Integer.parseInt(textField_1.getText()) });
				}

				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);

				Artikal a = null;

				for (int i = 0; i < mp.size(); i++) {
					for (int j = 0; j < mp.get(i).getArtikli().size(); j++) {
						if (mp.get(i).getArtikli().get(j).getSifra() == sifra) {
							a = mp.get(i).getArtikli().get(j);
						}
					}
				}

				StavkaOtpremnica so = new StavkaOtpremnica();

				so.setArtikliID(a);
				so.setKolicina(kolicina);

				stavOt.add(so);

				for (int i = 0; i < stavOt.size(); i++) { //
					System.out.println(stavOt.get(i)); // da proverim da li radi
					System.out.println(stavOt.size()); //
				}

			}
		});
		btnSacuvaj.setBounds(31, 227, 133, 23);
		contentPane.add(btnSacuvaj);

		JButton btnIzbrisi = new JButton("Izbrisi stavke");
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int i = table.getSelectedRow();

				model.removeRow(i);

				for (int j = 0; j < stavOt.size(); j++) {
					if (i == j) {
						stavOt.remove(j);
					}
				}
				System.out.println(stavOt.get(i));

			}
		});
		btnIzbrisi.setBounds(204, 227, 138, 23);
		contentPane.add(btnIzbrisi);

		JLabel lblBrOtpremnice = new JLabel("Br.Otpremnice");
		lblBrOtpremnice.setBounds(322, 11, 86, 14);
		contentPane.add(lblBrOtpremnice);

		JLabel lblKupac = new JLabel("Kupac");
		lblKupac.setBounds(322, 51, 46, 14);
		contentPane.add(lblKupac);

		BrOtpremnice = new JTextField();
		BrOtpremnice.setBounds(463, 8, 86, 20);
		contentPane.add(BrOtpremnice);
		BrOtpremnice.setColumns(10);

		Kupac = new JTextField();
		Kupac.setBounds(463, 51, 86, 20);
		contentPane.add(Kupac);
		Kupac.setColumns(10);

		btnSacuvajOtpremnicu = new JButton("Sacuvaj Otpremnicu");
		btnSacuvajOtpremnicu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				List<MagacinskiProstor> mp = mGUI.magacin.vratiSveMagacinskeProstore();

				int brOtpremnice = Integer.parseInt(BrOtpremnice.getText());
				String kupac = Kupac.getText();

				Otpremnica o = new Otpremnica();
				o.setBrojOtpremnice(brOtpremnice);
				o.setDatum(new GregorianCalendar());
				o.setKupac(kupac);
				o.setStavkeOt(stavOt);


				int mpID = 0;

				if (comboBox.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(contentPane, "Izaberite magacin");
					throw new MagacinException("Izaberite magacin");
				}

				for (int i = 0; i < mp.size(); i++) {

					if (mp.get(i).getLokacija().equals(comboBox.getSelectedItem().toString())) {
						mpID = mp.get(i).getMagacinskiProstorID();
					}

				}

				mGUI.magacin.izdajRobu(mpID, o);
				mGUI.magacin.sacuvajMagacin("SviMagacini");

				dispose();

			}
		});
		btnSacuvajOtpremnicu.setBounds(416, 227, 133, 23);
		contentPane.add(btnSacuvajOtpremnicu);

	}
}
