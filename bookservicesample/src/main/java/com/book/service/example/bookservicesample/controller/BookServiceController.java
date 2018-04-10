package com.book.service.example.bookservicesample.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.book.service.example.bookservicesample.dto.Book;

@RestController
public class BookServiceController {

	private static Map<String, List<Book>> bookDB = new HashMap<String, List<Book>>();
	 
    static {
    	bookDB = new HashMap<String, List<Book>>();
 
        List<Book> lst = new ArrayList();
        Book std = new Book(1,"java",50.0, "Class IV");
        lst.add(std);
        std = new Book(1,"C++",100.0, "Class V");
        lst.add(std);
 
        bookDB.put("chittoor", lst);
 
        lst = new ArrayList<Book>();
        std = new Book(3,"spring boot",50.0, "latha");
        lst.add(std);
        std = new Book(4,"Angularjs",50.0, "deepak");
        lst.add(std);
 
        bookDB.put("chennai", lst);
 
    }
 
    @RequestMapping(value = "/getBook/{schoolname}", method = RequestMethod.GET)
    public List<Book> getStudents(@PathVariable String schoolname) {
        System.out.println("Getting Student details for " + schoolname);
 
        List<Book> studentList = bookDB.get(schoolname);
        if (studentList == null) {
            studentList = new ArrayList<Book>();
            Book std = new Book(5,"not found",50.0, "");
            studentList.add(std);
        }
        return studentList;
    }
    
   
}
	

