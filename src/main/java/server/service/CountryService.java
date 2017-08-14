package server.service;

import java.util.List;

import javax.print.attribute.standard.Media;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import server.dao.CountryDao;
import server.obj.Country;
import server.obj.CountryList;

@Path("/countries/")
public class CountryService {

	CountryDao countrydao = new CountryDao();

	/*@GET
	@Produces({"application/xml"})
	
	public List getCountries() {

		List listOfCountries = countrydao.getAllCountries();
		return listOfCountries;
	}*/

	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })	
	public CountryList getCountries() {

		List listOfCountries = countrydao.getAllCountries();		
		CountryList list = new CountryList();
		list.getCountry().addAll(listOfCountries); 
		
		return list;
	}
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Country getCountryById(@PathParam("id") int id) {
		return countrydao.getCountry(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
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
