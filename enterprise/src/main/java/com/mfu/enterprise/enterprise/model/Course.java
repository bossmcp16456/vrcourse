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
    
        @Column(name="TEACHER_ID")
        private Long teacherid;
    
        @Column(name="PRICE")
        private int price;
    
        // @JsonIgnore
        // @OneToMany(mappedBy = "user")
        // private Set<Booking> booking;
    
        public Course() {}
    
        public Course(Long id, String name,Long teacherid, int price) {
            this.id = id;
            this.name = name;
            this.teacherid = teacherid;
            this.price = price;
        }
    
        public Course( String name,Long teacherid, int price) {
            this(null, name,teacherid, price);
        }
    
        public Long getId() {
            return id;
        }
       
        public String getName() {
            return name;
        }
    
        public Long getTeacherid() {
            return teacherid;
        }
    
        public int getPrice() {
            return price;
        }

        public void setId(Long id) {
            this.id = id;
        }   

        public void setName(String name) {
            this.name = name;
        }
    
        public void setTeacherid(Long teacherid) {
            this.teacherid = teacherid;
        }
    
        public void setPrice(int price) {
            this.price = price;
        }
    }
