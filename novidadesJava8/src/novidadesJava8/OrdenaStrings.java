package novidadesJava8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStrings {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		
		palavras.add("crossfit 40 graus");
		palavras.add("crossfit");
		palavras.add("crossfit open games ");
		
		Comparator<String> comparador = new ComparadorPorTamanho();
		
//		Collections.sort(palavras, comparador);
		
		palavras.sort((s1, s2) -> {
			if (s1.length() < s2.length()) 
				return -1;
			if(s2.length() < s1.length())
				return 1;
			
			return 0;
		});
		
		palavras.sort((s1, s2) ->Integer.compare(s1.length(), s2.length()));
		
		palavras.sort(Comparator.comparing( s -> s.length()));
		palavras.sort(Comparator.comparing( String::length));
		palavras.sort(String.CASE_INSENSITIVE_ORDER);
		
		
		Function<String, Integer> funcao = new Function<String, Integer>(){
			public Integer apply(String s) {
				return s.length();
			}
		};
		Comparator<String> comparador1 = Comparator.comparing(funcao);
		palavras.sort(comparador1);
		
		new Thread(new Runnable() {

		    @Override
		    public void run() {
		        System.out.println("Executando um Runnable");
		    }

		}).start();
		
		new Thread( () -> System.out.println("Executando um Runnable")).start();;
		
		System.out.println(palavras);
		
//		
//		for (String p : palavras) {
//		 System.out.println(p);	
//		}
//		Consumer<String> consumidor = new ImprimeNaLinha();

		Consumer<String> consumidor = s -> System.out.println(s);;

		palavras.forEach(consumidor);

		palavras.forEach(s -> System.out.println(s));
		
		palavras.forEach(System.out::println);
		
		
	}
}
class ComparadorPorTamanho implements Comparator<String>{

	@Override
	public int compare(String arg0, String arg1) {

		if (arg0.length() < arg1.length()) 
			return -1;
		if(arg1.length() < arg0.length())
			return 1;
		
		return 0;
	}
	
	
}

class ImprimeNaLinha implements Consumer<String>{

	@Override
	public void accept(String t) {
		System.out.println(t);
	}
	
}