/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SyedQadil
 */
public class mdb { 
 
    Connection connection = null;  
     ResultSet resultSet = null;  
     Statement st = null; 
     
     
     PreparedStatement updatinv=null;  
 
mdb(){    

      
     

     try 
     {  
         Class.forName("org.sqlite.JDBC");  
         connection = DriverManager.getConnection("jdbc:sqlite:shopdb.db");  
         st = connection.createStatement(); 
         
         
         resultSet =st.executeQuery("select * from t3 ");
                 while(resultSet.next()){
                 String s=resultSet.getString(2);
                 System.out.println(s);
                 }
         
     } 
     catch (Exception e) 
     {  
         e.printStackTrace();  
     }

}


Boolean ret=false;

 public Boolean verify(String email){  // verify
   try{ 
        
        
    ResultSet rs2=st.executeQuery("select * from  t4 where email='"+email+"'"); 
    while (rs2.next())
    {
        String ss=rs2.getString(3);
        if (ss.equalsIgnoreCase(email))
        {ret =true; }
        else ret=false; 
      
      
    }
   return ret;
   }
catch(Exception e)
{
 
 System.out.println(e);
 return ret=false;
 
}      
} // verify
 int inn=9;
 public int loginb(String emailp, String passs){  // login2
  
     try{ 
     String emp=null ;  
     Boolean ret=false; 
     
    ResultSet rs2=st.executeQuery("select * from  t4 where email='"+emailp+"'"); 
    while (rs2.next())
  {
      inn=8;
      emp=rs2.getString(2);
      ret=true;
      
      if(ret==true) {
   if(emp.equalsIgnoreCase(passs)){ inn=2; } 
   else 
   {inn=1;
   System.out.println(""+emp+""+passs);}
                  }
   else inn=-1;
                }
    
   return inn; } //try
    
   
catch(Exception e)
{
 
 System.out.println(e);
 return inn; 
}      
} // login2
 
 String st1[];
  public String[] getst(String cod){  // item
   try{ 
       
    st1=new String[8];
     Boolean ok=false;  
    int unit,stk; 
    String name;
    //,,sgen,srel,sadd,sh,sr ;
            int cel;
                    //String gen;
                    //String name; 
    ResultSet rs2=st.executeQuery("select * from  t3  where code='"+cod+"'"); 
    while (rs2.next()){ 
       ok=true; 
     name=rs2.getString(2);  
     unit=rs2.getInt(3);
     stk=rs2.getInt(4);
       //JOptionPane.showMessageDialog(null, "ok  Code");
       st1[0]=name;
       st1[1]=Integer.toString(unit); 
       st1[2]=Integer.toString(stk);
        
    } // wile
    
   // if(ok==false){JOptionPane.showMessageDialog(null, "Sorry Inavalid Code");}
    
     return st1;
   }
catch(Exception e){
    System.out.println(e);
return null;}      
} // getitem
  
 
  
  // insert recrd invoice
  public void addrcd(int a,int b,int c,int d,String co,String dd){
 
 
 try {
     
     int i=st.executeUpdate("insert into t6 values('"+a+"','"+b+"','"+c+"','"+d+"','"+co+"','"+dd+"') "); 
     
     if (i>-1){JOptionPane.showMessageDialog(null, "Successfully Updated");}
 
     
   }
catch(Exception e){
    System.out.println(e);
 }      
 } 
  
  // insert
  
  // getsaled  
  int isal,isalm;
  
  public int getsal(String dat){
  
  
 
 try {
     
     
      ResultSet rs2=st.executeQuery("select * from  t8 where date='"+dat+"'"); 
    while (rs2.next())
   {
       
      isal=rs2.getInt(2); 
       }  
 
     return isal;
   }
catch(Exception e){
    System.out.println("Sorry Invalid Date");
return isal;}      
 
 
 
 
 } 
  // get saled end
  
  // getsaled mnth
  
