package team7.vlu.sevenworkout;

public class Daily {
    private String number;
    private String textNumber;

    public Daily(String number, String textNumber) {
        this.number = number;
        this.textNumber = textNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTextNumber() {
        return textNumber;
    }

    public void setTextNumber(String textNumber) {
        this.textNumber = textNumber;
    }
}
