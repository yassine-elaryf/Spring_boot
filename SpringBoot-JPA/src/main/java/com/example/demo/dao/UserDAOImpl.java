package com.example.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.UsersEntity;
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	@PersistenceContext
private EntityManager em;
	@Override
	public void register(UsersEntity user) {

		em.persist(user);
		System.out.println("user created successfully !");
	}

}
