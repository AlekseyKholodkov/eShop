package com.kholodkov.controller;

import com.kholodkov.dao.ProductDao;
import com.kholodkov.dao.exception.DaoSystemException;
import com.kholodkov.dao.exception.NoSuchEntityException;
import com.kholodkov.entity.Product;
import com.kholodkov.inject.DependencyInjectorServlet;
import com.kholodkov.inject.Inject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.kholodkov.controller.SessionAttributes.PRODUCTS_IN_CART;

import static java.util.Collections.singletonMap;
import static java.util.Collections.unmodifiableMap;

/**
 *
 */
public class ProductAddToCartController extends DependencyInjectorServlet {
    private static final String PARAM_ID = "id";
    private static final String PAGE_ERROR = "error.jsp";

    @Inject("productDaoInject")
    private ProductDao productDao;

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String idStr = request.getParameter(PARAM_ID);
        if (idStr != null) {
            try {
                Integer id = Integer.valueOf(idStr);
                Product product = productDao.selectById(id);

                HttpSession session = request.getSession(true);
                Map<Product, Integer> oldCart = (Map<Product, Integer>)session.getAttribute(PRODUCTS_IN_CART);
                if (oldCart == null) {
                    session.setAttribute(PRODUCTS_IN_CART, singletonMap(product, 1));
                } else {
                    Map<Product, Integer> newCart = new LinkedHashMap<>(oldCart);
                    if (!newCart.containsKey(product)) {
                        newCart.put(product, 1);
                    } else {
                        newCart.put(product, newCart.get(product) + 1);
                    }
                    session.setAttribute(PRODUCTS_IN_CART, unmodifiableMap(newCart));
                }
//                OK
                String newLocation = "product.do?id=" + id;
                response.sendRedirect(newLocation);
                return;
            } catch (DaoSystemException | NoSuchEntityException ex) {
                /*NOP*/
            }
//        FAIL
        } else {
            response.sendRedirect(PAGE_ERROR);
        }
    }
}
