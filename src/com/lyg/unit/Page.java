package com.lyg.unit;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页信息
 * @author 无心
 *
 */
public class Page {
	/**
	 * 当前页，  默认第一行就是第一页
	 */
	private int currentPage=1;
	
	/**
	 * 符合条件的总行数
	 */
	private int totalRows;
	
	/**
	 * 默认每页显示的行数
	 */
	
	private int pageSize=3;
	
	/**
	 * 符合条件查询的总页数
	 */
	private int totalPages;
	
	/**
	 * 查询到的符合条件的所有记录
	 */
	
	private List<Object> datas=new ArrayList<>();

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	//总页数
    //总行数/每页显示的行数----整除就是它本身，不能整除+1
	public int getTotalPages() {
		totalPages=(totalRows%pageSize==0?(totalRows/pageSize):(totalRows/pageSize)+1);
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<Object> getDatas() {
		return datas;
	}

	public void setDatas(List<Object> datas) {
		this.datas = datas;
	}

	public Page(int currentPage, int totalRows, int pageSize, int totalPages,
			List<Object> datas) {
		super();
		this.currentPage = currentPage;
		this.totalRows = totalRows;
		this.pageSize = pageSize;
		this.totalPages = totalPages;
		this.datas = datas;
	}

	public Page() {
		super();
	}
	
	

}
