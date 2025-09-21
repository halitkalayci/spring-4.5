package com.turkcell.intro.web.entity;

import jakarta.persistence.*;

import java.util.Set;

@Table(name="users")
@Entity
public class User {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER) // Bir kullanıcıyı çekerken rollerinin de hemen yüklenmesini sağlar.
    @JoinTable(
            name = "user_operation_claims", // Veritabanında oluşturulacak ara tablonun adı.
            joinColumns = @JoinColumn(name = "user_id"), // Bu ara tabloda User'ı temsil eden kolon.
            inverseJoinColumns = @JoinColumn(name = "operation_claim_id") // Bu ara tabloda OperationClaim'i temsil eden kolon.
    )
    private Set<OperationClaim> operationClaims;

    public Set<OperationClaim> getOperationClaims() {
        return operationClaims;
    }

    public void setOperationClaims(Set<OperationClaim> operationClaims) {
        this.operationClaims = operationClaims;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
