package entity;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Term {
    private int id;
    private String term;
    private String duration;
    private int status = 1;
    private List<Discipline> disciplines=new ArrayList<Discipline>();

    public Term() {
    }

    public Term(int id, String term, String duration, int status, List<Discipline> disciplines) {
        this.id = id;
        this.term = term;
        this.duration = duration;
        this.status = status;
        this.disciplines = disciplines;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List <Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Term)) return false;

        Term term1 = (Term) o;

        if (getId() != term1.getId()) return false;
        if (getStatus() != term1.getStatus()) return false;
        if (getTerm() != null ? !getTerm().equals(term1.getTerm()) : term1.getTerm() != null) return false;
        if (getDuration() != null ? !getDuration().equals(term1.getDuration()) : term1.getDuration() != null)
            return false;
        return getDisciplines() != null ? getDisciplines().equals(term1.getDisciplines()) : term1.getDisciplines() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getTerm() != null ? getTerm().hashCode() : 0);
        result = 31 * result + (getDuration() != null ? getDuration().hashCode() : 0);
        result = 31 * result + getStatus();
        result = 31 * result + (getDisciplines() != null ? getDisciplines().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Term{" +
                "id=" + id +
                ", term='" + term + '\'' +
                ", duration='" + duration + '\'' +
                ", status=" + status +
                ", disciplines=" + disciplines +
                '}';
    }
}
