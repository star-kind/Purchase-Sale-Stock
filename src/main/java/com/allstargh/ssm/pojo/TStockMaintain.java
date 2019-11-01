/* https://github.com/orange1438 */
package com.allstargh.ssm.pojo;

import java.util.Date;

public class TStockMaintain {
	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 上次修改时间
	 */
	private Date lastestModifiedTime;

	/**
	 * 上次修改者,对应账号表usrid
	 */
	private Integer lastestModifier;

	/**
	 * 修改类型(0:修改单装区内某一批次货物的存储信息,1:货品之间数量抽调,2:组装混合种类货品单元)
	 */
	private Short modifyType;

	/**
	 * 变动信息,例如: 17s(第17批次自行修改设定,s:self), 22a36(第22批次添加到第36批次,a:add to),
	 * w15&17&51p10&43&45i3(抽调第15/17/51批次的全部货物,再抽调第10/43/45批次的部分货物,整合组建为新存储混装单元3;w:whole,p:partial,i:integrated)
	 */
	private String modifyInfo;

	/**
	 * 获取 主键 t_stock_maintain.id
	 * 
	 * @return 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置 主键 t_stock_maintain.id
	 * 
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取 上次修改时间 t_stock_maintain.lastest_modified_time
	 * 
	 * @return 上次修改时间
	 */
	public Date getLastestModifiedTime() {
		return lastestModifiedTime;
	}

	/**
	 * 设置 上次修改时间 t_stock_maintain.lastest_modified_time
	 * 
	 * @param lastestModifiedTime 上次修改时间
	 */
	public void setLastestModifiedTime(Date lastestModifiedTime) {
		this.lastestModifiedTime = lastestModifiedTime;
	}

	/**
	 * 获取 上次修改者,对应账号表usrid t_stock_maintain.lastest_modifier
	 * 
	 * @return 上次修改者,对应账号表usrid
	 */
	public Integer getLastestModifier() {
		return lastestModifier;
	}

	/**
	 * 设置 上次修改者,对应账号表usrid t_stock_maintain.lastest_modifier
	 * 
	 * @param lastestModifier 上次修改者,对应账号表usrid
	 */
	public void setLastestModifier(Integer lastestModifier) {
		this.lastestModifier = lastestModifier;
	}

	/**
	 * 获取 修改类型(0:修改单装区内某一批次货物的存储信息,1:货品之间数量抽调,2:组装混合种类货品单元)
	 * t_stock_maintain.modify_type
	 * 
	 * @return 修改类型(0:修改单装区内某一批次货物的存储信息,1:货品之间数量抽调,2:组装混合种类货品单元)
	 */
	public Short getModifyType() {
		return modifyType;
	}

	/**
	 * 设置 修改类型(0:修改单装区内某一批次货物的存储信息,1:货品之间数量抽调,2:组装混合种类货品单元)
	 * t_stock_maintain.modify_type
	 * 
	 * @param modifyType 修改类型(0:修改单装区内某一批次货物的存储信息,1:货品之间数量抽调,2:组装混合种类货品单元)
	 */
	public void setModifyType(Short modifyType) {
		this.modifyType = modifyType;
	}

	/**
	 * 获取 变动信息,例如: 17s(第17批次自行修改设定,s:self), 22a36(第22批次添加到第36批次,a:add to),
	 * w15&17&51p10&43&45i3(抽调第15/17/51批次的全部货物,再抽调第10/43/45批次的部分货物,整合组建为新存储混装单元3;w:whole,p:partial,i:integrated)
	 * t_stock_maintain.modify_info
	 * 
	 * @return 变动信息,例如: 17s(第17批次自行修改设定,s:self), 22a36(第22批次添加到第36批次,a:add to),
	 *         w15&17&51p10&43&45i3(抽调第15/17/51批次的全部货物,再抽调第10/43/45批次的部分货物,整合组建为新存储混装单元3;w:whole,p:partial,i:integrated)
	 */
	public String getModifyInfo() {
		return modifyInfo;
	}

	/**
	 * 设置 变动信息,例如: 17s(第17批次自行修改设定,s:self), 22a36(第22批次添加到第36批次,a:add to),
	 * w15&17&51p10&43&45i3(抽调第15/17/51批次的全部货物,再抽调第10/43/45批次的部分货物,整合组建为新存储混装单元3;w:whole,p:partial,i:integrated)
	 * t_stock_maintain.modify_info
	 * 
	 * @param modifyInfo 变动信息,例如: 17s(第17批次自行修改设定,s:self), 22a36(第22批次添加到第36批次,a:add
	 *                   to),
	 *                   w15&17&51p10&43&45i3(抽调第15/17/51批次的全部货物,再抽调第10/43/45批次的部分货物,整合组建为新存储混装单元3;w:whole,p:partial,i:integrated)
	 */
	public void setModifyInfo(String modifyInfo) {
		this.modifyInfo = modifyInfo == null ? null : modifyInfo.trim();
	}
}