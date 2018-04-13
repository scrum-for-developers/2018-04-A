package de.codecentric.psd.worblehat.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for Navigation
 */
@Controller
public class NavigationController {

    @Value("${build.version}")
    private String buildVersion;

    @ModelAttribute("buildVersion")
    public String getBuildVersion() {
        return buildVersion;
    }

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String center() {
		return "start";
	}
}
