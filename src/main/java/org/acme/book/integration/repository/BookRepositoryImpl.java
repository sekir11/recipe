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
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class BookRepositoryImpl implements PanacheRepository<BookEntity>, BookRepository {

  public Book getById(Integer bookId) {
    BookEntity bookEntity = find("id", bookId).firstResult();
    return BookEntityMapper.fromEntity(bookEntity);
  }

  public Book createBook(Book book) {
    BookEntity bookEntity = BookEntityMapper.toEntity(book);
    persist(bookEntity);
    return book;
  }

  public void updateBook(Book book) {
    BookEntity updateBookEntity = BookEntityMapper.toEntity(book);
    BookEntity bookEntity = find("id", book.getId()).firstResult();
    bookEntity.title = updateBookEntity.getTitle();
    bookEntity.author = updateBookEntity.getAuthor();
    bookEntity.cost = updateBookEntity.getCost();
    bookEntity.createdAt = updateBookEntity.getCreatedAt();
    bookEntity.updatedAt = updateBookEntity.getUpdatedAt();
  }

  public void deleteBook(Integer bookId) {
    BookEntity bookEntity = find("id", bookId).firstResult();
    delete(bookEntity);
  }

}





