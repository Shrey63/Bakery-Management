import java.sql.*;
import net.proteanit.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
public class AdminPanelFrame extends JFrame {

	private JPanel contentPane;
	
	private static Connection con;
	Statement stmt; 
	public static void main(String[] args) throws Exception{
		AdminPanelFrame frame = new AdminPanelFrame();
		frame.setVisible(true);		
	}
	public AdminPanelFrame() {
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is registered");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bakery_database",
			 "shrey@","Shreya_63");
			System.out.println("Connected");
		}
		catch(Exception ex) 
		{
			System.out.println(ex);
		}
		Image icon = Toolkit.getDefaultToolkit().getImage("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\icon.jpeg");
		setIconImage(icon);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		JTable table=new JTable();
		JTable table_1=new JTable();
		JTable table_2=new JTable();
		JTable table_3=new JTable();
		JTable table_4=new JTable();
		JTable table_5=new JTable();
		JTable table_6=new JTable();
		JTable table_7=new JTable();
		
		setBounds(100, 100, 1290, 740);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel lblNewLabel = new JLabel("Haven's Bakery                         ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Calligraphy", Font.BOLD, 24));
		
		JPanel panel_9=new JPanel();
		panel_9.add(lblNewLabel);
		panel_9.setBackground(new Color(204, 255, 153));
		
		getContentPane().add(panel_9, BorderLayout.NORTH);
		getContentPane().setBackground(new Color(204, 255, 153));
		
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBackground(new Color(204,255,153));
		
		UIManager.put("TabbedPane.selected",new Color(255,204,204));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane);
		
		
		JPanel p=new JPanel(new BorderLayout());
		JPanel p10=new JPanel();
		JPanel p11=new JPanel();
		tabbedPane.addTab("MAIN",p);
		p10.add(table.getTableHeader());
		p.add(p10,BorderLayout.NORTH);
		p11.add(table);
		p.add(p11,BorderLayout.CENTER);
		p10.setBackground(new Color(255,204,204));
		p11.setBackground(new Color(255,204,204));
		table.setBackground(Color.WHITE);
		
		
		JPanel p1=new JPanel(new BorderLayout());
		JPanel p12=new JPanel();
		JPanel p13=new JPanel();
		tabbedPane.addTab("CAKE",p1);
		p12.add(table_1.getTableHeader());
		p1.add(p12,BorderLayout.NORTH);
		p13.add(table_1);
		p1.add(p13,BorderLayout.CENTER);
		p12.setBackground(new Color(255,204,204));
		p13.setBackground(new Color(255,204,204));
		table_1.setBackground(Color.WHITE);

		

		JPanel p2=new JPanel(new BorderLayout());
		JPanel p14=new JPanel();
		JPanel p15=new JPanel();
		tabbedPane.addTab("DECORATIVES",p2);
		p14.add(table_2.getTableHeader());
		p2.add(p14,BorderLayout.NORTH);
		p15.add(table_2);
		p2.add(p15,BorderLayout.CENTER);
		p14.setBackground(new Color(255,204,204));
		p15.setBackground(new Color(255,204,204));
		table_2.setBackground(Color.WHITE);


		JPanel p3=new JPanel(new BorderLayout());
		JPanel p16=new JPanel();
		JPanel p17=new JPanel();
		tabbedPane.addTab("PASTRY",p3);
		p16.add(table_3.getTableHeader());
		p3.add(p16,BorderLayout.NORTH);
		p17.add(table_3);
		p3.add(p17,BorderLayout.CENTER);
		p16.setBackground(new Color(255,204,204));
		p17.setBackground(new Color(255,204,204));
		table_3.setBackground(Color.WHITE);
		
		
		JPanel p4=new JPanel(new BorderLayout());
		JPanel p18=new JPanel();
		JPanel p19=new JPanel();
		tabbedPane.addTab("BREAD",p4);
		p18.add(table_4.getTableHeader());
		p4.add(p18,BorderLayout.NORTH);
		p19.add(table_4);
		p4.add(p19,BorderLayout.CENTER);
		p18.setBackground(new Color(255,204,204));
		p19.setBackground(new Color(255,204,204));
		table_4.setBackground(Color.WHITE);
		
		

		JPanel p5=new JPanel(new BorderLayout());
		JPanel p20=new JPanel();
		JPanel p21=new JPanel();
		tabbedPane.addTab("CHOCOLATE",p5);
		p20.add(table_5.getTableHeader());
		p5.add(p20,BorderLayout.NORTH);
		p21.add(table_5);
		p5.add(p21,BorderLayout.CENTER);
		p20.setBackground(new Color(255,204,204));
		p21.setBackground(new Color(255,204,204));
		table_5.setBackground(Color.WHITE);

		JPanel p6=new JPanel(new BorderLayout());
		JPanel p22=new JPanel();
		JPanel p23=new JPanel();
		tabbedPane.addTab("ICE-CREAM",p6);
		p22.add(table_6.getTableHeader());
		p6.add(p22,BorderLayout.NORTH);
		p23.add(table_6);
		p6.add(p23,BorderLayout.CENTER);
		p22.setBackground(new Color(255,204,204));
		p23.setBackground(new Color(255,204,204));
		table_6.setBackground(Color.WHITE);
		
		
		JPanel p7=new JPanel(new BorderLayout());
		JPanel p24=new JPanel();
		JPanel p25=new JPanel();
		tabbedPane.addTab("FEEDBACK",p7);
		p24.add(table_7.getTableHeader());
		p7.add(p24,BorderLayout.NORTH);
		p25.add(table_7);
		p7.add(p25,BorderLayout.CENTER);
		p24.setBackground(new Color(255,204,204));
		p25.setBackground(new Color(255,204,204));
		table.setBackground(Color.WHITE);
		p7.setBackground(new Color(255,204,204));

		
for(int i=0;i<tabbedPane.getTabCount();i++)
{
		tabbedPane.setBackgroundAt(i,new Color(204,255,153));
}

		try{
		stmt=con.createStatement();

		ResultSet rs1 = stmt.executeQuery("select * from cake_table");
		table_1.setModel(DbUtils.resultSetToTableModel(rs1));
		
		ResultSet rs2 = stmt.executeQuery("select * from decorative_table");
		table_2.setModel(DbUtils.resultSetToTableModel(rs2));
		

		ResultSet rs3 = stmt.executeQuery("select * from pastry_table");
		table_3.setModel(DbUtils.resultSetToTableModel(rs3));
		
		ResultSet rs4 = stmt.executeQuery("select * from bread_table");
		table_4.setModel(DbUtils.resultSetToTableModel(rs4));
		
		ResultSet rs5 = stmt.executeQuery("select * from choco_table");
		table_5.setModel(DbUtils.resultSetToTableModel(rs5));
	
		ResultSet rs6 = stmt.executeQuery("select * from ice_table");
		table_6.setModel(DbUtils.resultSetToTableModel(rs6));
				
		ResultSet rs7 = stmt.executeQuery("select * from feedback_table");
		table_7.setModel(DbUtils.resultSetToTableModel(rs7));
		
		ResultSet rsm = stmt.executeQuery("select * from main_table");
		
		table.setModel(DbUtils.resultSetToTableModel(rsm));  
		}
		catch(Exception er){
			
		}
	}
}