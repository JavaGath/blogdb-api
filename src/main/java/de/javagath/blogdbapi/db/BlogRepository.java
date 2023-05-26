package de.javagath.blogdbapi.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Blog entity, contains all Requests for table "blogs". Extends CrudRepository for
 * standard functionality.
 *
 * @author Ievgenii Izrailtenko
 * @version 1.0
 * @since 1.0
 */
@Repository
public interface BlogRepository extends CrudRepository<Blog, Long> {

  /**
   * Looks for the Blog-Entity using its address.
   *
   * @param address value in blg_address column
   * @return Blog-Entity or null
   */
  Blog searchBlogByAddress(String address);

}