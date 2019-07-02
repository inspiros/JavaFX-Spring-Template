package com.template.application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import javafx.fxml.Initializable;

@Controller
public class TemplateController implements Initializable {
	private static final Logger LOGGER = LoggerFactory.getLogger(TemplateController.class);

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		LOGGER.info("Initializing Controller");

	}

}
