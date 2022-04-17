package com.ansar.org.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ansar.org.enums.ReceviedType;

@Entity
@Table(name = "DONOR")
public class Donor extends Audit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "AMOUNT")
	private Double amount;

	@Column(name = "PHONE")
	private String phone;

	@Enumerated(EnumType.STRING)
	@Column(name = "RECEIVED_TYPE")
	private ReceviedType receviedType;

	@Column(name = "REF_NAME")
	private String refName;

	@Column(name = "RECIVED_DATE")
	private Date recivedDate;

	@Transient
	private String receivedDateText;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "COMMENT_ID")
	private Comment comment;

	public ReceviedType getReceviedType() {
		return receviedType;
	}

	public void setReceviedType(ReceviedType receviedType) {
		this.receviedType = receviedType;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getRecivedDate() {
		return recivedDate;
	}

	public void setRecivedDate(Date recivedDate) {
		this.recivedDate = recivedDate;
	}

	public String getReceivedDateText() {
		return receivedDateText;
	}

	public void setReceivedDateText(String receivedDateText) {
		this.receivedDateText = receivedDateText;
	}

}
