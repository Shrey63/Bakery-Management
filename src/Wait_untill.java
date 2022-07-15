import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.sql.*;
import java.util.*;

public class Wait_untill extends JFrame {
	private JTextField textField;
	private JPanel Mpanel;
	private JLabel lblNewLabel_2;
	JLabel lblNewLabel_1 ;
	Timer timer;	
	public int second;
	int minute;
	String ddSecond, ddMinute;	
	private static Connection conn;
	DecimalFormat dFormat = new DecimalFormat("00");
	static double x;
	String[] nm=new String[9];
	String[] fb=new String[9];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Wait_untill w=new Wait_untill(1550);
		w.setVisible(true);
	}
	/**
	 * Create the frame.
	 */
	public Wait_untill(double price) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is registered");
		conn=
		DriverManager.getConnection("jdbc:mysql://localhost:3306/bakery_database",
				"shrey@","Shreya_63");
		System.out.println("Connected");
		}
		catch(Exception ex){	
		}
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 1537, 827);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		
		JLabel lblNewLabel_3 = new JLabel("Haven's Bakery");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Lucida Calligraphy",Font.BOLD, 24));
		lblNewLabel_3.setBackground(new Color(204, 255, 153));

		
		JPanel p1=new JPanel();
		p1.add(lblNewLabel_3);
		p1.setBackground(new Color(204,255,153));
		getContentPane().add(p1, BorderLayout.NORTH);
		
		Mpanel = new JPanel();
		Mpanel.setBackground(new Color(204, 255, 153));
		getContentPane().add(Mpanel,"Center");
		Mpanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 1, 1555, 173);
		panel.setBackground(new Color(255, 204, 204));
		Mpanel.add(panel);
		panel.setLayout(null);
		
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(UIManager.getColor("ComboBox.foreground"));
		lblNewLabel_1.setBackground(new Color(0, 0, 153));
		lblNewLabel_1.setBounds(119, 46, 1338, 70);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setPreferredSize(new Dimension(43, 7));
		lblNewLabel_1.setMinimumSize(new Dimension(43, 7));
		lblNewLabel_1.setMaximumSize(new Dimension(43, 8));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 70));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_1.setText("00:00");
		second =0;
		minute =1;
		countdownTimer();
		timer.start();	
		
		
		JLabel lblNewLabel = new JLabel("your order is arriving soon...");
		lblNewLabel.setBounds(160, 10, 1249, 38);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_15 = new JLabel("PRICE :");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_15.setBounds(503, 117, 271, 46);
		panel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel(price+"");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_16.setBounds(784, 116, 226, 46);
		panel.add(lblNewLabel_16);		
		
		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_1.setLocation(0, 170);
		panel_1.setBackground(new Color( 255, 204,204));
		panel_1.setSize(new Dimension(1587, 241));
		Mpanel.add(panel_1);
		panel_1.setLayout(null);
		
		
		lblNewLabel_2 = new JLabel("we need your valuable feedback");
		lblNewLabel_2.setBounds(314, 10, 880, 33);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 27));
		panel_1.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(346, 53, 835, 115);
		panel_1.add(textArea);
		
		JButton btnNewButton1 = new JButton("Submit");
		btnNewButton1.setBackground(new Color(255,255,255));
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
			PreparedStatement ps_fetch=conn.prepareStatement("select customer_id,name from main_table",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); 
			ResultSet rs=ps_fetch.executeQuery();
			rs.last();
			int y= rs.getInt(1);
			String n=rs.getString(2);
			String feedback=textArea.getText();
			if(n!="")
			{
			PreparedStatement feed_ps=conn.prepareStatement("insert into feedback_table values (?,?,?)",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			feed_ps.setInt(1,y);
			feed_ps.setString(2,n);
			feed_ps.setString(3,feedback);
			feed_ps.execute();
			}
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});
		btnNewButton1.setBackground(UIManager.getColor("InternalFrame.borderDarkShadow"));
		btnNewButton1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton1.setBounds(1064, 188, 117, 39);
		panel_1.add(btnNewButton1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 411, 1555, 360);
		Mpanel.add(scrollPane);
		

		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setBackground(new Color(204, 255, 153));
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel p=new JPanel();
		JLabel lblNewLabel_5 = new JLabel("FEEDBACK");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setVerticalAlignment(SwingConstants.TOP);
		p.add(lblNewLabel_5);
		p.setBackground(new Color(204,255,153));
		panel_2.add(p,BorderLayout.NORTH);
		
		//fetching 9 latest feedbacks
		int index=0;
		try {
			Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			ResultSet rsf = stmt.executeQuery("select cust_name, customer_feedback from  feedback_table"); 
		while(rsf.next() || index<=3)
		{
			nm[index]= rsf.getString("cust_name");
			fb[index]=rsf.getString("customer_feedback");
			//System.out.println(nm[index]+fb[index]);
			index++;
		}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(3, 3, 3, 3));
		
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel();
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		panel_5.add(lblNewLabel_6, BorderLayout.NORTH);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		panel_5.add(textArea_1, BorderLayout.CENTER);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		panel_6.add(lblNewLabel_9, BorderLayout.NORTH);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setEditable(false);
		panel_6.add(textArea_4, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		panel_7.add(lblNewLabel_12, BorderLayout.NORTH);
		
		JTextArea textArea_7 = new JTextArea();
		panel_7.add(textArea_7, BorderLayout.CENTER);
		
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_7 = new JLabel();
		panel_8.add(lblNewLabel_7, BorderLayout.NORTH);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		panel_8.add(textArea_2, BorderLayout.CENTER);
		
		
		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		panel_9.add(lblNewLabel_10, BorderLayout.NORTH);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setEditable(false);
		panel_9.add(textArea_5, BorderLayout.CENTER);
		
		JPanel panel_10 = new JPanel();
		panel_4.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		panel_10.add(lblNewLabel_13, BorderLayout.NORTH);
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setEditable(false);
		panel_10.add(textArea_8, BorderLayout.CENTER);
		
		JPanel panel_11 = new JPanel();
		panel_4.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		panel_11.add(lblNewLabel_8, BorderLayout.NORTH);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setEditable(false);
		panel_11.add(textArea_3, BorderLayout.CENTER);
		
		JPanel panel_12 = new JPanel();
		panel_4.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		panel_12.add(lblNewLabel_11, BorderLayout.NORTH);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setEditable(false);
		panel_12.add(textArea_6, BorderLayout.CENTER);
		
		JPanel panel_13 = new JPanel();
		panel_4.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		panel_13.add(lblNewLabel_14, BorderLayout.NORTH);
		
		JTextArea textArea_9 = new JTextArea();
		textArea_9.setEditable(false);
		panel_13.add(textArea_9, BorderLayout.CENTER);
			
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_6.setText(nm[0]);
		textArea_1.setText(fb[0]);
		
		lblNewLabel_9.setText(nm[1]);
		textArea_4.setText(fb[1]);
		
		lblNewLabel_12.setText(nm[2]);
		textArea_7.setText(fb[2]);
		
		lblNewLabel_7.setText(nm[3]);
		textArea_2.setText(fb[3]);
		
		lblNewLabel_10.setText(nm[4]);
		textArea_5.setText(fb[4]);
		
		lblNewLabel_13.setText(nm[5]);
		textArea_8.setText(fb[5]);
		
		lblNewLabel_8.setText(nm[6]);
		textArea_3.setText(fb[6]);
		
		lblNewLabel_11.setText(nm[7]);
		textArea_6.setText(fb[7]);
		
		lblNewLabel_14.setText(nm[8]);
		textArea_9.setText(fb[8]);
		
	}
	public void countdownTimer() {
		
		 timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				second--;
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);	
				lblNewLabel_1.setText(ddMinute + ":" + ddSecond);
				
				if(second==-1) {
					second = 6000;
					minute--;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);	
					lblNewLabel_1 .setText(ddMinute + ":" + ddSecond);
				}
				if(minute==0 && second==0) {
					timer.stop(); 
					setVisible(false);
					GoodBye g = new GoodBye();
					g.setVisible(true);
				}
			}
		});		
	}		


}
