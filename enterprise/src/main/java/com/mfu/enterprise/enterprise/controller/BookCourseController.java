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
public class BookCourseController {
  
  @Autowired
  private BookCourseRepository bookcourseRepo;
  
  @GetMapping("/getAllBookcourses")
  public ResponseEntity<List<BookCourse>> getAllUsers() {
	  try {
		  List<BookCourse> bookcourseList = new ArrayList<>();
		  bookcourseRepo.findAll().forEach(bookcourseList::add);
		  
		  if(bookcourseList.isEmpty()) {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  return new ResponseEntity<>(bookcourseList, HttpStatus.OK);
	  }catch(Exception e) {
		  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
  }
  
  @GetMapping("/getBookcourseById/{id}")
  public ResponseEntity<BookCourse> getUserById(@PathVariable Long id) {
	  Optional<BookCourse> BookCourseData = bookcourseRepo.findById(id);
	  
	  if(BookCourseData.isPresent()) {
		  return new ResponseEntity<>(BookCourseData.get(), HttpStatus.OK);
	  }
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  
  @PostMapping("/addBookcourse")
  public ResponseEntity<BookCourse> addUser(@RequestBody BookCourse bookcourse) {
	  BookCourse bookcourseObj = bookcourseRepo.save(bookcourse);
	  
	  return new ResponseEntity<>(bookcourseObj, HttpStatus.OK);
  }
  
  @PostMapping("/updateCourseById/{id}")
  public ResponseEntity<BookCourse> updateUserById(@PathVariable Long id, @RequestBody BookCourse newBookcourseData) {
	  Optional<BookCourse> oldBookcourseData = bookcourseRepo.findById(id);
	  
	  if(oldBookcourseData.isPresent()) {
        BookCourse updatedBookcourseData = oldBookcourseData.get();
        updatedBookcourseData.setDatetime(newBookcourseData.getDatetime());
       
		  
		  BookCourse bookcourseObj = bookcourseRepo.save(updatedBookcourseData);
		  return new ResponseEntity<>(bookcourseObj, HttpStatus.OK);
	  }
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  
  @DeleteMapping("/deleteBookcourseById/{id}")
  public ResponseEntity<HttpStatus> deleteBookcourseById(@PathVariable Long id) {
	  bookcourseRepo.deleteById(id);
	  return new ResponseEntity<>(HttpStatus.OK);
  }
}
