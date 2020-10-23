/*
 * (c)Copyright Since 2020, SOFTBANK Corp. All rights reserved.
 *
 */

package org.acme.book.domain.repository;

import org.acme.book.domain.model.Book;

public interface BookRepository {

  Book getById(Integer bookId);

  Book createBook(Book book);

  void updateBook(Book book);

  void deleteBook(Integer bookId);

}
