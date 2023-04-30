package de.javagath.blogdbservice.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity class for the table blogs.
 *
 * @author Ievgenii Izrailtenko
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "blogs")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Blog {

  @ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(
      name = "blog_tags",
      joinColumns = {@JoinColumn(name = "blt_blg_id")},
      inverseJoinColumns = {@JoinColumn(name = "blt_tag_name")}
  )
  Set<Tag> tags = new HashSet<>();

  @Id
  @Column(name = "blg_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "blg_address")
  private String address;

  @Column(name = "blg_title")
  private String title;

  @Column(name = "blg_subtitle")
  private String subtitle;

  @Column(name = "blg_banner")
  private String banner;

  @Column(name = "blg_date")
  private Date date;

  @Column(name = "blg_usr_id")
  @ManyToOne
  @JoinColumn(name = "blg_usr_id")
  private User user;

}