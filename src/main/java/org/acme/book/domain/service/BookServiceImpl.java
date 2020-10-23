/*
 * (c)Copyright Since 2020, SOFTBANK Corp. All rights reserved.
 *
 */

package org.acme.book.domain.service;

import org.acme.book.domain.model.Book;
import org.acme.book.domain.repository.BookRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * {@link BookService} の実装クラス。
 */
@RequestScoped
public class BookServiceImpl implements BookService {

  @Inject
  BookRepository bookRepository;

  @Override
  public Book getBook(Integer bookId) {
    return bookRepository.getById(bookId);
  }

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

  @Override
  @Transactional
  public void deleteBook(Integer bookId) {
    bookRepository.deleteBook(bookId);
  }

}


