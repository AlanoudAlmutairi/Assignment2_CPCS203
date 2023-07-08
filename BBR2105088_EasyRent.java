/*
Name : Alanoud Owaed Almutairi
ID :2105088
Section : BBR
 */
package bbr2105088_easyrent;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class BBR2105088_EasyRent {

   
    public static void main(String[] args) throws FileNotFoundException {
     
   File f = new File ("inputCICSData.txt") ;
        if(!f.exists()){
           System.out.println("The file"+f.getName()+  "is not exists ");
       System.exit(0);
       }
      Scanner input= new Scanner(f);
      File output1 = new File ("output1.txt") ;
      PrintWriter output =new PrintWriter(output1);
      
      int regCar =input.nextInt();
      int OwnerNO = input.nextInt();
      int insurance_coveragesNo =input.nextInt();
       
       String command = input.next();
  
      
       while(!command.equalsIgnoreCase("Quit")){
           
           if(command.equalsIgnoreCase("AddCar"))
            AddCar(input ,  output);
           
           else if(command.equalsIgnoreCase("AddOwner"))
            AddOwner ( input , output);
           
           else if (command.equalsIgnoreCase("AddInsuranceCoverage"))
               AddInsuranceCoverage( input , output);            
   }
       
       
       
               
               
       //inputClaims
       
   }
   
public static void AddCar( Scanner input , PrintWriter output){
             String PlateNo =input.next();
             String CarType = input.next();
             String Brand = input.next();
             String CarModle = input.next();
             String CarColor = input.next();
             int BuiltYear = input.nextInt();
             Car carr = new Car (PlateNo ,CarType, Brand , CarModle ,CarColor , BuiltYear);
              output.print(carr.toString());
              output.print("------------------------------------------------------");
             
           }
//------------------------------------------------------------------------------------------------

public static void AddOwner (Scanner input , PrintWriter output){
     String nationalID = input.next();
               String First_Name =input.next();
               String Last_Name =input.next();
             //  Date dob = input.nextLong();
               Owner owner = new Owner(nationalID,First_Name,Last_Name,dob);
           
}

//----------------------------------------------------------------------------------------------------
public static void AddInsuranceCoverage(Scanner input , PrintWriter output){
      int insuranceCoverageCode = input.nextInt();
      String descripition = input.next();
      double amount =input.nextDouble();
      
      InsuranceCoverage cov = new InsuranceCoverage( insuranceCoverageCode ,descripition,amount);
      output.print(cov.toString());
      output.print("------------------------------------------------------");
}    
    
}