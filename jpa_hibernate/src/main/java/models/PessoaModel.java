package models;

import entities.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class PessoaModel {

    private final EntityManager em = Persistence.createEntityManagerFactory("admin-jpa").createEntityManager();

    public void create(Pessoa p) {
        try {
            System.out.println("---Transação iniciada ---");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Pessoa criada com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao criar produto.");
        } finally {
            System.out.println("--- Transação encerrada ---");
        }
    }

    public void update(Pessoa p) {
        try {
            System.out.println("---Transação iniciada ---");
            em.getTransaction().begin();
            em.find(p.getClass(), p.getId());
            em.getTransaction().commit();
            System.out.println("Pessoa editada com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar produto.");
        } finally {
            System.out.println("--- Transação encerrada ---");
        }

    }

    public void delete(Pessoa p) {
        try {
            System.out.println("---Transação iniciada ---");
            em.getTransaction().begin();
            p = em.find(p.getClass(), p.getId());
            em.remove(p);
            em.getTransaction().commit();
            System.out.println("Pessoa removida com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao remover produto." + e.getMessage());
        } finally {
            System.out.println("--- Transação encerrada ---");

        }
    }

    public Pessoa findById(Pessoa p) {
        return em.find(p.getClass(), p.getId());
    }

    public List<Pessoa> findAll() {
        return em.createQuery("FROM " + Pessoa.class.getName()).getResultList();
    }
}
