package com.test.avianca.test.tata.models;

import java.util.Date;

import com.ibm.icu.text.SimpleDateFormat;

public class TripInformation {
	private String origin;
	private String destination;
	private Integer adultsNumber;
	private Integer childrensNumber;
	private Integer babiesNumber;

	public TripInformation() {
		this("default", "default", 0, 0, 0);
	}

	public TripInformation(String origin, String destination) {
		this(origin, destination, 0, 0, 0);
	}

	public TripInformation(String origin, String destination, Integer adultsNumber, Integer childrensNumber,
			Integer babiesNumber) {
		this.origin = origin;
		this.destination = destination;
		this.adultsNumber = adultsNumber;
		this.childrensNumber = childrensNumber;
		this.babiesNumber = babiesNumber;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Integer getAdultsNumber() {
		return adultsNumber;
	}

	public void setAdultsNumber(Integer adultsNumber) {
		this.adultsNumber = adultsNumber;
	}

	public Integer getChildrensNumber() {
		return childrensNumber;
	}

	public void setChildrensNumber(Integer childrensNumber) {
		this.childrensNumber = childrensNumber;
	}

	public Integer getBabiesNumber() {
		return babiesNumber;
	}

	public void setBabiesNumber(Integer babiesNumber) {
		this.babiesNumber = babiesNumber;
	}

}
