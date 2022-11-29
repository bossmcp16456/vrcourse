package com.mfu.enterprise.enterprise.model;

import java.util.Date;

import javax.persistence.*;

    @Entity
    @Table(name = "BOOKCOURSE")
    public class BookCourse {
    
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        @Column(name="BOOKCOURSE_ID")
        private Long id;
    
        @Column(name="USER_ID")
        private Long userid;
    
        @Column(name="COURSE_ID")
        private Long courseid;
    
        @Column(name="DATETIME")
        private Date datetime;
    
    
        public BookCourse() {}
    
        public BookCourse(Long id, Long userid,Long courseid, Date datetime) {
            this.id = id;
            this.userid = userid;
            this.courseid = courseid;
            this.datetime = datetime;
        }
    
        public BookCourse(Long userid, Long courseid, Date datetime) {
            this(null, userid,courseid, datetime);
        }
    
        public Long getId() {
            return id;
        }
       
        public Long getUserid() {
            return userid;
        }
    
        public Long getCourseid() {
            return courseid;
        }
    
        public Date getDatetime() {
            return datetime;
        }

        public void setId(Long id) {
            this.id = id;
        }   

        public void setUserid(Long userid) {
            this.userid = userid;
        }
    
        public void setCourseid(Long courseid) {
            this.courseid = courseid;
        }
    
        public void setDatetime(Date datetime) {
            this.datetime = datetime;
        }
    }
