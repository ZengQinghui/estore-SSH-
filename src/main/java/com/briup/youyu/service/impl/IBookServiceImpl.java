package com.briup.youyu.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.youyu.bean.Book;
import com.briup.youyu.common.exception.OrderServiceException;
import com.briup.youyu.dao.IBookDao;
import com.briup.youyu.service.IBookService;

@Service("bookService")
@Transactional
public class IBookServiceImpl implements IBookService {
	@Autowired
	private IBookDao bookDao;

	@Override
	public Map<Long,Book> findAllBooks() throws OrderServiceException {

		return bookDao.findAllBooks();

	}

	@Override
	public Book findBookById(Long id) throws OrderServiceException {
		return null;
	}

}
