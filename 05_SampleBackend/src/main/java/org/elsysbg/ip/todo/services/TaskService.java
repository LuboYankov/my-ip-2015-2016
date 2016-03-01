package org.elsysbg.ip.todo.services;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.elsysbg.ip.todo.entities.Task;

@Singleton
public class TaskService {
	private final EntityManagerFactory emf;
	
	public TaskService() {
		emf = Persistence.createEntityManagerFactory("todolist-jpa");
	}
	
	public Task createTask(Task task) {
		final EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(task);
			em.getTransaction().commit();
			return task;
		} finally {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}
	
	public List<Task> getTasks() {
		final EntityManager em = emf.createEntityManager();
		try {
			final TypedQuery<Task> query = em.createNamedQuery(Task.QUERY_ALL, Task.class);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
	
	public Task getTask(long taskId) {
		final EntityManager em = emf.createEntityManager();
		try {
			final Task result = em.find(Task.class, taskId);
			if(result == null) {
				throw new IllegalArgumentException("no task with id: " + taskId);
			}
			return result;
		} finally {
			em.close();
		}
	}
	
	public Task updateTask(Task task) {
		final EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			final Task result = em.merge(task);
			em.getTransaction().commit();
			return result;
		} finally {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}
	
	public void deleteTask(long taskId) {
		final EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			final Task fromDb = em.find(Task.class, taskId);
			if(fromDb == null) {
				throw new IllegalArgumentException("no task with id: " + taskId);
			}
			em.remove(fromDb);
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}
}
