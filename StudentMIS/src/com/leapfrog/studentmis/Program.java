/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.studentmis;

import com.leapfrog.studentmis.dao.StudentDAO;
import com.leapfrog.studentmis.dao.impl.StudentDAOImpl;
import com.leapfrog.studentmis.entity.Student;
import com.sun.image.codec.jpeg.JPEGQTable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Annoyin
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        StudentDAO stdDAO = new StudentDAOImpl();

        while (true) {
            System.out.println("Menu");
            System.out.println("1.Add");
            System.out.println("2.Delete");
            System.out.println("3.Show All");
            System.out.println("4.Search By ID");
            System.out.println("5.Search By Any");
            System.out.println("6.Search By Email");
            System.out.println("7.Exit");
            System.out.println("Enter your choice[1-7]");
            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    while (true) {
                        Student s = new Student();
                        String email;
                        System.out.println("Enter your First Name");
                        s.setFirstName(input.next());

                        System.out.println("Enter your Last Name");
                        s.setLastName(input.next());
                        while (true) {
                            System.out.println("Enter your Email");
                            email = input.next();

                            if (!stdDAO.checkEmail(email)) {
                                break;
                            }
                            System.out.println("Email Address Already Taken.");

                        }

                        s.setId(stdDAO.getAll().size() + 1);
                        stdDAO.add(new Student(s.getId(), s.getFirstName(), s.getLastName(), email));

                        System.out.println("Do you want to add more??:[Y/N]");
                        String ch = input.next();
                        if (ch.equalsIgnoreCase("n")) {
                            break;
                        }

                    }
                    break;

                case 2:
                    while (true) {
                        System.out.println("Enter id to delete:");
                        int delid = input.nextInt();
                        System.out.println(stdDAO.getById(delid).getBeh());
                        System.out.println("Are you sure to delete id " + delid + " [y/n]");
                        String decide = input.next();
                        if (!decide.equalsIgnoreCase("n")) {
                            stdDAO.delete(delid);
                            System.out.println("Id " + delid + " Deleted");
                        }

                        System.out.println("Do you want to delete more data??:[Y/N]");
                        String ch = input.next();
                        if (ch.equalsIgnoreCase("n")) {
                            break;
                        }
                    }
                    break;

                case 3:
                    stdDAO.getAll().forEach(a -> {
                        if (a != null) {
                            System.out.println(a.getId() + "," + a.getFirstName() + "," + a.getLastName() + "," + a.getEmail());
                        } else if (stdDAO.getAll().size() < 1) {
                            System.out.println("No data added");
                        }
                    });
                    break;

                case 4:
                    while (true) {
                        System.out.println("To Search Data-> Enter id:");
                        int srid = input.nextInt();
                        Student a = stdDAO.getById(srid);
                        if (a != null) {
                            System.out.println(a.getBeh());
                        } else {
                            System.out.println("Not Found");
                        }
                        System.out.println("Do you want to search by id again??:[Y/N]");
                        String ch = input.next();
                        if (ch.equalsIgnoreCase("n")) {
                            break;
                        }

                    }
                    break;

                case 5:
                    while (true) {
                        System.out.print("To Search Data-> Enter any field :  ");
                        String any = input.next();
                        stdDAO.getByAny(any);

                        System.out.println("Do you want to Search again??:[Y/N]");
                        String ch = input.next();
                        if (ch.equalsIgnoreCase("n")) {
                            break;
                        }

                    }
                    break;

                case 6:
                    while (true) {
                        System.out.println("To Search Data-> Enter Email");
                        String eml = input.next();
                        Student e = stdDAO.getByEmail(eml);
                        if (e != null) {
                            System.out.println(e.getBeh());
                        } else {
                            System.out.println("Not Found");
                        }

                        System.out.println("Do you want to Search by email again??:[Y/N]");
                        String ch = input.next();
                        if (ch.equalsIgnoreCase("n")) {
                            break;
                        }
                    }
                    break;

                case 7:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
            System.out.println("Go back to Menu:[Y/N]");
            String ch = input.next();
            if (ch.equalsIgnoreCase("n")) {
                System.exit(0);
            }

        }

    }
}
