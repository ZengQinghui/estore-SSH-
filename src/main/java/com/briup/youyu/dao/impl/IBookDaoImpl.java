package com.briup.youyu.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.briup.youyu.bean.Book;
import com.briup.youyu.dao.IBookDao;

@Repository("bookDao")
public class IBookDaoImpl implements IBookDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public Map<Long, Book> findAllBooks() {
		List<Book> list = sessionFactory.getCurrentSession().createQuery("FROM Book").list();
		Map<Long, Book> map = new HashMap<Long, Book>();
		for (Book book : list) {
			map.put(book.getId(), book);
		}
		return map;
	}

	@Override
	public Book findBookById(Long id) {
		return null;
	}

}
