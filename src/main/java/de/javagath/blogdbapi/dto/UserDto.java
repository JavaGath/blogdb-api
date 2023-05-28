package de.javagath.blogdbapi.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Dto class for User-Entity.
 *
 * @author Ievgenii Izrailtenko
 * @version 1.0
 * @since 1.0
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserDto {

  private Integer id;
  private String username;
  private String email;
  private String name;
  private String surname;
  private String avatar;
}