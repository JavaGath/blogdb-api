package de.javagath.blogdbservice.db;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.List;
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

  @Id
  @Column(name = "blg_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

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

  @ManyToMany
  @JoinTable(
      name = "blog_tags",
      joinColumns = @JoinColumn(name = "blt_blg_id"),
      inverseJoinColumns = @JoinColumn(name = "blt_tag_id")
  )
  private List<Tag> tags;

  @ManyToOne
  @JoinColumn(name = "blg_usr_id")
  private User user;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Component> components;

}