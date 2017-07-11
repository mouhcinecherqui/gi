package com.test.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class HomeController {

	@Autowired
	private Service service;

	@Value("${conference.name:everybody}")
	private String conference;

	@RequestMapping(value = "/users")
	public Iterable<Utilisateur> getUsers() {
		return service.getUsers();
	}

	@RequestMapping(value = "/users/{codeAlliance}")
	public Utilisateur getUser(@PathVariable(value = "codeAlliance") String codeAlliance) {
		return service.getUser(codeAlliance);
	}

	@RequestMapping(value = "/users/{codeAlliance}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "codeAlliance") String codeAlliance) {
		service.delete(codeAlliance);
	}

	@RequestMapping(value = "/users/{codeAlliance}", method = RequestMethod.PUT)
	public void update(@RequestBody Utilisateur utilisateur) {
		service.update(utilisateur);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Utilisateur create(@RequestBody Utilisateur utilisateurToSave) {
		return service.create(utilisateurToSave);
	}
}
