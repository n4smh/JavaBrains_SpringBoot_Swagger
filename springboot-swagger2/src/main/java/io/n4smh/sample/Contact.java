package io.n4smh.sample;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the contact")
public class Contact {

	@ApiModelProperty(notes = "The unique id of the contact")
	private String id;

	@ApiModelProperty(notes = "Contact name")
	private String name;

	@ApiModelProperty(notes = "Contact number")
	private String phone;

	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public Contact(String id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}

}
