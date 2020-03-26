package com.w.product.api.service;

import com.w.base.BaseResponse;
import com.w.member.output.dto.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @description: 商品搜索服务接口
 */
public interface ProductSearchService {

	@GetMapping("/search")
	public BaseResponse<List<ProductDto>> search(String name);

}
