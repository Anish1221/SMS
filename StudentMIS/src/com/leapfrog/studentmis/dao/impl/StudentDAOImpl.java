/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.studentmis.dao.impl;

import com.leapfrog.studentmis.dao.StudentDAO;
import com.leapfrog.studentmis.entity.Student;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Annoyin
 */
public class StudentDAOImpl implements StudentDAO {

    private final ArrayList<Student> stdlist = new ArrayList<>();

    @Override
    public void add(Student s) {

        stdlist.add(s);

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        for (int i = 0; i < stdlist.size(); i++) {
            if (stdlist.get(i) != null && stdlist.get(i).getId() == id) {
                stdlist.set(i, null);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Student> getAll() {
        return stdlist;
    }

    @Override
    public Student getById(int id) {
        for (Student s : stdlist) {
            if (s != null && s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void getByAny(String param) {
        int count = 0;
        for (Student s : stdlist) {
            if (s != null && ((s.getFirstName().equalsIgnoreCase(param)) ||(s.getLastName().equalsIgnoreCase(param)) ||(s.getEmail().equalsIgnoreCase(param))) ){
                System.out.println(s.getBeh());
                 count++;       }
            
        }
        if(count==0){
            System.out.println("NOt Found");
        }
        
    }

    @Override
    public Student getByEmail(String email) {
        for (Student s : stdlist) {
            if (s != null && s.getEmail() == email) {
                return s;
            }
        }

        return null;
    }

    @Override
    public boolean checkEmail(String email) {
        for (Student s : stdlist) {
            if (s.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }

        return false;

    }
}
