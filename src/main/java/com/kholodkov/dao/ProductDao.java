package com.kholodkov.dao;

import com.kholodkov.dao.exception.DaoSystemException;
import com.kholodkov.dao.exception.NoSuchEntityException;
import com.kholodkov.entity.Product;

import java.util.List;

/**
 * Created by Aleksey on 24.02.2015.
 */

//CRUD operations
//create  = SQL/insert  = List/add
//read    = SQL/select  = List/get
//update  = SQL/update  = List/set
//delete  = SQL/remove  = List/remove

//Java - DAO - DataBase



public interface ProductDao {
    /**
     * Never return null!
     */
    public Product selectById(int id) throws DaoSystemException, NoSuchEntityException;
    public List<Product> selectAll() throws DaoSystemException;
}
