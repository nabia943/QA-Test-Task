package utilities;

import managers.FrameworkException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

public class DefaultConfiguration {

    protected static Logger logger = LogManager.getLogger("connector");
    protected static final String DEFAULT_CONFIGURATION = "Configs/Configuration.properties";
    protected static Properties props = new Properties();

    static {
        loadProperties(props, DEFAULT_CONFIGURATION);
    }

    protected static Properties loadProperties(Properties props, String configurationFile) {
        try {
            logger.debug("Loading Default properties file configuration:");

            props.load(new FileInputStream(new File(configurationFile)));
        } catch (Exception e) {
            logger.error("Error while loading Default properties file configuration: " + e);
            e.printStackTrace();
            props = null;
        }
        return props;
    }

    public static String getProperty(String name) {
        return props.getProperty(name, null);
    }

    public static void setProperty(String strKey, String strValue) {
        try {

            loadProperties(props, DEFAULT_CONFIGURATION);
            props.setProperty(strKey, strValue);
            props.store(new FileOutputStream(DEFAULT_CONFIGURATION), null);

        }

        catch (Exception e) {
            throw new FrameworkException("Unknown Error encountered while writing " + strKey
                    + " to configuration file. ---" + e.getClass() + "---" + e.getMessage());
        }
    }



    public static String getCurrentDate() {
        int month, date, year;
        String[] Date = LocalDateTime.now().toString().split("T")[0].split("-");
        date = Integer.parseInt(Date[2]);
        month = Integer.parseInt(Date[1]);
        year = Integer.parseInt(Date[0]);
        return month + "/" + date + "/" + year;
    }

    public static String getPastDate(String day) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();
        System.out.println(dateFormat.format(currentDate));

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        // manipulate date
        if(day.equalsIgnoreCase("before")) {
            c.add(Calendar.DATE, -4);
        }
        else if(day.equalsIgnoreCase("after")) {
            c.add(Calendar.DATE, 4);

        }
        Date currentDateMinusOne= c.getTime();
        System.out.println(dateFormat.format(currentDateMinusOne));
        return currentDateMinusOne.toString();
    }

    public static String getTimeStamp(String timeZone) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        if (timeZone.toLowerCase().equals("utc")) {
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        } else {
            dateFormat.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
        }
        return dateFormat.format(new Date());
    }

}
