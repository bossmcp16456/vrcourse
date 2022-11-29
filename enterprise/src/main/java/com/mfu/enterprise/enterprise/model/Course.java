package com.mfu.enterprise.enterprise.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



    @Entity
    @Table(name = "COURSE")
    public class Course {
    
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        @Column(name="COURSE_ID")
        private Long id;
    
        @Column(name="NAME")
        private String name;
    
        @Column(name="PRICE")
        private int price;
    
        @ManyToOne
        @JoinColumn(name = "TEACHER_ID")
        private Teacher teacher;

        @JsonIgnore
        @OneToMany(mappedBy = "course")
        private Set<BookCourse> bookcourse;

    
        public Course() {}
    
        public Course(Long id, String name, int price) {
            this.id = id;
            this.name = name;      
            this.price = price;
        }
    
        public Course( String name, int price) {
            this(null, name, price);
        }
    
        public Long getId() {
            return id;
        }
       
        public String getName() {
            return name;
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
    
        public void setPrice(int price) {
            this.price = price;
        }

        public Teacher getTeacher() {
            return teacher;
        }

        public void setTeacher(Teacher teacher) {
            this.teacher = teacher;
        }

        public Set<BookCourse> getBookcourse() {
            return bookcourse;
        }

        public void setBookcourse(Set<BookCourse> bookcourse) {
            this.bookcourse = bookcourse;
        }
    }
