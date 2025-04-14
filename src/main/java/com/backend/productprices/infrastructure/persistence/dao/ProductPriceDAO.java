package com.backend.productprices.infrastructure.persistence.dao;

import com.backend.productprices.domain.entity.ProductPriceSearchCriteria;
import com.backend.productprices.infrastructure.persistence.model.ProductPricePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductPriceDAO {

    @Select("""
       SELECT
            product_id AS productId,
            brand_id AS brandId,
            price_list_id AS priceListId,
            price,
            currency,
            start_date AS startDate,
            end_date AS endDate,
            priority
       FROM prices
       WHERE
           product_id = #{criteria.productId}
           AND brand_id = #{criteria.brandId}
           AND #{criteria.date} BETWEEN start_date AND end_date
    """)
    List<ProductPricePO> getByCriteria(@Param("criteria") ProductPriceSearchCriteria criteria);
}
