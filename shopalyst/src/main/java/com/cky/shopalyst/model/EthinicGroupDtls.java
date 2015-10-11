package com.cky.shopalyst.model;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class EthinicGroupDtls {

	private int ethnicity;

	private double meanWeight;

	private double meanHeight;

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
	 * @return the meanWeight
	 */
	public double getMeanWeight() {
		return meanWeight;
	}

	/**
	 * @param meanWeight the meanWeight to set
	 */
	public void setMeanWeight(double meanWeight) {
		this.meanWeight = meanWeight;
	}

	/**
	 * @return the meanHeight
	 */
	public double getMeanHeight() {
		return meanHeight;
	}

	/**
	 * @param meanHeight the meanHeight to set
	 */
	public void setMeanHeight(double meanHeight) {
		this.meanHeight = meanHeight;
	}

}
