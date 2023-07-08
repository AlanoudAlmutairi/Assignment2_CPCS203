
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
/*
Name : Alanoud Owaed Almutairi
ID : 2105088
Section : BBR

*/


public class ProcessClaim {
   public static void main (String[]arges) throws FileNotFoundException, ParseException{
       
       //File 1 :creat file one (inputCICSDate) object + creat scanner and prentwriter
          File f1 = new File ("inputCICSData.txt") ;
          Scanner input_F1= new Scanner(f1);
          File output_F1 = new File ("CICSDatabase.txt") ;
          PrintWriter output =new PrintWriter(output_F1);
        if(!f1.exists()){
           System.out.println("The file"+f1.getName()+  "is not exists ");
         System.exit(0);
       }
      
      //creat an Arrays and but a size for each one 
      int regCar =input_F1.nextInt();
      int OwnerNO = input_F1.nextInt();
      int insurance_coveragesNo =input_F1.nextInt();
      Car [] registeredCars = new Car[regCar] ;
      Owner [] own = new Owner [OwnerNO];
      InsuranceCoverage[]insurance_coverages = new InsuranceCoverage[insurance_coveragesNo];
        
    // read command from file one + print first File 
      String command ;
      output.println("--------------- Welcome to CICS  Database ---------------");
      output.println();
     command = input_F1.next();
      do{  
          //read car information from file one
           if(command.equalsIgnoreCase("AddCar")){
            for(int i = 0 ; i <registeredCars.length ; i++){
                registeredCars[i]= getCar(input_F1) ;
              output.println( registeredCars[i].toString());
              output.println("------------------------------------------------------");
              command = input_F1.next();
           }}
           // read and print owner information 
           else if(command.equalsIgnoreCase("AddOwner")){
            for(int i =0 ; i<own.length; i++){
                own[i] = getOwner(input_F1);
                command = input_F1.next();
           }}
           //read and print Insurance Coverage
           else if (command.equalsIgnoreCase("AddInsuranceCoverage")){
                 for (int i =0 ; i<insurance_coverages.length;i++){
                   
                    insurance_coverages[i]= getInsuranceCoverage(input_F1);
                    output.println(insurance_coverages[i].toString());
                    output.println("------------------------------------------------------");
                    command = input_F1.next();
     }
                 //print owner information 
                 for(int i = 0 ; i<own.length;i++){
                     output.println(own[i].toString());
                     output.println("------------------------------------------------------");
                 }
                   }
                           
   }   while(!command.equalsIgnoreCase("Quit"));
      input_F1.close();
      output.close();
      
///File 2 :creat file two (inputClaims) object + creat scanner and prentwriter
        File f2 = new File ("inputClaims.txt") ;
        if(!f2.exists()){
           System.out.println("The file"+f2.getName()+  "is not exists ");
       System.exit(0);
       }
      Scanner input_F2= new Scanner(f2);
      File Output_F2 = new File ("ClaimInvoices.txt") ;
      PrintWriter output_F2 =new PrintWriter(Output_F2);
      //creat an Arrays and but a size for each one 
      int ClaimNum = input_F2.nextInt();
       Claim [] claim  = new Claim [ClaimNum]; 
       
       //read command from file 2  + print second File 
       
       
       command = input_F2.next();
      do{
          //read data from file 2 and print claim information 
          if(command.equalsIgnoreCase("ProcessClaim")){
              for (int i = 0 ; i<ClaimNum ; i++){
             claim[i]= GenerateClaim(input_F2,insurance_coverages ,registeredCars , own,output_F2 );
                command = input_F2.next();
          }
        }
          
      }while(!command.equalsIgnoreCase("Quit"));
      PrintClaim( output_F2 ,  claim ,own);
      
    input_F2.close();
    output_F2.flush();
    output_F2.close();
       
   }
//------------------------------------------------------------------------------
private static Car getCar(Scanner input_F1 ){
//this methode read all car information and creat an object (object type : Car) 
     String CarPlateNo=input_F1.next(); 
     String CarType= input_F1.next();
     String Brand =input_F1.next();
     String CarModle=input_F1.next() ;
     String CarColor =input_F1.next();
     int BuiltYear=input_F1.nextInt();
    Car GCar = new Car (CarPlateNo, CarType,Brand, CarModle,CarColor, BuiltYear);
  return GCar;
}
//------------------------------------------------------------------------------
private static InsuranceCoverage getInsuranceCoverage(Scanner input_F1){
//this methode read all  Insurance Coverage information and creat an object (object type : InsuranceCoverage) and return it 
    InsuranceCoverage coverage = new InsuranceCoverage ( input_F1.next(), input_F1.next(),input_F1.nextDouble()) ;
    return coverage;
}
//------------------------------------------------------------------------------
private static Owner getOwner(Scanner input_F1) throws ParseException{ 
    //this methode read all  owner information and creat an object (object type:Owner)  and return it         
    String nationalID = input_F1.next();
               String First_Name =input_F1.next();
               String Last_Name =input_F1.next();
               String Date = input_F1.next()+"-"+input_F1.next()+"-"+input_F1.next();
               SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
               Date dob = format.parse(Date);
    
    Owner own = new Owner(nationalID ,First_Name ,Last_Name , dob); 
           return own ;
}

//------------------------------------------------------------------------------
private static Claim GenerateClaim(Scanner input_F2, InsuranceCoverage[] insurance_Coverage, Car[] registeredCars, Owner[] own,PrintWriter output_F2) throws ParseException{
       ////this methode read all  claim information and creat an object (object type : Claim)  and return it     
    InsuranceCoverage insurance_Coverage1 = serchCoverage(input_F2.next(),insurance_Coverage);
    Car registeredCars1 =serchPlate (input_F2.next(),registeredCars );
    Owner own1 =serchID (input_F2.next(),own );
    String location = input_F2.next();
    String Date = input_F2.next()+"-"+input_F2.next()+"-"+input_F2.next();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date claimDate = format.parse(Date);
    boolean hasPremium = input_F2.nextBoolean();
    boolean hasSpecialOffer = input_F2.nextBoolean();
    long claimNo =System.currentTimeMillis();
Claim claim = new Claim(claimNo, insurance_Coverage1 , registeredCars1 , own1 , location ,claimDate , hasPremium , hasSpecialOffer);
return claim ;
}

//------------------------------------------------------------------------------

public static void PrintClaim(PrintWriter output_F2 , Claim[] claim ,Owner[]own){
  //this methode print the second file (claim information)
   
    output_F2.println("--------------- Welcome to Traffic Claim System ---------------");
    output_F2.println();
    for(Claim claim1 : claim){
        output_F2.println("Invoice No. "+claim1.getClaimNo());
        output_F2.println("Insurance Coverage Details");
        output_F2.println("\tInsurance Coverage Code: "+claim1.getInsuranceCoverage().getInsuranceCoverageCode());
        output_F2.println("\tInsurance Coverage Description: "+claim1.getInsuranceCoverage().getDiscripition().replaceAll("_", " "));
        output_F2.println("\tInsurance Coverage Penalty: "+claim1.getInsuranceCoverage().getAmount());
        output_F2.println();
        output_F2.println("Car Details");
        output_F2.println("\tNumber Plate: " +claim1.getCar().getCarPlateNo() );
        output_F2.println("\tType: "+claim1.getCar().getCarType());
        output_F2.println("\tBrand: "+claim1.getCar().getBrand());
        output_F2.println("\tModel: "+claim1.getCar().getCarModle());
        output_F2.println("\tColor: "+claim1.getCar().getCarColor());
        output_F2.println("\tBuilt Year: "+claim1.getCar().getBuiltYear());
        output_F2.println();
        output_F2.println("Owner Details");
        output_F2.println("\tNational ID: "+claim1.getOwner().getNationalID());
        output_F2.println("\tFull Name: "+claim1.getOwner().getFirst_Name()+" "+claim1.getOwner().getLast_Name());
        output_F2.println();
        output_F2.println("Claim Details");
       SimpleDateFormat format = new SimpleDateFormat("yyyy-dd-MM");
        String Date = format.format(claim1.getClaimDate());
        output_F2.println("\tDate: "+Date);
        output_F2.println("\tLocation: "+claim1.getLocation());
        output_F2.println();
        output_F2.println("Total Amount: "+claim1.CalculateFinalClaimAmount());
        output_F2.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
       
    }
    output_F2.println("--------Total claim(s) by owner--------");
    //here I invoc this method to calculate number of insurance covarege per owner
  NumOfInsuranceCoverageperOwner(output_F2 ,own ,claim  ) ;
}
//------------------------------------------------------------------------------
public static void NumOfInsuranceCoverageperOwner(PrintWriter output_F2 , Owner [] own,Claim [] claim  ){
  //this method calculate the number of Insurance Coverage for each owner and print the data in second file  
    output_F2.println("Owner ID             Owner Name            Total Claim(s)");
 for(int i =0 ; i<own.length;i++){
     int num = 0;
     for(int j = 0 ; j<claim.length;j++){
         if(own[i].getNationalID().equals(claim[j].getOwner().getNationalID()))
             num++;
     }
       output_F2.println(own[i].getNationalID() +"\t\t  "  + own[i].getFirst_Name()+" "+own[i].getLast_Name() +"\t\t\t\t  " +num);
 }
    
}
//------------------------------------------------------------------------------
public static InsuranceCoverage serchCoverage(String code,InsuranceCoverage[] insurance_Coverage){
  // serch Insurance Coverage code method
    for (InsuranceCoverage insurance_Coverage1 : insurance_Coverage ){
        //if insurance_Coverage(code) that I read it from the file  equal to insurance_Coverage
       if(code.equals(insurance_Coverage1.getInsuranceCoverageCode()))
           //return an object (type InsuranceCoverage)
           return insurance_Coverage1;
   }  
return null ;
}
//------------------------------------------------------------------------------

public static Car serchPlate (String plate,Car[] registeredCars  ){
    // // serch  Car Plate Number method
   for(Car registeredCars1 : registeredCars){
       //if plate number that I read it from the file is equal to plate number that stored in registeredCars
       if( plate.equals(registeredCars1.getCarPlateNo()))
           //return  object (type Car)
           return registeredCars1;
   }
  return null; 
}
//------------------------------------------------------------------------------
public static Owner serchID ( String ID, Owner[]own ){
   //  serch ID method
    for(Owner own1 : own){
        //if ID that I read it from the file equal to ID that stored in the own
      if(ID.equals(own1.getNationalID()))
          //return object ( type Owner)
          return own1;
  }
    return null;
}
}


