package com.restdemo.bean;

import javax.xml.bind.annotation.XmlRootElement;

//import java.util.Date;


//@XmlRootElement(name="user")
public class User implements java.io.Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String id;
	public String firstname;
	 public String lastname;
	 public int age;
	 public String city;
	 public String state;
	 public long zipcode;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String id, String firstname, String lastname, int age, String city, String state, long zipcode){
		this.id=id;
		this.firstname=firstname;
		this.lastname=lastname;
		this.age=age;
		this.city=city;
		this.state=state;
		this.zipcode=zipcode;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}public String getState() {
		return state;
	}public long getZipcode() {
		return zipcode;
	}
	public int getAge() {
		return age;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
    public String toString() {
          return id+"="+firstname + "=" + lastname + " =" + age+"="+city+"="+"="+state+"="+zipcode;
    }
	
}
 