package com.briup.youyu.dao;

import java.util.Map;

import com.briup.youyu.bean.Book;

public interface IBookDao {
	public Map<Long,Book> findAllBooks();

	public Book findBookById(Long id);
}
