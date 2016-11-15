import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import test.DatabaseReader;


@Path("/promos")
public class PromoInquiry {

	@Path("{kw}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String getDescriptionByKeyword(@PathParam("kw") String kw) {
		
		System.out.println("Subscriber input: " + kw);
		
		DatabaseReader dbReader = new DatabaseReader();
		HashMap<String, String> keyword = dbReader.getKwMap();
		String description = keyword.get(kw);
		
		System.out.println("KW Description: " + description);
		
		String output = "<promo>" + "<keyword>" + kw + "</keyword>" + "<description>" + description + "</description>" + "</promo>";
		return output;
	}
	
	public void test() {
	
	}

	
//	public static void main(String[] args) {
//		new PromoInquiry();
//	}
//	
//	public PromoInquiry() {
//		DatabaseReader dbReader = new DatabaseReader();
//		HashMap<String, String> keyword = dbReader.getKwMap();
//		String description = keyword.get("BIG50");
//		String output = "<promo>" + "<keyword>" + "BIG50" + "</keyword>" + "<description>" + description + "</description>" + "</promo>";
//		System.out.println(output);
//	}
}
