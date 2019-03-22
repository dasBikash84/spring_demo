package com.dasbikash.rest_demo.advice;

import com.dasbikash.rest_demo.exceptions.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
class EmployeeNotFoundAdvice {

    //@ResponseBody
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(EmployeeNotFoundException ex) {
        return ex.getMessage();
    }

	/*
	 * @ResponseBody
	 * 
	 * @ExceptionHandler(Throwable.class)
	 * 
	 * @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) String
	 * internalErrorHandler(Throwable ex) { return ex.getMessage(); }
	 */
}
