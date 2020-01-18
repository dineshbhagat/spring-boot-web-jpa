package com.example.notepad.jsonviews;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

/**
 * Ref:https://www.baeldung.com/jackson-json-view-annotation,
 * https://stackoverflow.com/q/38279782/2987755
 */
public class OrgViewsClient {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }


/*    public static void main(String[] args) throws Exception {
        Employee employee = new Employee("DB", "Localhost", "CXX", 1024 * 1024 * 1024, "Healthy");

        System.out.println(objectMapper.writeValueAsString(employee));
        //{"name":"DB","address":"Localhost","designation":"CXX","salary":1073741824,"medicalHistory" : "Healthy"}

        operateOnView(employee, OrgViews.Views.PERSONAL);
        operateOnView(employee, OrgViews.Views.INTERNAL);
        operateOnView(employee, OrgViews.Views.PUBLIC);
    }*/

    private static void operateOnView(Employee employee, OrgViews.Views view) throws IOException {
        System.out.println("-------------- " + view + "----------------");
        String str = OrgViews.serialize(employee, view);
        System.out.println("Serialized:" + str);

        Employee e1 = OrgViews.<Employee>deSerialize(Employee.class, str, view);
        System.out.println("De-serialized");
        System.out.println("Name:" + e1.getName());
        System.out.println("Address:" + e1.getAddress());
        System.out.println("Designation:" + e1.getDesignation());
        System.out.println("Salary:" + e1.getSalary());
        System.out.println("MedicalHistory:" + e1.getMedicalHistory());
        System.out.println("------------------------------");
    }

    /*

    {
  "name" : "DB",
  "address" : "Localhost",
  "designation" : "CXX",
  "salary" : 1073741824,
  "medicalHistory" : "Healthy"
}
-------------- PERSONAL----------------
Serialized:{"name":"DB","address":"Localhost","designation":"CXX","salary":1073741824,"medicalHistory":"Healthy"}
De-serialized
Name:DB
Address:Localhost
Designation:CXX
Salary:1073741824
MedicalHistory:Healthy
------------------------------
-------------- INTERNAL----------------
Serialized:{"name":"DB","address":"Localhost","designation":"CXX"}
De-serialized
Name:DB
Address:Localhost
Designation:CXX
Salary:0
MedicalHistory:null
------------------------------
-------------- PUBLIC----------------
Serialized:{"name":"DB","designation":"CXX"}
De-serialized
Name:DB
Address:null
Designation:CXX
Salary:0
MedicalHistory:null
------------------------------
     */
}
