package com.magister.slim.restcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.Resource;
import com.magister.slim.entity.User;
import com.magister.slim.service.ResourceAppService;

@RestController
@RequestMapping("resource")
@CrossOrigin(origins = "http://localhost:4200")
public class ResourceController {

	@Autowired
	ResourceAppService resourceAppService;

	@RequestMapping(method = RequestMethod.POST)
	public Resource createResource(@RequestBody Resource resource,HttpServletRequest request) {
		resource.setActive(true);
		User user= (User) request.getServletContext().getAttribute("user");
		Resource status = resourceAppService.addResource(resource,user);
		return status;
	}

	@RequestMapping(value = "/{resourceId}", method = RequestMethod.PUT)
	public Resource updateResourceDetails(@RequestBody Resource resource, @PathVariable("resourceId") String resourceId) {
		if (resource.getResourceName() != null && resource.getResourceType() != null)
			resourceAppService.updateResource(resourceId, resource);
		return resource;
	}

	@RequestMapping(value = "/{resourceId}", method = RequestMethod.DELETE)
	public String deleteResourceDetails(@PathVariable("resourceId") String resourceId) {
		String status = resourceAppService.deleteResource(resourceId);
		return status;
	}

	@RequestMapping(value = "/{resourceId}", method = RequestMethod.GET)
	public Resource getResourceDetail(@PathVariable("resourceId") String resourceId) {
		Resource resource = resourceAppService.getResource(resourceId);
		return resource;
	}

//	@RequestMapping(method = RequestMethod.GET)
//	public List<Resource> getResourceDetails(@RequestParam String resourceName) {
//		List<Resource> resources = resourceAppService.getResources(resourceName);
//		return resources;
//	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Resource> getResourceDetails(HttpServletRequest request) {
		User user= (User) request.getServletContext().getAttribute("user");
		List<Resource> resources = resourceAppService.getResources(user);
		return resources;
	}
}
