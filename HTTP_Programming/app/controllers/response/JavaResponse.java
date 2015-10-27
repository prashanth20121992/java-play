package controllers.response;


import play.mvc.Result;

import play.mvc.*;
import play.mvc.Http.*;
import play.mvc.Http.Response;
import views.html.*;
import views.html.defaultpages.badRequest;
import play.*;

import static play.mvc.Controller.*;
public class JavaResponse {

	//Cache
	public static Result index(){
		response().setContentType("text/html");
		response().setHeader(Response.CACHE_CONTROL, "max-age=3600");
		response().setHeader(Response.ETAG, "xxx");
		return ok(index.render("Check Headers"));
	}
	
	//Session


}
