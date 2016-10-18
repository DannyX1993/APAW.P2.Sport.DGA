package es.upm.miw.apaw.p2.sport;

import es.upm.miw.apaw.p2.sport.api.SportResource;
import es.upm.miw.apaw.p2.sport.api.UserResource;
import es.upm.miw.apaw.p2.sport.exceptions.InvalidRequestException;
import es.upm.miw.apaw.p2.sport.exceptions.InvalidUserFieldException;
import es.upm.miw.apaw.p2.sport.http.HttpRequest;
import es.upm.miw.apaw.p2.sport.http.HttpResponse;
import es.upm.miw.apaw.p2.sport.http.HttpStatus;

public class Dispatcher {

	private UserResource userResource = new UserResource();
	
	private SportResource sportResource = new SportResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		if ("users".equals(request.getPath())) {
			// GET **/users
			response.setBody(userResource.usersList().toString());
		} else if ("users".equals(request.paths()[0]) && "sport".equals(request.paths()[2])) {
			// GET **/users/search?sport=*
		}
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		if("users".equals(request.getPath())) {
			// POST **/users body="nick:email"
			this.createUser(request, response);
		} else if ("users".equals(request.paths()[0]) && "sport".equals(request.paths()[2])) {
			try {
				// POST **/users/{nick}/sport
				userResource.addSport(request.paths()[1], request.getBody());
				response.setStatus(HttpStatus.CREATED);
			} catch (Exception e) {
				responseError(response, e);
			}
		} else if("sports".equals(request.getPath())) {
			// POST **/sports body="name"
			this.createSport(request, response);
		} else {
			responseError(response, new InvalidRequestException(request.getPath()));
		}
		
	}
	
	private void createUser(HttpRequest request, HttpResponse response) {
		try {
			String nick = request.getBody().split(":")[0];
			String email = request.getBody().split(":")[1];
			userResource.createUser(nick, email);
			response.setStatus(HttpStatus.CREATED);
		} catch (Exception e) {
			responseError(response, e);
		}
	}
	
	private void createSport(HttpRequest request, HttpResponse response) {
		try {
			sportResource.createSport(request.getBody());
			response.setStatus(HttpStatus.CREATED);
		} catch (Exception e) {
			responseError(response, e);
		}
	}

	public void doPut(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
			case "users":
				break;
			default:
				responseError(response, new InvalidRequestException(request.getPath()));
				break;
		}
	}

	public void doDelete(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

}
