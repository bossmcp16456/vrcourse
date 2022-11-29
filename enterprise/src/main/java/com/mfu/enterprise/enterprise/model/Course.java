package com.mfu.enterprise.enterprise.model;

import javax.persistence.*;



    @Entity
    @Table(name = "COURSE")
    public class Course {
    
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        @Column(name="COURSE_ID")
        private Long id;
    
        @Column(name="NAME")
        private String name;
    
        @Column(name="USERNAME")
        private String username;
    
        @Column(name="PASSWORD")
        private String password;
    
        // @JsonIgnore
        // @OneToMany(mappedBy = "user")
        // private Set<Booking> booking;
    
        public Course() {}
    
        public Course(Long id, String name,String username, String password) {
            this.id = id;
            this.name = name;
            this.username = username;
            this.password = password;
        }
    
        public Course(String name, String username, String password) {
            this(null, name,username, password);
        }
    
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        // public Set<Booking> getBooking() {
        //     return booking;
        // }
    
        // public void setBooking(Set<Booking> booking) {
        //     this.booking = booking;
        // }
    
        public String getUsername() {
            return username;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public void setUsername(String username) {
            this.username = username;
        }
    
        public String getPassword() {
            return password;
        }
    
        public void setPassword(String password) {
            this.password = password;
        }
    }
