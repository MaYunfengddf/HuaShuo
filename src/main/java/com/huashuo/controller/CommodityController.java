package com.huashuo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huashuo.beans.AllGoodsRequest;
import com.huashuo.beans.AllGoodsResponse;
import com.huashuo.mapper.AllGoodsDto;
import com.huashuo.service.AllGoodsService;

@RestController
@RequestMapping("/huashuo")
public class CommodityController {
	Logger log = LoggerFactory.getLogger(CommodityController.class);
	
	@Autowired
	public AllGoodsService allGoodsService;
	
	/**
	 * 商品维护 增
	 * @return
	 */
	@RequestMapping("/AllGoodsWrite")
	public AllGoodsResponse AllGoodsWrite(@RequestBody AllGoodsRequest allGoodsRequest){
		System.out.println("增加商品");
		
		log.info("商品名称{}，商品型号{}，商品颜色{}，商品尺寸{}，商品价格{}，商品图片{}，商品库存{}，商品定位{}，商品处理器{}，商品内存{}，商品硬盘", 
				allGoodsRequest.getName(), allGoodsRequest.getModel(),allGoodsRequest.getColour(), allGoodsRequest.getSize(),
				allGoodsRequest.getPrice(), allGoodsRequest.getImages(),allGoodsRequest.getQuantity(), allGoodsRequest.getType(),
				allGoodsRequest.getProcessor(), allGoodsRequest.getMemory(),allGoodsRequest.getHarddisk());
				
		AllGoodsResponse allGoodsResponse = new AllGoodsResponse();
		boolean boo = allGoodsService.write(allGoodsRequest.getName(), allGoodsRequest.getModel(),allGoodsRequest.getColour(), allGoodsRequest.getSize(),
				allGoodsRequest.getPrice(), allGoodsRequest.getImages(),allGoodsRequest.getQuantity(), allGoodsRequest.getType(),
				allGoodsRequest.getProcessor(), allGoodsRequest.getMemory(),allGoodsRequest.getHarddisk());
		if(boo) {
			allGoodsResponse.setCode("0000");
			allGoodsResponse.setMessage("添加成功");
		} else {
			allGoodsResponse.setCode("9999");
			allGoodsResponse.setMessage("添加失败");
		}
		return allGoodsResponse;
	}
	
	/**
	 * 商品维护 删
	 * @return
	 */
	@RequestMapping("/AllGoodsDelete")
	public AllGoodsResponse AllGoodsDelete(@RequestBody AllGoodsRequest allGoodsRequest){
		System.out.println("删除商品");
		log.info("商品ID{}",allGoodsRequest.getName());
				
		AllGoodsResponse allGoodsResponse = new AllGoodsResponse();
		boolean boo = allGoodsService.delete(allGoodsRequest.getId());
		if(boo) {
			allGoodsResponse.setCode("0000");
			allGoodsResponse.setMessage("添加成功");
		} else {
			allGoodsResponse.setCode("9999");
			allGoodsResponse.setMessage("添加失败");
		}
		return allGoodsResponse;
	}
	
	/**
	 * 商品维护 改
	 * @return
	 */
	@RequestMapping("/AllGoodsModify")
	public AllGoodsResponse AllGoodsModify(@RequestBody AllGoodsRequest allGoodsRequest){
		log.info("商品名称{}，商品型号{}，商品颜色{}，商品尺寸{}，商品价格{}，商品图片{}，商品库存{}，商品定位{}，商品处理器{}，商品内存{}，商品硬盘", 
				allGoodsRequest.getName(), allGoodsRequest.getModel(),allGoodsRequest.getColour(), allGoodsRequest.getSize(),
				allGoodsRequest.getPrice(), allGoodsRequest.getImages(),allGoodsRequest.getQuantity(), allGoodsRequest.getType(),
				allGoodsRequest.getProcessor(), allGoodsRequest.getMemory(),allGoodsRequest.getHarddisk(),allGoodsRequest.getId());
				
		AllGoodsResponse allGoodsResponse = new AllGoodsResponse();
		boolean boo = allGoodsService.modify(allGoodsRequest.getName(), allGoodsRequest.getModel(),allGoodsRequest.getColour(), allGoodsRequest.getSize(),
				allGoodsRequest.getPrice(), allGoodsRequest.getImages(),allGoodsRequest.getQuantity(), allGoodsRequest.getType(),
				allGoodsRequest.getProcessor(), allGoodsRequest.getMemory(),allGoodsRequest.getHarddisk(),allGoodsRequest.getId());
		if(boo) {
			allGoodsResponse.setCode("0000");
			allGoodsResponse.setMessage("添加成功");
		} else {
			allGoodsResponse.setCode("9999");
			allGoodsResponse.setMessage("添加失败");
		}
		return allGoodsResponse;
	}
	
	/**
	 * 商品维护 查
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/AllGoodsInquiry")
	public List<AllGoodsDto> AllGoodsInquiry(){
		System.out.println("查询商品");
		List<AllGoodsDto> str = allGoodsService.inquiry();
		return str;
	}
	
	/**
	 * 指定id 查
	 * @param allGoodsRequest
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/AllGoodsInquiry2")
	public List<AllGoodsDto> AllGoodsInquiry2(@RequestBody AllGoodsRequest allGoodsRequest){
		System.out.println("查询商品指定id");
		log.info("商品ID{}",allGoodsRequest.getId());
		
		List<AllGoodsDto> str = allGoodsService.inquiry(allGoodsRequest.getId());
		return str;
	}
}
