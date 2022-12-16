
package com.project.fooddelivery;
import org.json.JSONArray;

public class CreditCard {
    private String Cardnum;
    private String CVV,ExpMonth;
    private String ExpYear;


    public CreditCard(String Cardnum, String CVV, String ExpMonth, String ExpYear) {
        this.Cardnum = Cardnum;
        this.CVV = CVV;
        this.ExpMonth = ExpMonth;
        this.ExpYear = ExpYear;
    }
    public CreditCard(){

    }
    
    public String getExpYear() {
        return ExpYear;
    }
    public String getExpMonth() {
        return ExpMonth;
    }
    public String getCVV() {
        return CVV;
    }
    public String getCardnum() {
        return Cardnum;
    }

    private void setCardnum(String Cardnum) {
        this.Cardnum = Cardnum;
    }
    private void setExpYear(String ExpYear) {
        this.ExpYear = ExpYear;
    }
    private void setExpMonth(String ExpMonth) {
        this.ExpMonth = ExpMonth;
    }
    private void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public CreditCard makeCreditCardFromArray(JSONArray arr){
        
        setCardnum(arr.getString(0));
        setCVV(arr.getString(1));
        setExpMonth(arr.getString(2));
        setExpYear(arr.getString(3));
        return this;

    }

    
    public JSONArray MakeJSONarray(){
        JSONArray CreditCardArray = new JSONArray();
        CreditCardArray.put(getCardnum());
        CreditCardArray.put(getCVV());
        CreditCardArray.put(getExpMonth());
        CreditCardArray.put(getExpYear());
        return CreditCardArray;
    }



    
}
