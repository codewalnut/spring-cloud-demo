package com.study.cloud.inventory.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 库存服务
 *
 * @author KelvinZ
 * @date 2018-11-20 20:34
 */
@FeignClient(value = "DEMO-SERVICE-INVENTORY", fallback = InventoryRemoteServiceHystrix.class)
public interface InventoryRemoteService {

	/**
	 * 查询库存数量
	 *
	 * @param sku 单品
	 * @return 查询结果
	 */
	@RequestMapping("/api/get")
	boolean get(@RequestParam("sku") String sku);

	/**
	 * 获得库存清单
	 *
	 * @return 查询结果
	 */
	@RequestMapping("/api/getAll")
	Map<String, Integer> getAll();

	/**
	 * 加库存
	 *
	 * @param sku    单品
	 * @param amount 数量
	 * @return 增加后的库存量
	 */
	@RequestMapping("/api/add")
	boolean add(@RequestParam("sku") String sku, @RequestParam("amount") int amount);

	/**
	 * 减库存
	 *
	 * @param sku    单品
	 * @param amount 数量
	 * @return 减少后的库存量
	 */
	@RequestMapping("/api/reduce")
	boolean reduce(@RequestParam("sku") String sku, @RequestParam("amount") int amount);

}
