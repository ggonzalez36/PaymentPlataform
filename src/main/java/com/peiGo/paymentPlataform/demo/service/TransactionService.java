package com.peiGo.paymentPlataform.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peiGo.paymentPlataform.demo.entity.OriginAccount;
import com.peiGo.paymentPlataform.demo.repository.AccountRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private AccountRepository studentRepository;

    @Transactional
    public String createStudent(OriginAccount student){
        try {
            if (!studentRepository.existsByEmail(student.getEmail())){
                student.setId(null == studentRepository.findMaxId()? 0 : studentRepository.findMaxId() + 1);
                studentRepository.save(student);
                return "Student record created successfully.";
            }else {
                return "Student already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }

    public List<OriginAccount> readStudents(){
        return studentRepository.findAll();
    }

    @Transactional
    public String updateStudent(OriginAccount student){
        if (studentRepository.existsByEmail(student.getEmail())){
            try {
                List<OriginAccount> students = studentRepository.findByEmail(student.getEmail());
                students.stream().forEach(s -> {
                    OriginAccount studentToBeUpdate = studentRepository.findById(s.getId()).get();
                    studentToBeUpdate.setName(student.getName());
                    studentToBeUpdate.setEmail(student.getEmail());
                    studentRepository.save(studentToBeUpdate);
                });
                return "Student record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "Student does not exists in the database.";
        }
    }

    @Transactional
    public String deleteStudent(OriginAccount student){
        if (studentRepository.existsByEmail(student.getEmail())){
            try {
                List<OriginAccount> students = studentRepository.findByEmail(student.getEmail());
                students.stream().forEach(s -> {
                    studentRepository.delete(s);
                });
                return "Student record deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "Student does not exist";
        }
    }
}
