package com.cky.shopalyst.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.cky.shopalyst.config.JsonDateSerializer;

@JsonAutoDetect
@Entity
@Table(name = "member_details")
public class MemberDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "pnum", columnDefinition = "int")
	private int id;

	@JsonSerialize(using=JsonDateSerializer.class)
	@Column(name = "dob")
	private Date dob;
	
	@Column(name = "caption")
	private String caption;

	@Column(name = "ethnicity")
	private int ethnicity;

	@Column(name = "weight")
	private int weight;
	
	@Column(name = "height")
	private int height;
	
	@Column(name = "is_veg")
	private int is_veg;
	
	@Column(name = "drink")
	private int drink;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the caption
	 */
	public String getCaption() {
		return caption;
	}

	/**
	 * @param caption the caption to set
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}

	/**
	 * @return the ethnicity
	 */
	public int getEthnicity() {
		return ethnicity;
	}

	/**
	 * @param ethnicity the ethnicity to set
	 */
	public void setEthnicity(int ethnicity) {
		this.ethnicity = ethnicity;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the is_veg
	 */
	public int getIs_veg() {
		return is_veg;
	}

	/**
	 * @param is_veg the is_veg to set
	 */
	public void setIs_veg(int is_veg) {
		this.is_veg = is_veg;
	}

	/**
	 * @return the drink
	 */
	public int getDrink() {
		return drink;
	}

	/**
	 * @param drink the drink to set
	 */
	public void setDrink(int drink) {
		this.drink = drink;
	}

}
