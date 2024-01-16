package com.ezen.www.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PagingVO {
	private int pageNo;
	private int qty;
	
	public PagingVO() {
		this.pageNo=1;
		this.qty=10;
	}
	
	public PagingVO(int pageNo,int qty) {
		this.pageNo=pageNo;
		this.qty=qty;
	}
	
	public int getPageStart() {
		return(this.pageNo-1)*qty;
		
	}

}
