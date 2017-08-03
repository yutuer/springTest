package com.yutuer.core.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yutuer.core.exception.BusinessException;

@Service
public class TestBService {

	@Transactional
	public void testB(int i) throws Exception {
		if(i == 6){
			throw new BusinessException("抛异常");
		}
	}
}
