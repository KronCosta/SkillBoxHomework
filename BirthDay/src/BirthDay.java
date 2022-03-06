import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class BirthDay {



    public static void main(String[] args) {

        DateFormat dateFormatEng = new SimpleDateFormat( "dd.MM.YYYY."+" - "+"EE", Locale.forLanguageTag("eng"));
        DateFormat dateFormatRus = new SimpleDateFormat( "dd.MM.YYYY."+" - "+"EE", Locale.forLanguageTag("ru"));
        DateFormat.getInstance();
        Calendar newCalendar = Calendar.getInstance();
        Calendar myCalendar = Calendar.getInstance();
        Date myDate = new Date(11,Calendar.JANUARY,1992);


        int month = Calendar.JANUARY;
        int year = 1992;
        int day = 11;
        int i = 1;
        myCalendar.set(year, month, day);

        while(newCalendar.after(myCalendar)){//Всё то же что и в первом коммите только условие цикла в виде "after\before"
            System.out.println(i + ". " + dateFormatRus.format(myCalendar.getTime())+ "\t" + dateFormatEng.format(myCalendar.getTime())   );
            myCalendar.add(Calendar.YEAR,1);
            i++;
        }      //Почему у меня захватывает 2021 год? Цикл должен закончиться же.
    }

}




