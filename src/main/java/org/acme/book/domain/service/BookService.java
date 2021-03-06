/*
 * (c)Copyright Since 2020, SOFTBANK Corp. All rights reserved.
 *
 */

package org.acme.book.domain.service;

import org.acme.book.domain.model.Book;

/**
 * 本に関するサービスのインターフェース。
 */
public interface BookService {

  /**
   * 指定した id の本を取得します。
   *
   * @param bookId 取得したい本 id
   * @return 取得した本
   */
  Book getBook(Integer bookId);


  /**
   * 指定した本を登録するためのエンドポイントです
   *
   * @param book 登録したい本のドメインモデル
   * @return 登録した本
   */
  Book createBook(Book book);

  void updateBook(Book book);

  void deleteBook(Integer id);
}
