package com.briup.youyu.service;

import java.util.Map;

import com.briup.youyu.bean.Book;
import com.briup.youyu.common.exception.OrderServiceException;

public interface IBookService {
	public Map<Long,Book> findAllBooks() throws OrderServiceException;

	public Book findBookById(Long id) throws OrderServiceException;
}
