package com.attservices.attservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="address_table")
public class address {

	@Id
	@GeneratedValue
	@Column(name="Address_ID")
	private int addID;
	
	@Column(name="Address_Line1")
	private String addLine1;
	
	@Column(name="Address_Line2")
	private String addLin2;
	
	@Column(name="City")
	private String city;
	
	@Column(name="State")
	private String state;
	
	@Column(name="Country")
	private String country;
	
	@Column(name="Zip")
	private long zip;
	
	@Column(name="is_Active")
	private boolean UserActive;
	
}
