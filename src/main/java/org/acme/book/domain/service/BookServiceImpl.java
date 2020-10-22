/*
 * (c)Copyright Since 2020, SOFTBANK Corp. All rights reserved.
 *
 */

package org.acme.book.domain.service;

import lombok.NoArgsConstructor;
import org.acme.book.domain.mapper.BookEntityMapper;
import org.acme.book.integration.entity.BookEntity;
import org.acme.book.domain.model.Book;
import org.acme.book.integration.repository.BookRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * {@link BookService} の実装クラス。
 */
@ApplicationScoped
public class BookServiceImpl implements BookService {

  @Inject
  BookRepository bookRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public Book getBook(Integer bookId) {
    return bookRepository.getById(bookId);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional
  public Book createBook(Book book) {
    return bookRepository.createBook(book);
  }

  @Transactional
  @Override
  public void updateBook(Book book) {
    bookRepository.updateBook(book);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional
  public void deleteBook(Integer bookId) {
    bookRepository.deleteBook(bookId);
  }

}
