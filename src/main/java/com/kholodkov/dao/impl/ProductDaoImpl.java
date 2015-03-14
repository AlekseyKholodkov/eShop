package com.kholodkov.dao.impl;

import com.kholodkov.dao.ProductDao;
import com.kholodkov.dao.exception.DaoSystemException;
import com.kholodkov.dao.exception.NoSuchEntityException;
import com.kholodkov.entity.Product;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Servlet#5-1 38:00
 */
public class ProductDaoImpl implements ProductDao {
    private final Map<Integer, Product> memoryMock = new ConcurrentHashMap<>();

    public ProductDaoImpl() {
        this.memoryMock.put(1, new Product(1, "Bread"));
        this.memoryMock.put(2, new Product(2, "Paper"));
        this.memoryMock.put(3, new Product(3, "Sugar"));
    }


    @Override
    public Product selectById(int id) throws NoSuchEntityException, DaoSystemException {
        if (!memoryMock.containsKey(id)) {
            throw new NoSuchEntityException("No product for id == '" + id + "', only id = 1..3");
        }
        return memoryMock.get(id);
    }

    @Override
    public List<Product> selectAll() throws DaoSystemException {
//       List<Product> products = (ArrayList)memoryMock.values();
//        return products;
        return new ArrayList<>(memoryMock.values());
    }
}
