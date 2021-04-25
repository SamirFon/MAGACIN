package MagacinGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.security.spec.MGF1ParameterSpec;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import MagacinKlase.Artikal;
import MagacinKlase.Magacin;
import MagacinKlase.MagacinException;
import MagacinKlase.MagacinInterfejs;
import MagacinKlase.MagacinskiProstor;
import MagacinKlase.Otpremnica;
import MagacinKlase.Prijemnica;
import MagacinKlase.StavkaPrijemnica;

import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.SwingConstants;
import MagacinGUI.ArtikliGUIOtpremnica;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent; // importovao ArtikliGUI

public class MagacinGUI extends JFrame {

	private JPanel contentPane;
	private JList list;

	MagacinInterfejs magacin = new Magacin();
	private JComboBox comboBox;

	MagacinGUI mGUI;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MagacinGUI frame = new MagacinGUI();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MagacinGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				izadjiIzAplikacije();
			}

			private void izadjiIzAplikacije() {
				int opcija = JOptionPane.showConfirmDialog(contentPane, "Da li zelite da zatvorite prozor",	 "Poruka", 
						JOptionPane.YES_NO_OPTION);
				if (opcija == JOptionPane.YES_OPTION)
					System.exit(0);
				
			}
		});

		magacin.ucitajMagacin("SviMagacini");
		
		

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		setBounds(100, 100, 726, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100, 500));
		tabbedPane.addTab("Magacinski prostor", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(180, 10));
		panel.add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(null);

		comboBox = new JComboBox();
		comboBox.setBounds(0, 5, 66, 20);

		for (MagacinskiProstor mp : magacin.vratiSveMagacinskeProstore())
			comboBox.addItem(mp.getLokacija().toString());

		comboBox.setSelectedItem(null); // ovo sam dodao
		panel_3.add(comboBox);

		JButton btnNewButton = new JButton("Prikazi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (comboBox.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(contentPane, "Izaberite magacin");
					throw new MagacinException("Izaberite magacin");
				}

				DefaultListModel lm = new DefaultListModel<>(); // a treba DefaultListModel lm = new DefaultListModel();

				List<MagacinskiProstor> mp = magacin.vratiSveMagacinskeProstore();

				if (magacin == null)
					throw new MagacinException("Nije ucitan magacin");
				if (magacin.vratiSveMagacinskeProstore().size() <= 0)
					throw new MagacinException("Nema magacinskih prostora");
				for (int i = 0; i < magacin.vratiSveMagacinskeProstore().size(); i++) {
					if (magacin.vratiSveMagacinskeProstore().get(i).getLokacija()
							.equals(comboBox.getSelectedItem().toString())) {
						for (int j = 0; j < magacin.vratiSveMagacinskeProstore().get(i).getArtikli().size(); j++)
							lm.addElement(magacin.vratiSveMagacinskeProstore().get(i).getArtikli().get(j));
						break;
					}
				}

				list.setModel(lm);

			}
		});
		btnNewButton.setBounds(71, 4, 89, 23);
		panel_3.add(btnNewButton);

		JButton UnesiA = new JButton("Unesi Artikle");
		UnesiA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				UnesiArtikalGUI ar = new UnesiArtikalGUI((MagacinGUI) contentPane.getParent().getParent().getParent());

				ar.setVisible(true);

			}
		});
		UnesiA.setBounds(10, 36, 123, 23);
		panel_3.add(UnesiA);

		JButton IzbrisiA = new JButton("Izbrisi Artikle");
		IzbrisiA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IzbrisiArtikalGUI ar = new IzbrisiArtikalGUI(
						(MagacinGUI) contentPane.getParent().getParent().getParent());
				ar.setVisible(true);

			}
		});
		IzbrisiA.setFont(new Font("Tahoma", Font.PLAIN, 11));
		IzbrisiA.setBounds(10, 70, 123, 23);
		panel_3.add(IzbrisiA);

		JButton btnNewButton_3 = new JButton("Unesi Magac Prostor");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UnesiteMagacinskiProstorGUI umg = new UnesiteMagacinskiProstorGUI(
						(MagacinGUI) contentPane.getParent().getParent().getParent());
				umg.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_3.setBounds(10, 104, 123, 23);
		panel_3.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Izbrisi Magac Prostor");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IzbrisiMagacinskiProstorGUI img = new IzbrisiMagacinskiProstorGUI(
						(MagacinGUI) contentPane.getParent().getParent().getParent());
				img.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(10, 138, 123, 23);
		panel_3.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Sacuvaj Magacin");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser fc = new JFileChooser();
					int opcija = fc.showSaveDialog(contentPane);
					if (opcija == JFileChooser.APPROVE_OPTION) {
						String fajl = fc.getSelectedFile().getAbsolutePath();
						magacin.sacuvajMagacin(fajl);

					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage(), ex.getClass().toString(),
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnNewButton_5.setBounds(10, 172, 123, 23);
		panel_3.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Ucitaj Magacin");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					JFileChooser fc = new JFileChooser();

					int opcija = fc.showOpenDialog(contentPane);
					if (opcija == JFileChooser.APPROVE_OPTION) {
						String fajl = fc.getSelectedFile().getAbsolutePath();

						magacin.ucitajMagacin(fajl);

						if (magacin.vratiSveMagacinskeProstore().size() <= 0)
							JOptionPane.showMessageDialog(contentPane, "Fajl nema magacinske prostore");
						if (magacin.vratiSvePrijemnice().size() <= 0)
							JOptionPane.showMessageDialog(contentPane, "Fajl nema prijemnice");
						if (magacin.vratiSveOtpremnice().size() <= 0)
							JOptionPane.showMessageDialog(contentPane, "Fajl nema otpremnice");

						for (MagacinskiProstor mp : magacin.vratiSveMagacinskeProstore())
							comboBox.addItem(mp.getLokacija().toString());

						osveziPrikaz();

					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage(), ex.getClass().toString(),
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_6.setBounds(10, 206, 123, 23);
		panel_3.add(btnNewButton_6);

		JButton btnNewButton_8 = new JButton("Izvestaj \r\ntrenutnog \r\nstanja");
		btnNewButton_8.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IzvestajTrenutnogStanjaGUI ps = new IzvestajTrenutnogStanjaGUI(
						(MagacinGUI) contentPane.getParent().getParent().getParent());
				ps.setVisible(true);
			}
		});
		btnNewButton_8.setBounds(10, 240, 123, 52);
		panel_3.add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("Izvestaj");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SastaviIzvestajGUI si = new SastaviIzvestajGUI(
						(MagacinGUI) contentPane.getParent().getParent().getParent());
				si.setVisible(true);
			}
		});
		btnNewButton_9.setBounds(10, 303, 123, 23);
		panel_3.add(btnNewButton_9);

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		list = new JList();
		scrollPane.setViewportView(list);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Otpremnica", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(120, 10));
		panel_1.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);

		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);

		JButton btnUnesiOtpremnicu = new JButton("Unesi Otpremnicu");
		btnUnesiOtpremnicu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArtikliGUIOtpremnica a = new ArtikliGUIOtpremnica(
						(MagacinGUI) contentPane.getParent().getParent().getParent());

				a.setVisible(true);
			}
		});
		btnUnesiOtpremnicu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnUnesiOtpremnicu.setHorizontalAlignment(SwingConstants.LEFT);
		btnUnesiOtpremnicu.setBounds(0, 61, 120, 36);
		panel_4.add(btnUnesiOtpremnicu);

		JButton btnPrikaziOtpremnicu = new JButton("Prikazi otpremnicu");
		btnPrikaziOtpremnicu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				magacin.ucitajMagacin("SviMagacini");

				DefaultListModel<Otpremnica> lm = new DefaultListModel<Otpremnica>();

				List<Otpremnica> ot = magacin.vratiSveOtpremnice();


				for (Otpremnica otpremnica : ot)
					lm.addElement(otpremnica);

				list_1.setModel(lm);
			}
		});
		btnPrikaziOtpremnicu.setBounds(0, 152, 120, 36);
		panel_4.add(btnPrikaziOtpremnicu);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Prijemnica", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(120, 10));
		panel_2.add(panel_5, BorderLayout.WEST);
		panel_5.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2.add(scrollPane_2, BorderLayout.CENTER);

		JList list_2 = new JList();
		scrollPane_2.setViewportView(list_2);

		JButton btnPrijemnica = new JButton("Unesite prijemnicu");
		btnPrijemnica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArtikliGUI2Prijemnica a = new ArtikliGUI2Prijemnica(
						(MagacinGUI) contentPane.getParent().getParent().getParent());
				a.setVisible(true);
			}
		});
		btnPrijemnica.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPrijemnica.setBounds(0, 64, 120, 23);
		panel_5.add(btnPrijemnica);

		JButton btnPrikaziPrijemnice = new JButton("Prikazi prijemnice");
		btnPrikaziPrijemnice.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPrikaziPrijemnice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DefaultListModel<Prijemnica> lm = new DefaultListModel<Prijemnica>();

				List<Prijemnica> pr = magacin.vratiSvePrijemnice();

				for (int i = 0; i < pr.size(); i++) {
					lm.addElement(pr.get(i));
				}

				list_2.setModel(lm);
			}
		});
		btnPrikaziPrijemnice.setBounds(0, 149, 120, 23);
		panel_5.add(btnPrikaziPrijemnice);

		osveziPrikaz();

	}

	public void osveziPrikaz() {

		DefaultListModel lm = new DefaultListModel<>();

		List<MagacinskiProstor> mp = magacin.vratiSveMagacinskeProstore();

		if (magacin == null)
			throw new MagacinException("Nije ucitan magacin");
		if (magacin.vratiSveMagacinskeProstore().size() <= 0)
			throw new MagacinException("Nema magacinskih prostora");
		for (int i = 0; i < magacin.vratiSveMagacinskeProstore().size(); i++) {

			for (int j = 0; j < magacin.vratiSveMagacinskeProstore().get(i).getArtikli().size(); j++)
				lm.addElement(magacin.vratiSveMagacinskeProstore().get(i).getArtikli().get(j));

		}

		list.setModel(lm);

		List<Prijemnica> pr = magacin.vratiSvePrijemnice();

		if (magacin == null)
			throw new MagacinException("Nije ucitan magacin");
		if (pr.size() <= 0)
			throw new MagacinException("Nema prijemnica");
		for (int i = 0; i < pr.size(); i++) {
			lm.addElement(pr.get(i));
		}

		list.setModel(lm);

		List<Otpremnica> ot = magacin.vratiSveOtpremnice();

		if (magacin == null)
			throw new MagacinException("Nije ucitan magacin");
		if (ot.size() <= 0)
			throw new MagacinException("Nema otpremnica");
		for (int i = 0; i < ot.size(); i++) {

			lm.addElement(ot.get(i));
		}
		list.setModel(lm);

	}

}
