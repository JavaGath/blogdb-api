package de.javagath.blogdbapi.service;

import de.javagath.blogdbapi.db.Blog;
import de.javagath.blogdbapi.db.BlogRepository;
import de.javagath.blogdbapi.dto.BlogDto;
import de.javagath.blogdbapi.dto.BlogRequestDto;
import org.springframework.stereotype.Service;

/**
 * Service class to work with Blog-Entity.
 *
 * @author Ievgenii Izrailtenko
 * @version 1.0
 * @since 1.0
 */
@Service
public class BlogService {

  private final BlogRepository blogRepository;

  /**
   * Constructor to autowire dependencies.
   *
   * @param blogRepository dependency of the bean BlogRepository
   */
  public BlogService(BlogRepository blogRepository) {
    this.blogRepository = blogRepository;
  }

  /**
   * Manages CRUD-Operation for blogs depending on request-operation.
   *
   * @param request dto for blog request
   * @return BlogDto response
   */
  public BlogDto manageBlogRequest(BlogRequestDto request) {
    switch (request.getOperation()) {
      case READ -> {
        Blog entity = blogRepository.searchBlogByAddress(request.getAddress());
        return mapBlogEnityToBlogDto(entity);
      }
      default -> throw new IllegalArgumentException("CRUD-Operation is not supported");
    }
  }

  private BlogDto mapBlogEnityToBlogDto(Blog entity) {
    BlogDto result = new BlogDto();
    result.setId(entity.getId());
    result.setDate(entity.getDate());
    result.setAddress(entity.getAddress());
    result.setBanner(entity.getBanner());
    result.setTags(entity.getTags());
    result.setComponents(entity.getComponents());
    result.setSubtitle(entity.getSubtitle());
    result.setTitle(entity.getTitle());
    result.setUser(entity.getUser());
    return result;
  }

}