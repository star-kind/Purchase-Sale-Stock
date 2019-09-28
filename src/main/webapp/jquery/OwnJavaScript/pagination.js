/**
 * 首页
 * 
 * @returns
 */
function firstPage() {
	hide();
	currPageNum = 1;
	showCurrPage(currPageNum);
	showTotalPage();
	for (i = 1; i < pageCount + 1; i++) {
		blockTable.rows[i].style.display = "";
	}

	firstText();
	preText();
	nextLink();
	lastLink();
}

/**
 * 上一页
 * 
 * @returns
 */
function prePage() {
	hide();
	currPageNum--;
	showCurrPage(currPageNum);
	showTotalPage();
	var firstR = firstRow(currPageNum);
	var lastR = lastRow(firstR);
	for (i = firstR; i < lastR; i++) {
		blockTable.rows[i].style.display = "";
	}

	if (1 == currPageNum) {
		firstText();
		preText();
		nextLink();
		lastLink();
	} else if (pageNum == currPageNum) {
		preLink();
		firstLink();
		nextText();
		lastText();
	} else {
		firstLink();
		preLink();
		nextLink();
		lastLink();
	}

}

/**
 * 下一页
 * 
 * @returns
 */
function nextPage() {
	hide();
	currPageNum++;
	showCurrPage(currPageNum);
	showTotalPage();
	var firstR = firstRow(currPageNum);
	var lastR = lastRow(firstR);
	for (i = firstR; i < lastR; i++) {
		blockTable.rows[i].style.display = "";
	}

	if (1 == currPageNum) {
		firstText();
		preText();
		nextLink();
		lastLink();
	} else if (pageNum == currPageNum) {
		preLink();
		firstLink();
		nextText();
		lastText();
	} else {
		firstLink();
		preLink();
		nextLink();
		lastLink();
	}
}

/**
 * 尾页
 * 
 * @returns
 */
function lastPage() {
	hide();
	currPageNum = pageNum;
	showCurrPage(currPageNum);
	showTotalPage();
	var firstR = firstRow(currPageNum);
	for (i = firstR; i < numCount + 1; i++) {
		blockTable.rows[i].style.display = "";
	}

	firstLink();
	preLink();
	nextText();
	lastText();
}

/**
 * 计算将要显示的页面的首行和尾行
 * 
 * @param currPageNum
 * @returns
 */
function firstRow(currPageNum) {
	return pageCount * (currPageNum - 1) + 1;
}

function lastRow(firstRow) {
	var lastRow = firstRow + pageCount;
	if (lastRow > numCount + 1) {
		lastRow = numCount + 1;
	}
	return lastRow;
}

function showCurrPage(cpn) {
	currPageSpan.innerHTML = cpn;
}

function showTotalPage() {
	pageNumSpan.innerHTML = pageNum;
}

/**
 * 隐藏所有行
 * 
 * @returns
 */
function hide() {
	for (var i = 1; i < numCount + 1; i++) {
		blockTable.rows[i].style.display = "none";
	}
}

/**
 * 控制首页/上一页/下一页/末页功能的开闭
 * 
 * @returns
 */
function firstLink() {
	firstSpan.innerHTML = "<a href='javascript:firstPage();'  style='text-decoration: underline;' >First</a>";
}
function firstText() {
	firstSpan.innerHTML = "First";
}

function preLink() {
	preSpan.innerHTML = "<a href='javascript:prePage();'  style='text-decoration: underline;'  >Pre</a>";
}
function preText() {
	preSpan.innerHTML = "Pre";
}

function nextLink() {
	nextSpan.innerHTML = "<a href='javascript:nextPage();'  style='text-decoration: underline;'  >Next</a>";
}
function nextText() {
	nextSpan.innerHTML = "Next";
}

function lastLink() {
	lastSpan.innerHTML = "<a href='javascript:lastPage();'  style='text-decoration: underline;'  >Last</a>";
}
function lastText() {
	lastSpan.innerHTML = "Last";
}