import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminFrame extends JFrame {
	private JPanel contentPane;
	JTextField textField ;
	JTextField  passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		AdminFrame a=new AdminFrame();
		a.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public AdminFrame() {
		Image icon = Toolkit.getDefaultToolkit().getImage("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\icon.jpeg");
		setIconImage(icon);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(50, 50, 1400,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		JLabel lblNewLabel=new JLabel("Haven's Bakery");
		lblNewLabel.setFont(new Font("Lucida Calligraphy", Font.BOLD, 24));
		
		panel.setBackground(new Color(204, 255, 153));
		panel.add(lblNewLabel);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.setBackground(new Color(255, 204, 204));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 204));
		panel_2.setBounds(547, 224, 308, 97);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 2, 3, 6));
		
		JLabel lblNewLabel_1 = new JLabel("User name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBackground(new Color(255, 204, 204));
		panel_2.add(lblNewLabel_1);
		
		textField  = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		panel_2.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("Shreya") || passwordField.getText().equals("my"))
				{
					AdminPanelFrame f = new AdminPanelFrame();
					f.setVisible(true);
				}
				setVisible(false);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(667, 387, 96, 29);
		panel_1.add(btnNewButton);
	}

}