  public int getsalm(String dat){
  
  
 
 try {
     
      ResultSet rs2=st.executeQuery(" select * from  t9 where month='"+dat+"'  "); 
    while (rs2.next()){ 
        isalm=rs2.getInt(2); 
         System.out.println("Sorry Invalid");
       }  
 
     return isalm;
   }
catch(Exception e){
    System.out.println("Sorry Invalid Date");
return isalm;}      
 
 
 
 
 } 
  // get saled end mnth
  
  
  // up sale mnth
   public void upsalm (String d,int saled){
     try { 
         
         int ii=st.executeUpdate("update t9 set sale='"+saled+"' where Month='"+d+"'  "); 
     
     if (ii>-1){JOptionPane.showMessageDialog(null, "Successfully Updated");}
     }
     catch (Exception ee){
    System.out.println(ee);}
     
     
   }
  // up sale mnth
  
  
   public void upsale (String d,int saled){
     try { 
         
         int ii=st.executeUpdate("update t8 set sale='"+saled+"' where date='"+d+"'  "); 
     
     if (ii>-1){JOptionPane.showMessageDialog(null, "Successfully Updated");}
     }
     catch (Exception ee){
    System.out.println(ee);}
     
     
   }
  
   
   // ad mnth
   public int adsalm(String d,int saled){
 
 int i=-1;
 try {
     
      i=st.executeUpdate("insert into t9 values('"+d+"','"+saled+"')  "); 
     
     if (i>-1){JOptionPane.showMessageDialog(null, "Successfully Add");}
   return i;  
 }
catch(Exception e){
    System.out.println(e);
      return i;  
 }      
 } 
  
  // insert
   // add mnth
  
  public int adsale(String d,int saled){
 
 int i=-1;
 try {
     
      i=st.executeUpdate("insert into t8 values('"+d+"','"+saled+"')  "); 
     
     if (i>-1){JOptionPane.showMessageDialog(null, "Successfully Add");}
   return i;  
 }
catch(Exception e){
    System.out.println(e);
      return i;  
 }      
 } 
  
  // insert
  
  // inv
    public void upinv(int i){
try { 
  int re=st.executeUpdate("update t7 set inv='"+i+"' "); 
updatinv=connection.prepareStatement(
         "update t7 set inv=? ");
      
      updatinv.setInt(1,i); 
      updatinv.executeUpdate();
  

  if(re>-1){JOptionPane.showMessageDialog(null, "Successfully Updated");}
   }

 
catch(Exception ex){ 
   JOptionPane.showMessageDialog(null, "Sorry Error ");
   
     }
  }
  
