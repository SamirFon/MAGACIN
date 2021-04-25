package MagacinGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MagacinKlase.Magacin;
import MagacinKlase.MagacinInterfejs;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;

public class IzvestajTrenutnogStanjaGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	private JList list;
	private JTextField NazivFajla;

	private MagacinGUI mGUI = null;

	public IzvestajTrenutnogStanjaGUI(MagacinGUI mGUI) {

		this.mGUI = mGUI;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUnesiteMagacinskiProstor = new JLabel("UNESITE MAGACINSKI PROSTOR ID ");
		lblUnesiteMagacinskiProstor.setBounds(34, 97, 203, 14);
		contentPane.add(lblUnesiteMagacinskiProstor);

		textField = new JTextField();
		textField.setBounds(291, 94, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnPrikaziPregled = new JButton("SAČUVAJ TRENUTNO STANJE");
		btnPrikaziPregled.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nazivFajla = NazivFajla.getText();

				int ID = Integer.parseInt(textField.getText());

				mGUI.magacin.pregledStanja(ID, nazivFajla);

				dispose();

			}
		});
		btnPrikaziPregled.setBounds(120, 163, 195, 23);
		contentPane.add(btnPrikaziPregled);

		JLabel lblUnesiteImeFajla = new JLabel("UNESITE NAZIV FAJLA");
		lblUnesiteImeFajla.setBounds(34, 35, 179, 14);
		contentPane.add(lblUnesiteImeFajla);

		NazivFajla = new JTextField();
		NazivFajla.setBounds(291, 32, 86, 20);
		contentPane.add(NazivFajla);
		NazivFajla.setColumns(10);
	}
}
