package MagacinGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import MagacinKlase.Artikal;
import MagacinKlase.KucnaHemija;
import MagacinKlase.Magacin;
import MagacinKlase.MagacinException;
import MagacinKlase.MagacinInterfejs;
import MagacinKlase.MagacinskiProstor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class IzbrisiArtikalGUI extends JFrame {

	private JPanel contentPane;
	private JTextField sifraArtikla;

	private MagacinGUI mGUI = null;
	private JTextField IDmagacina;

	public IzbrisiArtikalGUI(MagacinGUI mGUI) {
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent arg0) {
				
				izadjiIzAplikacije();
				
			}

			
		});

		this.mGUI = mGUI;

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUnesiteIDMagacina = new JLabel("UNESITE ID MAGACINA");
		lblUnesiteIDMagacina.setBounds(25, 77, 150, 14);
		contentPane.add(lblUnesiteIDMagacina);

		JLabel lblUnesiteSifruArtikla = new JLabel("UNESITE SIFRU  ARTIKLA");
		lblUnesiteSifruArtikla.setBounds(25, 142, 150, 14);
		contentPane.add(lblUnesiteSifruArtikla);

		sifraArtikla = new JTextField();
		sifraArtikla.setBounds(218, 139, 121, 20);
		contentPane.add(sifraArtikla);
		sifraArtikla.setColumns(10);

		JButton btnIzbrisi = new JButton("IZBRISI");
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					int brojMag = Integer.parseInt(IDmagacina.getText());
					int sifra = Integer.parseInt(sifraArtikla.getText());

					Artikal a = new KucnaHemija();
					a.setSifra(sifra);

					mGUI.magacin.izbrisiArtikle(brojMag, a);

					mGUI.osveziPrikaz();

					dispose();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPane, e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnIzbrisi.setBounds(164, 190, 97, 23);
		contentPane.add(btnIzbrisi);

		IDmagacina = new JTextField();
		IDmagacina.setBounds(218, 74, 121, 20);
		contentPane.add(IDmagacina);
		IDmagacina.setColumns(10);

	}

	private void izadjiIzAplikacije() {
		int opcija = JOptionPane.showConfirmDialog(contentPane, "Da li zelite da zatvorite prozor",	 "Poruka", 
				JOptionPane.YES_NO_OPTION);
		if (opcija == JOptionPane.YES_OPTION)
			System.exit(0);
	}
}
