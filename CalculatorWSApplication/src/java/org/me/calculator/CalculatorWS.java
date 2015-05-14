/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.calculator;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Junaid
 */
@WebService(serviceName = "CalculatorWS")
@Stateless()
public class CalculatorWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "add")
    public int add(@WebParam(name = "i") int i, @WebParam(name = "j") int j) {
        int k = i + j;
        return k;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "subtract")
    public int subtract(@WebParam(name = "i") int i, @WebParam(name = "j") int j) {
        int k = i - j;
        return k;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "multiply")
    public int multiply(@WebParam(name = "i") int i, @WebParam(name = "j") int j) {
        int k = i * j;
        return k;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "divide")
    public int divide(@WebParam(name = "i") int i, @WebParam(name = "j") int j) {
        int k = i / j;
        return k;
    }
}
