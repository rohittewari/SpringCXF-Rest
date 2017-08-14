package service.client;

import java.net.URLEncoder;

import javax.ws.rs.core.MediaType;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import server.obj.Account;
import server.obj.Country;

public class DemoRestClient {

	public static void main(String[] args) throws Exception {
		/*
		    WebClient client = WebClient.create("http://localhost:8182");
		    client.path("hiService/sayHi/hi");
		   client.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		    Response r = client.get();
		    System.out.println(r.readEntity(Account.class));*/
            (new DemoRestClient()).getAllCountries(); 
		

	}
	
	
	public Country getAllCountries () throws Exception {
		
		       String output = null;
		        try{
		            String url = "http://localhost:8380/apache-cxf-sample/rservice/countriesHttp/";
		          //  url = url + URLEncoder.encode(countryId, "UTF-8");
		            HttpClient client = new HttpClient();
		            GetMethod mPost = new GetMethod(url);
		            Header mtHeader = new Header();
		            mtHeader.setName("content-type");
		          //  mtHeader.setValue("application/x-www-form-urlencoded");
		            mtHeader.setName("accept");
		            mtHeader.setValue("application/json");
		            mPost.addRequestHeader(mtHeader);
		            client.executeMethod(mPost);
		            output = mPost.getResponseBodyAsString( );
		            mPost.releaseConnection( );
		            System.out.println("out : " + output);
		        }catch(Exception e){
		            throw new Exception("Exception in retriving group page info : " + e);
		        }
		        return null;		    
	}

}
