package es.upm.miw.apaw.p2.sport;

import es.upm.miw.apaw.p2.sport.http.HttpRequest;
import es.upm.miw.apaw.p2.sport.http.HttpResponse;
import es.upm.miw.apaw.p2.sport.daos.DaoFactory;
import es.upm.miw.apaw.p2.sport.daos.memory.DaoFactoryMemory;
import es.upm.miw.apaw.p2.sport.http.HttpMethod;
import upm.jbb.IO;

public class ApiArchitectureMain {

	private Server server = new Server();
	
	private HttpRequest request = new HttpRequest();
	
	public void help() {
		IO.getIO().println("GET **/users");
		IO.getIO().println("POST **/users   body=\"nick:email\"");
		IO.getIO().println("GET **/users/{nick}/sport");
		IO.getIO().println("GET **/users/search?sport=*");
		IO.getIO().println("POST **/sports   body=\"name\"");
	}

	
	public void execute() {
		request.setMethod(HttpMethod.POST);
		request.setPath("users");
		request.setBody("uno:uno@gmail.com");
		this.request();
		
		request.setMethod(HttpMethod.POST);
		request.setPath("users");
		request.setBody("dos:dos@gmail.com");
		this.request();
		
		request.setMethod(HttpMethod.POST);
		request.setPath("users");
		request.setBody("uno:tres@gmail.com");
		this.request();
		
		request.setMethod(HttpMethod.GET);
		request.setPath("users");
		request.setBody("");
		this.request();
		
		request.setMethod(HttpMethod.POST);
		request.setPath("sports");
		request.setBody("tenis");
		this.request();
		
		request.setMethod(HttpMethod.POST);
		request.setPath("sports");
		request.setBody("tenis");
		this.request();
		
		request.setMethod(HttpMethod.POST);
		request.setPath("sports");
		request.setBody("ajedrez");
		this.request();
		
		request.setMethod(HttpMethod.PUT);
		request.setPath("users/uno/sport");
		request.setBody("tenis");
		this.request();
		
		request.setMethod(HttpMethod.PUT);
		request.setPath("users/uno/sport");
		request.setBody("noDeporte");
		this.request();
		
		request.setMethod(HttpMethod.PUT);
		request.setPath("users/dos/sport");
		request.setBody("tenis");
		this.request();
		
		request.setMethod(HttpMethod.PUT);
		request.setPath("users/dos/sport");
		request.setBody("ajedrez");
		this.request();
		
		request.setMethod(HttpMethod.GET);
		request.setPath("users/search");
		request.setBody("");
		request.addQueryParam("sport", "tenis");
		this.request();
		
		request.setMethod(HttpMethod.POST);
		request.setPath("noPath");
		request.setBody("");
		request.clearQueryParams();
		this.request();
		
	}
	
	public void request() {
		IO.getIO().println(request.toString());
		HttpResponse response = server.request(request);
		IO.getIO().println(response);
		IO.getIO().println("---------------------------------------ooo----------------------------------------");
	}
	
	public static void main(String[] args) {
		ApiArchitectureMain main = new ApiArchitectureMain();
		DaoFactory.setFactory(new DaoFactoryMemory());
		IO.getIO().addView(main);
		main.execute();
	}
}
