package de.javagath.blogdbservice.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Dto to send and manage request for blog operations.
 *
 * @author Ievgenii Izrailtenko
 * @version 1.0
 * @since 1.0
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class BlogRequestDto {

  private String address;
  private CrudOperation operation;
  private BlogDto blog;

}