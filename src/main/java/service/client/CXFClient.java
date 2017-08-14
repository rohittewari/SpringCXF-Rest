package service.client;

import java.util.ArrayList;
import java.util.Collections;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;

import server.obj.Country;
import server.obj.CountryList;

public class CXFClient {
	
	public static void main (String [] args){
	
		WebClient client = WebClient.create("http://localhost:8380/apache-cxf-sample/rservice/countriesHttp/");
		
		CountryList list  = (client.accept("application/xml").get(CountryList.class));
		for (Country c : list.getCountry()){
			System.out.println(c.getCountryName()); 
		}
		
		
	}

}

/**

WebClient client = WebClient.create("http://localhost:8084/appname/rest/");
Book book = client.path("book/" + 1 ).accept("application/json").get(Book.class);

WebClient client = WebClient.create("http://localhost:8084/appname/rest/");
Set<Book> books = new HashSet<Book>(client.path("books/all").accept("application/json").getCollection(Book.class));

WebClient client = WebClient.create("http://localhost:8084/appname/rest/");
Book book = new Book();
book.setAuthor("Rohit);
book.setPublishedDate(new Date());
client.path("/book-post");
client.post(book); // Persist object

WebClient client = WebClient.create("http://localhost:8084/appname/rest/");
Book book = client.path("book/" + 1 ).accept("application/json").get(Book.class);
book.setAuthor("Rohit);
book.setPublishedDate(new Date());
client.back(true);
client.path("/book-put");
client.put(book);// update book object




*/
