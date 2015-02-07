package in.tusharbhargava.mealscrape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Main {

	/**
	 * @param args
	 * Unirests. 
	 * GSON 
	 * @throws IOException 
	 * @throws UnirestException 
	 * @throws URISyntaxException 
	 */
	public static void main(String[] args) throws IOException, UnirestException, URISyntaxException {
//		System.out.println("Hurray: ");
//		ArrayList<String> queries=new ArrayList<String>();
//		queries.add("Ratty");
//		queries.add("MONDAY");
//		queries.add("hackathon");
//		HttpResponse<String> answers=Unirest.get("https://api.students.brown.edu/dining/menu").header("accept", "application/json").queryString("eatery,day,client_id",queries).asString();
//		System.out.println("String: "+answers.toString());
		
//		HttpClient client = new DefaultHttpClient();
//		HttpGet request = new HttpGet("https://api.students.brown.edu/dining/menu");
//		request.setParams(new BasicHttpParams().setParameter("eatery", "Ratty"));
//		request.setParams(new BasicHttpParams().setParameter("client_id","hackathon"));
//		HttpResponse response = client.execute(request);
//		System.out.println(response.toString());
		
		URIBuilder builder = new URIBuilder("http://brown-apis.herokuapp.com/dining/menu");
		builder.setParameter("eatery", "RATTY").setParameter("client_id", "hackathon").setParameter("day", "7");
		HttpGet request=new HttpGet(builder.build());
		HttpClient client=new DefaultHttpClient();
		HttpResponse response=client.execute(request);
		InputStream ir=response.getEntity().getContent();
		InputStreamReader irReader=new InputStreamReader(ir);
		BufferedReader br=new BufferedReader(irReader);
		String s="Tushar";
		while(s!=null) {
			s=br.readLine();
			System.out.println(s);
		}
		
		ir.close();
	}

}
