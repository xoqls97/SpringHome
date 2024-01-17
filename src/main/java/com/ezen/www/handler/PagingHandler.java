package com.ezen.www.handler;

import com.ezen.www.domain.PagingVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PagingHandler {
	
	private int startPage;
	private int endPage;
	private boolean prev,next;
	private int totalCount;
	private PagingVO pgvo;
	
	public PagingHandler(PagingVO pgvo, int totalCount) {
		this.pgvo=pgvo;
		this.totalCount=totalCount;
		
		endPage=(int) Math.ceil(pgvo.getPageNo()/(double)pgvo.getQty())*10;
		startPage=endPage-9;
		int realEndPage = (int)Math.ceil(totalCount/(double)pgvo.getQty());
		
		if(realEndPage<endPage) {
			endPage=realEndPage;
		}
		this.prev = this.startPage>1;
		this.next = this.endPage<realEndPage;
		
		
	}
	
	

}
