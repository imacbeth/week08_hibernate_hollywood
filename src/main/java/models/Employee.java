package models;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "employee_type")
public abstract class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private double bankAccount;

    public Employee() {
    }

    public Employee(String firstName, String lastName, double bankAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bankAccount = bankAccount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "bank_account")
    public double getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(double bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void getPaid(double amount){
        this.bankAccount += amount;
    }
}
