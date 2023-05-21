package de.javagath.blogdbservice.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity class for the table components.
 *
 * @author Ievgenii Izrailtenko
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "components")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@IdClass(ComponentId.class)
public class Component {

  @Id
  @ManyToOne
  @JoinColumn(name = "cmp_blg_id")
  @JsonIgnore
  private Blog blog;

  @Id
  @Column(name = "cmp_counter")
  private Integer counter;

  @Column(name = "cmp_type")
  private String type;

  @Column(name = "cmp_header")
  private String header;

  @Column(name = "cmp_content")
  private String content;
}