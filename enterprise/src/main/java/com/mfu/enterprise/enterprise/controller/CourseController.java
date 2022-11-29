package com.mfu.enterprise.enterprise.controller;

import com.mfu.enterprise.enterprise.repository.*;
import com.mfu.enterprise.enterprise.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {
  
  @Autowired
  private CourseRepository courseRepo;
  
  @GetMapping("/getAllCourses")
  public ResponseEntity<List<Course>> getAllUsers() {
	  try {
		  List<Course> courseList = new ArrayList<>();
		  courseRepo.findAll().forEach(courseList::add);
		  
		  if(courseList.isEmpty()) {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  return new ResponseEntity<>(courseList, HttpStatus.OK);
	  }catch(Exception e) {
		  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
  }
  
  @GetMapping("/getCourseById/{id}")
  public ResponseEntity<Course> getUserById(@PathVariable Long id) {
	  Optional<Course> CourseData = courseRepo.findById(id);
	  
	  if(CourseData.isPresent()) {
		  return new ResponseEntity<>(CourseData.get(), HttpStatus.OK);
	  }
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  
  @PostMapping("/addCourse")
  public ResponseEntity<Course> addUser(@RequestBody Course course) {
	  Course courseObj = courseRepo.save(course);
	  
	  return new ResponseEntity<>(courseObj, HttpStatus.OK);
  }
  
  @PostMapping("/updateCourseById/{id}")
  public ResponseEntity<Course> updateUserById(@PathVariable Long id, @RequestBody Course newCourseData) {
	  Optional<Course> oldCourseData = courseRepo.findById(id);
	  
	  if(oldCourseData.isPresent()) {
		  Course updatedCourseData = oldCourseData.get();
		  updatedCourseData.setName(newCourseData.getName());
		  updatedCourseData.setPrice(newCourseData.getPrice());
		  
		  Course courseObj = courseRepo.save(updatedCourseData);
		  return new ResponseEntity<>(courseObj, HttpStatus.OK);
	  }
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  
  @DeleteMapping("/deleteCourseById/{id}")
  public ResponseEntity<HttpStatus> deleteCourseById(@PathVariable Long id) {
	  courseRepo.deleteById(id);
	  return new ResponseEntity<>(HttpStatus.OK);
  }
}
