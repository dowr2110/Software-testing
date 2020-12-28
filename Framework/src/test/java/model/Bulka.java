package model;


import java.util.Objects;

public class Bulka {

    private String nameOfBulka;
    private String countOfBulka;
    private String costOfBulka;
    private String errorMessage;


    public Bulka(String name, String count, String cost, String errorMessage) {
        this.nameOfBulka = name;
        this.countOfBulka = count;
        this.costOfBulka = cost;
        this.errorMessage=errorMessage;
    }

    public String getNameOfBulka() {
        return nameOfBulka;
    }

    public void setNameOfBulka(String nameOfBulka) {
        this.nameOfBulka = nameOfBulka;
    }

    public String getCountOfBulka() {
        return countOfBulka;
    }

    public void setCountOfBulka(String countOfBulka) {
        this.countOfBulka = countOfBulka;
    }

    public String getCostOfBulka() {
        return costOfBulka;
    }

    public void setCostOfBulka(String costOfBulka) {
        this.costOfBulka = costOfBulka;
    }

    public String getErrorMessageInPage() {
        return errorMessage;
    }

    public void setErrorMessageInPage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "Bulka{" +
                "name='" + nameOfBulka + '\'' +
                ", count='" + countOfBulka + '\'' +
                ", cost='" + costOfBulka + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bulka)) return false;
        Bulka bulka = (Bulka) o;
        return Objects.equals(getNameOfBulka(), bulka.getNameOfBulka()) &&
                Objects.equals(getCountOfBulka(), bulka.getCountOfBulka())&&
                Objects.equals(getCostOfBulka(), bulka.getCostOfBulka())&&
                        Objects.equals(getErrorMessageInPage(), bulka.getErrorMessageInPage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameOfBulka(), getCountOfBulka(), getCostOfBulka() ,getErrorMessageInPage());
    }
}