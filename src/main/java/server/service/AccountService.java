package server.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import server.obj.Account;

@Path("/accountservice/")
public class AccountService {

	Map<String, Account> accounts = new HashMap<String, Account>();

	public void init() {

		Account newAccount1 = new Account();
		newAccount1.setId(1);
		newAccount1.setName("Rohit");

		Account newAccount2 = new Account();
		newAccount2.setId(2);
		newAccount2.setName("Rohit Account");

		accounts.put("1", newAccount1);
		accounts.put("2", newAccount2);

	}

	public AccountService() {
		init();
	}

	@GET
	@Path("/accounts/{id}/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Account getAccount(@PathParam("id") String id) {
		Account c = accounts.get(id);
		return c;
	}

	@GET
	@Path("/accounts/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> getAllAccounts(Account account) {
		List<Account> accountList = new ArrayList<Account>();
		for (int i = 0; i <= accounts.size(); i++) {
			accountList.add((Account) accounts.get(i));
		}
		return accountList;
	}

}