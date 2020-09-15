package com.sg.uib.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Admin  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAdmin;
    @Column(unique = true)
    private String email;
    @Column(nullable = true)
    private String firstName;
    @Column(nullable = true)
    private String lastName;
    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private String password;
    @Column(nullable = true)
    private String dateOfBirth;
    @Column(nullable = true)
    private String gender;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    public Admin() {

    }
    public Admin(String email, String firstName, String lastName, String password, String dateOfBirth, String gender, Collection<Role> roles) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.roles = roles;
    }

  

    public Admin(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

    public Admin(String email, String firstName, String lastName,String password, String dateOfBirth, String gender) {
        super();
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }


    public long getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(long idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

  
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}