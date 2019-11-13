package com.allstargh.ssm.pojo;

/**
 * 文本分页对象第二代
 * 
 * @author admin
 *
 */
public class PagingTextII extends PagingText {
	/**
	 * 每页读取行数
	 */
	private Integer lines;

	public Integer getLines() {
		return lines;
	}

	public void setLines(Integer lines) {
		this.lines = lines;
	}

	@Override
	public String toString() {
		return "PagingTextII [lines=" + lines + ", toString()=" + super.toString() + "]";
	}

}
