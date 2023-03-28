package com.myblog.blogapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//handle exception in webservices
@ResponseStatus(value = HttpStatus.NOT_FOUND)//whenever record is not found obj of this class created and it give customize exception
public class ResourceNotFoundException extends RuntimeException{//1st step make child class of  RuntimeException
    private String resourceName;  //what msg u want to display
    private String fieldName;
    private long fieldValue;



    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {//constractor
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue)); // exmple:Post not found with id : 1
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
        public String getResourceName() {
            return resourceName;
        }

        public String getFieldName() {
            return fieldName;
        }

        public long getFieldValue() {
            return fieldValue;
        }


  }