 public int getinv(){
 int i=6; 
 
 Boolean t=false;
 
 try {
     
    ResultSet rs2=st.executeQuery("select * from  t7  "); 
    while (rs2.next()){ 
        i=rs2.getInt(1);
       
       }  
 
     return i;
   }
catch(Exception e){
    System.out.println(e);
return i;}      
 
 
 
 
 } 
 
  
  // show
  public void show(JTable j){ 
    
try{ 
    int rol;
    int i=0;
    String rid,nam,fnam,sid,gen,add,hid;
            int cel;
      
   // ResultSet rs2=st.executeQuery("select sum (cel) from tb1 order by cel");
    ResultSet rs2=st.executeQuery("select * from  student");
    while (rs2.next()){
     sid=rs2.getString(1);
     nam=rs2.getString(2);
     cel=rs2.getInt(3);
        hid=rs2.getString(4);
          rid=rs2.getString(5);
     fnam=rs2.getString(6);
      gen=rs2.getString(7); 
     add=rs2.getString(8);
     
     
     j.setValueAt( i+1,i, 0);
     
     j.setValueAt( sid,i, 1);
     j.setValueAt( nam,i, 2);
      j.setValueAt( fnam,i, 3);
       j.setValueAt( cel,i, 4);
        j.setValueAt( add,i, 5);
      
       j.setValueAt( hid,i, 6);
        j.setValueAt( rid,i, 7);
        i++;
    }

//String nm=rs2.getString(1);
   // int rol=rs2.getInt(1);
    //int mar=rs2.getInt(3);
    // st1=new String[5];   
    //System.out.println(rs2);
    //System.out.println("\n name "+nm+"\"d\n"
   // +"roll" +rol+"\n marks "+mar );
    
    
//int a=st.executeUpdate("insert into tb1 values ('jh"+price+"',8,4)");   
//if(a > -1)   {return true;}
 //else{ return false;} 
 
}
catch(Exception e){
    System.out.println(e);
//return false;

}
} // show method

// new show 
public void shown(JTable j){

    //String [] st=new String[];
    
try{ 
    
    DefaultTableModel mod= (DefaultTableModel) j.getModel();
    j.revalidate();
    j.repaint();
    
        for(int i=1;i<=mod.getRowCount();i++){
    j.remove(i);
    }
    
    int uni,qty; 
    String cod,nam;
    String []star=new String[4];    
    
    ResultSet rs2=st.executeQuery("select * from  t3 "); 
    while (rs2.next()){
     cod=rs2.getString(1);
     nam=rs2.getString(2);
     uni=rs2.getInt(3);
     qty=rs2.getInt(4);  
         
        star[0]=cod;
        star[1]=nam;
        star[2]=Integer.toString(uni);
        star[3]=Integer.toString(qty);
         
       
        mod.addRow(star); 
      
      
    }

 
}
catch(Exception e){
    System.out.println(e);
//return false;

}
} // new show
 
// new show 
public void showncusto(JTable j){

    //String [] st=new String[];
    
try{ 
    
    DefaultTableModel mod= (DefaultTableModel) j.getModel();
    j.revalidate();
    j.repaint();
    
        for(int i=1;i<=mod.getRowCount();i++){
    j.remove(i);
    }
    
    int cod,balanc; 
    String nam,emaill;
    String []star=new String[4];    
    
    ResultSet rs2=st.executeQuery("select * from  t10 "); 
    while (rs2.next()){
     cod=rs2.getInt(1);
     nam=rs2.getString(2);
     emaill=rs2.getString(3);
     balanc=rs2.getInt(4);  
         
        star[0]=Integer.toString(cod);
        star[1]=nam;
        star[2]= emaill;
        star[3]=Integer.toString(balanc);
         
       
        mod.addRow(star); 
      
      
    }

 
}
catch(Exception e){
    System.out.println(e);
//return false;

}
} // new showpeople
 



// daily saled 
public void dailysale(JTable j){

    //String [] st=new String[];
    
try{ 
    
    DefaultTableModel mod= (DefaultTableModel) j.getModel();
    j.revalidate();
    j.repaint();
    
        for(int i=1;i<mod.getRowCount();i++){
    j.remove(i);
    }
    
    int amount; 
    String dat;
    String []star=new String[2];    
    
    ResultSet rs2=st.executeQuery("select * from  t8 "); 
    while (rs2.next()){
     
     dat=rs2.getString(1);  
     amount=rs2.getInt(2);
     
        star[0]=dat;
        star[1]=Integer.toString(amount); 
        mod.addRow(star); 
      
      }

 
}
catch(Exception e){
    System.out.println(e);
//return false;

}
} 
// daily saled

// inv rcrd
//  
public void invrcdc(int i,String c,JTable j){

    //String [] st=new String[];
   
try{ 
    
    DefaultTableModel mod= (DefaultTableModel) j.getModel();
    j.revalidate();
    j.repaint();
 ((DefaultTableModel)j.getModel()).setNumRows(0);  
      
   
    
    int inv,t,pay,bl;
    String cod,dat;
    String []star=new String[6];    
    
    ResultSet rs2=st.executeQuery("select * from  t6 where code='"+c+"'"); 
    while (rs2.next()){
     
       
       
     inv=rs2.getInt(1);
     t=rs2.getInt(2);
     pay=rs2.getInt(3);
     bl=rs2.getInt(4);
     cod=rs2.getString(5);
     dat=rs2.getString(6);
     
         
        star[0]=Integer.toString(inv);  
        star[1]=Integer.toString(t); 
        star[2]=Integer.toString(pay); 
        star[3]=Integer.toString(bl);
        star[4]=cod;
        star[5]=dat;
        
        mod.addRow(star); 
      
      }

 
}
catch(Exception e){
    System.out.println(e);
//return false;

}
} 
// daily saled

// inv rcrd
//  
public void serinvbydat(String c,JTable j){

    //String [] st=new String[];
   
try{ 
    
    DefaultTableModel mod= (DefaultTableModel) j.getModel();
    j.revalidate();
    j.repaint();
 ((DefaultTableModel)j.getModel()).setNumRows(0);  
      
   
    
    int inv,t,pay,bl;
    String cod,dat;
    String []star=new String[6];    
    
    ResultSet rs2=st.executeQuery("select * from  t6 where date like '"+c+"%' "); 
    while (rs2.next()){
     
       System.out.print("ok like code");
       
     inv=rs2.getInt(1);
     t=rs2.getInt(2);
     pay=rs2.getInt(3);
     bl=rs2.getInt(4);
     cod=rs2.getString(5);
     dat=rs2.getString(6);
     
         
        star[0]=Integer.toString(inv);  
        star[1]=Integer.toString(t); 
        star[2]=Integer.toString(pay); 
        star[3]=Integer.toString(bl);
        star[4]=cod;
        star[5]=dat;
        
        mod.addRow(star); 
      
      }

 
}
catch(Exception e){
    System.out.println(e);
//return false;

}
} 
// inv by dat

 
//
 public int login(String email, String passs){  // login
 int i=9;
     try{ 
     String pas=null ;  
     Boolean ret=false;
     
    ResultSet rs2=st.executeQuery("select * from  t4 where email='ali'"); 
    while (rs2.next())
  {
      i=8;
      pas=rs2.getString("pass");
      ret=true;
      
      if(ret==true) {
   if(pas.equalsIgnoreCase(passs)){ i=2; } 
   else i=1;
                  }
   else i=-1;
                }
    
   return i+3; } //try
    
   
catch(Exception e)
{
 
 System.out.println(e);
 return i; 
}      
} // verify
 
