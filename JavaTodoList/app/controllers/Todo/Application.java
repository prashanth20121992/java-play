package controllers.Todo;

import models.Task;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
	static Form<Task> taskForm = Form.form(Task.class);

	public static Result create() {
		Form<Task> filledForm = taskForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			Logger.info("Has errors");
			return badRequest(views.html.index.render(Task.list(), filledForm));
		} else {
			Task.create(filledForm.get());
			return redirect(routes.Application.listAll());
		}
	}

	public static Result listAll() {
		return ok(views.html.index.render(Task.list(), taskForm));
	}

	public static Result delete(Long id) {
		Task.delete(id);
		return redirect(routes.Application.create());

	}
}
