package com.kubilaycicek.demo;

import com.kubilaycicek.demo.util.ImageConverter;
import org.apache.commons.io.FileUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Path filePath;

		String inputFilePath = "test_image.jpg";
		String outputFilePath = "test_image_copy.jpg";

		Path root = FileSystems.getDefault().getPath("").toAbsolutePath();

		filePath = Paths.get(root.toString(),"src", "main", "resources", inputFilePath);
		System.out.println("Image : "+ filePath);


		String base64Image=ImageConverter.ConvertImageFileToBase64String(filePath.toFile().getAbsolutePath());
		System.out.println("Base64 Image : " +base64Image);

		filePath = Paths.get(root.toString(),"src", "main", "resources", outputFilePath);

		ImageConverter.ConvertBase64ToImageFile(base64Image,filePath.toFile().getAbsolutePath());
		System.out.println("New Image : "+ filePath);
	}
}
