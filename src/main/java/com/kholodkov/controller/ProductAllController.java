package com.kholodkov.controller;

import com.kholodkov.dao.ProductDao;
import com.kholodkov.dao.exception.DaoSystemException;
import com.kholodkov.dao.impl.ProductDaoImpl;
import com.kholodkov.entity.Product;
import com.kholodkov.inject.DependencyInjectorServlet;
import com.kholodkov.inject.Inject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 */
public class ProductAllController extends DependencyInjectorServlet {
    public static final String ATTRIBUTE_MODEL_TO_VIEW = "productList";
    public static final String PAGE_OK = "productAll.jsp";
    public static final String PAGE_ERROR = "error.jsp";

    @Inject("productDaoInject")
    private ProductDao productDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Product> products = productDao.selectAll();
            request.setAttribute(ATTRIBUTE_MODEL_TO_VIEW, products);

            request.getRequestDispatcher(PAGE_OK).forward(request, response);
            return;
        } catch (DaoSystemException ignore) {

        }
        response.sendRedirect(PAGE_ERROR);
    }
}
