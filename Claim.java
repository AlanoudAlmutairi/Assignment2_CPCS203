
import java.util.Date;
import java.util.*;
/*
Name : Alanoud Owaed Almutairi
ID : 2105088
Section : BBR

*/

public class Claim {
    //Data field
    private long ClaimNo;
    private String location ;
    private Date claimDate;
    private boolean hasPremium;
    private boolean hasSpecialOffer;
    private InsuranceCoverage  insuranceCoverage ;
    private Car car ;
    private Owner owner ;
    //constructor
    public Claim (long ClaimNo, InsuranceCoverage  insuranceCoverage ,Car car ,Owner owner ,
            String location ,Date claimDate ,boolean hasPremium ,boolean hasSpecialOffer){
        this.ClaimNo = ClaimNo;
        this.insuranceCoverage= insuranceCoverage;
        this.car=car;
        this.owner=owner;
        this.location = location ;
        this.claimDate = claimDate ;
        this.hasPremium= hasPremium;
        this.hasSpecialOffer = hasSpecialOffer ;
        
    }
    //getter
    public long getClaimNo(){
        return ClaimNo; 
    }
    //setter
    public void setClimNo(long ClaimNo){
        this.ClaimNo = ClaimNo;
    }
    //getter
    public InsuranceCoverage getInsuranceCoverage(){
        return  insuranceCoverage ;
    } 
   //setter
    public void setInsuranceCoverage(InsuranceCoverage insuranceCoverage){
    this.insuranceCoverage =  insuranceCoverage ;
    
    }
    //getter
    public Car getCar(){
        return car;
        
    }
        //setter
     public void setCar(Car car ){
         this.car = car ;
     }    
    //getter
     public Owner getOwner(){
         return owner ;
     } 
   //setter
     public void setOwner(Owner owner){
             this.owner = owner;
         }   
     //getter
   public String getLocation (){
       return location ;
   } 
   //setter
   public void setLocation (String location ){
       this.location = location;
   }
   //getter
   public Date getClaimDate(){
       return claimDate;
   }
   //setter
   public void setClaimDate (Date ClaimDate){
       this.claimDate = ClaimDate;
   }
   //getter
  public boolean getHasPremiumInsurance(){
      return hasPremium  ;
  }
   //setter
 public void setHasPreiumInsurance(boolean hasPremium){
     this.hasPremium = hasPremium ;
 }
  
   //getter
   public boolean getHasSpecialOffer(){
       return hasSpecialOffer;
   }
   //setter
   public void setHasSpecialOffer(boolean hasSpecialOffer){
       this.hasSpecialOffer = hasSpecialOffer;
   }
        //here calculate the final anount     
    public double CalculateFinalClaimAmount(){
        double total = getInsuranceCoverage().getAmount();
        
        if(hasPremium)
         total+=200;   
        
        if(hasSpecialOffer)
            total+=100;
         
       Date current = new Date ();
       double Age = (current.getYear()+1900)-(owner.getDob().getYear()+1900);
       if( Age >= 60)
         total+=50; 
       
  return total;  
}}
