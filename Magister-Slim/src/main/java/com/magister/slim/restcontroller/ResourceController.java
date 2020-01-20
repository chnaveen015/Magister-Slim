package com.magister.slim.restcontroller;

import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.Resource;
import com.magister.slim.entity.User;
import com.magister.slim.service.ResourceAppService;
import com.magister.slim.service.UserAppService;

@RestController
public class ResourceController {
	@Autowired
	ResourceAppService resourceAppService;

	@RequestMapping(value = "resource", method = RequestMethod.POST)
	public Resource createResource(@RequestBody Resource resource, HttpServletRequest request) throws ParseException {
		resource.setResourceId(UserAppService.generateNumber());
		resource.setActive(true);
		User user = (User) request.getServletContext().getAttribute("user");
		return resourceAppService.addResource(resource, user);
	}

	@RequestMapping(value = "resource/{resourceId}", method = RequestMethod.DELETE)
	public Resource deleteResourceDetails(@PathVariable("resourceId") String resourceId) {
		return resourceAppService.deleteResource(resourceId);
	}

	@RequestMapping(value = "resource/{resourceId}", method = RequestMethod.GET)
	public Resource getResourceDetail(@PathVariable("resourceId") String resourceId) {
		return resourceAppService.getResource(resourceId);
	}

	@RequestMapping(value = "resources", method = RequestMethod.GET)
	public List<Resource> getResourceDetails(HttpServletRequest request) {
		User user = (User) request.getServletContext().getAttribute("user");
		return resourceAppService.getResource(user);
	}
}