 // cutmtr
 public Boolean custo(String email, String pass){  
  Boolean i=false;
     try{ 
     String pas=null ;   
     
    ResultSet rs2=st.executeQuery("select * from  t4 where email='"+email+"'"); 
    while (rs2.next())
  {
      pas=rs2.getString(2);
      i=true;
                }
    
    
   return i; } //try
    
   
catch(Exception e)
{
 
 System.out.println(e);
 return i; 
}      
}  
 // customer
 
 
 public boolean add(String a,String b,String c,int cel,String d,String e,String f,String g,String h,String i){
try {
  int re=st.executeUpdate("insert into t4 values('"+a+"','"+b+"','"+c+"','"+cel+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"')");   

  if(re>-1){JOptionPane.showMessageDialog(null, "Successfully Registration");}
  if(re > -1)   {return true; }

else{ return false;
  
  } 
  
}
catch(Exception ex){ 
   JOptionPane.showMessageDialog(null, "Sorry This Email is Already");
  //JOptionPane.showMessageDialog(null, ex);
return false;    }

} // add

    // add customr
  
  public void addcusto(String n,String em,int bl){
 
 int i=-1;
 try {
     
       i=st.executeUpdate("insert into t10 values(null,'"+n+"','"+em+"','"+bl+"')  "); 
     
     if (i>-1){JOptionPane.showMessageDialog(null, "Successfully Add People");}
   
 }
catch(Exception e){
    System.out.println(e);
    JOptionPane.showMessageDialog(null, "Sorry not added customer");
     
 }      
 } 
  
  // insert customr
  
  
  // show customr
  public void showcusto(JTable j){

    //String [] st=new String[];
    
try{ 
    
    DefaultTableModel mod= (DefaultTableModel) j.getModel();
    j.revalidate();
    j.repaint();
    
        for(int i=1;i<mod.getRowCount();i++){
     mod.removeRow(i);
    }
    
    int cod,bl; 
    String nam,eml;
    String []star=new String[4];    
    
    ResultSet rs2=st.executeQuery("select * from  t10 "); 
    while (rs2.next()){
     
       
     cod=rs2.getInt(1);
     nam=rs2.getString(2); 
     eml=rs2.getString(3);  
     bl=rs2.getInt(4);
     
        star[0]=Integer.toString(cod);
        star[1]=nam;
        star[2]=eml;
        star[3]=Integer.toString(bl); 
        mod.addRow(star); 
      
      }

 
}
catch(Exception e){
    System.out.println(e);
//return false;

}
}  
  // show customer
  
