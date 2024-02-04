package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class ObterUsuarios {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "SELECT u FROM Usuario u";
//		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
//		query.setMaxResults(5);
		
//		List<Usuario> usuarios = query.getResultList();
		
		List<Usuario> usuarios = em
				.createQuery(jpql, Usuario.class)
				.setMaxResults(5)
				.getResultList();
		
		for(Usuario usuario: usuarios) {
			System.out.println("ID: " + usuario.getId() + " Email: " + usuario.getEmail() + " Nome: " + usuario.getNome());
		}
		
		em.close();
		emf.close();
	}
}
