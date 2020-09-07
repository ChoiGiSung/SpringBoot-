package jpabook.jpashop.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name="delivery_id")
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy ="delivery",fetch = FetchType.LAZY)
    private Order order;

    @Embedded //내장 타입
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; //READY , COMP
}
