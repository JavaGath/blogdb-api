package de.javagath.blogdbservice.db;

import de.javagath.blogdbservice.entity.Blog;
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

}