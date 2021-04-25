package MagacinGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MagacinKlase.Magacin;
import MagacinKlase.MagacinInterfejs;
import MagacinKlase.MagacinskiProstor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IzbrisiMagacinskiProstorGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	private MagacinGUI mGUI = null;

	static MagacinInterfejs magacin = new Magacin(); // ovo sam dodao

	public IzbrisiMagacinskiProstorGUI(MagacinGUI mGUI) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUnesiteMagacinskiProstor = new JLabel("UNESITE MAGACINSKI PROSTOR ID");
		lblUnesiteMagacinskiProstor.setBounds(27, 78, 211, 14);
		contentPane.add(lblUnesiteMagacinskiProstor);

		textField = new JTextField();
		textField.setBounds(300, 78, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnIzbrisi = new JButton("IZBRISI");
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int ID = Integer.parseInt(textField.getText());

					mGUI.magacin.izbrisiMagacinskiProstor(ID);
					mGUI.magacin.sacuvajMagacin("SviMagacini");

					mGUI.osveziPrikaz();

					dispose();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPane, e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnIzbrisi.setBounds(164, 150, 103, 23);
		contentPane.add(btnIzbrisi);
	}

}
