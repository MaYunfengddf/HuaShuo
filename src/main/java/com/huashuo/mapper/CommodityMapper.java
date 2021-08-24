package com.huashuo.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommodityMapper {
	public List<CommodityDto> findAllId();
	public List<CommodityDto> findAllName(CommodityDto name);
	public List<CommodityDto> findAllModel(CommodityDto model);
	public List<CommodityDto> findAllPrice(@Param("small") BigDecimal small, @Param("large") BigDecimal large);
	//@Param("small") BigDecimal xxxx 的意思是xxxx在xml文件里改变量叫small；
}
