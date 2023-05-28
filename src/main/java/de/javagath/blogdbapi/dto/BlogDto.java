package de.javagath.blogdbapi.dto;

import java.sql.Date;
import java.util.HashSet;
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
  private Set<TagDto> tags = new HashSet<>();
  private UserDto user;
  private Set<ComponentDto> components = new HashSet<>();

}