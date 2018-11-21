package com.study.cloud.demoservice.service;

import com.study.cloud.demoservice.exception.InventoryException;

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
     * @param sku
     * @return
     */
    int get(String sku);

    /**
     * 获取所有库存
     *
     * @return
     */
    Map<String, Integer> getAll();

    /**
     * 增加库存
     *
     * @param sku
     * @param amount
     * @return
     */
    int add(String sku, int amount) throws InventoryException;

    /**
     * 减少库存
     *
     * @param sku
     * @param amount
     * @return
     */
    int reduce(String sku, int amount) throws InventoryException;

}
