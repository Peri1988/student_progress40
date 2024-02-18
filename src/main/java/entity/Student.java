package entity;

import java.sql.Date;

public class Student {
    private  int id;
    private String surname;
    private  String name;
    private String groupe;
    private Date date;
    private int status =1;

    public Student() {
    }

    public Student(int id, String surname, String name, String grope, Date date, int status) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.groupe = grope;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (getId() != student.getId()) return false;
        if (getStatus() != student.getStatus()) return false;
        if (getSurname() != null ? !getSurname().equals(student.getSurname()) : student.getSurname() != null)
            return false;
        if (getName() != null ? !getName().equals(student.getName()) : student.getName() != null) return false;
        if (getGroupe() != null ? !getGroupe().equals(student.getGroupe()) : student.getGroupe() != null) return false;
        return getDate() != null ? getDate().equals(student.getDate()) : student.getDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getGroupe() != null ? getGroupe().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + getStatus();
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", groupe='" + groupe + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
