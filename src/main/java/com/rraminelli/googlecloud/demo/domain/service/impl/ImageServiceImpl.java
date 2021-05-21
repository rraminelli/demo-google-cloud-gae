package com.rraminelli.googlecloud.demo.domain.service.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.PredefinedAcl;
import com.google.cloud.storage.StorageOptions;
import com.rraminelli.googlecloud.demo.domain.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

	private static Storage storage = StorageOptions.getDefaultInstance().getService();
	
	@Override
	public String saveImage(MultipartFile file) {
		try {
			BlobInfo blobInfo = storage.create(BlobInfo.newBuilder("demo-api-rraminelli", file.getOriginalFilename()).build(), 
					file.getBytes(),
					BlobTargetOption.predefinedAcl(PredefinedAcl.PUBLIC_READ));
			return blobInfo.getMediaLink();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
