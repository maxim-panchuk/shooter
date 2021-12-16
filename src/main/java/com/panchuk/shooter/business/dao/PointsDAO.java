package com.panchuk.shooter.business.dao;

import com.panchuk.shooter.business.model.Point;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PointsDAO implements DAO<Point> {

    private final EntityManager em;

    public PointsDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        em = emf.createEntityManager();
    }

    public void add(Point point) {
        em.getTransaction().begin();
        em.persist(point);
        em.getTransaction().commit();
        em.close();
    }

    public List<Point> getAll () {
        em.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Point> list = em.createQuery("from Point").getResultList();
        em.close();
        return null;
    }

    public void clear() {

    }
}
