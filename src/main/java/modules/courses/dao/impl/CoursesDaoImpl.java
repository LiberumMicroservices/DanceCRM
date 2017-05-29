package modules.courses.dao.impl;

import modules.courses.dao.CoursesDao;
import modules.courses.dto.Course;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class CoursesDaoImpl implements CoursesDao {

    @Override
    public List<Course> allCourses() {
        Session session = null;
        List<Course> res = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            res = session.createQuery("from Course c order by c.title asc").list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen()))
                session.close();
        }
        return res;
    }

    @Override
    public Course getCourse(int id) {
        Course res = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            res = session.get(Course.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen()))
                session.close();
        }
        return res;
    }

    @Override
    public Course getCourse(String title) {
        Course res = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM Course C WHERE C.title = :title");
            query.setParameter("title", title);
            List list = query.list();
            if(list.size() > 0)
                res = (Course) list.get(0);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen()))
                session.close();

        }
        return res;
    }

    @Override
    public void save(Course course) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(course);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen()))
                session.close();
        }
    }

    @Override
    public void delete(Course course) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(course);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if((session != null) && (session.isOpen()))
                session.close();
        }
    }
}