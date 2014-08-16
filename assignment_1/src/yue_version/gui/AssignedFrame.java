package yue_version.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import yue_version.fibonacci.Fibonacci;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * This is for fun, an easy fibonacci calculator
 * 
 * @author Yue
 * @version 1.0
 *
 */
public class AssignedFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmHelpMenuItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssignedFrame frame = new AssignedFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AssignedFrame() {
		super("Fibonacci \"Four\"");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		mnNewMenu = new JMenu("Help");
		menuBar.add(mnNewMenu);
		mntmHelpMenuItem = new JMenuItem("Version");
		mntmHelpMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayInfo();
			}
		});
		mnNewMenu.add(mntmHelpMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		this.textArea = new JTextArea();
		textArea.setLineWrap(true);
		textField = new JTextField();
		textField.setBounds(25, 30, 154, 19);
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		this.scrollPane = new JScrollPane(textArea);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		Button button = new Button("New button");
		contentPane.add(button, BorderLayout.SOUTH);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fibonacci fibo = new Fibonacci();
				String result = "-1";
				if (validateUserInput(textField.getText()))
					result = fibo.fib4(Integer.parseInt(textField.getText()))
							.toString();
				textArea.setText(result);
			}
		});
		button.setBounds(203, 26, 86, 23);
	}

	private boolean validateUserInput(String input) {
		String digits = "0123456789";
		for (int i = 0; i < input.length(); i++) {
			if (!digits.contains(Character.toString(input.charAt(i)))) {
				return false;
			}
		}
		return true;
	}

	private void displayInfo() {
		JOptionPane
				.showMessageDialog(
						this,
						"This Fibonacci calculator is developed for ADA assignment 1."
								+ "\nInput must be greater than or equal 0, digits only;\n"
								+ "Output error message otherwise.   -  Yue");
	}
}
