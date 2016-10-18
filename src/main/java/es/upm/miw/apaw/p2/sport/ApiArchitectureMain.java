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

	
	public void demo() {
		request.setMethod(HttpMethod.POST);
		request.setPath("sports");
		request.setBody("");
		this.request();
		
		request.setMethod(HttpMethod.POST);
		request.setPath("sports");
		request.setBody("Futbol");
		this.request();
		
		request.setMethod(HttpMethod.POST);
		request.setPath("sports");
		request.setBody("Baloncesto");
		this.request();
		
		request.setMethod(HttpMethod.POST);
		request.setPath("sports");
		request.setBody("Futbol");
		this.request();
		
		request.setMethod(HttpMethod.POST);
		request.setPath("users");
		request.setBody("daniel:daniel.glez1993@gmail.com");
		this.request();
		
		request.setMethod(HttpMethod.POST);
		request.setPath("users");
		request.setBody("andres:andres@gmail.com");
		this.request();
		
		request.setMethod(HttpMethod.POST);
		request.setPath("users");
		request.setBody("daniel:daniel.glez1993@gmail.com");
		this.request();
		
		request.setMethod(HttpMethod.POST);
		request.setPath("users/daniel/sport");
		request.setBody("");
		this.request();
		
		request.setMethod(HttpMethod.POST);
		request.setPath("users/daniel/sport");
		request.setBody("asdasd");
		this.request();
		
		request.setMethod(HttpMethod.POST);
		request.setPath("users/daniel/sport");
		request.setBody("Futbol");
		this.request();
		
		request.setMethod(HttpMethod.POST);
		request.setPath("users/daniel/sport");
		request.setBody("Baloncesto");
		this.request();
		
		request.setMethod(HttpMethod.GET);
		request.setPath("users");
		this.request();
		
		request.setMethod(HttpMethod.GET);
		request.setPath("users/search");
		request.setBody("");
		request.addQueryParam("sport", "Futbol");
		this.request();
		
		request.setMethod(HttpMethod.GET);
		request.setPath("users/search");
		request.setBody("");
		request.addQueryParam("sport", "asd");
		this.request();
		
	}
	
	public void request() {
		IO.getIO().println(request.toString());
		HttpResponse response = server.request(request);
		IO.getIO().println(response);
		IO.getIO().println("---------------------------------------ooo----------------------------------------");
	}
	
	private void showStatus() {
		IO.getIO().setStatusBar(request.toString());
	}
	
	public static void main(String[] args) {
		ApiArchitectureMain main = new ApiArchitectureMain();
		DaoFactory.setFactory(new DaoFactoryMemory());
		IO.getIO().addView(main);
		main.showStatus();
	}
}
