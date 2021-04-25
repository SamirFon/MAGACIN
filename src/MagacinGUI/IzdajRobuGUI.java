package MagacinGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class IzdajRobuGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public IzdajRobuGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUnesiteMagacinskiProstor = new JLabel("UNESITE MAGACINSKI PROSTOR ID");
		lblUnesiteMagacinskiProstor.setBounds(30, 66, 202, 14);
		contentPane.add(lblUnesiteMagacinskiProstor);

		JLabel lblUnesiteOtpremnicu = new JLabel("UNESITE OTPREMNICU");
		lblUnesiteOtpremnicu.setBounds(30, 143, 181, 14);
		contentPane.add(lblUnesiteOtpremnicu);

		textField = new JTextField();
		textField.setBounds(282, 63, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(282, 140, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnSacuvaj = new JButton("SACUVAJ");
		btnSacuvaj.setBounds(167, 198, 100, 23);
		contentPane.add(btnSacuvaj);
	}

}
