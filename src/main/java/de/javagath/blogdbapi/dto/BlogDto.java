package de.javagath.blogdbapi.dto;

import de.javagath.blogdbapi.db.Component;
import de.javagath.blogdbapi.db.Tag;
import de.javagath.blogdbapi.db.User;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Dto class for Blog-Entity.
 *
 * @author Ievgenii Izrailtenko
 * @version 1.0
 * @since 1.0
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BlogDto {

  private Long id;
  private String address;
  private String title;
  private String subtitle;
  private String banner;
  private Date date;
  private List<Tag> tags = new ArrayList<>();
  private User user;
  private Set<Component> components = new HashSet<>();

}