import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			 
			Client client = Client.create();
			System.out.println("main start....");
			WebResource webResource = client
			   .resource("http://localhost:8080/Inventory/test/");
	 
			String input = "{\"quantity\":\"1\",\"itemID\":\"1\",\"branchID\":\"2\"}";
	 
			ClientResponse response = webResource.type("application/json")
			   .post(ClientResponse.class, input);
	 
			
	 
			
	 
		  } catch (Exception e) {
	 
			e.printStackTrace();
	 
		  }
	 
		}

	}


