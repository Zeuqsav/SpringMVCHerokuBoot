package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RestController
public class HelloController {
	
	 @RequestMapping(value = "/x", method = RequestMethod.GET)
	 public ModelAndView method() {
        return new ModelAndView("redirect:https://www.google.cl/maps/search/-33.45099503,-70.65444365");
}

    @RequestMapping("/")
    public ResponseEntity<Ubicacion> get() {
    	
    	Ubicacion ubicacion = new Ubicacion();
    	ubicacion.setId("1");
    	ubicacion.setCoorx("ghgjhgj");
    	ubicacion.setCoory("658758");
    	ubicacion.setOtro("iijoj");
    	
    	return new ResponseEntity <Ubicacion>(ubicacion,HttpStatus.OK);
    	
        //return "Greetings from Level up lunch!";
    }
    
    @RequestMapping("/jsontest") 
    public @ResponseBody Map<String, String> callSomething () {
    	
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("url", "<a href>http://www.leveluplunch.com</a>");
    	
    	
    	
    	return map;
    }
     
    @RequestMapping(value="/ubicacion", method = RequestMethod.POST)
    public ResponseEntity<Ubicacion> update (@RequestBody Ubicacion ubicacion) {
    	try{
    	if (ubicacion != null){
    		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    		Date date2 = new Date();

    		Class.forName("org.postgresql.Driver");
    		//Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Pruebas","postgres","rrffdgdg");
    		Connection c = DriverManager.getConnection("jdbc:postgresql://ec2-54-197-224-173.compute-1.amazonaws.com:5432/d6a2bta8rjrict","ldtflhszyrbjzv","B__VbV9uu-fnetOJBt7CT6Zi_f");
    		ResultSet res = c.createStatement().executeQuery("insert into ubicacion (id,coorx,coory,otro) values ('" + ubicacion.getId() +"','" + ubicacion.getCoorx() +"','" + ubicacion.getCoory() +"','" + ubicacion.getOtro() +"   " + date2.toString() + "')");
   		    		
    		ubicacion.setCoory("logrado");
    	}
    	}catch (SQLException e){
    		
	    	return new ResponseEntity<Ubicacion> (ubicacion,HttpStatus.OK);
    	} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return new ResponseEntity<Ubicacion> (ubicacion,HttpStatus.OK);
    	//return "Greetings from Level up lunch!";
    }
    

}