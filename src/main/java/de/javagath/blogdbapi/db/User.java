package de.javagath.blogdbapi.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity class for the table user.
 *
 * @author Ievgenii Izrailtenko
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {

  @Id
  @Column(name = "usr_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "usr_username")
  private String username;

  @Column(name = "usr_email")
  private String email;

  @Column(name = "usr_name")
  private String name;

  @Column(name = "usr_surname")
  private String surname;

  @Column(name = "usr_avatar")
  private String avatar;

  @OneToMany(mappedBy = "user")
  @JsonIgnore
  private Set<Blog> blogs;

}