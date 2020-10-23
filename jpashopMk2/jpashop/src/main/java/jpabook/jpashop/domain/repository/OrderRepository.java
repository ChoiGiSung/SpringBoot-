package jpabook.jpashop.domain.repository;

import jpabook.jpashop.domain.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
public class OrderRepository {

    @PersistenceContext
    private  EntityManager entityManager;
    
    public void save(Order order){
        entityManager.persist(order);
    }

    public Order findOne(Long id){
        return entityManager.find(Order.class,id);
    }
    
    //검색 로직
   public List<Order> findAll(OrderSearch orderSearch){

    //값이 다 있다는 전제하에 유저가 이름도 다쓰고 상태도 다 골라줬을때
       return entityManager.createQuery("select o from Order o join o.member m" +
               " where o.status= :status" +
               " and m.name like :name", Order.class)
               .setParameter("status",orderSearch.getOrderStatus())
               .setParameter("name",orderSearch.getMemberName())
               .getResultList();

       //쿼리 dsl로 하는게 좋다
   }
}