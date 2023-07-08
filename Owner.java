
import java.util.Date;


/*
Name : Alanoud Owaed Almutairi
ID : 2105088
Section : BBR

*/

public class Owner {
    //Data field 
    private String nationalID ;
    private String First_Name ;
    private String Last_Name ;
    private Date dob ;
    //costructor
    public Owner (String nationalID ,String First_Name ,
   String Last_Name , Date dob ){
   this.nationalID = nationalID ;
   this.First_Name = First_Name ;
   this.Last_Name = Last_Name ;
   this.dob= dob;
}

   
//getter
    public String getNationalID(){
        return nationalID ; 
    }
//setter
    public  void setNationalID (String nationalID){
        this.nationalID = nationalID ;
    }
    //getter
    public String getFirst_Name (){
        return First_Name ;
    }
    //setter
    public void setFirst_Name (String First_Name){
        this.First_Name = First_Name ;
    }
//getter
    public String getLast_Name (){
        return Last_Name ;
    }
    //setter
    public void steLast_Name (String Last_Name){
        this.Last_Name=Last_Name ;
    }
    //getter
    public Date getDob(){
        return dob ;
    }
    //setter
    public void setDob(Date dob){
        this.dob = dob;
    }
   //to String  
    public String toString (){
        return "\tOwner ID: " + nationalID + "\tName: " +  getFirst_Name () + " " + getLast_Name();
    }
    
    

}

