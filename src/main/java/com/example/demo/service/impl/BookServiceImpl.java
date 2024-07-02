package com.example.demo.service.impl;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.GenericResponse;
import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepo;
import com.example.demo.service.BookImageService;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookImageService bookImageService;
    @Autowired
    BookRepo bookRepo;
    @Override
    public GenericResponse save(BookDto bookDto) throws IOException {
        Book book=new Book();
        if(bookDto.getId() !=null){
            Optional<Book> bookOptional=bookRepo.findById(bookDto.getId());
            if(bookOptional.isPresent()){
                book=bookOptional.get();
                if(bookDto.getName()!=null) {
                    book.setName(bookDto.getName());
                }else{
                    book.setName(book.getName());
                }
                book.setPrize(bookDto.getPrize());
                book.setAuthor(bookDto.getAuthor());
                book.setCount(bookDto.getCount());
//                book.setCategory(bookDto.getCategory());
                book.setBookImage(bookDto.getBookImage());
                bookRepo.save(book);
                BookDto dto=entityToDto(book);
                return new GenericResponse(HttpStatus.OK.value(),"book update successfully " + dto);
            }
        }else{
         book.setName(bookDto.getName());
         book.setPrize(bookDto.getPrize());
         book.setAuthor(bookDto.getAuthor());
         book.setCount(bookDto.getCount());
//         book.setCategory(bookDto.getCategory());
         book.setBookImage(bookDto.getBookImage());
         bookRepo.save(book);
         BookDto dto=entityToDto(book);
         return new GenericResponse(HttpStatus.OK.value(),"book save successfully", dto);
        }
        return null;
    }

    public BookDto entityToDto(Book bookDto){
        BookDto book=new BookDto();
        book.setName(bookDto.getName());
        book.setPrize(bookDto.getPrize());
        book.setAuthor(bookDto.getAuthor());
        book.setCount(bookDto.getCount());
//        book.setCategory(bookDto.getCategory());
        book.setBookImage(bookDto.getBookImage());
        return book;
    }
}
