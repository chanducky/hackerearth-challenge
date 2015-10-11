package com.cky.shopalyst.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.springframework.stereotype.Repository;

import com.cky.shopalyst.model.EthinicGroupDtls;
import com.cky.shopalyst.model.MemberDetail;

@Repository(value="memberDao")
public class MemberDetailDaoImpl extends HibernateSessionDao implements IMemberDetailDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MemberDetail> getAllMembers() {
		Criteria crt = getSession().createCriteria(MemberDetail.class);
		return crt.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberDetail> findMemberDetailsByCaption(String captionString, int pageNo){
		
		Criteria crt = getSession().createCriteria(MemberDetail.class);
		crt.add(Restrictions.like("caption", "%"+captionString+"%"));
		
		crt.setFirstResult(10*pageNo);
		crt.setMaxResults(10);

		List<MemberDetail> memberDetailList = crt.list();
	
		return memberDetailList;
	}

	@Override
	public Integer getTotalMemberCount() {
		Object countObj =  getSession().createCriteria(MemberDetail.class).setProjection(Projections.rowCount()).uniqueResult();

		if(countObj != null ){
			return	((Long)countObj).intValue();
		}
		return 0;
	}
	
	public EthinicGroupDtls ethnicGroupAvgHeightWeight(int ethnicity){
		SQLQuery query =  getSession().createSQLQuery(" select ethnicity, avg(height) as meanHeight, avg(weight) as meanWeight "
				+ " from member_details where ethnicity= :ethnicity");
		
		query.setParameter("ethnicity", ethnicity);
		query.addScalar("ethnicity", IntegerType.INSTANCE);
		query.addScalar("meanHeight", DoubleType.INSTANCE);
		query.addScalar("meanWeight", DoubleType.INSTANCE);
		
		query.setResultTransformer(Transformers.aliasToBean(EthinicGroupDtls.class));
		return (EthinicGroupDtls) query.uniqueResult();
	}

	
			
}
