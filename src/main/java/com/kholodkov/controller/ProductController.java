package com.kholodkov.controller;

import com.kholodkov.dao.ProductDao;
import com.kholodkov.dao.exception.DaoSystemException;
import com.kholodkov.dao.exception.NoSuchEntityException;
import com.kholodkov.entity.Product;
import com.kholodkov.inject.DependencyInjectorServlet;
import com.kholodkov.inject.Inject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductController extends DependencyInjectorServlet {
    private static final String PARAM_ID = "id";
    private static final String ATTRIBUTE_MODEL_TO_VIEW = "product";
    private static final String PAGE_OK = "product.jsp";
    private static final String PAGE_ERROR = "error.jsp";

//    private ProductDao productDao = new ProductDaoImpl();
    @Inject("productDaoInject")
    private ProductDao productDao;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter(PARAM_ID);
        if (idStr != null) {
            try {
                Integer id = Integer.valueOf(idStr);
                Product product = this.productDao.selectById(id);
                request.setAttribute(ATTRIBUTE_MODEL_TO_VIEW, product);
                request.getRequestDispatcher(PAGE_OK).forward(request, response);
                return;
            } catch (NumberFormatException | NoSuchEntityException | DaoSystemException e) {

            }
        }
        response.sendRedirect(PAGE_ERROR);
    }
}