   // serch customr
  public void sercusto(int c,JTable j){

    //String [] st=new String[];
    int rz=-1;
try{ 
    
    DefaultTableModel mod= (DefaultTableModel) j.getModel();
    j.revalidate();
    
    
    int cod,bl; 
    String nam,eml;
    String []star=new String[4];    
    
    ResultSet rs2=st.executeQuery("select * from  t10 where code='"+c+"'"); 
    while (rs2.next()){
     
       rz=1;
     cod=rs2.getInt(1);
     nam=rs2.getString(2); 
     eml=rs2.getString(3);  
     bl=rs2.getInt(4);
     
        star[0]=Integer.toString(cod);
        star[1]=nam;
        star[2]=eml;
        star[3]=Integer.toString(bl); 
        mod.addRow(star); 
      
      }
if(rz==-1){JOptionPane.showMessageDialog(null, "Sorry! invalid Code");}
 
}
catch(Exception e){
    JOptionPane.showMessageDialog(null, "Sorry! invalid Code");
      

}
}  
  // serch customer
  
   // updat customr
  
  public void updtcusto(int c,String n,String em,int bl){
 
 int i=-1;
 try {
     
       i=st.executeUpdate("update t10 set name='"+n+"' , email='"+em+"', balance='"+bl+"' where code='"+c+"'  "); 
     
     if (i>-1){JOptionPane.showMessageDialog(null, "Successfully updated People");}
   
 }
catch(Exception e){
    System.out.println(e);
     
 }      
 } 
  
  // update customr
  
  // remv custo
  public boolean rmvcusto(int m){
   // int nb=m;
try { 
  int a=st.executeUpdate("delete from t10 where code='"+m+"'");   

  
  if(a>-1){JOptionPane.showMessageDialog(null, "Success fully");}
  else  {JOptionPane.showMessageDialog(null, "Invalid ID\n Sorry");}
  
  if(a > -1)   {return true;
  
  //JOptionPane.showMessageDialog(null, "Su");
  }

else{ return false;}
   
}
catch(Exception e){ 
   
  JOptionPane.showMessageDialog(null,  "Invalid ID\n Sorry");
return false;    }

} // delete
  //rmv customr
 
 //editget
 public String[] editg(int co){  // edit
   try{ 
       
       st1=new String[3];
       
    int bal; 
    String name,email;
             
    ResultSet rs2=st.executeQuery("select * from  t10 where code='"+co+"'"); 
    while (rs2.next()){
     
     name=rs2.getString(2);  
         email=rs2.getString(3);
         bal=rs2.getInt(4);
       
     st1[0]=name;
       st1[1]=email;
         st1[2]=Integer.toString(bal);
        }
     return st1;
   }
catch(Exception e){
    System.out.println(e);
return null;}      
}
 // edit get
 
 // updat itm
  
  public void updtitm(String a,String b,int c,int d ){
 
 int i=-1;
 try {
     
       i=st.executeUpdate("update t3 set   name='"+b+"', unit='"+c+"' , qty='"+d+"' where code='"+a+"'  "); 
     
     if (i>-1){JOptionPane.showMessageDialog(null, "Successfully updated item");}
   
 }
catch(Exception e){
    System.out.println(e);
     
 }      
 } 
  
  // update itm
 
 // add item
public boolean additem(String a,String b,int c,int d){
try {
  int re=st.executeUpdate("insert into t3 values('"+a+"','"+b+"','"+c+"' ,'"+d+"' )");   

  if(re>-1){JOptionPane.showMessageDialog(null, "Successfully Item Entered");}
  else { JOptionPane.showMessageDialog(null, "Sorry This Item is Already Exist");}
  
  if(re > -1)   {return true; }

else{ 
      
      return false;
  
  } 
  
}
catch(Exception ex){ 
    JOptionPane.showMessageDialog(null, "Sorry This Item is Already Exist");
 // JOptionPane.showMessageDialog(null, ex);
return false;    }

} // add itm


    
}
