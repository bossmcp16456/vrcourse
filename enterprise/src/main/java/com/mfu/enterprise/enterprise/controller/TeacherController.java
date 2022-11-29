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
public class TeacherController {
    @Autowired
  private TeacherRepository teacherRepo;
  
  @GetMapping("/getAllTeachers")
  public ResponseEntity<List<Teacher>> getAllUsers() {
	  try {
		  List<Teacher> teacherList = new ArrayList<>();
		  teacherRepo.findAll().forEach(teacherList::add);
		  
		  if(teacherList.isEmpty()) {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  return new ResponseEntity<>(teacherList, HttpStatus.OK);
	  }catch(Exception e) {
		  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
  }
  
  @GetMapping("/getTeacherById/{id}")
  public ResponseEntity<Teacher> getUserById(@PathVariable Long id) {
	  Optional<Teacher> teacherData = teacherRepo.findById(id);
	  
	  if(teacherData.isPresent()) {
		  return new ResponseEntity<>(teacherData.get(), HttpStatus.OK);
	  }
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  
  @PostMapping("/addTeacher")
  public ResponseEntity<Teacher> addUser(@RequestBody Teacher teacher) {
    Teacher teacherObj = teacherRepo.save(teacher);
	  
	  return new ResponseEntity<>(teacherObj, HttpStatus.OK);
  }
  
  @PostMapping("/updateTeacherById/{id}")
  public ResponseEntity<Teacher> updateUserById(@PathVariable Long id, @RequestBody Teacher newTeacherData) {
	  Optional<Teacher> oldTeacherData = teacherRepo.findById(id);
	  
	  if(oldTeacherData.isPresent()) {
        Teacher updatedTeacherData = oldTeacherData.get();
		  updatedTeacherData.setName(newTeacherData.getName());
		  updatedTeacherData.setLastname(newTeacherData.getLastname());
		  
		  Teacher teacherObj = teacherRepo.save(updatedTeacherData);
		  return new ResponseEntity<>(teacherObj, HttpStatus.OK);
	  }
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  
  @DeleteMapping("/deleteTeacherById/{id}")
  public ResponseEntity<HttpStatus> deleteTeacherById(@PathVariable Long id) {
	  teacherRepo.deleteById(id);
	  return new ResponseEntity<>(HttpStatus.OK);
  }
}
