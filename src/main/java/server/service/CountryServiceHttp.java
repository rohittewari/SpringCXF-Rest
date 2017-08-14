package server.service;

import java.util.List;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import server.dao.CountryDao;
import server.exceptions.DoNotFoundException;
import server.obj.Country;
import server.obj.CountryList;

@Path("/countriesHttp/")
public class CountryServiceHttp {

	CountryDao countrydao = new CountryDao();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	
	public Response  getCountries() {

		List listOfCountries = countrydao.getAllCountries();		
		CountryList list = new CountryList();
		list.getCountry().addAll(listOfCountries); 
		
		return (Response.ok(list).build());
	}
	
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Country getCountryById(@PathParam("id") int id) {
		Country cntry = countrydao.getCountry(id);
		if (cntry==null){
			throw new DoNotFoundException("Not found",404);
		}
		
		return cntry;
	}

	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Country addCountry(Country country) {
		return countrydao.addCountry(country);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Country updateCountry(Country country) {
		return countrydao.updateCountry(country);

	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCountry(@PathParam("id") int id) {
		countrydao.deleteCountry(id);

	}

}
