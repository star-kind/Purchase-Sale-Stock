package com.allstargh.ssm.pojo;

import java.io.Serializable;

/**
 * 分页对象v2.0
 * 
 * <b>从零开始</b>
 * 
 * <ul>
 * <li>总页数</li>
 * <li>每页展示行数</li>
 * <li>是否还有上一页</li>
 * <li>是否还有下一页</li>
 * <li>所获数据</li>
 * <li>当前页码</li>
 * </ul>
 * 
 * @author admin
 * @param <E>
 *
 */
public class PaginationII<E> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer totalPages;
	private Integer rows;
	private Boolean hasPreviousPage;
	private Boolean hasNextPage;
	private E data;
	private Integer currentPageth;

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Boolean getHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(Boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public Boolean getHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(Boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Integer getCurrentPageth() {
		return currentPageth;
	}

	public void setCurrentPageth(Integer currentPageth) {
		this.currentPageth = currentPageth;
	}

	/**
	 * 有参构造方法
	 * 
	 * @param data
	 */
	public PaginationII(E data) {
		this.data = data;
	}

	/**
	 * 冇参
	 */
	public PaginationII() {
	}

	@Override
	public String toString() {
		return "PaginationII [totalPages=" + totalPages + ", rows=" + rows + ", hasPreviousPage=" + hasPreviousPage
				+ ", hasNextPage=" + hasNextPage + ", data=" + data + ", currentPageth=" + currentPageth + "]";
	}

}
