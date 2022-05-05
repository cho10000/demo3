package com.example.demo.mapper;

import java.util.List;

import javax.servlet.http.Part;

import org.springframework.stereotype.Repository;

@Repository("TestMapper")
public interface TestMapper {

	    public List<Part> post();


}
