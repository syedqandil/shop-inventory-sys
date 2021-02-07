/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop1;

import java.util.ArrayList;

/**
 *
 * @author SyedQadil
 */ 
 

public class Shop1 {
 
   //String[] unit=new String[10]; 
    ArrayList <Object> unit=new ArrayList<Object> (); 
    ArrayList <Object> name=new ArrayList<Object> ();
    ArrayList <Object> stck=new ArrayList<Object> ();
    ArrayList <Object> code=new ArrayList<Object> ();
    ArrayList <Object> tot=new ArrayList<Object> ();
    
  public void setv(String a,String b,String c,String d, String e){
    unit.add(a);
    name.add(b);
    stck.add(c);
    code.add(d);
    code.add(e);
    }
  
public String getunit(int i){
   String s=(String)unit.get(i);
    return  s;
    }  

public String gettot(int i){
   String s=(String)tot.get(i);
    return  s;
    }

public String getname(int i){
   String s=(String)name.get(i);
    return  s;
    }  

public String getstck(int i){
   String s=(String)stck.get(i);
    return  s;
    }  

public String getcode(int i){
   String s=(String)code.get(i);
    return  s;
    }  
  
    public static void main(String[] args) {
        // TODO code application logic here
        
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new f1().setVisible(true);
            }
        }); 
    }
    
}

  


