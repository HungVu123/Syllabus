package com.group.syllabus;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group.syllabus.model.Syllabus;
import com.group.syllabus.repository.SyllabusRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@SpringBootApplication

public class SyllabusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyllabusApplication.class, args);
	}
}
