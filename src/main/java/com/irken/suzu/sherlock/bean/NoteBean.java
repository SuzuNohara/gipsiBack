package com.irken.suzu.sherlock.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class NoteBean {

	private int id;
	private String title;
	private String content;
	private TypeBean type;
	private List<TagBean> tags;
	
}