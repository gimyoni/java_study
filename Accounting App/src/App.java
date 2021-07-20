import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class App {
	private final String ID = "asdf";
	private final String PASS = "asdf";
	private JFrame frame;
	private JTextField idField;
	private JPasswordField passField;
	private JPanel currPanel;
	private JTextField nameInput;
	private JTextField amountInput;
	private JTextField searchInput;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TableData td = new TableData();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImagePanel loginPanel = new ImagePanel(new ImageIcon("C:\\Users\\Mirim\\OneDrive\\문서\\java_swing_basic\\Accounting App\\image\\theme.jpg").getImage());
		currPanel = loginPanel;
		
		frame.setSize(loginPanel.getDim());
		frame.setPreferredSize(loginPanel.getDim());
		ImagePanel sumPanel = new ImagePanel(new ImageIcon("C:\\Users\\Mirim\\OneDrive\\문서\\java_swing_basic\\Accounting App\\image\\Activation.jpg").getImage());
		frame.getContentPane().add(sumPanel);
		
		
		sumPanel.setVisible(false);
		
		// Summary 
		
		
		
		JLabel lblSearch = new JLabel("search :");
		lblSearch.setBounds(353, 84, 57, 15);
		sumPanel.add(lblSearch);
		
		searchInput = new JTextField();
		searchInput.setBounds(437, 81, 743, 48);
		sumPanel.add(searchInput);
		searchInput.setColumns(10);
		
		JPanel tp = new JPanel();
		tp.setBounds(337, 156, 1187, 429);
		sumPanel.add(tp);
		
		table = new JTable(td);
		table.setBounds(337, 140,1155,445);
		table.setRowHeight(30);
		table.setFont(new Font("Sansserif", Font.BOLD, 15));
		table.setPreferredScrollableViewportSize(new Dimension(1155,440));
		tp.add(new JScrollPane(table));
		tp.setOpaque(false);
		
		JTableHeader header = table.getTableHeader();
		header.setBackground(new Color(92,179, 255));
		header.setForeground(new Color(255,255,255));
		header.setFont(new Font("Sansserif", Font.BOLD, 15));
		
		searchInput.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String search = searchInput.getText();
				TableRowSorter<AbstractTableModel> trs = new TableRowSorter<>(td);
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(search));
				
			}
		});
		
		
		
		ImagePanel tranPanel = new ImagePanel(new ImageIcon("C:\\Users\\Mirim\\OneDrive\\문서\\java_swing_basic\\Accounting App\\image\\Activation.jpg").getImage());
		frame.getContentPane().add(tranPanel);
		
		tranPanel.setVisible(false);
		frame.getContentPane().add(loginPanel);
		
		idField = new JTextField();
		idField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		idField.setBounds(1223, 311, 296, 43);
		loginPanel.add(idField);
		idField.setColumns(10);
		idField.setBorder(null);
		
		passField = new JPasswordField();
		passField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		passField.setBounds(1223, 391, 296, 43);
		passField.setBorder(null);
		loginPanel.add(passField);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(1184, 440, 25, 25);
		loginPanel.add(chckbxNewCheckBox);
		
		JButton tranBtn = new JButton("Transaciton");
		tranBtn.setBounds(30, 167, 259, 40);
		tranBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPanel.setVisible(false);
				tranPanel.setVisible(true);
				currPanel = tranPanel;
			}
		});
		sumPanel.setLayout(null);
		tranBtn.setBorder(null);
		sumPanel.add(tranBtn);
		
		JButton logInBtn = new JButton("");
		logInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ID.equals(idField.getText()) && PASS.equals(passField.getText())){
					currPanel.setVisible(false);
					sumPanel.setVisible(true);
					currPanel = sumPanel;
				}else{
					JOptionPane.showMessageDialog(null,"You Failed to Log In");
				}
			}
		});
		logInBtn.setBorder(null);
		logInBtn.setBounds(1183, 467, 338, 38);
		loginPanel.add(logInBtn);
		logInBtn.setIcon(new ImageIcon("C:\\Users\\Mirim\\OneDrive\\문서\\java_swing_basic\\Accounting App\\image\\button.jpg"));
		logInBtn.setPressedIcon(new ImageIcon("C:\\Users\\Mirim\\OneDrive\\문서\\java_swing_basic\\Accounting App\\image\\btnClicked.jpg"));
		
		// Transaction
		
		JButton sumBtn = new JButton("summmary");
		sumBtn.setBorder(null);
		sumBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPanel.setVisible(false);
				sumPanel.setVisible(true);
				currPanel = sumPanel;
			}
		});
		sumBtn.setBounds(29, 123, 259, 40);
		tranPanel.add(sumBtn);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(354, 186, 57, 15);
		tranPanel.add(lblName);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(354, 264, 57, 15);
		tranPanel.add(lblType);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(354, 353, 57, 15);
		tranPanel.add(lblAmount);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setBounds(354, 426, 57, 15);
		tranPanel.add(lblNote);
		
		nameInput = new JTextField();
		nameInput.setBounds(443, 183, 116, 21);
		tranPanel.add(nameInput);
		nameInput.setColumns(10);
		
		amountInput = new JTextField();
		amountInput.setColumns(10);
		amountInput.setBounds(443, 350, 116, 21);
		tranPanel.add(amountInput);
		
		JTextArea noteInput = new JTextArea();
		noteInput.setBounds(443, 423, 116, 102);
		tranPanel.add(noteInput);
		
		String[] typeArr = new String[] {"Deposit", "Withdraw"};
		JComboBox typeInput = new JComboBox(typeArr);
		typeInput.setBounds(443, 261, 116, 21);
		tranPanel.add(typeInput);
		typeInput.setBackground(Color.WHITE);
		noteInput.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean fileExists = new File("./data.csv").exists();
					FileWriter fw = new FileWriter("./data.csv",true); 
					if(!fileExists) {
						fw.append("Name,Type,Amount,Note\n");
					}
					String name = nameInput.getText();
					String type = (String) typeInput.getSelectedItem();
					String amount = amountInput.getText();
					String note = noteInput.getText();
					fw.append(name + ","+type+","+amount+","+note+"\n");
					nameInput.setText("");
					amountInput.setText("");
					typeInput.setSelectedIndex(0);
					noteInput.setText("");					
					JOptionPane.showMessageDialog(null,"Data Saved Successfully");
					fw.close();
					td.refresh();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "There was an error while writing the data");
				}
			}
		});
		btnNewButton.setBounds(529, 570, 97, 23);
		tranPanel.add(btnNewButton);
		
		frame.pack();
	}
}
