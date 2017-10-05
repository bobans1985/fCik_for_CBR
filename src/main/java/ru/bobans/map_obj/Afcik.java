package ru.bobans.map_obj;

public abstract class Afcik {

    public String idClient;
    public String LastName;
    public String FirstName;
    public String MiddleName;
    public String BirthDay;
    public String TypyOfAccount;
    public String Account;
    public String Ostt;
    public String NameOfCred;
    public String KodOfCred;
    public String NekonfAdrOfCred;
    public String konfAdrOfCred;

    public String getAccount() {
        return Account;
    }

    public String getKonfAdrOfCred() {
        return konfAdrOfCred;
    }

    public String getIdClient() {
        return idClient;
    }

    public String getLastName() {
        return LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public String getBirthDay() {
        return BirthDay;
    }

    public String getTypyOfAccount() {
        return TypyOfAccount;
    }

    public String getOstt() {
        return Ostt;
    }

    public String getNameOfCred() {
        return NameOfCred;
    }

    public String getKodOfCred() {
        return KodOfCred;
    }

    public String getNekonfAdrOfCred() {
        return NekonfAdrOfCred;
    }
}
