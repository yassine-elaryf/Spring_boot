package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.StudentEntity;
@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO<StudentEntity> {
	@PersistenceContext
private EntityManager em;
	@Override
	public List<StudentEntity> getAllStudents() {
		Query req=em.createQuery("select p from student p");
		return req.getResultList();
	}

	@Override
	public StudentEntity getStudentById(Long id) {
		StudentEntity s=em.find(StudentEntity.class, id);
		
		return s;
	}

	@Override
	public StudentEntity saveStudent(StudentEntity stu) {
	em.persist(stu);
		return stu;
	}

	@Override
	public StudentEntity update(StudentEntity student) {
em.merge(student);

return student; 
	}

	@Override
	public void delete(Long id) {
		StudentEntity s=em.find(StudentEntity.class, id);
		em.remove(s);
	}

}
