package fr.audrain.appcoeur;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    //Main
    private String name;

    //I am
    private Sexe sexe;
    private int age;

    //My Heart
    private boolean heart_condition, diabetic, family, cholesterol;

    //heart/avc,

    //Doctor
    private String cardioRisk;
    private boolean checkup, seeCardio;

    public Person(String name) {
        this.name = name;
    }
    public Person() {}

    private Person(Parcel in) {
        // Both reading and writing orderings must match (see writeToParcel method)
        this.setName(in.readString());

        this.setSexe(Sexe.values()[in.readInt()]);
        this.setAge(in.readInt());

        this.setHeart_condition(in.readBoolean());
        this.setDiabetic(in.readBoolean());
        this.setFamily(in.readBoolean());
        this.setCholesterol(in.readBoolean());

        this.setCardioRisk(in.readString());
        this.setCheckup(in.readBoolean());
        this.setSeeCardio(in.readBoolean());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sexe isSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {this.sexe = sexe;}

    public void setSexe (String sexe) {this.sexe = Sexe.valueOf(sexe);}

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

    /**
     * Pour implementer Parcelable
     */
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);

        parcel.writeInt(sexe.ordinal());
        parcel.writeInt(age);

        parcel.writeBoolean(heart_condition);
        parcel.writeBoolean(diabetic);
        parcel.writeBoolean(family);
        parcel.writeBoolean(cholesterol);

        parcel.writeString(cardioRisk);
        parcel.writeBoolean(checkup);
        parcel.writeBoolean(seeCardio);
    }

    /**
     * A ne pas toucher
     */
    public static final Parcelable.Creator<Person> CREATOR
            = new Parcelable.Creator<Person>() {
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sexe=" + sexe +
                ", age=" + age +
                ", heart_condition=" + heart_condition +
                ", diabetic=" + diabetic +
                ", family=" + family +
                ", cholesterol=" + cholesterol +
                ", cardioRisk='" + cardioRisk + '\'' +
                ", checkup=" + checkup +
                ", seeCardio=" + seeCardio +
                '}';
    }

}
