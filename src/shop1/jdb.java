/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

 

public class jdb {
    Connection xc;
Statement st;
String st1[];
    
    
    jdb(){

try{
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    xc = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName=shop1; user=sa; password=123;");
    st = xc.createStatement();
        System.out.println("Successfull");  } // try
 catch(Exception e)
 {
        System.out.println("Error is " +e);
 
 }
} // login constru
 
    public String[] getst(String cod){  // edit
   try{ 
       
    st1=new String[8];
       
    int unit,stk; 
    String name;
    //,,sgen,srel,sadd,sh,sr ;
            int cel;
                    //String gen;
                    //String name; 
    ResultSet rs2=st.executeQuery("select * from  t1 where code='"+cod+"'"); 
    while (rs2.next()){
    //=rs2.getInt(1);
     name=rs2.getString(2);  
     unit=rs2.getInt(3);
     stk=rs2.getInt(4);
       
       st1[0]=name;
       st1[1]=Integer.toString(unit); 
       st1[2]=Integer.toString(stk);
        
          
    }
     return st1;
   }
catch(Exception e){
    System.out.println(e);
return null;}      
}
    
    
}
