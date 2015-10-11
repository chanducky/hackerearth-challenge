package com.cky.shopalyst.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cky.shopalyst.model.EthinicGroupDtls;
import com.cky.shopalyst.model.MemberDetail;
import com.cky.shopalyst.service.IMemberDetailService;


@Controller
@RequestMapping("/member")
public class MemberDetailController {

	@Autowired
	IMemberDetailService memberService;

	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MemberDetail>> getAllMembers() {
		List<MemberDetail> memberList = null;
		memberList = memberService.getAllMembers();
		
		if(memberList.isEmpty()){
			return new ResponseEntity<List<MemberDetail>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<MemberDetail>>(memberList, HttpStatus.OK);

	}
	
	@ResponseBody
	@RequestMapping(value = "/search_caption", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MemberDetail>> loadUserDetailsByUserName(@RequestParam String query, @RequestParam String page) {

		if(StringUtils.isEmpty(query)){
			throw new RuntimeException("Query parameter not found.");
		}else if(StringUtils.isEmpty(page)){
			throw new RuntimeException("Page parameter not found.");
		}
		List<MemberDetail> memberList = memberService.findMemberDetailsByCaption(query, Integer.parseInt(page));
		
		if(memberList.isEmpty()){
			return new ResponseEntity<List<MemberDetail>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<MemberDetail>>(memberList, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> getMemberCount() {
		
		Integer memberCount = memberService.getTotalMemberCount();
		
		if(memberCount == 0){
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Integer>(memberCount, HttpStatus.OK);

	}
	
	@ResponseBody
	@RequestMapping(value = "/{ethnicity}/averages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EthinicGroupDtls> ethnicGroupAvgHeightWeight(@PathVariable String ethnicity) {
		
		if(StringUtils.isEmpty(ethnicity)){
			throw new RuntimeException(" ethnicity parameter not found.");
		}
		
		EthinicGroupDtls ethinicGroupDtls = memberService.getEthnicGroupAvgHeightWeight(Integer.parseInt(ethnicity));
		
		if(ethinicGroupDtls == null){
			return new ResponseEntity<EthinicGroupDtls>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<EthinicGroupDtls>(ethinicGroupDtls, HttpStatus.OK);

	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> errorHandler(Exception e) {
		System.out.println("In exception handler..");
		e.printStackTrace();
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
