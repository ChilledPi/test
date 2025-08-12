package com.sik9.sik9_server.entity;

import com.sik9.sik9_server.entity.base.BaseEntity;
import com.sik9.sik9_server.entity.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
//@Table(name = "user")
public class Users extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    private String address;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    protected Users() {
    }

    public Users(String email, String password, String name, String address) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.role = Role.USER;
    }
}
