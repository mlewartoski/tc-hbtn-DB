package models;

import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class ProdutoModel {
    private final EntityManager em = Persistence.createEntityManagerFactory("admin-jpa").createEntityManager();

    public void create(Produto p) {
        try {
            System.out.println("---Transação iniciada ---");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao criar produto.");
        } finally {
            System.out.println("--- Transação encerrada ---");
        }
    }

    public void update(Produto p) {
        try {
            System.out.println("---Transação iniciada ---");
            em.getTransaction().begin();
            em.find(p.getClass(), p.getId());
            em.getTransaction().commit();
            System.out.println("Produto editado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar produto.");
        } finally {
            System.out.println("--- Transação encerrada ---");
        }

    }

    public void delete(Produto p) {
        try {
            System.out.println("---Transação iniciada ---");
            em.getTransaction().begin();
            p = em.find(p.getClass(), p.getId());
            em.remove(p);
            em.getTransaction().commit();
            System.out.println("Produto removido com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao remover produto." + e.getMessage());
        } finally {
            System.out.println("--- Transação encerrada ---");

        }
    }

    public Produto findById(Produto p) {
        return em.find(p.getClass(), p.getId());
    }

    public List<Produto> findAll() {
        return em.createQuery("FROM " + Produto.class.getName()).getResultList();
    }
}