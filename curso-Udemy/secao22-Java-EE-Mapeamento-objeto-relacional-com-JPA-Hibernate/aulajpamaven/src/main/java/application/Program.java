package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
//		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
//		Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		
		EntityManagerFactory enf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = enf.createEntityManager();
		
//		em.getTransaction().begin();
		
//		em.persist(p1);
//		em.persist(p2);
//		em.persist(p3);
		
//		em.getTransaction().commit();
		
		Pessoa p = em.find(Pessoa.class, 2);
		
		System.out.println(p);
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("Pronto");
		
		em.close();
		enf.close();
		
//		System.out.println(p1);
//		System.out.println(p2);
//		System.out.println(p3);
	}

}
