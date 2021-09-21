package fr.audrain.appcoeur;

public class Person {
    //Main
    private String name;

    //I am
    private boolean sexe;
    private int age;

    //My Heart
    private boolean heart_condition, diabetic, family, cholesterol;

    //Doctor
    private String cardioRisk;
    private boolean checkup, seeCardio;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSexe() {
        return sexe;
    }

    public void setSexe(boolean sexe) {
        this.sexe = sexe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHeart_condition() {
        return heart_condition;
    }

    public void setHeart_condition(boolean heart_condition) {
        this.heart_condition = heart_condition;
    }

    public boolean isDiabetic() {
        return diabetic;
    }

    public void setDiabetic(boolean diabetic) {
        this.diabetic = diabetic;
    }

    public boolean isFamily() {
        return family;
    }

    public void setFamily(boolean family) {
        this.family = family;
    }

    public boolean isCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(boolean cholesterol) {
        this.cholesterol = cholesterol;
    }

    public String getCardioRisk() {
        return cardioRisk;
    }

    public void setCardioRisk(String cardioRisk) {
        this.cardioRisk = cardioRisk;
    }

    public boolean isCheckup() {
        return checkup;
    }

    public void setCheckup(boolean checkup) {
        this.checkup = checkup;
    }

    public boolean isSeeCardio() {
        return seeCardio;
    }

    public void setSeeCardio(boolean seeCardio) {
        this.seeCardio = seeCardio;
    }
}
