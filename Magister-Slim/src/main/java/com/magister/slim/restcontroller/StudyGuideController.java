<<<<<<< HEAD

package com.magister.slim.restcontroller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.StudyGuide;
import com.magister.slim.entity.User;
import com.magister.slim.model.MagisterInterceptor;
import com.magister.slim.service.StudyGuideAppService;
import com.magister.slim.service.UserAppService;

@RestController
//@RequestMapping("studyGuide")
@CrossOrigin(origins = "http://localhost:4200")
public class StudyGuideController {

	@Autowired
	StudyGuideAppService studyGuideAppService;
	MagisterInterceptor magisterInterceptor;
	UserAppService userAppService;

	@RequestMapping(value="studyGuide",method = RequestMethod.POST)
	public StudyGuide createStudyGuide(@RequestBody StudyGuide studyGuide,HttpServletRequest request) throws ParseException {
		studyGuide.setStudyGuideId(userAppService.generateNumber());
		studyGuide.setActive(true);
		User user= (User) request.getServletContext().getAttribute("user");
		System.out.println(studyGuide);
		System.out.println(user);
		StudyGuide status = studyGuideAppService.addStudyGuide(studyGuide,user);
		return status;
	}

	@RequestMapping(value = "studyGuide/{studyGuideId}", method = RequestMethod.DELETE)
	public String deleteStudyGuideDetails(@PathVariable("studyGuideId") String studyGuideId, HttpServletRequest request,
			HttpServletResponse response) {
		String status = studyGuideAppService.deleteStudyGuide(studyGuideId);
		return status;
	}

	@RequestMapping(value = "studyGuide/{studyGuideId}", method = RequestMethod.PUT)
	public StudyGuide updateStudyGuideDetails(@PathVariable("studyGuideId") String studyGuideId, @RequestBody StudyGuide studyGuide) {
		StudyGuide status = studyGuideAppService.updateStudyGuide(studyGuide,studyGuideId);
		return status;
	}

	@RequestMapping(value = "studyGuide/{studyGuideId}",method = RequestMethod.GET)
	public StudyGuide getStudyGuideDetail(@PathVariable("studyGuideId") String studyGuideId) {
		StudyGuide studyGuide = studyGuideAppService.getStudyGuideById(studyGuideId);
		return studyGuide;
	}

//	@RequestMapping(method = RequestMethod.GET)
//	public List<StudyGuide> getStudyGuideDetails(@RequestParam String studyGuideName,HttpServletRequest request) {
//		User user= (User) request.getServletContext().getAttribute("user");
//		System.out.println(user);
//		List<StudyGuide> studyGuide = studyGuideAppService.getStudyGuide(studyGuideName);
//		return studyGuide;
//	}
	@RequestMapping(value="studyGuides",method = RequestMethod.GET)
	public List<StudyGuide> getStudyGuide(HttpServletRequest request,HttpServletResponse response) throws Exception {
		User user= (User) request.getServletContext().getAttribute("user");
		//magisterInterceptor.preHandle(request, response, user);
		List<StudyGuide> studyGuide = studyGuideAppService.getStudyGuide(user);
		return studyGuide;
	}
}



=======

package com.magister.slim.restcontroller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.StudyGuide;
import com.magister.slim.entity.User;
import com.magister.slim.model.MagisterInterceptor;
import com.magister.slim.service.StudyGuideAppService;
import com.magister.slim.service.UserAppService;

@RestController
public class StudyGuideController {

	@Autowired
	StudyGuideAppService studyGuideAppService;
	MagisterInterceptor magisterInterceptor;
	UserAppService userAppService;

	@RequestMapping(value="studyGuide",method = RequestMethod.POST)
	public StudyGuide createStudyGuide(@RequestBody StudyGuide studyGuide,HttpServletRequest request) throws ParseException {
		studyGuide.setStudyGuideId(UserAppService.generateNumber());
		studyGuide.setActive(true);
		User user= (User) request.getServletContext().getAttribute("user");
		System.out.println(studyGuide);
		System.out.println(user);
		StudyGuide status = studyGuideAppService.addStudyGuide(studyGuide,user);
		return status;
	}

	@RequestMapping(value = "studyGuide/{studyGuideId}", method = RequestMethod.DELETE)
	public String deleteStudyGuideDetails(@PathVariable("studyGuideId") String studyGuideId, HttpServletRequest request,
			HttpServletResponse response) {
		String status = studyGuideAppService.deleteStudyGuide(studyGuideId);
		return status;
	}

	@RequestMapping(value = "studyGuide/{studyGuideId}", method = RequestMethod.PUT)
	public StudyGuide updateStudyGuideDetails(@PathVariable("studyGuideId") String studyGuideId, @RequestBody StudyGuide studyGuide) {
		StudyGuide status = studyGuideAppService.updateStudyGuide(studyGuide,studyGuideId);
		return status;
	}

	@RequestMapping(value = "studyGuide/{studyGuideId}",method = RequestMethod.GET)
	public StudyGuide getStudyGuideDetail(@PathVariable("studyGuideId") String studyGuideId) {
		StudyGuide studyGuide = studyGuideAppService.getStudyGuideById(studyGuideId);
		return studyGuide;
	}

//	@RequestMapping(method = RequestMethod.GET)
//	public List<StudyGuide> getStudyGuideDetails(@RequestParam String studyGuideName,HttpServletRequest request) {
//		User user= (User) request.getServletContext().getAttribute("user");
//		System.out.println(user);
//		List<StudyGuide> studyGuide = studyGuideAppService.getStudyGuide(studyGuideName);
//		return studyGuide;
//	}
	@RequestMapping(value="studyGuides",method = RequestMethod.GET)
	public List<StudyGuide> getStudyGuide(HttpServletRequest request,HttpServletResponse response) throws Exception {
		User user= (User) request.getServletContext().getAttribute("user");
		//magisterInterceptor.preHandle(request, response, user);
		List<StudyGuide> studyGuide = studyGuideAppService.getStudyGuide(user);
		return studyGuide;
	}
}



>>>>>>> Removed Cross Origins
