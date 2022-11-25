package com.springboot.advanced_jpa.data.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

// 엔티티 관련 어노테이션
// 엔티티를 작성할 때는 어노테이션을 많이 사용합니다. 그중에는 테이블과 매핑하기 위해 사용하는 어노테이션도 있고,
// 다른 테이블과의 연관관계를 정의하기 위해 사용하는 어노테이션, 자동으로 값을 주입하기 위한 어노테이션도 있습니다.
// 여기서는 먼저 기본적으로 많이 사용하는 어노테이션을 소개하고, 다른 어노테이션은 이후 내용을 진행하면서 필요할 때마다 소개하겠습니다.

// Entity
// 해당 클래스가 엔티티임을 명시하기 위한 어노테이션입니다. 클래스 자체는 테이블과 일대일로 매칭되며,
// 해당 클래스의 인스턴스는 매핑되는 테이블에서 하나의 레코드를 의미합니다.

// Table
// 엔티티 클래스는 테이블과 매핑되므로 특별한 경우가 아니면 @Table 어노테이션이 필요하지 않습니다.
// @Table 어노테이션을 사용할 때는 클래스의 이름과 테이블의 이름을 다르게 지정해야 하는 경우입니다.
// @Table 어노테이션을 명시하지 않으면 테이블의 이름과 클래스의 이름이 동일하다는 의미이며,
// 서로 다른 이름을 쓰려면 @Table(name = 값) 형태로 데이터베이스의 테이블명을 명시해야 합니다.
// 대체로 자바의 명명법과 데이터베이스가 사용하는 명명법이 다르기 때문에 자주 사용됩니다.
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "name")
@Table(name = "product")
public class Product {

//    Id
//    엔티티 클래스의 필드는 테이블의 칼럼과 매핑됩니다. @Id 어노테이션이 선언된 필드는 테이블의 "기본값"
//    역할로 사용됩니다. 모든 엔티티는 @Id어노테이션이 필요합니다. 꼭 기억해주세요.

//    GeneratedValue
//    일반적으로 Id 어노테이션과 함께 사용됩니다. 이 어노테이션은 해당 필드의 값을 어떤 방식으로 자동으로 생성할지 결정할 때 사용합니다.
//      값 생성 방식은 다음과 같습니다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
