package com.mfu.enterprise.enterprise.model;


import javax.persistence.*;

    @Entity
    @Table(name = "BOOKCOURSE")
    public class BookCourse {
    
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        @Column(name="BOOKCOURSE_ID")
        private Long id;

        @ManyToOne
        @JoinColumn(name = "COURSE_ID")
        private Course course;

        @ManyToOne
        @JoinColumn(name = "USER_ID")
        private User user;

        @Column(name="DATETIME")
        private String datetime;
        
    
        public BookCourse() {}
    
        public BookCourse(Long id, String datetime) {
            this.id = id;
           
            this.datetime = datetime;
        }
    
        public BookCourse( String datetime) {
            this(null,  datetime);
        }
    
        public Long getId() {
            return id;
        }
        
        public String getDatetime() {
            return datetime;
        }

        public void setId(Long id) {
            this.id = id;
        }        
    
        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public Course getCourse() {
            return course;
        }

        public void setCourse(Course course) {
            this.course = course;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }
