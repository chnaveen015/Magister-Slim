package com.magister.slim.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.AssignmentResult;
import com.magister.slim.repository.AssignmentInterface;
import com.magister.slim.repository.AssignmentResultInterface;

@Service
public class AssignmentResultAppService {

	@Autowired
	AssignmentResultInterface assignmentResultInterface;
	@Autowired
	AssignmentInterface assignmentInterface;

	public List<AssignmentResult> getAssignmentResults(String assignmentId) {
		List<AssignmentResult> assignmentResults = assignmentResultInterface.findAll();
		List<AssignmentResult> assignmentResult = assignmentResults.stream().map(assignmentResultReference -> {
			if (assignmentResultReference.getAssignmentReference().getAssignmentId().equals( assignmentId)) {
				return assignmentResultReference;
			} else
				return null;
		}).collect(Collectors.toList());
		return assignmentResult;
	}

//	public AssignmentResult deleteAssignmentResult(int assignmentResultId) {
//		AssignmentResult assignmentResult=assignmentResultInterface.findById(assignmentResultId).get();
//		assignmentResult.set
//		assignmentResultInterface.save(assignmentResult);
//		return assignmentResult;
//	}

	public AssignmentResult addAssignmentResult(AssignmentResult assignmentResult) {
		assignmentResultInterface.save(assignmentResult);
		// assignmentResult=assignmentResultInterface.findById(assignmentResult.getAssignmentReference().getAssignmentId()).get();
		// assignmentResult.setAssignmentReference(assignmentDetails(assignmentResult.getAssignmentReference().,assignmentResult));
		return assignmentResult;
	}

//	private List<AssignmentResultReference> assignmentDetails(int assignmentId,
//			AssignmentResult assignmentResult) {
//		AssignmentReference assignmentReference = new AssignmentReference();
//		List<AssignmentResultReference> assignmentResults = new ArrayList<AssignmentResultReference>();
//		assignmentResults = assignmentResult.getAssignmentReference();
//		if (assignmentResults == null)
//			assignmentResults = new ArrayList<AssignmentResultReference>();
////		assignmentReference.setAssignmentResultId(assignmentId);
////		assignmentResults.add(assignmentReference);
//		return assignmentResults;
//	}

	public AssignmentResult getAssignmentResult(String assignmentResultid, String assignmentId, String studyGuideId,
			String themeId) {
		if (assignmentResultInterface.findById(assignmentResultid).isPresent()) {
			AssignmentResult assignmentResult = assignmentResultInterface.findById(assignmentResultid).get();
			if (assignmentResult.getAssignmentReference().getAssignmentId().equals(assignmentId))
				return assignmentResult;
		}
		else
			return null;
		return null;
	}

	public AssignmentResult updateAssignmentResult(String assignmentResultid) {
		AssignmentResult assignmentResult = assignmentResultInterface.findById(assignmentResultid).get();
		assignmentResultInterface.save(assignmentResult);
		return assignmentResult;
	}

}
