package com.cky.shopalyst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cky.shopalyst.dao.IMemberDetailDao;
import com.cky.shopalyst.model.EthinicGroupDtls;
import com.cky.shopalyst.model.MemberDetail;

@Service(value="memberService")
@Transactional(propagation=Propagation.REQUIRED)
public class MemberDetailServiceImpl implements IMemberDetailService{

	@Autowired
	IMemberDetailDao memberDao;

	@Override
	public List<MemberDetail> getAllMembers() {
		return memberDao.getAllMembers();
	}

	@Override
	public List<MemberDetail> findMemberDetailsByCaption(String captionString, int pageNo){
		return memberDao.findMemberDetailsByCaption(captionString, pageNo);
	}

	public Integer getTotalMemberCount(){
		return  memberDao.getTotalMemberCount();
	}

	@Override
	public EthinicGroupDtls getEthnicGroupAvgHeightWeight(int ethincity) {
		return memberDao.ethnicGroupAvgHeightWeight(ethincity);
	}
	
}
