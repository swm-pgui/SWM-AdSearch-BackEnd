package com.soma.pgui.domain.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductsRepository extends JpaRepository<Products, Long> {
}
