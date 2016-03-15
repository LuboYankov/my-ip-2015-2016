package org.elsysbg.ip.todo.services;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

import org.elsysbg.ip.todo.entities.Member;

@Singleton
public class MemberService {
	private final EntityManagerService entityManagerService;
	
	@Inject
	public MemberService(EntityManagerService entityManagerService) {
		this.entityManagerService = entityManagerService;
	}
	
	public Member createMember(Member member) {
		final EntityManager em = entityManagerService.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(member);
			em.getTransaction().commit();
			return member;
		} finally {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
		}
	}
}

