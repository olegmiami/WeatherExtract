import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.commons.validator.UrlValidator;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * The purpose of this class is to extract info about the weather from a site
 * @author Oleg  Astafyev
 */

public class WeatherExtract {

    final static String API_KEY = "453e1f9cd56745e2b4f8353fba9d27be";
    static UrlValidator validator = new UrlValidator();
    static String timeNow = java.time.LocalTime.now().toString().substring(0,2);
    static int hoursLeft = 24 - Integer.parseInt(timeNow); // hours left in a day
    static LinkedList<String> leftHoursList;
    static LinkedList<String> leftWeatherList;
    static LinkedList<String> leftIconsList;

    /**
     * Static helper method to save url as text
     * @param urlString the url to save
     * @return a string representation of the url
     * @throws Exception
     */
    private static String readUrl(String urlString) throws IOException {

            BufferedReader reader = null;
            try {
                URL url = new URL(urlString);
                reader = new BufferedReader(new InputStreamReader(url.openStream()));
                StringBuffer buffer = new StringBuffer();
                int read;
                char[] chars = new char[1024];
                while ((read = reader.read(chars)) != -1)
                    buffer.append(chars, 0, read);

                return buffer.toString();
            } finally {
                if (reader != null)
                    reader.close();
            }
        }

    /**
     * A method to retrieve information about temperature and description from the given link
     * @param url the link to get info from
     * @return info about temperature and description
     */

    public static String getInfo(String url) {

        JsonElement description;
        JsonElement temperature;

            try {
                description = new JsonParser().parse(readUrl(url)).getAsJsonObject().get("data").
                        getAsJsonArray().get(0).getAsJsonObject().get("weather").getAsJsonObject().get("description"); //getting deeper in layers of the data and retrieving the description
                temperature = new JsonParser().parse(readUrl(url)).getAsJsonObject().get("data").
                        getAsJsonArray().get(0).getAsJsonObject().get("temp"); // retrieving the temperature

                return description.toString() + temperature.toString();
            }

            catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

    /**
     * A method to get current temperature
     * @param url url to get current temp from
     * @return the current temperature
     */
    public static String getTemp(String url) {

        JsonElement temp;

        try {

            temp = new JsonParser().parse(readUrl(url)).getAsJsonObject().get("data").
                    getAsJsonArray().get(0).getAsJsonObject().get("temp"); // retrieving the temperature

            return temp.toString();
        }

        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * A method to get current temperature
     * @param url url to get current temp from
     * @return the current temperature
     */
    public static String getDescription(String url) {

        JsonElement info;

        try {

            info = new JsonParser().parse(readUrl(url)).getAsJsonObject().get("data").
                    getAsJsonArray().get(0).getAsJsonObject().get("weather").getAsJsonObject().get("description");

            return info.toString();
        }

        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * A method to get hourly temperature for the day
     * @return hourly temperature for the day
     */
    public static void getHourly() {

        leftHoursList = new LinkedList<>(); //linked list with all left hours
        leftWeatherList = new LinkedList<>(); //linked list with all temperature info for left hours
        leftIconsList = new LinkedList<>(); //linked list with all icons names for left hours


        //saving json data about the left hours in the day into "data" variable
        try {

            JsonElement data = new JsonParser().
                    parse(readUrl("https://api.weatherbit.io/v2.0/forecast/hourly?city=Kusterdingen&key=453e1f9cd56745e2b4f8353fba9d27be&hours=" + hoursLeft));

        //Adding the "skeleton" with timestamps to a linked list
        for (int i = Integer.parseInt(timeNow); i <24 ; i++) {

            leftHoursList.add("Time: " + i);
        }
        //adding the temperature info by iterating through skeleton linked list
        for (int i = 0; i < hoursLeft; i++) {

                leftWeatherList.add(data.getAsJsonObject().get("data").
                        getAsJsonArray().get(i).getAsJsonObject().get("temp").toString() + " | ");
                }
        //adding the icon info to a linked list
        for (int i = 0; i < hoursLeft; i++) {

            leftIconsList.add(data.getAsJsonObject().get("data").
                    getAsJsonArray().get(i).getAsJsonObject().get("weather").getAsJsonObject().get("icon").toString());
                }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
/**
        String result = ""; //string with the result of this method

        //To iterate over two linked lists simultaneously we need two iterators
        Iterator<String> i1 = leftHoursList.iterator();
        Iterator<String> i2 = leftWeatherList.iterator();

        while (i1.hasNext() && i2.hasNext()) {
            result += i1.next() + i2.next(); //composing the final string
        }

        return result; **/
    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        System.out.println(getInfo("https://api.weatherbit.io/v2.0/forecast/hourly?city=Kusterdingen&key=453e1f9cd56745e2b4f8353fba9d27be&hours=1"));
        System.out.println(getTemp("https://api.weatherbit.io/v2.0/forecast/hourly?city=Kusterdingen&key=453e1f9cd56745e2b4f8353fba9d27be&hours=1"));
        System.out.println(hoursLeft);
    }
}
