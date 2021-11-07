package com.huashuo.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huashuo.beans.AllGoodsResponse;
import com.huashuo.beans.HomePageRequest;
import com.huashuo.mapper.AddressDto;
import com.huashuo.mapper.HomePageDto;
import com.huashuo.service.HomePageService;

@RestController
@RequestMapping("/huashuo")
public class HomePageController {
	Logger log = LoggerFactory.getLogger(CommodityController.class);
	
	@Autowired
	private HomePageService homePageService;
	/**
	 * 主页推荐 增
	 * @return HomePageRequest
	 */
	@RequestMapping("/HomePageInput")
	public AllGoodsResponse HomePageInput(@RequestBody HomePageRequest homePageRequest){
		System.out.println("主页推荐 增" + homePageRequest);

		log.info("订单键{}", homePageRequest.getRecommend());
				
		AllGoodsResponse allGoodsResponse = new AllGoodsResponse();
		boolean boo = homePageService.write(homePageRequest.getRecommend());
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
	 *主页推荐 删 
	 * @return
	 */
	@RequestMapping("/HomePageDelete")
	public AllGoodsResponse HomePageDelete(@RequestBody HomePageRequest homePageRequest){
		System.out.println(homePageRequest + "主页推荐 删");
		log.info("订单ID{}",homePageRequest.getId());
		
		AllGoodsResponse allGoodsResponse = new AllGoodsResponse();
		boolean boo = homePageService.delete(homePageRequest.getId());
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
	 *  主页推荐 改 
	 * @return
	 */
	@RequestMapping("/HomePageModify")
	public AllGoodsResponse HomePageModify(@RequestBody HomePageRequest homePageRequest){
		System.out.println( " 主页推荐 改"  + homePageRequest);
		log.info("订单账号{}，订单键{}，订单Id{}",  homePageRequest.getRecommend(), homePageRequest.getId());
				
		AllGoodsResponse allGoodsResponse = new AllGoodsResponse();
		boolean boo = homePageService.modify(homePageRequest.getRecommend(), homePageRequest.getId());
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
	 *  主页推荐 默认查
	 * @return
	 */
	@RequestMapping("/HomePageQuery")
	public List<HomePageDto> HomePageQuery(){
		System.out.println("主页推荐 默认查");
		List<HomePageDto> array = homePageService.inquiry();
		System.out.println(array);
		return array;
	}
	/** 
	 *  主页推荐 全部input查
	 * @return
	 */
	@RequestMapping("/AllQuery")
	public List<HomePageDto> AllQuery(HttpServletRequest request, @RequestBody HomePageRequest homePageRequest){
		System.out.println("主页推荐 input查");
		log.info("input查{}", homePageRequest.getQuery());
		
		List<HomePageDto> query = homePageService.allQuery(homePageRequest.getQuery());
		
		return query;
	}
}
