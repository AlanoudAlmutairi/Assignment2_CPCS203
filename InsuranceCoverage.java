
/*
Name : Alanoud Owaed Almutairi
ID : 2105088
Section : BBR

*/
public class InsuranceCoverage {
 //Data feld
    private String insuranceCoverageCode ;
    private String descripition ;
    private double amount ;
    //constructor 
    public InsuranceCoverage(String insuranceCoverageCode , String descripition, double amount){
        this.insuranceCoverageCode =insuranceCoverageCode ;
        this.descripition =descripition;
        this.amount=amount; 
                }

 
    //getter
    public String getInsuranceCoverageCode(){
        return insuranceCoverageCode;
    }
    //setter
    public void setInsuranceCoverageCode(String insuranceCoverageCode){
        this.insuranceCoverageCode =insuranceCoverageCode;
    }
    //getter
    public String getDiscripition(){
        return descripition ;
    }
    //setter
    public void setDiscripition(String discripition){
        this.descripition = descripition ;
    }
    //getter
    public double getAmount (){
        return amount ;
    }
    //setter
    public void setAmount(double amount){
        this.amount=amount;
    }
    //to String 
    public String toString(){
        return "\tInsuranceCoverage Code: "+getInsuranceCoverageCode()
                +"\tInsuranceCoverage Description: "+getDiscripition().replaceAll("_", " ");
    }

    
    
    
}
