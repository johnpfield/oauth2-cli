/**
 * 
 */
package architectedsec.sample.oauth2;
/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Domain object for tracking Orders
 *
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

	private Long id;

	private String orderNumber;
	
	private Date orderDate;

	private String customerName;

	private String description;

	private String attrJ;
	
	private String attrK;
	
	private String attrL;
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the orderNumber
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the attrJ
	 */
	public String getAttrJ() {
		return attrJ;
	}

	/**
	 * @param attr_j the attrJ to set
	 */
	public void setAttrJ(String attr_j) {
		this.attrJ = attr_j;
	}

	/**
	 * @return the attrK
	 */
	public String getAttrK() {
		return attrK;
	}

	/**
	 * @param attr_k the attrK to set
	 */
	public void setAttrK(String attr_k) {
		this.attrK = attr_k;
	}

	/**
	 * @return the attrL
	 */
	public String getAttrL() {
		return attrL;
	}

	/**
	 * @param attr_l the attrL to set
	 */
	public void setAttrL(String attr_l) {
		this.attrL = attr_l;
	}

}
