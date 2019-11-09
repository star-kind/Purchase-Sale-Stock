package com.allstargh.ssm.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 分页文本对象<br>
 * 属性:<br>
 * 当前页.<br>
 * 总页数.<br>
 * 文本内容.<br>
 * 是否还有上一页.<br>
 * 是否还有下一页.<br>
 * 
 * @author admin
 *
 */
public class PagingText {
	/**
	 * 起点:0
	 */
	private Integer currentPage;

	/**
	 * 从0开始计数
	 */
	private Integer totalPages;

	private String[] textContent;
	private Boolean isPrevious;
	private Boolean isNext;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public String[] getTextContent() {
		return textContent;
	}

	public void setTextContent(String[] textContent) {
		this.textContent = textContent;
	}

	public Boolean getIsPrevious() {
		return isPrevious;
	}

	public void setIsPrevious(Boolean isPrevious) {
		this.isPrevious = isPrevious;
	}

	public Boolean getIsNext() {
		return isNext;
	}

	public void setIsNext(Boolean isNext) {
		this.isNext = isNext;
	}

	@Override
	public String toString() {
		return "PagingText [currentPage=" + currentPage + ", totalPages=" + totalPages + ", textContent="
				+ Arrays.toString(textContent) + ", isPrevious=" + isPrevious + ", isNext=" + isNext + "]";
	}

}
