/*
 * (c)Copyright Since 2020, SOFTBANK Corp. All rights reserved.
 *
 */

package org.acme.book.integration.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.book.domain.mapper.BookEntityMapper;
import org.acme.book.domain.model.Book;
import org.acme.book.domain.repository.BookRepository;
import org.acme.book.integration.entity.BookEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class BookRepositoryImpl implements PanacheRepository<BookEntity>, BookRepository {

  @Override
  public Book getById(Integer bookId) {
    BookEntity bookEntity = find("id", bookId).firstResult();
    return BookEntityMapper.fromEntity(bookEntity);
  }

  @Override
  @Transactional
  public Book createBook(Book book) {
    BookEntity bookEntity = BookEntityMapper.toEntity(book);
    persist(bookEntity);
    return book;
  }

  @Override
  @Transactional
  public void updateBook(Book book) {
    BookEntity updateBookEntity = BookEntityMapper.toEntity(book);
    String query = "title = ?1, " +
                   "author = ?2, " +
                   "cost = ?3, " +
                   "created_at = ?4, " +
                   "updated_at = ?5" +
                   "WHERE id = " + updateBookEntity.getId();
    update(query, updateBookEntity.getTitle(),
                           updateBookEntity.getAuthor(),
                           updateBookEntity.getCost(),
                           updateBookEntity.getCreatedAt(),
                           updateBookEntity.getUpdatedAt());
  }

  @Override
  public void deleteBook(Integer bookId) {
    BookEntity bookEntity = find("id", bookId).firstResult();
    delete(bookEntity);
  }

}





