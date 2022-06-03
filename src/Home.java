import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.*;
import java.awt.Image;
import java.io.*;
import javax.imageio.ImageIO;
public class Home {

	private JFrame frame;
	private final JLabel lblNewLabel_4 = new JLabel("Heavens Bakery");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try
				{
					Home window = new Home();
					window.frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Home() throws IOException {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		Image icon = Toolkit.getDefaultToolkit().getImage("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\icon.jpeg");
		frame.setIconImage(icon);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(255, 204, 204));
		//frame.setContentPane(new JLabel(new ImageIcon("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\icon.jpeg")));
		JPanel panel =new JPanel();
		frame.getContentPane().add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 204));
		panel.add(panel_2, BorderLayout.NORTH);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 204, 204));
		panel.add(panel_3, BorderLayout.WEST);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 204, 204));
		panel.add(panel_4, BorderLayout.SOUTH);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 204, 204));
		panel.add(panel_5, BorderLayout.EAST);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 204, 204));
		panel.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new GridLayout(3, 0, 0, 0));

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 204, 204));
		panel_6.add(panel_8);

		JButton btnNewButton_2 = new JButton("Admin Login");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminFrame fr = new AdminFrame();
				fr.setVisible(true);
				frame.setVisible(false);
				}
		});
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_8.add(btnNewButton_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 204));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);

		JButton btnNewButton_1 = new JButton("Place Order");
		btnNewButton_1.setFont(new Font("Script MT Bold", Font.PLAIN, 20));
		btnNewButton_1.setBounds(670, 400, 170, 56);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sales_final f = new Sales_final();
				f.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.add(btnNewButton_1);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(204, 255, 153));
		frame.getContentPane().add(panel_9, BorderLayout.NORTH);
		lblNewLabel_4.setFont(new Font("Lucida Calligraphy", Font.BOLD, 24));
		panel_9.add(lblNewLabel_4);
	}
}