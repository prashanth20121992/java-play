package controllers;

import play.*;
import controllers.Todo.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return redirect(controllers.Todo.routes.Application.create());
    }

}
