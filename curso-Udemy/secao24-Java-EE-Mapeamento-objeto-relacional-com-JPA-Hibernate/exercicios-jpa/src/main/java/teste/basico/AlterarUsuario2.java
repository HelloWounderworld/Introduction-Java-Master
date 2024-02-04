package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario2 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = em.find(Usuario.class, 5L);
		System.out.println(usuario.getEmail());
		usuario.setNome("Marie Curie - Alterado");
		usuario.setEmail("mcurie@iamonlywomantogettwonobelprize.com");
		
		em.getTransaction().begin();
		
//		em.merge(usuario); // update
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
