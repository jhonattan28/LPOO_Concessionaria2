package model.dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Venda;

public class VendaDAO extends PersistenciaJPA {

    public List<Venda> listaVendas() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Venda> query
                    = em.createQuery("SELECT v FROM Venda v", Venda.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        
            

    public Optional<Venda> buscarPorID(Integer id) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Venda> query = em.createQuery(
                    "SELECT v FROM Venda v WHERE v.id = :id", Venda.class);
            query.setParameter("id", id);
            return query.getResultList().stream().findFirst();
        } finally {
            em.close();
        }
    }
}
