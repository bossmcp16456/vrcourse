package com.mfu.enterprise.enterprise.model;

import javax.persistence.*;

    @Entity
    @Table(name = "TEACHER")
    public class Teacher {
    
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        @Column(name="TEACHER_ID")
        private Long id;
    
        @Column(name="NAME")
        private String name;
    
        @Column(name="LASTNAME")
        private String lastname;
    
        @Column(name="COURSE_ID")
        private Long courseid;
    
        // @JsonIgnore
        // @OneToMany(mappedBy = "user")
        // private Set<Booking> booking;
    
        public Teacher() {}
    
        public Teacher(Long id, String name,String lastname, Long courseid) {
            this.id = id;
            this.name = name;
            this.lastname = lastname;
            this.courseid = courseid;
        }
    
        public Teacher(String name, String lastname, Long courseid) {
            this(null, name,lastname, courseid);
        }
    
        public Long getId() {
            return id;
        }
       
        public String getName() {
            return name;
        }
    
        public String getLastname() {
            return lastname;
        }
    
        public Long getCourseid() {
            return courseid;
        }

        public void setId(Long id) {
            this.id = id;
        }   

        public void setName(String name) {
            this.name = name;
        }
    
        public void setLastname(String lastname) {
            this.lastname = lastname;
        }
    
        public void setCourseid(Long courseid) {
            this.courseid = courseid;
        }
    }
