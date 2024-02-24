package com.irken.suzu.sherlock.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NoteDaoService {

	@Autowired
	private JdbcTemplate springJdbcTemplate;
//	public NoteBean getNote(int id) {
//		Predicate<? super NoteBean> predicate = note -> note.getId().equals(id);
//		// return note.stream().filter(predicate).findFirst().orElse(null);
//	}
	
	public void insert() {
		
	}
}
