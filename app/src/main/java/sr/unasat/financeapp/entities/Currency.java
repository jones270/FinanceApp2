package sr.unasat.financeapp.entities;

/**
 * Created by JTA on 3/20/18.
 */

public class Currency {
    private String name;
    private String symbol;
    private String code;
    private String symbol_native;
    private String decimal_digits;
    private String rounding;

    public Currency(String symbol, String code, String symbol_native, String decimal_digits, String rounding) {
        this.symbol = symbol;
        this.code = code;
        this.symbol_native = symbol_native;
        this.decimal_digits = decimal_digits;
        this.rounding = rounding;
    }

    public Currency(){

    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol_native() {
        return symbol_native;
    }

    public void setSymbol_native(String symbol_native) {
        this.symbol_native = symbol_native;
    }

    public String getDecimal_digits() {
        return decimal_digits;
    }

    public void setDecimal_digits(String decimal_digits) {
        this.decimal_digits = decimal_digits;
    }

    public String getRounding() {
        return rounding;
    }

    public void setRounding(String rounding) {
        this.rounding = rounding;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "symbol='" + symbol + '\'' +
                ", code='" + code + '\'' +
                ", symbol_native='" + symbol_native + '\'' +
                ", decimal_digits='" + decimal_digits + '\'' +
                ", rounding='" + rounding + '\'' +
                '}';
    }
}
