package br.edu.ifnmg.pfms;

public class Phone {
    private Byte areaCode;
    private Integer number;

    public Phone(Byte areaCode, Integer number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    @Override
    public String toString() {
        // format number as xxx-xxx-xxx or xxxx-xxxx
        String numberString = this.number.toString();
        if (numberString.length() == 8) {
            numberString = numberString.substring(0, 4) + "-" + numberString.substring(4, 8);
        } else if (numberString.length() == 9) {
            numberString = numberString.substring(0, 3) + "-" + numberString.substring(3, 6) + "-" + numberString.substring(6, 9);
        }
        return "(" + this.areaCode + ") " + numberString;
    }
}
