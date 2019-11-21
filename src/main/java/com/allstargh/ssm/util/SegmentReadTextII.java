package com.allstargh.ssm.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.allstargh.ssm.pojo.PagingText;
import com.allstargh.ssm.pojo.PagingTextII;

/**
 * 从文本文件中分页读取数据
 * <h3>第二代版</h3>
 * 
 * <b>第0即第1</b> <br>
 * 以每隔 index * LINE_COUNT 作为开始行,可达到"分页"的效果
 * 
 * @author admin
 *
 */
public class SegmentReadTextII {
	/**
	 * 每次从文件中读取的行数
	 */
	private Integer lineCount;

	/**
	 * 文件路径
	 */
	private String filePath;

	public SegmentReadTextII(Integer lineCount, String filePath) {
		this.lineCount = lineCount;
		this.filePath = filePath;
	}

	/**
	 * 文件默认编码
	 */
	public static final String FILE_ENCODING = "UTF-8";

	/**
	 * 文件唯一标识,用于记录从文件的哪一行开始读取
	 */
	private Map<String, Integer> counterMap = Collections.synchronizedMap(new HashMap<String, Integer>());

	/**
	 * 设置从文件的开始读取行数<br>
	 * <b>msgKey默认值一定是null,而不能是空字符串,不然得到的数据会一直是重复不变的</b>
	 * 
	 * @param msgKey 文件的唯一标识
	 * @param offset 开始读取的行数位置
	 */
	public void setupBeginLines(String msgKey, int offset) {
		counterMap.put(msgKey, offset);
	}

