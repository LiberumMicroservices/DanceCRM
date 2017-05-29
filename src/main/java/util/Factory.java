package util;

import modules.courses.dao.CoursesDao;
import modules.courses.dao.impl.CoursesDaoImpl;
import modules.students.dao.StudentsDao;
import modules.students.dao.impl.StudentsDaoImpl;

public class Factory {

    public CoursesDao coursesDao;
    public StudentsDao studentsDao;

    private static Factory instance = null;

    public static Factory getInstance(){
        if(instance == null) {
            synchronized(Factory.class){
                if (instance == null)
                    instance = new Factory();
            }
        }
        return instance;
    }

    public CoursesDao getCoursesDao(){
        if (coursesDao == null){
            synchronized (CoursesDao.class){
                if(coursesDao == null)
                    coursesDao = new CoursesDaoImpl();
            }
        }
        return coursesDao;
    }

    public StudentsDao getStudentsDao(){
        if (studentsDao == null){
            synchronized (StudentsDao.class){
                if(studentsDao == null)
                    studentsDao = new StudentsDaoImpl();
            }
        }
        return studentsDao;
    }
}
