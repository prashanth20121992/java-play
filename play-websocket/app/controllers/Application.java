package controllers;

import java.util.ArrayList;
import java.util.List;

import play.*;
import play.cache.Cache;
import play.libs.F.Callback0;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	public static WebSocket<String> wsCall(){
		return new WebSocket<String>(){

			@SuppressWarnings("unchecked")
			@Override
			public void onReady(play.mvc.WebSocket.In<String> in,
					play.mvc.WebSocket.Out<String> out) {
				// TODO Auto-generated method stub
				if (Cache.get("channels") == null) {
					List<Out> outs = new ArrayList<Out>();
					outs.add(out);
					Cache.set("channels", outs);
				} else ((List<Out>) Cache.get("channels")).add(out);
				in.onClose(new Callback0() {

					public void invoke() throws Throwable {
						// TODO Auto-generated method stub
						((List<Out>) Cache.get("channels")).remove(out);
						out.close();
					}
				});
			}
		};

	}

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}


}
