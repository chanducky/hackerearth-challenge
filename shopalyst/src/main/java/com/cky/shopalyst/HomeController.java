package com.cky.shopalyst;

import java.util.Locale;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public String home(Locale locale, Model model) {
		String data = "Welcome ! service is running .. ";
		return data;
	}
	
}
