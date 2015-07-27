package br.com.Persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.Persistencia.HibernateUtil;
import br.com.Previdenciario.Bin.Opcao;
import br.com.Previdenciario.Bin.Questao;

public class Banco {

	private static Banco instance;
	private Session sessao;
	private Transaction tx;

	public Banco() {

	}

	public static Banco getInstance() {
		if (instance == null)
			instance = new Banco();
		return instance;
	}

	public <T> Object buscarPorId(Class<T> clazz, Integer id) {
		try {
			sessao = HibernateUtil.getSession().openSession();
			Object object = sessao.get(clazz, id);
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sessao.close();
		}
	}

	public <T> Object buscarPorNome(Class<T> clazz, String nome) {
		try {
			sessao = HibernateUtil.getSession().openSession();
			Object object = sessao.get(clazz, nome);
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sessao.close();
		}
	}

	public <T> Object buscarPorChaveUnica(Class<T> clazz, Long codigo,
			String coluna) {
		try {
			sessao = HibernateUtil.getSession().openSession();
			Object object = sessao.createCriteria(clazz)
					.add(Restrictions.eq(coluna, codigo)).uniqueResult();
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sessao.close();
		}
	}

	public <T> boolean salvarObjeto(T objeto) {
		try {
			sessao = HibernateUtil.getSession().openSession();
			tx = sessao.beginTransaction();
			sessao.save(objeto);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			sessao.close();
		}
	}

	public <T> boolean salvarOuAtualizarObjeto(T objeto) {
		try {
			sessao = HibernateUtil.getSession().openSession();
			tx = sessao.beginTransaction();
			sessao.saveOrUpdate(objeto);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			sessao.close();
		}
	}

	public <T> boolean deletarObjeto(T objeto) {
		try {
			sessao = HibernateUtil.getSession().openSession();
			tx = sessao.beginTransaction();
			sessao.delete(objeto);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			sessao.close();
		}
	}

	public List<?> listarObjetosDesc(Class<?> classe, String ordanacao) {
		try {
			sessao = HibernateUtil.getSession().openSession();
			Criteria criteria = sessao.createCriteria(classe).addOrder(
					Order.desc(ordanacao));

			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erro : " + e);
			return null;
		} finally {
			sessao.close();
		}
	}

	public List<?> listarObjetosAsc(Class<?> classe, String ordanacao) {
		try {
			sessao = HibernateUtil.getSession().openSession();
			Criteria criteria = sessao.createCriteria(classe).addOrder(
					Order.asc(ordanacao));

			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erro : " + e);
			return null;
		} finally {
			sessao.close();
		}
	}
	
	public List<?> listarObjetosAscDupla(Class<?> classe, String ordanacao, String segundaOrdenacao) {
		try {
			sessao = HibernateUtil.getSession().openSession();
			Criteria criteria = sessao.createCriteria(classe).addOrder(
					Order.asc(ordanacao)).addOrder(Order.desc(segundaOrdenacao));

			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erro : " + e);
			return null;
		} finally {
			sessao.close();
		}
	}

//	public List<?> retornaUmaQuestao() {
//		try {
//			List<Object> lista = new ArrayList<Object>();
//			Questao quest = (Questao) listarObjetosAsc(Questao.class,
//					"numeroOcorrencia").get(0);
//			lista.add(quest.getId());
//			System.out.println("adicionou a referencia da questão id : "+quest.getId());
//			Criteria crit = sessao.createCriteria(Opcao.class);
//			crit.add(Restrictions.eq("id", quest.getId()));
//			List results = crit.list();
//			for (int i = 0; i < results.size(); i++) {
//				Opcao op = (Opcao) results.get(i); 
//				lista.add(op.getId());
//				System.out.println("Adicionou a referencia da opcao id : "+op.getId());
//			}
//
//			//List<Object> listaa = buscarPorId(Opcao.class, "id");
//
//			return lista;
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("erro : " + e);
//			return null;
//		} finally {
//			sessao.close();
//		}
//	}
}
