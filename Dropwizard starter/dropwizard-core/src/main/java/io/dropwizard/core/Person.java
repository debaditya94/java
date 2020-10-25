package io.dropwizard.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GeneratedType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

@Entity
@table(name = "people")
@NamedQueries(
	{
		@NamedQuery(
			name = "io.dropwizard.core.Person.findAll",
			query = "SELECT p from Person p"
		)
	}
)
public class Person {
	@Id
	@GeneratedValue(strategy = GeneratedType.IDENTITY)
	private long id;
	
	@Column(name = "fullName", nullable = false)
	private String fullName;
	
	@Column(name = "jobTitle", nullable = false)
	private String jobTitle;
	
	@Column(name = "yearBorn")
	@Min(value = 0)
	@Max(value = 9999)
	private int yearBorn;
	
	public Person() {
		
	}
	
	public Person(String fullName, String jobTitle, int yearBorn) {
		this.fullName = fullName;
		this.jobTitle = jobTitle;
		this.yearBorn = yearBorn;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getJobTitle() {
		return jobTitle;
	}
	
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public long getYearBorn() {
		return yearBorn;
	}
	
	public void setYearBorn(int yearBorn) {
		this.yearBorn = yearBorn;
	}
	
	@Override
	public Boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Person)) return false;
		
		Person person = (Person) o;
		return id == person.id &&
				yearBorn == person.yearBorn &&
				Objects.equals(fullName, person.fullName) &&
				Objects.equals(yearBorn, person.yearBorn);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, fullName, jobTitle, yearBorn);
	}
}
