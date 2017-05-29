package modules.students.dao.impl;

import modules.students.dao.StudentsDao;
import modules.students.dto.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class StudentsDaoImpl implements StudentsDao{

    @Override
    public List<Student> allStudents() {
        Session session = null;
        List<Student> res = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            res = session.createQuery("from Student s order by s.fName asc").list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen()))
                session.close();
        }
        return res;
    }

    @Override
    public List<Student> students(String fName, String lName) {
        Session session = null;
        List<Student> res = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Student S WHERE S.fName = :fName and S.lName = :lName");
            query.setParameter("fName", fName);
            query.setParameter("lName", lName);
            res = query.list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen()))
                session.close();
        }
        return res;
    }

    @Override
    public Student getStudent(int id) {
        Student res = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            res = session.get(Student.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen()))
                session.close();
        }
        return res;
    }

    @Override
    public void save(Student student) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen()))
                session.close();
        }
    }

    @Override
    public void delete(Student student) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen()))
                session.close();
        }
    }
}
