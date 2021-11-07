package com.huashuo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShoppingCartMapper {
	//购物车 增
	public int insert(ShoppingCartDto shoppingCart);
	//购物车 删
	public int delete(ShoppingCartDto shoppingCart);
	//购物车 改
	public int update(ShoppingCartDto shoppingCart);
	//购物车 查
	public List<ShoppingCartDto> findAll(ShoppingCartDto shoppingCart);
}
