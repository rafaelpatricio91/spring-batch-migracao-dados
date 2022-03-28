package com.rafa.migracaodados.reader;

import java.util.Date;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.validation.BindException;

import com.rafa.migracaodados.domain.Pessoa;

@Configuration
public class ArquivoPessoasReaderConfig {

	@Bean
	public FlatFileItemReader<Pessoa> arquivoPessoasReader() {
		return new FlatFileItemReaderBuilder<Pessoa>()
				.name("arquivoPessoasReader")
				.resource(new FileSystemResource("files/pessoas.csv"))
				.delimited()
				.names("nome","email","dataNascimento","idade","id")
				.addComment("--") //string que é usado como delimitador de comentario no arquivo. será ignorado na leitura.
				.fieldSetMapper(fieldSetMapper()) //para mapear e fazer o cast necessario dos campos
				.build();
	}

	private FieldSetMapper<Pessoa> fieldSetMapper() {
		
		return new FieldSetMapper<Pessoa>() {

			@Override
			public Pessoa mapFieldSet(FieldSet fieldSet) throws BindException {
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(fieldSet.readString("nome"));
				pessoa.setEmail(fieldSet.readString("email"));
				pessoa.setDataNascimento(new Date(fieldSet.readDate("dataNascimento", "yyyy-MM-dd HH:mm:ss").getTime()));
				pessoa.setIdade(fieldSet.readInt("idade"));
				pessoa.setId(fieldSet.readInt("id"));
				return pessoa;
			}
		};
	}
}
