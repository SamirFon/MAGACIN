package MagacinGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MagacinKlase.Magacin;
import MagacinKlase.MagacinInterfejs;
import MagacinKlase.MagacinskiProstor;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UnesiteMagacinskiProstorGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	private MagacinGUI mGUI = null;

	static MagacinInterfejs magacin = new Magacin(); // ovo sam dodao

	public UnesiteMagacinskiProstorGUI(MagacinGUI mGUI) {

		MagacinskiProstor mp1 = new MagacinskiProstor();
		mp1.setLokacija("Hemija");
		mp1.setMagacinskiProstorID(2);

		MagacinskiProstor mp2 = new MagacinskiProstor();
		mp2.setLokacija("KancelarijskiMaterijal");
		mp2.setMagacinskiProstorID(1);

		MagacinskiProstor mp3 = new MagacinskiProstor();
		mp3.setLokacija("Knjige");
		mp3.setMagacinskiProstorID(3);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMagacinskiProstorId = new JLabel("MAGACINSKI PROSTOR ID");
		lblMagacinskiProstorId.setBounds(10, 45, 156, 14);
		contentPane.add(lblMagacinskiProstorId);

		textField = new JTextField();
		textField.setBounds(227, 42, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblLokacija = new JLabel("LOKACIJA");
		lblLokacija.setBounds(10, 98, 133, 14);
		contentPane.add(lblLokacija);

		textField_1 = new JTextField();
		textField_1.setBounds(227, 95, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnSacuvaj = new JButton("SACUVAJ");
		btnSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int ID = Integer.parseInt(textField.getText());
					String lokacija = textField_1.getText();

					mGUI.magacin.unesiMagacinskiProstor(ID, lokacija);

					mGUI.magacin.sacuvajMagacin("SviMagacini");

					mGUI.osveziPrikaz();

					dispose();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPane, e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnSacuvaj.setBounds(146, 154, 89, 23);
		contentPane.add(btnSacuvaj);
	}
}
