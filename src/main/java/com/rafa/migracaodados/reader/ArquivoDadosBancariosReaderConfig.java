package com.rafa.migracaodados.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.rafa.migracaodados.domain.DadosBancarios;

@Configuration
public class ArquivoDadosBancariosReaderConfig {
	
	@Bean
	public FlatFileItemReader<DadosBancarios> arquivoDadosBancariosReader() {
		return new FlatFileItemReaderBuilder<DadosBancarios>()
				.name("arquivoDadosBancariosReader")
				.resource(new FileSystemResource("files/dados_bancarios.csv"))
				.delimited()
				.names("pessoaId","agencia","conta","banco","id")
				.addComment("--") //string que é usado como delimitador de comentario no arquivo. será ignorado na leitura.
				.targetType(DadosBancarios.class) //como nao possui obj complexo como date, pode ser mapeado direto desta forma. sem mapper.
				.build();
	}
}
