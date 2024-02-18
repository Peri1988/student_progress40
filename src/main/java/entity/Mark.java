package entity;

public class Mark {
    private  int id;
    private int mark;
    private Student student;
    private  Term term;
    private Discipline discipline;

    public Mark() {
    }

    public Mark(int id, int mark, Student student, Term term, Discipline discipline) {
        this.id = id;
        this.mark = mark;
        this.student = student;
        this.term = term;
        this.discipline = discipline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mark)) return false;

        Mark mark1 = (Mark) o;

        if (getId() != mark1.getId()) return false;
        if (getMark() != mark1.getMark()) return false;
        if (getStudent() != null ? !getStudent().equals(mark1.getStudent()) : mark1.getStudent() != null) return false;
        if (getTerm() != null ? !getTerm().equals(mark1.getTerm()) : mark1.getTerm() != null) return false;
        return getDiscipline() != null ? getDiscipline().equals(mark1.getDiscipline()) : mark1.getDiscipline() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getMark();
        result = 31 * result + (getStudent() != null ? getStudent().hashCode() : 0);
        result = 31 * result + (getTerm() != null ? getTerm().hashCode() : 0);
        result = 31 * result + (getDiscipline() != null ? getDiscipline().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", mark=" + mark +
                ", student=" + student +
                ", term=" + term +
                ", discipline=" + discipline +
                '}';
    }
}
