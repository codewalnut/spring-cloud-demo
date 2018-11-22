package com.study.cloud.inventory.service;

import com.study.cloud.inventory.exception.InventoryException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 库存业务实现
 *
 * @author KelvinZ
 * @date 2018-11-21 12:43
 */
@Service
public class InventoryServiceImpl implements InventoryService {
	/**
	 * 模拟库存
	 */
	private static Map<String, Integer> inventory = new HashMap<>();

	static {
		inventory.put("手机", 10);
		inventory.put("智能音箱", 15);
		inventory.put("电动车", 5);
	}

	@Override
	public int get(String sku) {
		return inventory.get(sku);
	}

	@Override
	public Map<String, Integer> getAll() {
		return new HashMap<>(inventory);
	}

	@Override
	public int add(String sku, int amount) throws InventoryException {
		if (amount < 1) {
			throw new InventoryException("库存增加参数不能小于1");
		}
		Integer oldStock = inventory.get(sku);
		int total = oldStock + amount;
		inventory.replace(sku, total);
		return total;
	}

	@Override
	public int reduce(String sku, int amount) throws InventoryException {
		Integer oldStock = inventory.get(sku);
		int total = oldStock - amount;
		if (total >= 0) {
			inventory.replace(sku, total);
		} else {
			throw new InventoryException("库存不足");
		}
		return total;
	}

}
