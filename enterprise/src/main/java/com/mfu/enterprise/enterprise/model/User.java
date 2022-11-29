package com.mfu.enterprise.enterprise.model;

import java.util.Set;

// import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

// import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="USER_ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="LASTNAME")
    private String lastname;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="EMAIL")
    private String email;

    @Column(name="GENDER")
    private String gender;

    @Column(name="TELEPHONE")
    private String telephone;


    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<BookCourse> bookcourse;


    public User() {}

    public User(Long id, String name,String lastname, String password,String email,String gender,String telephone) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.telephone = telephone;
        
    }

    public User(String name, String lastname, String password,String email,String gender,String telephone) {
        this(null, name,lastname, password,email,gender,telephone);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    
}