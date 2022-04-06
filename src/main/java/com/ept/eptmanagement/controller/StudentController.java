//package com.ept.eptmanagement.controller;
//
//
//import com.ept.eptmanagement.model.Offre;
//import com.ept.eptmanagement.model.Student;
//import com.ept.eptmanagement.model.User;
//import com.ept.eptmanagement.service.OffreService;
//import com.ept.eptmanagement.service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin
//@RequestMapping("student")
//public class StudentController {
//
//    @Autowired
//    private OffreService offreService;
//    @Autowired
//    private StudentService studentService;

//    @PostMapping
//    public ResponseEntity<User> saveStudent(@PathVariable Student student) {
//        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.Created);
//    }

//    public Student saveStudent(Student student){
//        Student newStudent = new Student();
//        newStudent.setOption(student.getOption());
//        newStudent.setAddress(student.getAddress());
//        newStudent.setGender(student.getGender());
//        newStudent.setPhoneNumber(student.getPhoneNumber());
//        newStudent.setFirstName(student.getFirstName());
//        newStudent.setLastName(student.getLastName());
//        newStudent.setPassword(student.getPassword());
//        newStudent.setEmail(student.getEmail());
//        newStudent.setBirthday(student.getBirthday());
//        newStudent.setCity(student.getCity());
//        newStudent.setCountry(student.getCountry());
//        newStudent.getOffres()
//                .addAll(student
//                        .getOffres()
//                        .stream()
//                        .map( o -> {
//                            Offre oo =OffreService.findOffreById(o.findById())
//                                }
//                        ))
//
//
//
//
//    }
//
//}
