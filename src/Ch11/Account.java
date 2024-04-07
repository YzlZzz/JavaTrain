package Ch11;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {

    public static void main(String[] args){
        Account account = new Account("1122", "George", 1000);
        account.setAnnualInterestRate(1.5);

        account.deposit(30, "salary");
        account.deposit(40, "present");
        account.deposit(50, "borrow");

        account.withdraw(5, "bought");
        account.withdraw(4, "drink");
        account.withdraw(2, "subway");

        account.showDetail();
    }

    private String name;

    private String id;

    private double balance;

    private double annualInterestRate;

    private java.util.Date dateCreated;

    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(){
        this("0","0" ,0);
    }

    public Account(String name, String id, double balance){
        this.name = name;
        this.id = id;
        this.balance = balance;
        dateCreated = new Date(System.currentTimeMillis());
    }

    public void withdraw(double amount, String description){
        transactions.add(new Transaction('W', amount, this.balance -= amount, description));
    }

    public void deposit(double amount, String description){
        transactions.add(new Transaction('D', amount, balance += amount, description));
    }

    public double getBalance() {
        return balance;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate * 100;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate / 100;
    }

    public double getMonthlyInterestRate(){
        return annualInterestRate / 12;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMonthlyInterest(){
        return balance * this.getMonthlyInterestRate();
    }

    public void showDetail(){
        System.out.printf("%10s%8s%10s%5s%8s%18s%30s","Name", "Rate", "Balance", "Type", "Amount", "Description", "Time");
        int len = transactions.size();
        for(int i = 0; i < len; i++){
            System.out.printf("\n%10s%8s%10s%5s%8s%18s%30s", name, this.getAnnualInterestRate() + "%", transactions.get(i).getBalance(), transactions.get(i).getType(), transactions.get(i).getAmount(), transactions.get(i).getDescription(), transactions.get(i).getDate().toString());
        }
    }
}

class Transaction{
    final private java.util.Date date = new Date(System.currentTimeMillis());

    private char type;

    private double amount;

    private double balance;//交易后的新余额

    private String description;

    public Transaction(char type, double amount, double balance,String description){
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public char getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getDescription() {
        return description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(char type) {
        this.type = type;
    }
}