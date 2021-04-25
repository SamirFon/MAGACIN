package MagacinGUI;

import java.awt.BorderLayout;

import MagacinKlase.*;
import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class UnesiArtikalGUI extends JFrame {

	private JPanel contentPane;

	private MagacinGUI mGUI = null;

	private JTextField textSifra;
	private JTextField textNaziv;
	private JTextField txtKolicina;
	private JTextField textSastav;
	private JTextField textISNB;
	private JTextField textPakovanje;
	private JLabel lblUnesiteKolicinu;

	public UnesiArtikalGUI(MagacinGUI mGUI) {

		this.mGUI = mGUI;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 462, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();

		for (MagacinskiProstor mp : mGUI.magacin.vratiSveMagacinskeProstore())
			comboBox.addItem(mp.getLokacija());

		comboBox.setBounds(296, 8, 117, 17);
		contentPane.add(comboBox);

		JLabel lblUnesiMagacinskiProstor = new JLabel("IZABERI MAGACINSKI PROSTOR ");
		lblUnesiMagacinskiProstor.setBounds(10, 11, 206, 14);
		contentPane.add(lblUnesiMagacinskiProstor);

		JLabel lblUnesiteSifru = new JLabel("UNESITE SIFRU");
		lblUnesiteSifru.setBounds(10, 65, 161, 14);
		contentPane.add(lblUnesiteSifru);

		JButton btnSacuvaj = new JButton("SACUVAJ");
		btnSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					int sifra = Integer.parseInt(textSifra.getText());
					String naziv = textNaziv.getText();
					int kolicina = Integer.parseInt(txtKolicina.getText());
					String sastav = textSastav.getText();
					String isbn = textISNB.getText();
					String pakovanje = textPakovanje.getText();

					Artikal a = null;

					if (comboBox.getSelectedItem().toString().equals("KancelarijskiMaterijal")) {
						a = new KancelarijskiMaterijal(sifra, kolicina, naziv, pakovanje);

					}

					else if (comboBox.getSelectedItem().toString().equals("Hemija")) {
						a = new KucnaHemija(sifra, kolicina, naziv, sastav);
					}

					if (comboBox.getSelectedItem().toString().equals("Knjige")) {
						a = new Knjiga(sifra, kolicina, naziv, isbn);
					}
					

					mGUI.magacin.unesiArtikle(mGUI.magacin.vratiSveMagacinskeProstore().get(comboBox.getSelectedIndex())
							.getMagacinskiProstorID(), a);

					mGUI.osveziPrikaz();

					dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPane, e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
				}

				

			}
		});
		btnSacuvaj.setBounds(170, 292, 89, 23);
		contentPane.add(btnSacuvaj);

		JLabel lblUnesiNaziv = new JLabel("UNESI NAZIV");
		lblUnesiNaziv.setBounds(10, 90, 95, 14);
		contentPane.add(lblUnesiNaziv);

		lblUnesiteKolicinu = new JLabel("UNESITE KOLICINU");
		lblUnesiteKolicinu.setBounds(10, 115, 117, 14);
		contentPane.add(lblUnesiteKolicinu);

		JLabel lblUnesiteSastav = new JLabel("UNESITE SASTAV");
		lblUnesiteSastav.setBounds(10, 140, 141, 14);
		contentPane.add(lblUnesiteSastav);

		JLabel lblUnesiteIsnb = new JLabel("UNESITE ISNB");
		lblUnesiteIsnb.setBounds(10, 165, 80, 14);
		contentPane.add(lblUnesiteIsnb);

		textSifra = new JTextField();
		textSifra.setEnabled(true);
		textSifra.setBounds(296, 62, 86, 20);
		contentPane.add(textSifra);
		textSifra.setColumns(10);

		textNaziv = new JTextField();
		textNaziv.setBounds(296, 87, 86, 20);
		contentPane.add(textNaziv);
		textNaziv.setColumns(10);

		txtKolicina = new JTextField();
		txtKolicina.setBounds(296, 115, 86, 20);
		contentPane.add(txtKolicina);
		txtKolicina.setColumns(10);

		textSastav = new JTextField();
		textSastav.setBounds(296, 137, 86, 20);
		contentPane.add(textSastav);
		textSastav.setColumns(10);

		textISNB = new JTextField();
		textISNB.setBounds(296, 162, 86, 20);
		contentPane.add(textISNB);
		textISNB.setColumns(10);

		JLabel lblUnesitePakovanje = new JLabel("UNESITE PAKOVANJE");
		lblUnesitePakovanje.setBounds(10, 190, 206, 14);
		contentPane.add(lblUnesitePakovanje);

		textPakovanje = new JTextField();
		textPakovanje.setBounds(296, 187, 86, 20);
		contentPane.add(textPakovanje);
		textPakovanje.setColumns(10);

		textSifra.setVisible(false);
		textNaziv.setVisible(false);
		txtKolicina.setVisible(false);
		textSastav.setVisible(false);
		textISNB.setVisible(false);
		textPakovanje.setVisible(false);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				unesiPolja(lblUnesiteSastav, lblUnesiteIsnb, lblUnesitePakovanje, textSastav, textISNB, textPakovanje,
						comboBox);
			}
		});

	}

	private void unesiPolja(JLabel lblUnesiteSastav, JLabel lblUnesiteIsnb, JLabel lblUnesitePakovanje,
			JTextField textSastav, JTextField textISNB, JTextField textPakovanje, JComboBox comboBox) {

		if (comboBox.getSelectedItem() == null)
			JOptionPane.showMessageDialog(contentPane, "Unesite željeni magaci");

		if (comboBox.getSelectedItem().toString().equals("Hemija")) {
			lblUnesiteSastav.setVisible(true);
			lblUnesiteIsnb.setVisible(false);
			lblUnesitePakovanje.setVisible(false);
			textSastav.setVisible(true);
			textISNB.setVisible(false);
			textPakovanje.setVisible(false);

			textSifra.setVisible(true);
			textNaziv.setVisible(true);
			txtKolicina.setVisible(true);

		}

		else if (comboBox.getSelectedItem().toString().equals("KancelarijskiMaterijal")) {
			lblUnesiteSastav.setVisible(false);
			lblUnesiteIsnb.setVisible(false);
			lblUnesitePakovanje.setVisible(true);
			textSastav.setVisible(false);
			textISNB.setVisible(false);
			textPakovanje.setVisible(true);

			textSifra.setVisible(true);
			textNaziv.setVisible(true);
			txtKolicina.setVisible(true);

		}

		else if (comboBox.getSelectedItem().toString().equals("Knjige")) {
			lblUnesiteSastav.setVisible(false);
			lblUnesiteIsnb.setVisible(true);
			lblUnesitePakovanje.setVisible(false);
			textSastav.setVisible(false);
			textISNB.setVisible(true);
			textPakovanje.setVisible(false);
			textSifra.setVisible(true);
			textNaziv.setVisible(true);
			txtKolicina.setVisible(true);

		} else if (comboBox.getSelectedItem().toString().equals("Pice")) {
			lblUnesiteSastav.setVisible(false);
			lblUnesiteIsnb.setVisible(false);
			lblUnesitePakovanje.setVisible(false);
			textSastav.setVisible(false);
			textISNB.setVisible(false);
			textPakovanje.setVisible(false);
			textSifra.setVisible(true);
			textNaziv.setVisible(true);
			txtKolicina.setVisible(true);
		}
	}
}
