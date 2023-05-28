package de.javagath.blogdbapi.service;

import de.javagath.blog.dto.BlogDto;
import de.javagath.blog.dto.BlogRequestDto;
import de.javagath.blog.dto.ComponentDto;
import de.javagath.blog.dto.CrudOperation;
import de.javagath.blog.dto.TagDto;
import de.javagath.blog.dto.UserDto;
import de.javagath.blogdbapi.db.Blog;
import de.javagath.blogdbapi.db.BlogRepository;
import de.javagath.blogdbapi.db.User;
import java.util.Objects;
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
    if (Objects.requireNonNull(request.getOperation()) == CrudOperation.READ) {
      Blog entity = blogRepository.searchBlogByAddress(request.getAddress());
      return mapBlogEnityToBlogDto(entity);
    }
    throw new IllegalArgumentException("CRUD-Operation is not supported");
  }

  private BlogDto mapBlogEnityToBlogDto(Blog entity) {
    BlogDto result = new BlogDto();
    result.setId(entity.getId());
    result.setDate(entity.getDate());
    result.setAddress(entity.getAddress());
    result.setBanner(entity.getBanner());
    entity.getTags().forEach(tag -> result.getTags().add(new TagDto(tag.getId(), tag.getName())));
    entity.getComponents()
        .forEach(component -> result.getComponents().add(new ComponentDto(component.getCounter(),
            component.getType(), component.getHeader(), component.getContent())));
    result.setSubtitle(entity.getSubtitle());
    result.setTitle(entity.getTitle());
    result.setUser(convertUserToDto(entity.getUser()));
    return result;
  }


  private UserDto convertUserToDto(User user) {
    UserDto result = new UserDto();
    result.setUsername(user.getUsername());
    result.setName(user.getName());
    result.setSurname(user.getSurname());
    result.setEmail(user.getEmail());
    result.setAvatar(user.getAvatar());
    result.setId(user.getId());
    return result;
  }

}