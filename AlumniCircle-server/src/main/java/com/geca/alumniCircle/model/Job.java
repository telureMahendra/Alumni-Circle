package com.geca.alumniCircle.model;



import jakarta.persistence.*;


@Entity
@Table(name = "jobs")
public class Job {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Assuming you have an ID field
    
    private String title;
    private String description;
    private String location;
    private String company;
    private Double salary; // or Integer based on your requirement
    private String applyLink;
    
    @ManyToOne
    @JoinColumn(name = "alumni_id", nullable = true)  // Nullable for employer posts
    private Alumni alumni;

    @ManyToOne
    @JoinColumn(name = "employer_id", nullable = true) // Nullable for alumni posts
    private Employer employer;  // Reference to Employer
    
	public Alumni getAlumni() {
		return alumni;
	}
	public void setAlumni(Alumni alumni) {
		this.alumni = alumni;
	}
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getApplyLink() {
		return applyLink;
	}
	public void setApplyLink(String applyLink) {
		this.applyLink = applyLink;
	}
    
    

	
}
