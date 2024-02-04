package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		Usuario novoUsuario = new Usuario("Alan Turing", "aturing@likesandwich.com");
//		Usuario novoUsuario = new Usuario("Albert Einstein", "aeinstein@taradao.com");
//		Usuario novoUsuario = new Usuario("Stephen Hawking", "shawking@iamsupercomputer.com");
//		novoUsuario.setId(1L);
		
		em.getTransaction().begin();
		em.persist(novoUsuario);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
