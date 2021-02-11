package com.example.healthyeats;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class jsonReader
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader= new FileReader("db-recipes.json"))
        {
            Object obj  = jsonParser.parse(reader);
            JSONArray recipieList =  (JSONArray) obj;
            recipieList.forEach( rep -> parseEmployeeObject( (JSONObject) rep ) );
        
            //Read JSON file
           /* Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);

            //Iterate over employee array
            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseEmployeeObject(JSONObject employee)
    {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("id44");

        //Get employee first name
        String firstName = (String) employeeObject.get("id");
        System.out.println(firstName);

        //Get employee last name
       // String lastName = (String) employeeObject.get("lastName");
      //  System.out.println(lastName);

        //Get employee website name
      //  String website = (String) employeeObject.get("website");
       // System.out.println(website);
    }
}