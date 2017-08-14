package server.obj;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Countries")
public class CountryList {
	
	private List<Country> country;
	
	public List<Country> getCountry() {
		if (country == null) {
			country = new ArrayList<Country>();
		}
		
		return country;
	}

	public void setCountry(List<Country> country) {
		this.country= country;
	}
	
}
