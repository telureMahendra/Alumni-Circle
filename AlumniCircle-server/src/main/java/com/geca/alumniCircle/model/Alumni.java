package com.geca.alumniCircle.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alumni")
public class Alumni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String about;
    private String email;
    private String mobileNo;
    private Integer graduationYear;
    private String branch;
    private String currentCompany;
    private String password;
    
    @Column(nullable = false)
    private Boolean verificationStatus = false; // Default value set to false

    private String city;

    @Lob
    private byte[] photo;
    
    
    

	public Alumni() {

	}

	public Alumni(Long id, String firstName, String lastName, String about, String email, String mobileNo,
			Integer graduationYear, String branch, String currentCompany, String password, Boolean verificationStatus,
			String city, byte[] photo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.about = about;
		this.email = email;
		this.mobileNo = mobileNo;
		this.graduationYear = graduationYear;
		this.branch = branch;
		this.currentCompany = currentCompany;
		this.password = password;
		this.verificationStatus = verificationStatus;
		this.city = city;
		this.photo = photo;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Integer getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(Integer graduationYear) {
		this.graduationYear = graduationYear;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCurrentCompany() {
		return currentCompany;
	}

	public void setCurrentCompany(String currentCompany) {
		this.currentCompany = currentCompany;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(Boolean verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
    
    
    

    
    
}
