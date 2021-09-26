package fr.audrain.appcoeur;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Person implements Parcelable {
    //Main
    private String name;

    //I am
    private Sexe sexe;
    private int age;

    //My Heart
    private boolean heart_condition, diabetic, hypertension, cholesterol, imc;
    private YesNoMaybe avc;

    //Doctor
    private YesNoMaybe cardioRisk;
    private boolean checkup, seeCardio;

    //diet
    private boolean breakfast, vegetable, salt;
    private EatCustom eatCutsom;

    public Person() {
        this.setName("");

        this.setSexe(Sexe.UNDEFINED);
        this.setAge(0);

        this.setHeart_condition(false);
        this.setDiabetic(false);
        this.setHypertension(false);
        this.setCholesterol(false);
        this.setImc(false);
        this.setAvc(YesNoMaybe.DONTKNOW);

        this.setCardioRisk(YesNoMaybe.DONTKNOW);
        this.setCheckup(false);
        this.setSeeCardio(false);

        this.setBreakfast(true);
        this.setVegetable(true);
        this.setSalt(false);
        this.setEatCutsom(EatCustom.COOKED);
    }

    private Person(Parcel in) {
        // Both reading and writing orderings must match (see writeToParcel method)
        this.setName(in.readString());

        this.setSexe(Sexe.values()[in.readInt()]);
        this.setAge(in.readInt());

        this.setHeart_condition(in.readBoolean());
        this.setDiabetic(in.readBoolean());
        this.setHypertension(in.readBoolean());
        this.setCholesterol(in.readBoolean());
        this.setImc(in.readBoolean());
        this.setAvc(YesNoMaybe.values()[in.readInt()]);

        this.setCardioRisk(YesNoMaybe.values()[in.readInt()]);
        this.setCheckup(in.readBoolean());
        this.setSeeCardio(in.readBoolean());

        this.setBreakfast(in.readBoolean());
        this.setVegetable(in.readBoolean());
        this.setSalt(in.readBoolean());
        this.setEatCutsom(EatCustom.values()[in.readInt()]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
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

    public boolean isHypertension() {
        return hypertension;
    }

    public void setHypertension(boolean hypertension) {
        this.hypertension = hypertension;
    }

    public boolean isCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(boolean cholesterol) {
        this.cholesterol = cholesterol;
    }

    public boolean isImc() {
        return imc;
    }

    public void setImc(boolean imc) {
        this.imc = imc;
    }

    public YesNoMaybe getAvc() {
        return avc;
    }

    public void setAvc(YesNoMaybe avc) {
        this.avc = avc;
    }

    public YesNoMaybe getCardioRisk() {
        return cardioRisk;
    }

    public void setCardioRisk(YesNoMaybe cardioRisk) {
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

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public boolean isVegetable() {
        return vegetable;
    }

    public void setVegetable(boolean vegetable) {
        this.vegetable = vegetable;
    }

    public boolean isSalt() {
        return salt;
    }

    public void setSalt(boolean salt) {
        this.salt = salt;
    }

    public EatCustom getEatCutsom() {
        return eatCutsom;
    }

    public void setEatCutsom(EatCustom eatCutsom) {
        this.eatCutsom = eatCutsom;
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
        parcel.writeBoolean(hypertension);
        parcel.writeBoolean(cholesterol);
        parcel.writeBoolean(imc);
        parcel.writeInt(avc.ordinal());

        parcel.writeInt(cardioRisk.ordinal());
        parcel.writeBoolean(checkup);
        parcel.writeBoolean(seeCardio);

        parcel.writeBoolean(breakfast);
        parcel.writeBoolean(vegetable);
        parcel.writeBoolean(salt);
        parcel.writeInt(eatCutsom.ordinal());
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
}
