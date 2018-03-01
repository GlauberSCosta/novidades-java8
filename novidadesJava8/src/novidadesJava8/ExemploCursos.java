package novidadesJava8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Curso {

	private String nome;
	private int alunos;
	
	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}
	public String getNome() {
		return nome;
	}
	public int getAlunos() {
		return alunos;
	}
}

public class ExemploCursos{
	
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new  Curso("Python", 45));
		cursos.add(new  Curso("JavaScript", 150));
		cursos.add(new  Curso("Java 8", 113));
		cursos.add(new  Curso("C", 55));
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		
//		cursos.forEach(c -> System.out.println(c.getNome()));
		
		cursos.stream()
			.filter(c -> c.getAlunos() > 50)
			.forEach(c -> System.out.println(c.getNome()));
		
		cursos.stream()
		.filter(c -> c.getAlunos() > 50)
		.map(Curso::getNome);
	
		cursos.stream()
		   .filter(c -> c.getAlunos() > 50)
		   .map(Curso::getAlunos)
		   .forEach(System.out::println);
		
		int sum = cursos.stream()
		.filter(c -> c.getAlunos() > 100)
		.mapToInt(Curso::getAlunos)
		.sum();
		
		System.out.println(sum);
		
//		NullPointer
//		Optional<Curso> optional = cursos.stream().filter(c -> c.getAlunos() >= 1000).findAny();
//		Curso curso = optional.orElse(null);
//		System.out.println(curso.getNome());
		
		Optional<Curso> optional = cursos.stream()
										 .filter(c -> c.getAlunos() >= 50)
										 .findFirst();
		
		optional.ifPresent(c -> System.out.println(c.getNome()));
		
		
		OptionalDouble mediaAlunos = cursos.stream().mapToInt(c -> c.getAlunos()).average();
		mediaAlunos.ifPresent(System.out::println);
		
		Stream<Curso> stream = cursos.stream()
				   .filter(c -> c.getAlunos() > 50);
		List<Curso> list = stream.collect(Collectors.toList());
		
	}
}