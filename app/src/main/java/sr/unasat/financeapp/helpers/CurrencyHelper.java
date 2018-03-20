package sr.unasat.financeapp.helpers;


import java.text.NumberFormat;

public class CurrencyHelper {

    public static String returnStringCurrency(double amount){
        //SRD
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(amount);
    }
}
