package org.elsysbg.ip.todo;

import org.apache.derby.iapi.jdbc.AuthenticationService;
import org.elsysbg.ip.todo.services.EntityManagerService;
import org.elsysbg.ip.todo.services.MemberService;
import org.elsysbg.ip.todo.services.TaskService;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

public class TodoListServletContextListener extends GuiceServletContextListener {

	public static Injector injector;

	@Override
	protected Injector getInjector() {
		if (injector == null) {
			injector = Guice.createInjector(new ServletModule() {
				@Override
				protected void configureServlets() {
					bind(TaskService.class);
					bind(EntityManagerService.class);
					bind(MemberService.class);
					bind(AuthenticationService.class);
				}
			});
		}

		return injector;
	}
}
