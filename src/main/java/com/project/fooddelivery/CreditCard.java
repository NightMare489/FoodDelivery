
package com.project.fooddelivery;
import org.bson.Document;

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

    public CreditCard makeCreditCardFromObject(Document doc){
        
        setCardnum(doc.getString("Cardnum"));
        setCVV(doc.getString("CVV"));
        setExpMonth(doc.getString("ExpMonth"));
        setExpYear(doc.getString("ExpYear"));
        return this;

    }

    
    public Document MakeDocument(){
        
        Document CreditCardDoc = new Document("Cardnum", getCardnum())
                .append("CVV", getCVV())
                .append("ExpMonth", getExpMonth())
                .append("ExpYear",getExpYear());
        
        return CreditCardDoc;
    }

    
}
