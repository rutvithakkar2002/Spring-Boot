package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.WishListBean;
import com.dao.WishDao;
import com.dto.WishListDto;

@RestController
public class WishListController {

	@Autowired
	WishDao wishDao;
	
	@PostMapping("/wishlist")
	public WishListBean addWishList(@RequestBody WishListBean wish)
	{
		System.out.println(wish.getUserId());
		System.out.println(wish.getProductId());
		wishDao.insertWish(wish);
		return wish;
	}
	
	@GetMapping("/wishlist")
	public List<WishListDto> getAllWish()
	{
		List<WishListDto> wishListItems=wishDao.getAllWish();
		return wishListItems;
	}
	
	@GetMapping("/wishlist/{userId}")
	public List<WishListDto> getAllWishByUser(@PathVariable("userId") Integer userId)
	{
		List<WishListDto> wishListItems= wishDao.getAllWishByUser(userId);
		return wishListItems;
	}
	
	
	
}
