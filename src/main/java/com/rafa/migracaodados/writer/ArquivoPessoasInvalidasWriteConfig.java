package com.rafa.migracaodados.writer;

import javax.lang.model.element.Name;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.rafa.migracaodados.domain.Pessoa;

@Configuration
public class ArquivoPessoasInvalidasWriteConfig {
	@Bean
	public FlatFileItemWriter<Pessoa> arquivoPessoasInvalidasWriter() {
		return new FlatFileItemWriterBuilder<Pessoa>()
			.name("arquivoPessoasInvalidasWriter")
			.resource(new FileSystemResource("files/pessoas_invalidas.csv"))
			.delimited()
			.names("id")
			.build();
	}
}
