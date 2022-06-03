
import java.sql.*;
import java.util.*;

class bakery_db
{
	public static void main(String args[]) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is registered");
		Connection con=
			DriverManager.getConnection("jdbc:mysql://localhost:3306/bakery_database",
		 "shrey@","Shreya_63");
		System.out.println("Connected");
		Statement stmt=con.createStatement();
		//Scanner s =new Scanner(System.in);
		//stmt.execute("delete from Employee");
		//System.out.println("Details of how many ppls");
		//int n=s.nextInt();

/*		for(int i=1;i<=n;i++)
		{
			s.nextLine();
			System.out.println("Enter the name");
			String name=s.nextLine();
			System.out.println("Enter the phone number");
			Double sal=s.nextDouble();
			String q="insert into Employee values ("'"+name+"',"+sal+")";
			stmt.execute(q);
		}*/
		ResultSet rs=stmt.executeQuery("select * from cake_table");
				System.out.println("--------------------------------------------------------------------------");
				while(rs.next())
				{
					System.out.println(rs.getInt("cake_customer_id")+"\t\t"+rs.getString("flavour")+"\t\t\t"+rs.getInt("weight"));
		}
		rs.close();
		stmt.close();
		con.close();
	}
}
