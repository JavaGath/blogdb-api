package de.javagath.blogdbservice.web;

import de.javagath.blogdbservice.db.BlogRepository;
import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController to create manage db calls to blog-db.
 *
 * @author Ievgenii Izrailtenko
 * @version 1.0
 * @since 1.0
 */

@RestController
public class BlogDbController {

  private static final Logger LOG =
      LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

  @Autowired
  BlogRepository blogRepository;

  @GetMapping(value = "/")
  public Object dummyMethod() {
    LOG.info("My find all");
    return blogRepository.findAll();
  }
}