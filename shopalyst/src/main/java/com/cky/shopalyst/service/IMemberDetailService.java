package com.cky.shopalyst.service;

import java.util.List;

import com.cky.shopalyst.model.EthinicGroupDtls;
import com.cky.shopalyst.model.MemberDetail;

public interface IMemberDetailService {

	/**
	 * @return List<MemberDetail>
	 */
	public List<MemberDetail> getAllMembers();

	/**
	 * @param captionString
	 * @param pageNo
	 * @return List<MemberDetail>
	 */
	public List<MemberDetail> findMemberDetailsByCaption(String captionString, int pageNo);

	/**
	 * @return Integer
	 */
	public Integer getTotalMemberCount();
	
	/**
	 * @param ethincity
	 * @return EthinicGroupDtls
	 */
	public EthinicGroupDtls getEthnicGroupAvgHeightWeight(int ethincity);
}
