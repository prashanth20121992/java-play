package controllers;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import play.*;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

	// Reverse Routing
    public static Result index() {
        return redirect(controllers.routes.Application.hello("Prashanth"));
    }

    public static Result seeNumbers(String number){
    	Logger.info("See Number is called");
    	return ok(index.render("Check whether the param is number"));
    }
    
    public static Result flight(Object number){
    	Logger.info("Flight is called");
    	return ok(index.render("Check whether the param is number"));
    }
    
    public static Result hello(String name) {
        return ok(index.render("Hello " + name + "!"));
    }
    
    public static Result returnJSON(){
    	Map<String,String> a = new HashMap<String,String>();
    	a.put("title", "Introduction to Play");
    	//String b = "Prashanth";
    	JsonNode json = Json.toJson(a);
    	Logger.info(""+json);
    	return ok(json);
    }
}