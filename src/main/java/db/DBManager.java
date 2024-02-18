package db;

import constants.Constants;
import entity.Discipline;
import entity.Mark;
import entity.Student;
import entity.Term;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    public static List<Student> getAllActiveStudents(){
        ArrayList <Student> students = new ArrayList <Student>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE status = '1'");


            while (rs.next()){
                Student st = new Student();
                st.setId(rs.getInt("id"));
                st.setSurname(rs.getString("surname"));
                st.setName(rs.getString("name"));
                st.setGroupe(rs.getString("groupe"));
                st.setDate(rs.getDate("date"));
                students.add(st);
            }



        }catch (Exception e){
           e.printStackTrace();
        }


        return students;
    }

    public static void createStudent(String surname, String name, String groupe, String date){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            stmt.execute(" INSERT INTO `student` (`surname`, `name`, `groupe`, `date`) VALUES ('"+surname+"', '"+name+"', '"+groupe+"', '"+date+"');");



        }catch (Exception e){
            e.printStackTrace();
        }



    }


    public static void deleteStudent(String id){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            stmt.execute(" UPDATE `student` SET `status` = '0' WHERE (`id` = '"+id+"');");



        }catch (Exception e){
            e.printStackTrace();
        }



    }
    public static Student getStudentById(String id){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE status = '1' AND id = "+ id);



            while (rs.next()){
                Student st = new Student();
                st.setId(rs.getInt("id"));
                st.setSurname(rs.getString("surname"));
                st.setName(rs.getString("name"));
                st.setGroupe(rs.getString("groupe"));
                st.setDate(rs.getDate("date"));
                return st;
            }



        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

    public static void modifyStudent(String id, String surname, String name, String groupe, String dateToDB) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            stmt.execute(" UPDATE `student` SET `surname` = '"+surname+"', `name` = '"+name+"', `groupe` = '"+groupe+"', `date` = '"+dateToDB+"' WHERE (`id` = '"+id+"');\n");

        }catch (Exception e){
            e.printStackTrace();
        }



    }

    public static List<Term> getAllActiveTerms(){
        ArrayList <Term> terms = new ArrayList <Term>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM term WHERE status = '1'");


            while (rs.next()){
               Term term = new Term();
               term.setId(rs.getInt("id"));
               term.setTerm(rs.getString("name_of_term"));
               terms.add(term);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return terms;
    }

    public static Term getTermById(String id){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM term WHERE status = '1' AND id = "+ id);



            while (rs.next()){
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setTerm(rs.getString("name_of_term"));
                return term;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


    public static List<Mark> getMarksByStudentAndTerm(String idStudent, int idTerm){
        ArrayList <Mark> marks = new ArrayList <Mark>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT d.id, d.discipline, m.mark FROM mark as m\n" +
                    "LEFT JOIN term_discipline as td on m.id_term_discipline = td.id\n" +
                    "LEFT JOIN discipline as d on td.id_discipline =d.id\n" +
                    "WHERE m.id_student ="+idStudent+" and td.id_term = "+idTerm);


            while (rs.next()){
                Mark mark = new Mark();
                mark.setMark(rs.getInt("mark"));

                Discipline discipline=new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("discipline"));
                mark.setDiscipline(discipline);

                marks.add(mark);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return marks;
    }

    public static boolean canLogin(String login, String password, String role){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(" SELECT * FROM user_role AS ur\n" +
                    "LEFT JOIN user AS u ON ur.id_user = u.id\n" +
                    "WHERE ur.id_role = "+role+" AND u.login = '"+login+"' AND u.password = '"+password+"'");



            while (rs.next()){
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }


    public static List<Discipline> getAllActiveDisciplines(){
        ArrayList <Discipline> disciplines = new ArrayList <Discipline>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM discipline where status = '1'");


            while (rs.next()){
                Discipline ds = new Discipline();
                ds.setId(rs.getInt("id"));
                ds.setDiscipline(rs.getString("discipline"));

                disciplines.add(ds);
            }



        }catch (Exception e){
            e.printStackTrace();
        }


        return disciplines;
    }

    public static void createDiscipline(String name){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            stmt.execute("    INSERT INTO `discipline` (`discipline`) VALUES ('"+name+"');");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void deleteDiscipline(String id){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            stmt.execute(" UPDATE `discipline` SET `status` = '0' WHERE (`id` = '"+id+"');");



        }catch (Exception e){
            e.printStackTrace();
        }



    }

    public static Discipline getDisciplineById(String id){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM discipline WHERE status = '1' AND id = "+ id);



            while (rs.next()){
                Discipline ds = new Discipline();
                ds.setId(rs.getInt("id"));
                ds.setDiscipline(rs.getString("discipline"));

                return ds;
            }



        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static void modifyDiscipline(String id, String disciplines) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            stmt.execute(" UPDATE `discipline` SET `discipline` = '"+disciplines+"' WHERE (`id` = '"+id+"');\n");

        }catch (Exception e){
            e.printStackTrace();
        }



    }

    public static List<Discipline> getDisciplinesByTerm( int idTerm){
        ArrayList <Discipline> disciplines = new ArrayList <Discipline>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT t.id, t.name_of_term, t.duration, d.id as id_disc, d.discipline FROM term_discipline as td\n" +
                    "LEFT JOIN term AS t ON td.id_term =t.id\n" +
                    "LEFT JOIN discipline AS d ON td.id_discipline = d.id\n" +
                    "WHERE td.id_term = "+idTerm+" and d.status = '1'");

            //"WHERE m.id_student ="+idStudent+" and td.id_term = "+idTerm);


            while (rs.next()){

                   Term term  = new Term();
                   term.setId(rs.getInt("id"));
                   term.setTerm(rs.getString("name_term"));
                   term.setDuration(rs.getString("duration"));


               Discipline discipline = new Discipline();
               discipline.setId(rs.getInt("id_disc"));
               discipline.setDiscipline(rs.getString("discipline"));
               term.setDisciplines(disciplines);

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return disciplines;
    }


    public static void createTerm(String duration){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO `term` ( `duration`) VALUES ( '"+duration+"');\n");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
