package com.ansar.org.vo;

public class DonorVo {

	private Long id;

	private String firstName;

	private String middleName;

	private String lastName;

	private Double amount;

	private String phone;

	private String receivedType;

	private String refName;

	private String recivedDate;

	private String comment;

	public String getReceivedType() {
		return receivedType;
	}

	public void setReceivedType(String receivedType) {
		this.receivedType = receivedType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRefName() {
		return refName;
	}

	public void setRefName(String refName) {
		this.refName = refName;
	}

	public String getRecivedDate() {
		return recivedDate;
	}

	public void setRecivedDate(String recivedDate) {
		this.recivedDate = recivedDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
