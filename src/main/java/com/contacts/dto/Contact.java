package com.contacts.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class Contact implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNumber;
	private Date createdDate;
	private Date updatedDate;

}
