package MagacinGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PrijemRobeGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	
	public PrijemRobeGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUnesiteMagacinskiProstor = new JLabel("UNESITE MAGACINSKI PROSTOR ID");
		lblUnesiteMagacinskiProstor.setBounds(38, 66, 212, 14);
		contentPane.add(lblUnesiteMagacinskiProstor);

		textField = new JTextField();
		textField.setBounds(310, 66, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblUnesitePrijemnicu = new JLabel("UNESITE PRIJEMNICU");
		lblUnesitePrijemnicu.setBounds(38, 129, 176, 14);
		contentPane.add(lblUnesitePrijemnicu);

		textField_1 = new JTextField();
		textField_1.setBounds(310, 126, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnSacuvaj = new JButton("SACUVAJ");
		btnSacuvaj.setBounds(169, 183, 116, 23);
		contentPane.add(btnSacuvaj);
	}

}
