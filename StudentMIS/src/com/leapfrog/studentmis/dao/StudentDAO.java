/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.studentmis.dao;

import com.leapfrog.studentmis.entity.Student;
import java.util.ArrayList;

/**
 *
 * @author Annoyin
 */
public interface StudentDAO {
    void add(Student s);
    boolean delete(int id);
    ArrayList<Student> getAll();
    Student getById(int id);
   void getByAny(String param);
    Student getByEmail(String email);
    boolean checkEmail(String email);
    

}
