/*
 * (c)Copyright Since 2020, SOFTBANK Corp. All rights reserved.
 *
 */

package org.acme.book.domain.service;

import lombok.NoArgsConstructor;
import org.acme.book.domain.mapper.BookEntityMapper;
import org.acme.book.integration.entity.BookEntity;
import org.acme.book.domain.model.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

/**
 * {@link BookService} の実装クラス。
 */
@NoArgsConstructor
@ApplicationScoped
public class BookServiceImpl implements BookService {

  /**
   * {@inheritDoc}
   */
  @Override
  public Book getBook(Integer bookId) {
    BookEntity bookEntity = BookEntity.findById(bookId);
    return BookEntityMapper.fromEntity(bookEntity);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional
  public Book createBook(Book book) {
    BookEntity bookEntity = BookEntityMapper.toEntity(book);
    bookEntity.persist();
    return BookEntityMapper.fromEntity(bookEntity);
  }

  @Transactional
  @Override
  public void updateBook(Book book) {
    BookEntity bookEntity = BookEntityMapper.toEntity(book);
    BookEntity.update(String.valueOf(bookEntity.getId()), bookEntity);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional
  public void deleteBook(Integer id) {
    BookEntity.deleteById(id);
  }

}
