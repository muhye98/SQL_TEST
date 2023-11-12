import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyFirstDataBaseTest {
	Connection con = null;
	Statement stm = null;

	@BeforeTest
	public void setup() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "root");
	}

	@Test(enabled = false)

	public void addTest() throws SQLException {
		stm = con.createStatement();

		String InsertQuery = "insert into customers (customerNumber,customerName,contactFirstName,contactLastName,phone,addressLine1,city,country)"
				+ "values (1117,'abc conpany','ahmad','ali','0777147444','amman','amman','jordan');";

		int rowEffected = stm.executeUpdate(InsertQuery);

		if (rowEffected > 0) {
			System.out.print("data has been added");

		} else {
			System.out.print("sorry there is a mistake");
		}
	}

	@Test(enabled = false)
	public void deleteTest() throws SQLException {
		stm = con.createStatement();
		
		String DeletQuery ="Delete from customers where customerNumber=1117 ;";
		int rowEffected = stm.executeUpdate(DeletQuery);

		Assert.assertEquals(rowEffected> 0,true,"sorry there is a mistake" );
				
	}
	
	@Test(enabled = false)
	public void updateTest() throws SQLException {
		stm = con.createStatement();
		String UpdatQuery ="update customers set city = 'maan' where customerNumber = 1115";
		int rowEffected = stm.executeUpdate(UpdatQuery);
		Assert.assertEquals(rowEffected> 0,true,"sorry there is a mistake" );
	}

	
	@Test()
	public void selectTest() throws SQLException {
		stm = con.createStatement();


	}


	

}
