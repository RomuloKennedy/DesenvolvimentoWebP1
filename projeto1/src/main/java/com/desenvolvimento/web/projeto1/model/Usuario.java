package com.desenvolvimento.web.projeto1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "usuarios_tbl")
@ToString
@SQLDelete(sql = "UPDATE pessoas_tbl SET deleted_at = CURRENT_TIMESTAMP WHERE id=?")
@Where(clause = "deleted_at is null")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @Column(name= "usuario_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @NotBlank(message = "O Campo nome não pode estar em branco.")
    String nome;

    LocalDateTime deletedAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;
    @CreationTimestamp
    LocalDateTime createdAt;

}
