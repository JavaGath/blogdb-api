package de.javagath.blogdbapi.web;

import de.javagath.blogdbapi.dto.BlogDto;
import de.javagath.blogdbapi.dto.BlogRequestDto;
import de.javagath.blogdbapi.service.BlogService;
import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
  private final BlogService blogService;

  /**
   * Constructor to autowire dependencies.
   *
   * @param blogService dependency of the bean BlogService
   */
  public BlogDbController(BlogService blogService) {
    this.blogService = blogService;
  }

  /**
   * Main endpoint to manage Crud operations
   *
   * @param request BlogRequestDto
   * @return Blog Entity, returns empty BlogDto if blog was deleted
   */
  @PostMapping(value = "/blog", consumes = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody BlogDto manageBlogRequest(@RequestBody BlogRequestDto request) {
    LOG.debug("My address: " + request.getAddress());
    return blogService.manageBlogRequest(request);
  }
}