package com.w.zuul.mapper;

import com.w.zuul.mapper.entity.MeiteBlacklist;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface BlacklistMapper {

	@Select(" select ID AS ID ,ip_addres AS ipAddres,restriction_type  as restrictionType, availability  as availability from meite_blacklist where  ip_addres =#{ipAddres} and  restriction_type='1' ")
	MeiteBlacklist findBlacklist(String ipAddres);

}
