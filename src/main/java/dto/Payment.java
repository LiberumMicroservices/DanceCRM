package dto;

import modules.students.dto.Student;

import java.time.LocalDate;

public class Payment {

    private int id;

    private LocalDate date;

    private Student student;

    private int amount;

    public Payment() { }

    public Payment(LocalDate date, Student student, int amount) {
        this.date = date;
        this.student = student;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;

        Payment payment = (Payment) o;

        if (amount != payment.amount) return false;
        if (date != null ? !date.equals(payment.date) : payment.date != null) return false;
        return student != null ? student.equals(payment.student) : payment.student == null;

    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (student != null ? student.hashCode() : 0);
        result = 31 * result + amount;
        return result;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", date=" + date +
                ", student=" + student.getfName() + " " + student.getlName() +
                ", amount=" + amount +
                '}';
    }
}
