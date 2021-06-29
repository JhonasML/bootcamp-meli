package aula2.tm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
Crie uma classe Data. A classe conterá, além dos construtores que você considera apropriados, métodos de acesso e o método toString, conforme explicamos no exercício anterior,
 um método para verificar se a data está correta e outro para adicionar um dia ao valor atual da data.
A classe GregorianCalendar deve ser investigada e usada para implementar os construtores e métodos Date.
 */
public class Exercicio5 {

}

 class Data {
     private GregorianCalendar gc;
     private Date dataParaManipular;
     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

     public Data(Date data){
         this.gc = new GregorianCalendar();
         this.gc.setTime(data);
         this.dataParaManipular = data;
     }

     public Data(String data){
         try {
             this.gc = new GregorianCalendar();
             this.gc.setTime(formatter.parse(data));
         } catch (ParseException e) {
             e.printStackTrace();
         }
     }

     public Data(int dia, int mes, int ano){
         this.gc = new GregorianCalendar();
         this.gc.set( ano,mes, dia);
     }

     public Date getData(){
         return this.dataParaManipular;
     }

     public void adicionarDia(int quantidade){
         gc.add(Calendar.DAY_OF_MONTH, 1);
         dataParaManipular = gc.getTime();
     }

     public int getMinutos(){
         return getCampo(Calendar.MINUTE);
     }

     public int getHoras(){
         return getCampo(Calendar.HOUR);
     }

     private int getCampo(int tipoCampo){
         return gc.get(tipoCampo);
     }

     @Override
     public String toString(){
         return formatter.format(dataParaManipular);
     }

 }