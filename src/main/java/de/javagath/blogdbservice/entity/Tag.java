package de.javagath.blogdbservice.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity class for the table tags.
 *
 * @author Ievgenii Izrailtenko
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "tags")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Tag {

  @ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(
      name = "blog_tags",
      joinColumns = {@JoinColumn(name = "blt_blg_id")},
      inverseJoinColumns = {@JoinColumn(name = "blt_tag_name")}
  )
  Set<Blog> blogs = new HashSet<>();
  @Id
  @Column(name = "tag_name")
  private String name;

}