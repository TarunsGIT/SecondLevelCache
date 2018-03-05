package ad.hibernate.com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import ad.hibernate.com.dto.ProductDTO;

public class ProductModel implements AutoCloseable {

	public static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = null;

		if (sessionFactory == null) {

			sessionFactory = new Configuration().configure("product.cfg.xml")
					.buildSessionFactory();
		}
		return sessionFactory;

	}

	public long addProduct(ProductDTO dto) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(dto);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("Transaction Rolled Back::addProduct");
			}

		} finally {
			session.close();
		}
		return dto.getId();
	}

	public long updateProduct(ProductDTO dto) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(dto);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("Transaction Rolled Back::updateProduct");
			}
		} finally {
			session.close();
		}
		return dto.getId();
	}

	public void deleteProduct(ProductDTO dto) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(dto);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("Transaction Rolled Back::deleteProduct");
			}

		} finally {
			session.close();
		}

	}

	public ProductDTO getProduct(long productId) {
		Session session = null;
		ProductDTO dto = null;
		try {
			session = getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(ProductDTO.class);
			criteria.add(Restrictions.eq("productId", productId));
			List<ProductDTO> list = criteria.list();
			if (list.size() == 1) {
				dto = list.get(0);

			}

		} catch (HibernateException e) {
			System.out.println("Issue In Getting Product::getProdcut");

		} finally {
			session.close();
		}
		return dto;
	}

	public void load() {

		Configuration cfg = new Configuration();
		cfg.configure("product.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session1 = factory.openSession();
		Object o1 = session1.load(ProductDTO.class, new Long(4));

		ProductDTO dto1 = (ProductDTO) o1;
		System.out.println("\n##Loaded Object Product_Name(DATABASE HIT):: "
				+ dto1.getProductName());
		System.out
				.println("**********Object Loaded INTO SECOND LEVEL CACHE***************");
		session1.close();
		System.out.println("\n------------Wating------------");
		try {
			Thread.sleep(6000);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("\n---------6 Second Completed----------");
		System.out
				.println("\n---------------SECOND LEVEL CACHE DESTROYED-----------");

		Session session2 = factory.openSession();
		Object o2 = session2.load(ProductDTO.class, new Long(4));
		ProductDTO dto2 = (ProductDTO) o2;
		System.out.println("\n----------Object Loaded from DATABASE--------");
		System.out.println("##Loaded Object Product_Name(DATABASE HIT):: "
				+ dto2.getProductName());
		session2.close();
		System.out
		.println("\n----------Object Loaded from Global Cache --------");
		Session session3 = factory.openSession();
		Object o3 = session3.load(ProductDTO.class, new Long(4));
		ProductDTO dto3 = (ProductDTO) o3;
		System.out.println("\nLoaded Object Product_Name(GLOBAL CACHE):: "
				+ dto3.getProductName());
		

		if(factory!=null){
		factory.close();
		}

	}

	@Override
	public void close() throws Exception {

	}

}
