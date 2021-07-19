import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ModalPractice {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModalPractice window = new ModalPractice();
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
	public ModalPractice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		

		JLabel lblNewLabel = new JLabel("My Modal Course");
		lblNewLabel.setBounds(123, 88, 175, 48);
		panel.add(lblNewLabel);
		
		JButton btn = new JButton("Open Modal");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modal m = new Modal(frame, lblNewLabel);
				m.setVisible(true);
				
			}
		});
		btn.setBounds(123, 146, 175, 64);
		panel.add(btn);
		
	}

}
