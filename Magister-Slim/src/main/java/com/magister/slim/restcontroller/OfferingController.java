package com.magister.slim.restcontroller;

import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.Offering;
import com.magister.slim.service.OfferingAppService;
import com.magister.slim.service.UserAppService;

@RestController
public class OfferingController {

	public Offering offering;
	@Autowired
	OfferingAppService offeringAppService;
	@Autowired
	UserAppService userAppService;

	@RequestMapping(value = "offering", method = RequestMethod.POST)
	public Offering createOffering(@RequestBody Offering offering) throws ParseException {
		offering.setActive(true);
		offering.setOfferingId(UserAppService.generateNumber());
		Offering status = offeringAppService.addOfferingDetails(offering);
		return status;
	}

	@RequestMapping(value = "/offering/{offeringId}", method = RequestMethod.DELETE)
	public Offering deleteOfferingDetails(@PathVariable("offeringId") String offeringId) {
		return offeringAppService.deleteOffering(offeringId);

	}

	@RequestMapping(value = "/offering/{offeringId}", method = RequestMethod.PUT)
	public Offering updateOfferingDetails(@PathVariable("offeringId") String offeringId,
			@RequestBody Offering offering) {
		offering.setOfferingId(offeringId);
		Offering status = offeringAppService.updateOfferingName(offering);
		return status;
	}

	@RequestMapping(value = "/offering/{offeringId}", method = RequestMethod.GET)
	public Offering getOfferingDetail(@PathVariable("offeringId") String offeringId) {
		Offering offering = offeringAppService.getOfferingById(offeringId);
		return offering;

	}

	@GetMapping(value = "offerings")
	public List<Offering> getOfferingList() {
		return offeringAppService.getOfferings();
	}
}