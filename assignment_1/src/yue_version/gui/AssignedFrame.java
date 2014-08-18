package yue_version.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

import yue_version.fibonacci.Fibonacci;
import yue_version.modular.Modulo;

/**
 * This is for fun, an easy fibonacci calculator
 * 
 * @author Yue
 * @version 1.0
 *
 */
public class AssignedFrame extends JFrame {

	private JPanel contentPane;
	private JTextField fiboTextField;
	private JTextArea fiboTextArea;
	private JScrollPane fiboScrollPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmHelpMenuItem;
	private JTabbedPane fiboTabbedPane;
	private JPanel fiboPanel;
	private JPanel euclid_panel;
	private JScrollPane euclidScrollPane;
	private JTextField euclidTextField;
	private JButton euclidButton;
	private JTextArea euclidTextArea;

	private static final String DIGITS = "0123456789";

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
		super("Assignment 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setMinimumSize(new Dimension(300, 250));
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		mnNewMenu = new JMenu("Help");
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
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
		initFiboTab();
		initEuclidTab();
	}

	private void initFiboTab() {
		fiboTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		fiboTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		contentPane.add(fiboTabbedPane, BorderLayout.CENTER);
		// fibo4
		fiboPanel = new JPanel();
		fiboTabbedPane.addTab("FibFour", null, fiboPanel, null);
		fiboPanel.setLayout(new BoxLayout(fiboPanel, BoxLayout.X_AXIS));
		this.fiboTextArea = new JTextArea();
		fiboTextArea.setLineWrap(true);
		this.fiboScrollPane = new JScrollPane(fiboTextArea);
		fiboPanel.add(fiboScrollPane);
		JButton button = new JButton("fibo4!");
		fiboScrollPane.setRowHeaderView(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fibonacci fibo = new Fibonacci();
				String result = "-1";
				if (validateUserInputFibonacci(fiboTextField.getText()))
					result = fibo.fib4(
							(Integer.parseInt(fiboTextField.getText()) - 1))
							.toString();
				fiboTextArea.setText(result);
			}
		});
		button.setBounds(203, 26, 86, 23);
		fiboTextField = new JTextField();
		fiboScrollPane.setColumnHeaderView(fiboTextField);
		fiboTextField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		fiboTextField.setBounds(25, 30, 154, 19);
		fiboTextField.setColumns(10);
	}

	private boolean validateUserInputFibonacci(String input) {
		if (input.length() == 1 && input.charAt(0) == '0'
				|| input.length() == 0)
			return false;
		for (int i = 0; i < input.length(); i++) {
			if (!DIGITS.contains(Character.toString(input.charAt(i)))) {
				return false;
			}
		}
		return true;
	}

	private void initEuclidTab() {
		euclid_panel = new JPanel();
		fiboTabbedPane.addTab("Euclid", null, euclid_panel, null);
		euclid_panel.setLayout(new BoxLayout(euclid_panel, BoxLayout.X_AXIS));

		euclidScrollPane = new JScrollPane();
		euclid_panel.add(euclidScrollPane);

		euclidTextField = new JTextField();
		euclidScrollPane.setColumnHeaderView(euclidTextField);
		euclidTextField.setColumns(10);

		euclidButton = new JButton("Euclid");
		euclidButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String result = "-1";
				if (validateUserInputEuclid(euclidTextField.getText())) {
					int[] parsedInput = parseUserInputToIntEuclid(euclidTextField
							.getText());
					int[] ans = Modulo.euclid(parsedInput[0], parsedInput[1]);
					result = ans[0] + " " + ans[1] + " " + ans[2];

				}
				euclidTextArea.setText(result);
			}
		});
		euclidScrollPane.setRowHeaderView(euclidButton);

		euclidTextArea = new JTextArea();
		euclidScrollPane.setViewportView(euclidTextArea);
	}

	private boolean validateUserInputEuclid(String input) {
		String[] strArray = input.split(" ");
		if (strArray.length != 2)
			return false;
		for (String test : strArray) {
			for (int i = 0; i < test.length(); i++) {
				if (!DIGITS.contains(Character.toString(test.charAt(i))))
					return false;
			}
		}
		return true;
	}

	private int[] parseUserInputToIntEuclid(String input) {
		int[] numbers = new int[2];
		numbers[0] = Integer.parseInt(input.split(" ")[0]);
		numbers[1] = Integer.parseInt(input.split(" ")[1]);
		return numbers;
	}

	private void displayInfo() {
		JOptionPane
				.showMessageDialog(
						this,
						"This is a fun development part (was not expected to be evaluated) for ADA assignment 1."
								+ "\nFor Fibonacci numbers, input must be greater than 0 representing the nth fibonacci, digits only;\n"
								+ "\nFor Euclid input, please input in such form\"x y\""
								+ "Output error message otherwise.   -  Yue");
	}
}
