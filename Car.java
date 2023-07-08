
/*
Name : Alanoud Owaed Almutairi
ID : 2105088
Section : BBR

*/

public class Car {
//Date feild
    private String CarPlateNo ;
    private String CarType ;
    private String Brand ;
    private String CarModle ;
    private String CarColor ;
    private int BuiltYear ;
    
    
    //costructor
    public Car (String PlateNo , String CarType,
        String Brand , String CarModle ,String CarColor , int BuiltYear ){
        this.CarPlateNo = PlateNo;
        this.CarType = CarType ;
        this.Brand = Brand;
        this.CarModle= CarModle ;
        this.CarColor = CarColor ;
        this.BuiltYear = BuiltYear ;      
    }
    //getter
    public String getCarPlateNo (){
        return CarPlateNo ;
    }
    //seter
    public void setCarPlateNo(String CarPlateNo){
        this.CarPlateNo = CarPlateNo;
    }
    //getter
    public String getBrand (){
        return Brand ;
    }
    //setter
    public void setBrand(String Brand ){
        this.Brand=Brand ;
    }
    //getter
    public String getCarType(){
        return CarType;
    }
    //setter
    public void setCarType (String CarType){
        this.CarType = CarType ;
    }
    //getter
    public String getCarModle (){
        return CarModle ;
    }
    //setter
    public void setCarModel (String CarModle ){
        this.CarModle = CarModle ;
    }
    //getter
    public String getCarColor (){
        return CarColor ;
    }
    //setter
    public void setCarColor (String CarColor){
        this.CarColor = CarColor ;
    }
    //getter
    public int getBuiltYear (){
        return BuiltYear ;
    }
    //setter
    public void setBuiltYear (int BuiltYear){
        this.BuiltYear = BuiltYear ;
    }
    // 
    public String toString(){
        return "\tCar No.: "+CarPlateNo +"\tType: "+CarType+
        "\tBrand: "+Brand + "\tModel: "+CarModle + "\tColor: "+CarColor + "\tMfg. Year: "+BuiltYear;
    }



    
}
