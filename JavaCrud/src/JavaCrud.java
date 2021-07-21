import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JavaCrud {

	private JFrame frame;
	private JTextField txtbname;
	private JTextField txtedition;
	private JTextField txtprice;
	private JTable table;
	private JTextField txtbid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaCrud window = new JavaCrud();
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
	public JavaCrud() {
		initialize();
		Connect();
		table_load();
	}

	Connection con;
	PreparedStatement pat;
	ResultSet rs;
	
	public void Connect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javacrud?useSSL=false","root","1234");
			System.out.println("DB 연결 성공");
		}
		catch(ClassNotFoundException ex) 
		{
			
		}
		catch(SQLException ex)
		{
			
		}
	}
	
	public void table_load()
	{
		try
		{
			pat = con.prepareStatement("select * from book");
			rs = pat.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 711, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBookShop = new JLabel("Book Shop");
		lblBookShop.setFont(new Font("HY견고딕", Font.BOLD, 30));
		lblBookShop.setBounds(279, 10, 227, 45);
		frame.getContentPane().add(lblBookShop);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 65, 366, 170);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		lblBookName.setBounds(37, 35, 101, 17);
		panel.add(lblBookName);
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setHorizontalAlignment(SwingConstants.LEFT);
		lblEdition.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		lblEdition.setBounds(37, 77, 101, 17);
		panel.add(lblEdition);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		lblPrice.setBounds(37, 117, 101, 17);
		panel.add(lblPrice);
		
		txtbname = new JTextField();
		txtbname.setBounds(150, 34, 168, 21);
		panel.add(txtbname);
		txtbname.setColumns(10);
		
		txtedition = new JTextField();
		txtedition.setColumns(10);
		txtedition.setBounds(150, 76, 168, 21);
		panel.add(txtedition);
		
		txtprice = new JTextField();
		txtprice.setColumns(10);
		txtprice.setBounds(150, 116, 168, 21);
		panel.add(txtprice);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bname, edition, price;
				
				bname = txtbname.getText();
				edition = txtedition.getText();
				price = txtprice.getText();
				
				try {
					pat = con.prepareStatement("insert into book(name, edition, price) values(?,?,?)");
					pat.setString(1, bname);
					pat.setString(2, edition);
					pat.setString(3, price);
					pat.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added!");
					table_load();
					txtbname.setText("");
					txtedition.setText("");
					txtprice.setText("");
					txtbname.requestFocus();
					System.out.println("책 저장");
					
				}catch(SQLException e1) {
					e1.getStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(12, 245, 114, 66);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(138, 245, 114, 66);
		frame.getContentPane().add(btnExit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtbname.setText("");
				txtedition.setText("");
				txtprice.setText("");
				txtbname.requestFocus();
			}
		});
		btnClear.setBounds(264, 245, 114, 66);
		frame.getContentPane().add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(390, 65, 250, 246);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 321, 366, 71);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setBounds(44, 33, 69, 17);
		lblBookId.setHorizontalAlignment(SwingConstants.LEFT);
		lblBookId.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		panel_1.add(lblBookId);
		
		txtbid = new JTextField();
		txtbid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String id = txtbid.getText();
					
					pat = con.prepareStatement("select name, edition, price from book where id = ?");
					pat.setString(1, id);
					ResultSet rs = pat.executeQuery();
					
					if(rs.next()==true)
					{
						String name = rs.getString(1);
						String edition = rs.getString(2);
						String price = rs.getString(3);
						
						txtbname.setText(name);
						txtedition.setText(edition);
						txtprice.setText(price);
						
						
					}else {
						txtbname.setText("");
						txtedition.setText("");
						txtprice.setText("");
					}
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
				
			}
		});
		txtbid.setBounds(125, 32, 164, 21);
		txtbid.setColumns(10);
		panel_1.add(txtbid);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bname, edition, price, bid;
				
				bname = txtbname.getText();
				edition = txtedition.getText();
				price = txtprice.getText();
				bid = txtbid.getText();
				
				try {
					pat = con.prepareStatement("update book set name = ?, edition =?, price = ? where id = ?");
					pat.setString(1, bname);
					pat.setString(2, edition);
					pat.setString(3, price);
					pat.setString(4, bid);
					pat.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Updated!");
					table_load();
					
					txtbname.setText("");
					txtedition.setText("");
					txtprice.setText("");
					txtbname.requestFocus();
					System.out.println("책 업데이트");
					
				}catch(SQLException e1) {
				}
				
			}
		});
		btnUpdate.setBounds(390, 326, 114, 66);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bid;
				
				bid = txtbid.getText();
				
				try {
					pat = con.prepareStatement("delete from book where id = ?");
					pat.setString(1, bid);
					pat.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Delete!");
					table_load();
					
					txtbname.setText("");
					txtedition.setText("");
					txtprice.setText("");
					txtbname.requestFocus();
					System.out.println("책 삭제");
					
				}catch(SQLException e1) {
				}
			}
		});
		btnDelete.setBounds(516, 326, 114, 66);
		frame.getContentPane().add(btnDelete);
	}
}
