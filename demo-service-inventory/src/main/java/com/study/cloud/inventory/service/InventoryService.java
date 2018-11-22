package com.study.cloud.inventory.service;

import com.study.cloud.inventory.exception.InventoryException;

import java.util.Map;

/**
 * 库存
 *
 * @author KelvinZ
 * @date 2018-11-21 11:52
 */
public interface InventoryService {

	/**
	 * 获取库存
	 *
	 * @param sku 单品
	 * @return 库存量
	 */
	int get(String sku);

	/**
	 * 获取所有库存
	 *
	 * @return 库存清单
	 */
	Map<String, Integer> getAll();

	/**
	 * 增加库存
	 *
	 * @param sku    单品
	 * @param amount 数量
	 * @return 库存量
	 * @throws InventoryException 数量为负数时会报此异常
	 */
	int add(String sku, int amount) throws InventoryException;

	/**
	 * 减少库存
	 *
	 * @param sku    单品
	 * @param amount 数量
	 * @return 库存量
	 * @throws InventoryException 库存不足时会报此异常
	 */
	int reduce(String sku, int amount) throws InventoryException;

}
