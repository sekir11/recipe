package org.acme.book.applicaiton.controller;

import org.acme.book.applicaiton.payload.BookResponse;
import org.acme.book.applicaiton.payload.CreateBookRequest;
import org.acme.book.applicaiton.payload.CreateBookResponse;
import org.acme.book.domain.model.Book;
import org.acme.book.domain.service.BookService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/books")
public class BookController {

  @Inject
  BookService bookService;

  /**
   * 指定した id の書籍を取得するためのエンドポイントです!
   *
   * @param bookId 取得したい書籍の id
   * @return 取得した書籍
   */
  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public BookResponse getBook(@PathParam("id") String bookId) {
    Book book = bookService.getBook(1);
    return BookResponse.of(book);
  }

  /**
   * 指定した書籍を登録するためのエンドポイントです
   *
   * @param request 登録したい書籍のリクエスト
   * @return 登録した書籍
   */
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public CreateBookResponse getBook(CreateBookRequest request) {
    Book book = bookService.createBook(request.toModel());
    return CreateBookResponse.of(book);
  }

  @PATCH
  @Path("/{id}")
  public void updateBook(@PathParam("id") Integer id, CreateBookRequest request) {
    bookService.updateBook(request.toModel(id));
  }


  @DELETE
  @Path("/{id}")
  public void deleteBook(@PathParam("id") Integer id) {
    bookService.deleteBook(id);
  }
}