package com.panchuk.shooter.business.dao;

import com.panchuk.shooter.business.model.Point;
import com.panchuk.shooter.business.utils.PortForwarder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PointsDAO implements DAO {

    private final EntityManager em;



    public PointsDAO() {
        PortForwarder.connect();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        em = emf.createEntityManager();
    }

    public void add(Point point) {
        try {
            begin();
            em.persist(point);
            em.flush();
            end();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Point> getAll () {
        try {
            begin();
            @SuppressWarnings("unchecked")
            List<Point> resultList = em.createQuery("SELECT point FROM Point point").getResultList();
            end();
            return resultList;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void clear() {
        try {
            begin();
            Query query = em.createQuery("delete FROM Point");
            query.executeUpdate();
            end();
        } catch (Exception unexpected) {
            unexpected.printStackTrace();
        }
    }

    private void begin() {
        em.getTransaction().begin();
    }

    private void end() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        } else {
            throw new RuntimeException("Inactive transaction");
        }
    }
}
