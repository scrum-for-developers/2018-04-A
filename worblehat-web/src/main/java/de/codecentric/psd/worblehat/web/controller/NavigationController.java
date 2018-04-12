package de.codecentric.psd.worblehat.web.controller;

import de.codecentric.psd.worblehat.web.formdata.BookDataFormData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for Navigation
 */
@Controller
public class NavigationController {

	@Value("${build.version}")
	private String buildVersion;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap modelMap) {
		modelMap.addAttribute("buildVersion", buildVersion);
		return "home";
	}

}
