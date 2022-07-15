import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.*;
import java.awt.FlowLayout;
public class Sales_final extends JFrame {
	String[] a=new String[1000];
	private static Connection conn;
	private JPanel contentPane;
	private final JPanel panel_1 = new JPanel();
	private JTextField txtEnterYourGood;
	private JTable table;
	private JTextField textField;
	public static void main(String[] args) throws Exception{
		Sales_final fr = new Sales_final();
		fr.setVisible(true);
	}
	double getSum()
	{
		double sum=0;
		for(int i=0;i<table.getRowCount();i++)
		{
			sum=sum +Double.parseDouble(table.getValueAt(i,3).toString());
		}
		return sum;
	}
	public Sales_final() {
		getContentPane().setBackground(new Color(255, 182, 193));
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is registered");
			conn=
					DriverManager.getConnection("jdbc:mysql://localhost:3306/bakery_database",
							"shrey@","Shreya_63");
			System.out.println("Connected");
		}
		catch(Exception ex)
		{
			System.out.println(" Handdeled");
		}
		Image icon = Toolkit.getDefaultToolkit().getImage("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\icon.jpeg");
		setIconImage(icon);
		
		setBounds(40,40, 1400, 800);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 153));
		getContentPane().add(panel, BorderLayout.NORTH);
		panel_1.setBackground(new Color(204, 255, 153));
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("   Heavens Bakery   ");
		lblNewLabel.setBackground(new Color(102, 255, 102));
		lblNewLabel.setFont(new Font("Lucida Calligraphy", Font.BOLD, 24));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 204));
		getContentPane().add(panel_2, BorderLayout.EAST);
			
		table = new JTable();
		
		table.setBackground(new Color(255, 204, 204));
		table.setShowGrid(false);
		table.setPreferredSize(new Dimension(100, 200));
		table.setFocusTraversalKeysEnabled(false);
		table.setFillsViewportHeight(true);
		table.setShowHorizontalLines(false);
		table.setRowSelectionAllowed(false);
		table.setBounds(30, 40, 200, 300);
		table.setPreferredScrollableViewportSize(new Dimension(350, 10));
		DefaultTableModel form_table=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Product", "Flavor","Quantity", "Price",
				}
			);
		table.setModel(form_table);
		table.getColumnModel().getColumn(0).setResizable(false);
		panel_2.setLayout(new GridLayout(3,1, 50, 5));
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(255, 204, 204));
		panel_2.add(panel_14);
		panel_14.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setBounds(10, 10, 245, 209);
		panel_14.add(lblNewLabel_10);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(255, 204, 204));
		panel_2.add(panel_13);
		panel_13.setLayout(null);
		JScrollPane p=new JScrollPane(table);
		p.setBackground(new Color(255, 204, 204));
		p.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_2.add(p);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 204, 204));
		panel_3.setMaximumSize(new Dimension(50000, 32767));
		getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(10, 2));
		
		JPanel panel_23 = new JPanel();
		panel_23.setBackground(new Color(255, 204, 204));
		panel_3.add(panel_23);
		panel_23.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(232, 30, 33, 13);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel_1.setBackground(new Color(255, 204, 204));
		panel_23.add(lblNewLabel_1);
		
		JTextField textfield=new JTextField("");
		textfield.setBounds(10, 20, 317, 28);
		textfield.setColumns(20);
		JPanel p_9=new JPanel();
		p_9.setBackground(new Color(255, 204, 204));
		p_9.setLayout(null);
		p_9.add(textfield);
		panel_3.add(p_9);
		textfield.setMaximumSize(new Dimension(150, 150));
		
		JPanel panel_24 = new JPanel();
		panel_24.setBackground(new Color(255, 204, 204));
		panel_3.add(panel_24);
		panel_24.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Cakes");
		lblNewLabel_2.setBounds(226, 28, 41, 13);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_24.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 204, 204));
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setRequestFocusEnabled(false);
		comboBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (comboBox.getSelectedIndex()==1)
				lblNewLabel_10.setIcon(new ImageIcon("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\chocolate-truffle600.jpg"));
			else if (comboBox.getSelectedIndex()==2)
				lblNewLabel_10.setIcon(new ImageIcon("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\pinata-800.jpg"));
			else if (comboBox.getSelectedIndex()==3)
				lblNewLabel_10.setIcon(new ImageIcon("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\Red-Velvet-Cake-900.jpg"));
			else if (comboBox.getSelectedIndex()==4)
				lblNewLabel_10.setIcon(new ImageIcon("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\caramel-cake850.jpg"));
			else if (comboBox.getSelectedIndex()==5)
				lblNewLabel_10.setIcon(new ImageIcon("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\blueberry-800.jpg"));
			else if (comboBox.getSelectedIndex()==6)
				lblNewLabel_10.setIcon(new ImageIcon("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\black-forest-cake-thumb700.jpg"));
			else if (comboBox.getSelectedIndex()==7)
				lblNewLabel_10.setIcon(new ImageIcon("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\white_forest_cake700.jpg"));
			else if (comboBox.getSelectedIndex()==8)
				lblNewLabel_10.setIcon(new ImageIcon("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\oreo-750.jpg"));
			else if (comboBox.getSelectedIndex()==9)
				lblNewLabel_10.setIcon(new ImageIcon("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\bomb_cake 1700.jpg"));
			else if (comboBox.getSelectedIndex()==10)
				lblNewLabel_10.setIcon(new ImageIcon("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\Fruit-Cake 750.jpg"));
			else if (comboBox.getSelectedIndex()==11)
				lblNewLabel_10.setIcon(new ImageIcon("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\Chocolate-Coconut-Cake-800.jpg"));
			else if (comboBox.getSelectedIndex()==12)
				lblNewLabel_10.setIcon(new ImageIcon("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\funfetti_cake900.jpg"));
			else if (comboBox.getSelectedIndex()==13)
				lblNewLabel_10.setIcon(new ImageIcon("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\butterscotch-cake850.jpg"));
			else if (comboBox.getSelectedIndex()==14)
				lblNewLabel_10.setIcon(new ImageIcon("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\vanilla-cake650.jpg"));
			else if (comboBox.getSelectedIndex()==15)
				lblNewLabel_10.setIcon(new ImageIcon("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\carrot-and-walnut-cake-1400.jpg"));
			else if (comboBox.getSelectedIndex()==16)
				lblNewLabel_10.setIcon(new ImageIcon("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\Rainbow-cake850.jpg"));
			else if (comboBox.getSelectedIndex()==17)
				lblNewLabel_10.setIcon(new ImageIcon("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\chocolate-cheesecake-900.jpg"));
			else if (comboBox.getSelectedIndex()==18)
				lblNewLabel_10.setIcon(new ImageIcon("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\new-york-cheesecake-750.jpg"));
			else if (comboBox.getSelectedIndex()==19)
				lblNewLabel_10.setIcon(new ImageIcon("D:\\SHREYA'S DOCUMENTS\\STUDY MATERIAL\\3rd YEAR\\V SEMESTER\\PRACTICALS\\ADV. JAVA\\Eclipse Projects\\Bakery Management System\\src\\images\\White-mud-cake 800.jpg"));	
			}
		});
		comboBox.setBounds(55, 10, 138, 19);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Truffle Cake ", "Pinnata Cake", "Red Velvet Cake", "Caramel Cake", "Blueberry Cake     ", "Blackforest Cake   ", "Whiteforest Cake  ", "Oreo Cake", "Bomb Cake", "Fruit Cake", "Chocolate Coconut", "Funfetti Cake", "Butterscotch Cake", "Vanilla Cake", "Carrot & Walnut", "Rainbow Cake", "Chocolate Cheese", "New York Chesse", "White Mud Cake"}));
		panel_4.add(comboBox);
		
		ButtonGroup gp = new ButtonGroup();
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("0.5 Kg");
		rdbtnNewRadioButton.setBackground(new Color(255, 204, 204));
		rdbtnNewRadioButton.setActionCommand("0.5");
		rdbtnNewRadioButton.setBounds(254, 9, 60, 21);
		panel_4.add(rdbtnNewRadioButton);
		gp.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("1 Kg");
		rdbtnNewRadioButton_1.setBackground(new Color(255, 204, 204));
		rdbtnNewRadioButton_1.setActionCommand("1");
		rdbtnNewRadioButton_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		rdbtnNewRadioButton_1.setBounds(316, 9, 56, 21);
		panel_4.add(rdbtnNewRadioButton_1);
		gp.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("1.5 Kg");
		rdbtnNewRadioButton_2.setBackground(new Color(255, 204, 204));
		rdbtnNewRadioButton_2.setActionCommand("1.5");
		rdbtnNewRadioButton_2.setBounds(374, 9, 60, 21);
		panel_4.add(rdbtnNewRadioButton_2);
		gp.add(rdbtnNewRadioButton_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spinner_3.setBounds(258, 43, 71, 17);
		panel_4.add(spinner_3);
		
		textField = new JTextField();
		textField.setBounds(108, 43, 85, 17);
		panel_4.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			double price;
			int w=-1;
			public void actionPerformed(ActionEvent e) {
				if(!(comboBox.getSelectedIndex()==0 || (rdbtnNewRadioButton.isSelected()==false && rdbtnNewRadioButton_1.isSelected()==false && rdbtnNewRadioButton_2.isSelected()==false)))
				{
					w++;
					a[w]=gp.getSelection().getActionCommand();
					validateEmbellishment(textField.getText());
					if(comboBox.getSelectedIndex()==1)
						price=600;
					else if(comboBox.getSelectedIndex()==2)
						price=1200;
					else if(comboBox.getSelectedIndex()==3)
						price=900;
					else if(comboBox.getSelectedIndex()==4)
						price=850;
					else if(comboBox.getSelectedIndex()==5)
						price=800;
					else if(comboBox.getSelectedIndex()==6)
						price=700;
					else if(comboBox.getSelectedIndex()==7)
						price=700;
					else if(comboBox.getSelectedIndex()==8)
						price=750;
					else if(comboBox.getSelectedIndex()==9)
						price=1700;
					else if(comboBox.getSelectedIndex()==10)
						price=750;
					else if(comboBox.getSelectedIndex()==11)
						price=800;
					else if(comboBox.getSelectedIndex()==12)
						price=900;
					else if(comboBox.getSelectedIndex()==13)
						price=850;
					else if(comboBox.getSelectedIndex()==14)
						price=650;
					else if(comboBox.getSelectedIndex()==15)
						price=1400;
					else if(comboBox.getSelectedIndex()==16)
						price=850;
					else if(comboBox.getSelectedIndex()==17)
						price=900;
					else if(comboBox.getSelectedIndex()==18)
						price=750;
					else if(comboBox.getSelectedIndex()==19)
						price=800;								
					
					if(rdbtnNewRadioButton.isSelected()==true)
						price-=(price/2);
					else if(rdbtnNewRadioButton_2.isSelected()==true)
						price+=(price/2);
					
						price*=(int)spinner_3.getValue();
					form_table.addRow(new Object[]{"Cake",comboBox.getSelectedItem(),spinner_3.getValue(),price});
					spinner_3.setValue(((SpinnerNumberModel) spinner_3.getModel()).getMinimum());
					comboBox.setSelectedIndex(0);
				 	gp.clearSelection();
				 	textField.setText("");			
				}
			}
		});
		
		btnNewButton.setBounds(384, 41, 95, 21);
		panel_4.add(btnNewButton);
		
		JLabel lblNewLabel_12 = new JLabel("Embellishment");
		lblNewLabel_12.setBounds(3, 45, 95, 13);
		panel_4.add(lblNewLabel_12);
		
		
		JLabel lblNewLabel_11_2 = new JLabel("Weight");
		lblNewLabel_11_2.setBounds(213, 13, 39, 13);
		panel_4.add(lblNewLabel_11_2);
		
		
		
		JLabel lblNewLabel_11_2_1 = new JLabel("Quantity");
		lblNewLabel_11_2_1.setBounds(203, 45, 56, 13);
		panel_4.add(lblNewLabel_11_2_1);
		
		JLabel lblNewLabel_13 = new JLabel("Flavour");
		lblNewLabel_13.setBounds(3, 11, 45, 16);
		panel_4.add(lblNewLabel_13);
		
		JPanel panel_25 = new JPanel();
		panel_25.setBackground(new Color(255, 204, 204));
		panel_3.add(panel_25);
		panel_25.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Decoratives");
		lblNewLabel_3.setBounds(206, 25, 85, 13);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_25.add(lblNewLabel_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 204, 204));
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"", "HBD Balloons", "Birthday Cap", "Lotus Lamp", "Snow Spary", "Candles", "Party Bomb"}));
		comboBox_4.setBounds(28, 11, 156, 19);
		panel_5.add(comboBox_4);
		
		JLabel lblNewLabel_11_2_1_1 = new JLabel("Quantity");
		lblNewLabel_11_2_1_1.setBounds(247, 14, 56, 13);
		panel_5.add(lblNewLabel_11_2_1_1);
		
		JSpinner spinner_3_1 = new JSpinner();
		spinner_3_1.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spinner_3_1.setBounds(325, 12, 71, 17);
		panel_5.add(spinner_3_1);
		
		JButton btnNewButton_1_2 = new JButton("Add");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(comboBox_4.getSelectedIndex()==0 ))
				{
					double deco_price=0;
					if(comboBox_4.getSelectedIndex()==1)
						deco_price=200;
					else if(comboBox_4.getSelectedIndex()==2)
						deco_price=20;
					else if(comboBox_4.getSelectedIndex()==3)
						deco_price=110;
					else if(comboBox_4.getSelectedIndex()==4)
						deco_price=30;
					else if(comboBox_4.getSelectedIndex()==5)
						deco_price=10;
					else if(comboBox_4.getSelectedIndex()==6)
						deco_price=170;
					
					
					deco_price*=(int)(spinner_3_1.getValue());
					form_table.addRow(new Object[]{"Decoratives",comboBox_4.getSelectedItem(),spinner_3_1.getValue(),deco_price});
					spinner_3_1.setValue(((SpinnerNumberModel) spinner_3_1.getModel()).getMinimum());
					comboBox_4.setSelectedIndex(0);
				}	
			}
		});
		btnNewButton_1_2.setBounds(382, 39, 98, 21);
		panel_5.add(btnNewButton_1_2);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(new Color(255, 204, 204));
		panel_3.add(panel_19);
		panel_19.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Pastries");
		lblNewLabel_5.setBounds(221, 26, 49, 13);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_19.add(lblNewLabel_5);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 204, 204));
		panel_3.add(panel_7);
		panel_7.setLayout(null);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(65, 10, 130, 25);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "Choco Chip ", "Coffee", "Choco Walnut", "Chocolate Mud", "Mango", "Ice Candy", "Cruffin", "Semla", "Vanilla Slice", "Pineapple", "Fudgy Chocolate", "Fresh Fruit", "Strawberry", "Blackberry"}));
		panel_7.add(comboBox_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spinner.setBounds(323, 10, 71, 20);
		panel_7.add(spinner);
		
		JLabel lblNewLabel_11 = new JLabel("Quantity");
		lblNewLabel_11.setBounds(243, 10, 56, 19);
		panel_7.add(lblNewLabel_11);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(!(comboBox_1.getSelectedIndex()==0 ))
			{
				double pastry_price=0;
				if(comboBox_1.getSelectedIndex()==1)
					pastry_price=50;
				else if(comboBox_1.getSelectedIndex()==2)
					pastry_price=45;
				else if(comboBox_1.getSelectedIndex()==3)
					pastry_price=60;
				else if(comboBox_1.getSelectedIndex()==4)
					pastry_price=50;
				else if(comboBox_1.getSelectedIndex()==5)
					pastry_price=35;
				else if(comboBox_1.getSelectedIndex()==6)
					pastry_price=100;
				else if(comboBox_1.getSelectedIndex()==7)
					pastry_price=85;
				else if(comboBox_1.getSelectedIndex()==8)
					pastry_price=65;
				else if(comboBox_1.getSelectedIndex()==9)
					pastry_price=45;
				else if(comboBox_1.getSelectedIndex()==10)
					pastry_price=40;
				else if(comboBox_1.getSelectedIndex()==11)
					pastry_price=75;
				else if(comboBox_1.getSelectedIndex()==12)
					pastry_price=50;
				else if(comboBox_1.getSelectedIndex()==13)
					pastry_price=40;
				else if(comboBox_1.getSelectedIndex()==14)
					pastry_price=45;
				pastry_price*=(int)(spinner.getValue());
				form_table.addRow(new Object[]{"Pastry",comboBox_1.getSelectedItem(),spinner.getValue(),pastry_price});
				spinner.setValue(((SpinnerNumberModel) spinner.getModel()).getMinimum());
				comboBox_1.setSelectedIndex(0);
			}
		}
		});
		btnNewButton_1.setBounds(375, 40, 98, 21);
		panel_7.add(btnNewButton_1);
		
		JLabel lblNewLabel_13_1_4 = new JLabel("Flavour");
		lblNewLabel_13_1_4.setBounds(10, 13, 45, 13);
		panel_7.add(lblNewLabel_13_1_4);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(new Color(255, 204, 204));
		panel_3.add(panel_20);
		panel_20.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Bread");
		lblNewLabel_6.setBounds(226, 25, 40, 13);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_20.add(lblNewLabel_6);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 204, 204));
		panel_3.add(panel_8);
		panel_8.setLayout(null);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(65, 10, 130, 25);
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"", "Wheat", "Rye ", "Hot dog bun", "Donut", "Breadsticks", "White ", "Brown", "Fruit", "French", "Banana", "Humburger", "Pita", "Bagels", "Swiss rolls"}));
		panel_8.add(comboBox_1_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spinner_2.setBounds(323, 7, 71, 20);
		panel_8.add(spinner_2);
		
		JLabel lblNewLabel_11_1 = new JLabel("Quantity");
		lblNewLabel_11_1.setBounds(244, 7, 56, 19);
		panel_8.add(lblNewLabel_11_1);
		
		JButton btnNewButton_1_1 = new JButton("Add");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(comboBox_1_1.getSelectedIndex()==0 ))
				{
					double bread_price=0;
					if(comboBox_1_1.getSelectedIndex()==1)
						bread_price=35;
					else if(comboBox_1_1.getSelectedIndex()==2)
						bread_price=200;
					else if(comboBox_1_1.getSelectedIndex()==3)
						bread_price=35;
					else if(comboBox_1_1.getSelectedIndex()==4)
						bread_price=80;
					else if(comboBox_1_1.getSelectedIndex()==5)
						bread_price=35;
					else if(comboBox_1_1.getSelectedIndex()==6)
						bread_price=30;
					else if(comboBox_1_1.getSelectedIndex()==7)
						bread_price=30;
					else if(comboBox_1_1.getSelectedIndex()==8)
						bread_price=35;
					else if(comboBox_1_1.getSelectedIndex()==9)
						bread_price=35;
					else if(comboBox_1_1.getSelectedIndex()==10)
						bread_price=150;
					else if(comboBox_1_1.getSelectedIndex()==11)
						bread_price=30;
					else if(comboBox_1_1.getSelectedIndex()==12)
						bread_price=30;
					else if(comboBox_1_1.getSelectedIndex()==13)
						bread_price=50;
					else if(comboBox_1_1.getSelectedIndex()==14)
						bread_price=170;
					bread_price*=(int)(spinner_2.getValue());
					
					form_table.addRow(new Object[]{"Bread",comboBox_1_1.getSelectedItem(),spinner_2.getValue(),bread_price});
					spinner_2.setValue(((SpinnerNumberModel) spinner_2.getModel()).getMinimum());
					comboBox_1_1.setSelectedIndex(0);
				}
			}	
		});
		btnNewButton_1_1.setBounds(379, 39, 98, 21);
		panel_8.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_13_1_1 = new JLabel("Flavour");
		lblNewLabel_13_1_1.setBounds(10, 10, 45, 13);
		panel_8.add(lblNewLabel_13_1_1);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(new Color(255, 204, 204));
		panel_3.add(panel_21);
		panel_21.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Chocolate");
		lblNewLabel_7.setBounds(212, 27, 72, 13);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_21.add(lblNewLabel_7);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 204, 204));
		panel_3.add(panel_12);
		panel_12.setLayout(null);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "Kit kat", "Dairy milk.", "Five Star. ", "Perk ", "Munch  ", "Snickers.", "Ferrero Rocher. ", "Hershey Chocolate  ", "Choco Pie ", "Celebrations"}));
		comboBox_2.setBounds(65, 9, 130, 25);
		panel_12.add(comboBox_2);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spinner_1.setBounds(320, 10, 71, 20);
		panel_12.add(spinner_1);
		
		JLabel lblNewLabel_11_1_1 = new JLabel("Quantity");
		lblNewLabel_11_1_1.setBounds(243, 10, 56, 19);
		panel_12.add(lblNewLabel_11_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Add");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(comboBox_2.getSelectedIndex()==0 ))
				{
					double choco_price=0;
					if(comboBox_2.getSelectedIndex()==1)
						choco_price=20;
					else if(comboBox_2.getSelectedIndex()==2)
						choco_price=20;
					else if(comboBox_2.getSelectedIndex()==3)
						choco_price=10;
					else if(comboBox_2.getSelectedIndex()==4)
						choco_price=10;
					else if(comboBox_2.getSelectedIndex()==5)
						choco_price=5;
					else if(comboBox_2.getSelectedIndex()==6)
						choco_price=40;
					else if(comboBox_2.getSelectedIndex()==7)
						choco_price=500;
					else if(comboBox_2.getSelectedIndex()==8)
						choco_price=120;
					else if(comboBox_2.getSelectedIndex()==9)
						choco_price=20;
					else if(comboBox_2.getSelectedIndex()==10)
						choco_price=200;
					choco_price*=(int)(spinner_1.getValue());
					
					form_table.addRow(new Object[]{"Chocolate",comboBox_2.getSelectedItem(),spinner_1.getValue(),choco_price});
					spinner_1.setValue(((SpinnerNumberModel) spinner_1.getModel()).getMinimum());
					comboBox_2.setSelectedIndex(0);
				}
			}
		});
		btnNewButton_1_1_1.setBounds(376, 40, 98, 21);
		panel_12.add(btnNewButton_1_1_1);
		
		JLabel lblNewLabel_13_1_2 = new JLabel("Flavour");
		lblNewLabel_13_1_2.setBounds(10, 13, 45, 13);
		panel_12.add(lblNewLabel_13_1_2);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(255, 204, 204));
		panel_3.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Ice-Cream");
		lblNewLabel_8.setBounds(210, 23, 86, 13);
		lblNewLabel_8.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(lblNewLabel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 204, 204));
		panel_3.add(panel_9);
		panel_9.setLayout(null);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(64, 9, 130, 25);
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"", "Cookies & Cream  ", "Buttered Pecan.  ", "Moose tracks.", "Neapolitan.", "Espresso.", "Durian.", "Hazelnut", "Macadamia", "Cranberry."}));
		panel_9.add(comboBox_3);
		
		JSpinner spinner_1_1 = new JSpinner();
		spinner_1_1.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spinner_1_1.setBounds(318, 10, 71, 20);
		panel_9.add(spinner_1_1);
		
		JLabel lblNewLabel_11_1_2 = new JLabel("Quantity");
		lblNewLabel_11_1_2.setBounds(238, 10, 56, 19);
		panel_9.add(lblNewLabel_11_1_2);
		
		JButton btnNewButton_1_1_2 = new JButton("Add");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(comboBox_3.getSelectedIndex()==0 ))
				{
						double ice_price=0;
						if(comboBox_3.getSelectedIndex()==1)
							ice_price=45;
						else if(comboBox_3.getSelectedIndex()==2)
							ice_price=50;
						else if(comboBox_3.getSelectedIndex()==3)
							ice_price=45;
						else if(comboBox_3.getSelectedIndex()==4)
							ice_price=50;
						else if(comboBox_3.getSelectedIndex()==5)
							ice_price=40;
						else if(comboBox_3.getSelectedIndex()==6)
							ice_price=45;
						else if(comboBox_3.getSelectedIndex()==7)
							ice_price=55;
						else if(comboBox_3.getSelectedIndex()==8)
							ice_price=55;
						else if(comboBox_3.getSelectedIndex()==9)
							ice_price=45;
						ice_price*=(int)(spinner_1_1.getValue());		
					form_table.addRow(new Object[]{"Icecream",comboBox_3.getSelectedItem(),spinner_1_1.getValue(),ice_price});
					spinner_1_1.setValue(((SpinnerNumberModel) spinner_1_1.getModel()).getMinimum());
					comboBox_3.setSelectedIndex(0);
				}
			}
		});
		btnNewButton_1_1_2.setBounds(375, 40, 98, 21);
		panel_9.add(btnNewButton_1_1_2);
		
		JLabel lblNewLabel_13_1_3 = new JLabel("Flavour");
		lblNewLabel_13_1_3.setBounds(9, 13, 45, 13);
		panel_9.add(lblNewLabel_13_1_3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 204, 204));
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Phone No.");
		lblNewLabel_9.setBounds(193, 31, 122, 13);
		lblNewLabel_9.setHorizontalTextPosition(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_9);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextField textfield1=new JTextField(" ");
		textfield1.setBounds(10, 20, 317, 28);
		textfield1.setColumns(10);
		
		JPanel p_10=new JPanel();
		p_10.setBackground(new Color(255, 204, 204));
		p_10.setLayout(null);
		p_10.add(textfield1);
		
		
		panel_3.add(p_10);
		textfield1.setMaximumSize(new Dimension(150, 150));
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(255, 204, 204));
		panel_16.setForeground(new Color(255, 204, 204));
		panel_3.add(panel_16);
		panel_16.setLayout(null);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(255, 204, 204));
		panel_3.add(panel_15);
		JButton b = new JButton("Submit");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				if(validateLetters(textfield.getText()) && whenMatchesTenDigitsNumber_thenCorrect(textfield1.getText()))
				{
					if(table.getRowCount()>=1) {
					int m = JOptionPane.showConfirmDialog(null,"Your bill Amount is :"+getSum(),"Confirm the Order",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
					if(m==JOptionPane.OK_OPTION)
					{
						try 
						{
							//PreparedStatement get_ps=conn.prepareStatement("select customer_id from main_table where name=?",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); //to get id for all the sub tables
							
							PreparedStatement main_ps=conn.prepareStatement("insert into main_table values (?,?,?,?)",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); //to insert all values	
							
							PreparedStatement cake_ps=conn.prepareStatement("insert into cake_table values (?,?,?,?)");
							PreparedStatement deco_ps=conn.prepareStatement("insert into decorative_table values (?,?,?)");
							PreparedStatement pastry_ps=conn.prepareStatement("insert into pastry_table values (?,?,?)");
							PreparedStatement bread_ps=conn.prepareStatement("insert into bread_table values (?,?,?)");
							PreparedStatement choco_ps=conn.prepareStatement("insert into choco_table values (?,?,?)");
							PreparedStatement ice_ps=conn.prepareStatement("insert into ice_table values (?,?,?)"); 
							PreparedStatement ps_fetch=conn.prepareStatement("select customer_id from main_table",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);  //to get incremently customer_id
							ResultSet rs=ps_fetch.executeQuery();
							rs.last();
							
							int y= rs.getInt(1);					
							main_ps.setInt(1,y+1);
							main_ps.setString(2,textfield.getText());
							main_ps.setString(3,textfield1.getText());
							main_ps.setDouble(4,getSum());
							if(main_ps.executeUpdate()==1)
								System.out.println("done!");
							else
								System.out.println("undone!");
							int j=-1;
							for(int i=0;i<table.getRowCount();i++)
							{
								if(table.getValueAt(i,0).toString()=="Cake")
								{
									j++;
									for(int quan=1;quan<=Integer.parseInt(table.getValueAt(i,2).toString());quan++)
									{	
										System.out.println("you hav cake in your order list");
										ps_fetch=conn.prepareStatement("select customer_id from main_table",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);  //to get incremently customer_id
										rs=ps_fetch.executeQuery();
										rs.last();
									
										cake_ps.setInt(1,rs.getInt(1));
										cake_ps.setString(2,table.getValueAt(i,1).toString());
										cake_ps.setFloat(3,Float.parseFloat(a[j]));
										cake_ps.setDouble(4,(Double.parseDouble(table.getValueAt(i,3).toString())/(double)(Integer.parseInt(table.getValueAt(i,2).toString()))));
										cake_ps.executeUpdate();
									}
								}
								if(table.getValueAt(i,0).toString()=="Decoratives")
								{
									for(int quan=1;quan<=Integer.parseInt(table.getValueAt(i,2).toString());quan++)
									{
									System.out.println("you hav decoratives in your order list");
									ps_fetch=conn.prepareStatement("select customer_id from main_table",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);  //to get incremently customer_id
									rs=ps_fetch.executeQuery();
									rs.last();
									
									deco_ps.setInt(1,rs.getInt(1));
									deco_ps.setString(2,table.getValueAt(i,1).toString());	     
									deco_ps.setDouble(3,Double.parseDouble(table.getValueAt(i,3).toString())/(double)(Integer.parseInt(table.getValueAt(i,2).toString())));
									deco_ps.executeUpdate();
									}
								}
								if(table.getValueAt(i,0).toString()=="Pastry")
								{
									for(int quan=1;quan<=Integer.parseInt(table.getValueAt(i,2).toString());quan++)
									{
									System.out.println("you hav pastry in your order list");
									ps_fetch=conn.prepareStatement("select customer_id from main_table",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);  //to get incremently customer_id
									rs=ps_fetch.executeQuery();
									rs.last();	
									pastry_ps.setInt(1,rs.getInt(1));
									pastry_ps.setString(2,table.getValueAt(i,1).toString());	
									pastry_ps.setDouble(3,(Double.parseDouble(table.getValueAt(i,3).toString())/(double)(Integer.parseInt(table.getValueAt(i,2).toString()))));
									pastry_ps.executeUpdate();
									}
								}
								if(table.getValueAt(i,0).toString()=="Bread")
								{
									for(int quan=1;quan<=Integer.parseInt(table.getValueAt(i,2).toString());quan++)
									{
									System.out.println("you hav bread in your order list");
									ps_fetch=conn.prepareStatement("select customer_id from main_table",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);  //to get incremently customer_id
									rs=ps_fetch.executeQuery();
									rs.last();
									
									bread_ps.setInt(1,rs.getInt(1));
									
									bread_ps.setString(2,table.getValueAt(i,1).toString());	
									bread_ps.setDouble(3,(Double.parseDouble(table.getValueAt(i,3).toString())/(double)(Integer.parseInt(table.getValueAt(i,2).toString()))));
									bread_ps.executeUpdate();
									}
								}
								if(table.getValueAt(i,0).toString()=="Chocolate")
								{
									for(int quan=1;quan<=Integer.parseInt(table.getValueAt(i,2).toString());quan++)
									{
									System.out.println("you hav chocolate in your order list");
									ps_fetch=conn.prepareStatement("select customer_id from main_table",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);  //to get incremently customer_id
									rs=ps_fetch.executeQuery();
									rs.last();
									
									choco_ps.setInt(1,rs.getInt(1));
									choco_ps.setString(2,table.getValueAt(i,1).toString());	
									choco_ps.setDouble(3,(Double.parseDouble(table.getValueAt(i,3).toString())/(double)(Integer.parseInt(table.getValueAt(i,2).toString()))));
									choco_ps.executeUpdate();
									}
								}
								if(table.getValueAt(i,0).toString()=="Icecream")
								{
									for(int quan=1;quan<=Integer.parseInt(table.getValueAt(i,2).toString());quan++)
									{
									System.out.println("you hav ice cream in your order list");
									ps_fetch=conn.prepareStatement("select customer_id from main_table",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);  //to get incremently customer_id
									rs=ps_fetch.executeQuery();
									rs.last();
									
									ice_ps.setInt(1,rs.getInt(1));
									ice_ps.setString(2,table.getValueAt(i,1).toString());	
									ice_ps.setDouble(3,(Double.parseDouble(table.getValueAt(i,3).toString())/(double)(Integer.parseInt(table.getValueAt(i,2).toString()))));
									ice_ps.executeUpdate();
									}
								}
				}					
						}
						catch(Exception f)
						{
							System.out.println(f);
						}
						Wait_untill f = new Wait_untill(getSum());
						f.setVisible(true);
						setVisible(false);
					}
					else if(m== JOptionPane.CLOSED_OPTION || m==JOptionPane.CANCEL_OPTION)
					{		
					}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Please select something","Error!",JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		});
		panel_15.setLayout(null);
		b.setBounds(384, 26, 95, 35);
		panel_15.add(b);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(new Color(255, 204, 204));
		panel_18.setForeground(new Color(255, 204, 204));
		panel_3.add(panel_18);
		panel_18.setLayout(null);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(new Color(255, 204, 204));
		panel_3.add(panel_17);
		panel_17.setLayout(null);
		
		JPanel panel_10=new JPanel();
		getContentPane().add(panel_10, BorderLayout.SOUTH);
		panel_10.setLayout(null);
	}
	public boolean validateLetters(String txt){
		CharSequence inputStr = txt;
	    Pattern pattern = Pattern.compile("^[a-zA-Z\\s]*$");
	    Matcher matcher = pattern.matcher(inputStr);
	    if(!(matcher.matches()))
	    {
	         JOptionPane.showMessageDialog(null,"Please enter a valid name","Error!",JOptionPane.WARNING_MESSAGE);        
	         return false;
	    }
	    else if (!(txt.matches("[a-zA-Z]*[\\s]{1}[a-zA-Z].*")))
	    {
	    	JOptionPane.showMessageDialog(null,"Please enter full name","Error!",JOptionPane.WARNING_MESSAGE);
	    	return false;
	    }
	    else
	    return true;
	}
	public void validateEmbellishment(String emb) {
		CharSequence inputStr = emb;
	    Pattern pattern = Pattern.compile("^[a-zA-Z\\s]*$");
	    Matcher matcher = pattern.matcher(inputStr);
	    if(!(matcher.matches()))
	    {
	         JOptionPane.showMessageDialog(null,"Please enter a valid Embellishment","Error!",JOptionPane.WARNING_MESSAGE);
	    }
	  }
	public boolean whenMatchesTenDigitsNumber_thenCorrect(String mobNumber) {
		//validates phone numbers having 10 digits (9998887776)  
//		if (mobNumber.matches("\\d{10}"))  
//		return true;  
//		//validates phone numbers having digits, -, . or spaces  
//		else if (mobNumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))  
//		return true;  
//		else if (mobNumber.matches("\\d{4}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}"))  
//		return true;  
//		//validates phone numbers having digits and extension (length 3 to 5)  
//		else if (mobNumber.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))  
//		return true;  
//		//validates phone numbers having digits and area code in braces  
//		else if (mobNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))  
//		return true;  
//		else if (mobNumber.matches("\\(\\d{5}\\)-\\d{3}-\\d{3}"))  
//		return true;  
//		else if (mobNumber.matches("\\(\\d{4}\\)-\\d{3}-\\d{3}"))  
//		return true;
		String patterns 
	      = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

	    Pattern pattern = Pattern.compile(patterns);
	        Matcher matcher = pattern.matcher(mobNumber);
	        
	    if(matcher.matches())
	    	return true;
		else
		{
			 JOptionPane.showMessageDialog(null,"Please enter a valid number","Error!",JOptionPane.WARNING_MESSAGE);
				return false;
		}
	    	    	
	}
}

