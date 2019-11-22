package com.allstargh.ssm.util;

/**
 * 分页辅助工具类
 * 
 * @author admin
 *
 */
public class PaginationsSupply {
	/**
	 * 获取计算的总页数
	 * 
	 * @param totalRows 全部数据总行数
	 * @param line      设定每页行数
	 * @return
	 */
	public int getAllpages(Integer totalRows, Integer line) {
		Integer j = totalRows % line;

		int t = totalRows / line;

		if (j > 0) {
			t++;
		}

		return t;
	}

	/**
	 * 判断是否有上一页和下一页 <br>
	 * <li>element[0]=previous
	 * <li>element[1]=next
	 * 
	 * @param pageNum    当前页
	 * @param totalPages 总页数
	 * @return
	 */
	public Boolean[] judgePrevOrNext(Integer pageNum, Integer totalPages) {
		Boolean prev = null;
		Boolean next = null;

		Boolean[] flags = new Boolean[2];

		if (pageNum == 0 && totalPages > 0) {// 总页数至少2页
			prev = false;
			next = true;
		} else if ((pageNum + 1) == totalPages && totalPages > 0) {// 总页数至少2页
			prev = true;
			next = false;
		} else if (totalPages == 0) {// 总页数仅仅一页或冇数据
			prev = false;
			next = false;
		} else if (pageNum > 0 && pageNum < totalPages) {// 总页数至少3页
			prev = true;
			next = true;
		}

		flags[0] = prev;
		flags[1] = next;

		return flags;
	}

}
