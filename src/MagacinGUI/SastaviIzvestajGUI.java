package MagacinGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import com.toedter.components.JSpinField;

import MagacinKlase.Magacin;
import MagacinKlase.MagacinException;
import MagacinKlase.MagacinInterfejs;
import MagacinKlase.Otpremnica;
import MagacinKlase.Prijemnica;

import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JList;

public class SastaviIzvestajGUI extends JFrame {

	private JPanel contentPane;

	private MagacinGUI mGUI = null;

	private JTextField Dan;
	private JTextField Mesec;
	private JTextField Godina;
	private JTextField Fajl;

	public SastaviIzvestajGUI(MagacinGUI mGUI) {

		this.mGUI = mGUI;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 586, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 150));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);

		Dan = new JTextField();
		Dan.setBounds(70, 60, 42, 20);
		panel.add(Dan);
		Dan.setColumns(10);

		Mesec = new JTextField();
		Mesec.setBounds(217, 60, 42, 20);
		panel.add(Mesec);
		Mesec.setColumns(10);

		Godina = new JTextField();
		Godina.setBounds(376, 60, 65, 20);
		panel.add(Godina);
		Godina.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);

		JList list = new JList();
		scrollPane.setViewportView(list);

		JButton btnPrikaziIzvestaj = new JButton("PRIKAZI IZVESTAJ");
		btnPrikaziIzvestaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (Dan.getText().equals(""))
					JOptionPane.showMessageDialog(contentPane, "Upisite dan");

				if (Mesec.getText().equals(""))
					JOptionPane.showMessageDialog(contentPane, "Upisite mesec");

				if (Godina.getText().equals(""))
					JOptionPane.showMessageDialog(contentPane, "Upisite godina");

				int day = Integer.parseInt(Dan.getText());
				int mesec = Integer.parseInt(Mesec.getText());
				int godina = Integer.parseInt(Godina.getText());

				GregorianCalendar dan = new GregorianCalendar(godina, mesec - 1, day);

				DefaultListModel lm = new DefaultListModel<>();

				lm.addElement(mGUI.magacin.sastaviIzvestaj(dan));

				list.setModel(lm);

				

			}
		});
		btnPrikaziIzvestaj.setBounds(81, 127, 154, 23);
		panel.add(btnPrikaziIzvestaj);

		JLabel lblSacuvajUFajl = new JLabel("SACUVAJ U FAJL");
		lblSacuvajUFajl.setBounds(70, 22, 115, 14);
		panel.add(lblSacuvajUFajl);

		Fajl = new JTextField();
		Fajl.setBounds(267, 19, 86, 20);
		panel.add(Fajl);
		Fajl.setColumns(10);

		JLabel lblDan = new JLabel("DAN");
		lblDan.setBounds(10, 63, 46, 14);
		panel.add(lblDan);

		JLabel lblMesec = new JLabel("MESEC");
		lblMesec.setBounds(142, 66, 46, 14);
		panel.add(lblMesec);

		JLabel lblGodina = new JLabel("GODINA");
		lblGodina.setBounds(286, 66, 55, 14);
		panel.add(lblGodina);

		JButton btnSacuvajIzvestaj = new JButton("SACUVAJ IZVESTAJ");
		btnSacuvajIzvestaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String fajl = Fajl.getText();

				if (Fajl.getText().equals(""))
					JOptionPane.showMessageDialog(contentPane, "Upisite fajl");

				if (Dan.equals(""))
					JOptionPane.showMessageDialog(contentPane, "Upisite dan");
				if (Mesec.equals(""))
					JOptionPane.showMessageDialog(contentPane, "Upisite mesec");
				if (Godina.equals(""))
					JOptionPane.showMessageDialog(contentPane, "Upisite godina");

				int day = Integer.parseInt(Dan.getText());
				int mesec = Integer.parseInt(Mesec.getText());
				int godina = Integer.parseInt(Godina.getText());

				GregorianCalendar dan = new GregorianCalendar(godina, mesec - 1, day);

				mGUI.magacin.sacuvajIzvestaj(mGUI.magacin.sastaviIzvestaj(dan), fajl);

				dispose();

			}
		});
		btnSacuvajIzvestaj.setBounds(315, 127, 126, 23);
		panel.add(btnSacuvajIzvestaj);

	}
}