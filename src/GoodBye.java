import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.util.*;

public class GoodBye extends JFrame {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		GoodBye g=new GoodBye();
		g.setVisible(true);
			}
	/**
	 * Create the frame.
	 */
	public GoodBye() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1334, 795);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Haven's Bakery");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Calligraphy", Font.BOLD, 24));
		lblNewLabel.setBackground(new Color(255,204,204));
		
		JPanel p2=new JPanel();
		p2.setBackground(new Color(204, 255, 153));
		p2.add(lblNewLabel);
		
		getContentPane().add(p2, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblThanksForVisiting = new JLabel("Thanks for Choosing Haven's Bakery");
		lblThanksForVisiting.setBounds(491, 57, 564, 110);
		lblThanksForVisiting.setHorizontalAlignment(SwingConstants.CENTER);
		lblThanksForVisiting.setFont(new Font("Comic Sans MS", Font.BOLD, 29));
		panel.add(lblThanksForVisiting);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setSize(new Dimension(1587, 241));
		panel_1.setBackground(new Color(204, 255, 153));
		panel_1.setBounds(0, 235, 1587, 241);
		panel.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("we need your valuable feedback");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_2.setBounds(314, 10, 880, 33);
		panel_1.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(346, 53, 835, 115);
		panel_1.add(textArea);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("Driver is registered");
					Connection conn=
					DriverManager.getConnection("jdbc:mysql://localhost:3306/bakery_database",
				 "shrey@","Shreya_63");
					System.out.println("Connected");
					PreparedStatement psmid_fetch=conn.prepareStatement("select customer_id from  main_table",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); 
					ResultSet rsmain=psmid_fetch.executeQuery();
					rsmain.last();
					
					PreparedStatement psfid_fetch=conn.prepareStatement("select feedback_customer_id from feedback_table",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); 
					ResultSet rsfeed=psfid_fetch.executeQuery();
					rsfeed.last();
					
					if(!(rsmain.getInt(1)==rsfeed.getInt(1)))
					{
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
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBackground(SystemColor.WHITE);
		btnNewButton.setBounds(998, 188, 186, 39);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("VISIT AGAIN :)");
		lblNewLabel_1.setFont(new Font("Lucida Handwriting", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(525, 552, 291, 61);
		panel.setBackground(new Color(255,204,204));
		panel.add(lblNewLabel_1);

	}
}
