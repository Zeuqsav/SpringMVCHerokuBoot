package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class PruebaFruta {

	private List<String> frutasVarias = new ArrayList<String> ();

	public PruebaFruta(){
		try{
		Class.forName("org.postgresql.Driver");
		//Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Pruebas","postgres","rrffdgdg");
		Connection c = DriverManager.getConnection("jdbc:postgresql://ec2-54-197-224-173.compute-1.amazonaws.com:5432/d6a2bta8rjrict","ldtflhszyrbjzv","B__VbV9uu-fnetOJBt7CT6Zi_f");
		ResultSet res = c.createStatement().executeQuery("select ('https://www.google.cl/maps/search/' || coory ||',' || coorx ||'     ->' || otro ) as id from ubicacion where coory <> 'cooy';");
		while (res.next())
			{
			frutasVarias.add(res.getString("id"));
			}
	//	frutasVarias.add("Uva");

		}catch (SQLException e) {
		        e.printStackTrace();
		        frutasVarias.add(e.toString());
        }catch (ClassNotFoundException  e) {
            	e.printStackTrace();
            	frutasVarias.add(e.toString());
        }
	
	}
	
	public List<String> getFrutasVarias(){
		return frutasVarias;
	
	}
	
}
