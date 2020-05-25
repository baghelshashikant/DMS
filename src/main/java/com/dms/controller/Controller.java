package com.dms.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dms.config.AppConfig;
import com.dms.model.Patient;
import com.dms.services.PatientService;
import com.dms.view.Home;
import com.dms.view.Login;

public class Controller {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Home frame = context.getBean(Home.class);
		frame.setVisible(true);
	}

}
