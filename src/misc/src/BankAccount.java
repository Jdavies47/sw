/**
 * Created by Zsolt Pazmandy on 27/04/16.
 * [1600690] [zxp590]
 * zxp590@student.bham.ac.uk
 * zsoltpazmandy@gmail.com
 * University of Birmingham
 * Computer Science MSc 2015/16
 */
public class BankAccount {
    int overdraftFee; // it's always the same, so it will be static, we don't need more than 1 of this
    String name;
    int balance;

    // CONST#1
    public BankAccount(String name, int balance) { // these vars shadow the outer vars

        // so
        name = name;
        balance = balance;
        // do nothing, ie they override the vars with the samve vals

        // however
        this.name = name;
        this.balance = balance;
        // DO take the outer vals, the ones from the obj
    }

    // CONST#2
    public BankAccount(String name) {
        this.name = name;
    }

    // amount & type of arguments when calling a constructor will define which const is used

}
