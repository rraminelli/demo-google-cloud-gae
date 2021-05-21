package com.rraminelli.googlecloud.demo.domain.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

	String saveImage(MultipartFile file);
	
}
