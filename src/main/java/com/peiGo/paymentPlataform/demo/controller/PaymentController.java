package com.peiGo.paymentPlataform.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.peiGo.paymentPlataform.demo.entity.OriginAccount;
import com.peiGo.paymentPlataform.demo.service.StudentService;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(){
        return "The application is up...";
    }

    @RequestMapping(value = "createstudent", method = RequestMethod.POST)
    public String createStudent(@RequestBody OriginAccount student){
        return studentService.createStudent(student);
    }

    @RequestMapping(value = "readstudents", method = RequestMethod.GET)
    public List<OriginAccount> readStudents(){
        return studentService.readStudents();
    }

    @RequestMapping(value = "updatestudent", method = RequestMethod.PUT)
    public String updateStudet(@RequestBody OriginAccount student){
        return studentService.updateStudent(student);
    }

    @RequestMapping(value = "deletestudent", method = RequestMethod.DELETE)
    public String deleteStudent(@RequestBody OriginAccount student){
        return studentService.deleteStudent(student);
    }
}
