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
    
       
    
        // @JsonIgnore
        // @OneToMany(mappedBy = "user")
        // private Set<Booking> booking;
    
        public Teacher() {}
    
        public Teacher(Long id, String name,String lastname) {
            this.id = id;
            this.name = name;
            this.lastname = lastname;
            
        }
    
        public Teacher(String name, String lastname) {
            this(null, name,lastname);
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
    
        

        public void setId(Long id) {
            this.id = id;
        }   

        public void setName(String name) {
            this.name = name;
        }
    
        public void setLastname(String lastname) {
            this.lastname = lastname;
        }
    
        
    }
