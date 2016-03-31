import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class FunWithCalender {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Calendar calendar = Calendar.getInstance();
        int timeRangeInDays = 270;
        calendar.add(Calendar.DATE, -1 * (timeRangeInDays + 7));
        Long eventFilterStartTS = calendar.getTimeInMillis();
        System.out.println(String.format("Date before %s days from today: %s. Job start TS: %s",
                timeRangeInDays + 7, new Date(calendar.getTimeInMillis()), eventFilterStartTS));


        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM");
        List<String> tableNames = new ArrayList<String>();

        if(calendar.get(Calendar.YEAR)< 2015 || (calendar.get(Calendar.YEAR) == 2015 && calendar.get(Calendar.MONTH) + 1 < 9)){
            tableNames.add("EVENT_ACCOUNTS");
            calendar.set(Calendar.YEAR,2015);
            calendar.set(Calendar.MONTH,8);
        }

        while (calendar.getTimeInMillis() < System.currentTimeMillis()) {
            tableNames.add(dateFormat.format(calendar.getTime()));
            calendar.add(Calendar.MONTH, 1);
        }
        String inputTables = String.join(",", tableNames);
        System.out.println(String.format("Event Tables referred for the data %s", inputTables));
    }
}
