package de.javagath.blogdbservice.entity;

import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * ID class for the table components.
 *
 * @author Ievgenii Izrailtenko
 * @version 1.0
 * @since 1.0
 */

@Getter
@ToString
@EqualsAndHashCode
public class ComponentId implements Serializable {

  private final Integer blog;
  private final Integer counter;

  /**
   * Default constructor.
   *
   * @param blog    PK from Blog.java and PK/FK from Component.java
   * @param counter PK from Component.java
   */
  public ComponentId(Integer blog, Integer counter) {
    this.blog = blog;
    this.counter = counter;
  }

}