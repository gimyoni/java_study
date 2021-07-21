import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Calculator {

	private JFrame frame;
	private String func = "ADD";
	private int firstNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
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
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel answer = new JLabel("0");
		answer.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 40));
		answer.setHorizontalAlignment(SwingConstants.RIGHT);
		answer.setBounds(26, 40, 382, 67);
		frame.getContentPane().add(answer);
		
		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 28));
		btn7.setBounds(26, 141, 80, 80);
		frame.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn8.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 28));
		btn8.setBounds(127, 141, 80, 80);
		frame.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 28));
		btn9.setBounds(230, 141, 80, 80);
		frame.getContentPane().add(btn9);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String curr = answer.getText();
				firstNumber = Integer.parseInt(curr);
				answer.setText("0");
				func = "ADD";
			}
		});
		btnPlus.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 28));
		btnPlus.setBounds(328, 141, 80, 80);
		frame.getContentPane().add(btnPlus);
		
		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 28));
		btn4.setBounds(26, 247, 80, 80);
		frame.getContentPane().add(btn4);
		
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 28));
		btn1.setBounds(26, 351, 80, 80);
		frame.getContentPane().add(btn1);
		
		JButton btnDot = new JButton(".");
		btnDot.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 28));
		btnDot.setBounds(26, 455, 80, 80);
		frame.getContentPane().add(btnDot);
		
		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 28));
		btn5.setBounds(127, 247, 80, 80);
		frame.getContentPane().add(btn5);
		
		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 28));
		btn2.setBounds(127, 351, 80, 80);
		frame.getContentPane().add(btn2);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new NumberActionListener(answer, "0"));
		btn0.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 28));
		btn0.setBounds(127, 455, 80, 80);
		frame.getContentPane().add(btn0);
		
		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 28));
		btn6.setBounds(230, 247, 80, 80);
		frame.getContentPane().add(btn6);
		
		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 28));
		btn3.setBounds(230, 351, 80, 80);
		frame.getContentPane().add(btn3);
		
		JButton btnEnter = new JButton("=");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(func) {
					case "ADD":{
						int currValue = Integer.parseInt(answer.getText());
						answer.setText((firstNumber+currValue)+"");
						break;
					}
					case "SUB":{
						int currValue = Integer.parseInt(answer.getText());
						answer.setText((firstNumber-currValue)+"");
						break;
					}
					case "MULT":{
						int currValue = Integer.parseInt(answer.getText());
						answer.setText((firstNumber*currValue)+"");
						break;
					}
					case "DIV":{
						int currValue = Integer.parseInt(answer.getText());
						answer.setText((firstNumber/currValue)+"");
						break;
					}
				}
			}
		});
		btnEnter.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 28));
		btnEnter.setBounds(230, 455, 80, 80);
		frame.getContentPane().add(btnEnter);
		
		JButton btnSub = new JButton("-");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String curr = answer.getText();
				firstNumber = Integer.parseInt(curr);
				answer.setText("0");
				func = "SUB";
			}
		});
		btnSub.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 28));
		btnSub.setBounds(328, 247, 80, 80);
		frame.getContentPane().add(btnSub);
		
		JButton btnMul = new JButton("X");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String curr = answer.getText();
				firstNumber = Integer.parseInt(curr);
				answer.setText("0");
				func = "MULT";
			}
		});
		btnMul.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 28));
		btnMul.setBounds(328, 351, 80, 80);
		frame.getContentPane().add(btnMul);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String curr = answer.getText();
				firstNumber = Integer.parseInt(curr);
				answer.setText("0");
				func = "DIV";
			}
		});
		btnDiv.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 28));
		btnDiv.setBounds(328, 455, 80, 80);
		frame.getContentPane().add(btnDiv);
		
		btn1.addActionListener(new NumberActionListener(answer, "1"));
		btn2.addActionListener(new NumberActionListener(answer, "2"));
		btn3.addActionListener(new NumberActionListener(answer, "3"));
		btn4.addActionListener(new NumberActionListener(answer, "4"));
		btn5.addActionListener(new NumberActionListener(answer, "5"));
		btn6.addActionListener(new NumberActionListener(answer, "6"));
		btn7.addActionListener(new NumberActionListener(answer, "7"));
		btn8.addActionListener(new NumberActionListener(answer, "8"));
		btn9.addActionListener(new NumberActionListener(answer, "9"));

		
	}

}
class NumberActionListener implements ActionListener{

	private JLabel label;
	private String text;
	
	public NumberActionListener(JLabel l, String s) {
		label = l;
		text = s;
	}
	
	public void actionPerformed(ActionEvent e) {
		String curr = label.getText();
		if(curr.equals("0")) {
			label.setText(text);
		}else {
			label.setText(label.getText()+text);
		}
	}
	
}
