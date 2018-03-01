package novidadesJava8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
	
	public static void main(String[] args) {
		 LocalDate hoje = LocalDate.now();
		 System.out.println(hoje);
		 
		 LocalDate dataHomemSaturno = LocalDate.of(2099, Month.JANUARY, 25);
		 int anos = dataHomemSaturno.getYear() - hoje.getYear();
		 System.out.println(anos);
		 
		 Period periodo = Period.between(hoje, dataHomemSaturno);
		 System.out.println(periodo.getMonths());
		 System.out.println(periodo.getDays());
		 
		 System.out.println(dataHomemSaturno.plusYears(4));
		 
		 
		 DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 System.out.println(dataHomemSaturno.format(formatador));
		 
		 DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		 LocalDateTime agora = LocalDateTime.now();
		 System.out.println(agora.format(formatadorComHoras));
		 
		 LocalTime intervaloAula = LocalTime.of(15, 30);
		 System.out.println(intervaloAula);
		 
		 
		 
	}
}