	/**
	 * 每次从文件中读取固定行数的记录
	 * 
	 * @param msgKey   文件唯一标识
	 * @param filePath 文件路径
	 * @return List 读取的文件内容
	 */
	public List<Map<Integer, String>> readRowsRecords(String msgKey, String filePath) {
		List<Map<Integer, String>> dataList = new ArrayList<>();

		int line = 0;

		if (counterMap.get(msgKey) == null) {
			counterMap.put(msgKey, line);
		} else {
			line = counterMap.get(msgKey);
		}

		try {
			File file = new File(filePath);

			if (file.isFile() && file.exists()) {// 判断文件是否存在
				// 考虑到编码格式
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), FILE_ENCODING);
				BufferedReader buffer = new BufferedReader(read);
				String lineText = null;

				int index = 1;

				while ((lineText = buffer.readLine()) != null) {
					// 每次读取时从上次最后读取的行位开始
					if (index > line) {
						Map<Integer, String> data = new HashMap<>();

						data.put(index, lineText);

						dataList.add(data);

						// 每次只读取多少行
						if ((index - line) == lineCount) {
							line = index;
							break;
						}
					}

					index++;
				}

				/* 说明文件已经读完,插入一个读完的标记,file.renameTo(file)用于判断当前文件是否被其他程序写入内容或者占用 */
				if (lineText == null && file.renameTo(file)) {
					Map<Integer, String> data = new HashMap<>();

					data.put(-1, "已经到文本末尾了");

					dataList.add(data);

					line = index;

				}

				read.close();
				buffer.close();
			} else {
				System.err.println("未寻获指定的文件");
			}
		} catch (IOException e) {
			System.err.println("读取文件出现异常");
			e.printStackTrace();
		} finally {
			// 记录下次要从文件的哪一行行位开始读取
			counterMap.put(msgKey, line);
		}

		return dataList;
	}

	/**
	 * 根据文件位置和页数获取文本数据 <br>
	 * 第0页即为第一页
	 * 
	 * @param filePath
	 * @param index    指定页
	 * @return
	 */
	public List<Map<Integer, String>> getTextData(String filePath, Integer index) {
		/* msgKey默认值一定是null,而不能是空字符串,不然得到的数据会一直是重复不变的 */
		setupBeginLines(null, index * lineCount);

		List<Map<Integer, String>> list = readRowsRecords(null, filePath);
		System.err.println("list.size: " + list.size());

		for (Map<Integer, String> map : list) {
			for (Map.Entry<Integer, String> ele : map.entrySet()) {
				// System.out.println(ele.getKey() + " , " + ele.getValue());
			}
		}

		return list;
	}

	/**
	 * 统计文本文件内容总行数
	 * 
	 * @param filePath
	 * @return
	 */
	public Integer countTextLines(String filePath) {
		Integer lines = 0;

		try {
			File file = new File(filePath);

			if (file.exists()) {
				long fileLength = file.length();

				LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));

				lineNumberReader.skip(fileLength);

				lines = lineNumberReader.getLineNumber();

				System.err.println(this.getClass().getName() + ",Total number of lines===");
				System.err.println(lines);

				lineNumberReader.close();
			} else {
				System.err.println("File does't exists");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lines;
	}

	/**
	 * 炼制数据<br>
	 * 为了更好地将文本内容投射在前台页面,需要将内容提取转化为字符串数组
	 * 
	 * @param list
	 * @return
	 */
	public String[] refineData(List<Map<Integer, String>> list) {
		String value = null;

		for (Map<Integer, String> map : list) {
			for (Map.Entry<Integer, String> ele : map.entrySet()) {
				// System.out.println(ele.getKey() + " , " + ele.getValue());
				value += ele.getValue();
			}
		}

		// System.err.println(value);
		String[] split = value.split("\n|\r");

		for (int i = 0; i < split.length; i++) {
			// System.err.println(split[i]);
		}

		return split;
	}

	/**
	 * 封装
	 * 
	 * @param filePath
	 * @param index
	 * @return
	 */
	public PagingText packaging(String filePath, Integer index) {
		PagingText text = new PagingText();

		List<Map<Integer, String>> list = getTextData(filePath, index);

		String[] data = refineData(list);

		Integer lines = countTextLines(filePath);

		int totalPages = lines / lineCount;

		text.setTotalPages(totalPages);

		if (index >= totalPages && totalPages > 0) {
			text.setIsNext(false);
			text.setIsPrevious(true);

		} else if (index < totalPages && index > 0) {
			text.setIsNext(true);
			text.setIsPrevious(true);

		} else if (index == 0 && totalPages > 0) {
			text.setIsNext(true);
			text.setIsPrevious(false);

		} else if (totalPages == 0) {
			text.setIsNext(false);
			text.setIsPrevious(false);

		}

		text.setTextContent(data);
		text.setCurrentPage(index);

		return text;
	}

	/**
	 * 计算总页数
	 * 
	 * @param totalTextRows 原文件内内容总行数
	 * @param line          设定每页行数
	 * @return
	 */
	protected int countTotalpages(Integer totalTextRows, Integer line) {
		Integer j = totalTextRows % line;

		int t = totalTextRows / line;

		if (j > 0) {
			t++;
		}

		return t;
	}

	/**
	 * 封装v2.0
	 * 
	 * @param filePath
	 * @param index
	 * @return
	 */
	public PagingTextII packaging(Integer index) {
		PagingTextII text = new PagingTextII();

		List<Map<Integer, String>> list = getTextData(filePath, index);

		String[] data = refineData(list);

		Integer lines = countTextLines(filePath);

		// Integer totalPages = lines / lineCount;
		int totalPages = countTotalpages(lines, lineCount);

		text.setTotalPages(totalPages);

		if (index >= totalPages && totalPages > 0) {
			text.setIsNext(false);
			text.setIsPrevious(true);

		} else if (index < totalPages && index > 0) {
			text.setIsNext(true);
			text.setIsPrevious(true);

		} else if (index == 0 && totalPages > 0) {
			text.setIsNext(true);
			text.setIsPrevious(false);

		} else if (totalPages == 0) {
			text.setIsNext(false);
			text.setIsPrevious(false);

		}

		text.setTextContent(data);
		text.setCurrentPage(index);
		text.setLines(lineCount);

		return text;
	}

}
