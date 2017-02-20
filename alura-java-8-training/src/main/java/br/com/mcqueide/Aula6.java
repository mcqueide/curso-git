package br.com.mcqueide;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Created by mcqueide on 20/02/17.
 */
public class Aula6 {

    public static void main(String[] args){
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate olimpiadasRio = LocalDate.of(2018, Month.JUNE,5);

        System.out.println("Faltam " + (olimpiadasRio.getYear() - hoje.getYear()) + " ano(s) para as olimpíadas");

        Period periodo = Period.between(hoje,olimpiadasRio);

        System.out.println(periodo);
        System.out.println("Faltam " + periodo.getYears() + " ano(s) para as olimpíadas");

        //A nova api de data é imutável, ela sempre irá retornar um novo objeto
        System.out.println("Próxima olimpíada será em: " + olimpiadasRio.plusYears(4));

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Próxima olimpíada será em: " + olimpiadasRio.format(formatador));

        DateTimeFormatter formatadorAgora = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        //classe para obter data e horário
        LocalDateTime agora = LocalDateTime.now();
        System.out.println("Agora é "+agora.format(formatadorAgora));

        //classe para horas
        LocalTime intervalo = LocalTime.of(15,30);
        DateTimeFormatter formatadorIntervalo = DateTimeFormatter.ofPattern("hh:mm");
        System.out.println("O horário do intervalo é "+intervalo.format(formatadorIntervalo));
    }
}
