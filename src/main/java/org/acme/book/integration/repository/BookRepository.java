/*
 * (c)Copyright Since 2020, SOFTBANK Corp. All rights reserved.
 *
 */

package org.acme.book.integration.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.book.domain.mapper.BookEntityMapper;
import org.acme.book.domain.model.Book;
import org.acme.book.integration.entity.BookEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookRepository implements PanacheRepository<BookEntity> {

  public Book getById(Integer bookId) {
    BookEntity bookEntity = find("id", bookId).firstResult();
    return BookEntityMapper.fromEntity(bookEntity);
  }

  public Book createBook(Book book) {
    BookEntity bookEntity = BookEntityMapper.toEntity(book);
    System.out.println("create");
    persist(bookEntity);
    return book;
  }

  public void updateBook(Book book) {
    BookEntity bookEntity = BookEntityMapper.toEntity(book);
    System.out.println("update");

    update(bookEntity);
  }

  public void deleteBook(Integer bookId) {
    BookEntity bookEntity = find("id", bookId).firstResult();
    delete(bookEntity);
  }

}
