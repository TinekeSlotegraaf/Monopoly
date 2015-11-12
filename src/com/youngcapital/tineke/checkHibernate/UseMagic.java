package com.youngcapital.tineke.checkHibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UseMagic {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("magic");

	@RequestMapping("/tric")
	public @ResponseBody String doMagic() {
		Magic magic = new Magic();
		magic.setName("Wizard");
		magic.setCount(100);
		magic.setTric("Saw the girl");

		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(magic);

		t.commit();
		em.close();
		return "Gelukt!";
	}
}
