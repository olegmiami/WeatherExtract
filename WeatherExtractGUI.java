import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.text.*;


/**
 * The purpose of this class is a GUI for the WeatherExtract
 * @author Oleg  Astafyev
 */

public class WeatherExtractGUI extends WeatherExtract {

    private JFrame frame;

    WeatherExtractGUI() {

        //create frame
        frame = new JFrame("Weather+Fashion");
        frame.setSize(900, 700);

        FlowLayout aFlowLayout = new FlowLayout(FlowLayout.LEFT, 50, 50);

        //Creating a panel with Flow layout
        JPanel panel = new JPanel();
        panel.setLayout(aFlowLayout);
        panel.setBackground(Color.BLACK);

        String currentTemp = getTemp("https://api.weatherbit.io/v2.0/forecast/hourly?city=Kusterdingen&key=453e1f9cd56745e2b4f8353fba9d27be&hours=1");
        String currentInfo = getDescription("https://api.weatherbit.io/v2.0/forecast/hourly?city=Kusterdingen&key=453e1f9cd56745e2b4f8353fba9d27be&hours=1");

        //Creating a label for "Current weather" text and adding it to the panel
        JLabel currentWeather = new JLabel("Current weather: " + currentTemp + "°С", SwingConstants.LEFT);
        currentWeather.setFont(new Font("Monospaced", Font.BOLD, 30));
        currentWeather.setForeground(Color.white);
        panel.add(currentWeather);



        //Creating a label for description text and adding it to the panel
        JLabel description = new JLabel(currentInfo);
        description.setFont(new Font("Monospaced", Font.BOLD, 30));
        description.setForeground(Color.white);
        panel.add(description);

        //Updating info about left hours
        getHourly();

        Iterator<String> hours = leftHoursList.iterator();
        Iterator<String> degrees = leftWeatherList.iterator();
        Iterator<String> icons = leftIconsList.iterator();

        JList<BufferedImage> listOfIcons = new JList<>();
        DefaultListModel<BufferedImage> model = new DefaultListModel<>();

        while (icons.hasNext()) {
            model.addElement(icons.next().substring(1,6));
        }

        /**
        //Creating labels with timestamps, degrees and icons for left hours
        while (hours.hasNext() && degrees.hasNext() && icons.hasNext()) {
        }**/


        //add window listener for closing window
        frame.addWindowListener(new WindowListener());
        frame.getContentPane().add(panel);
        frame.setVisible(true); //set the frame visible


        //------------------------------------------------------------------------------------------------------------------

        /**
         * Creating ImageIcons for all possible weather states
         */

        try {
            BufferedImage a01d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//a01d.png"));
            BufferedImage a01n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//a01n.png"));
            BufferedImage a02d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//a02d.png"));
            BufferedImage a02n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//a02n.png"));
            BufferedImage a03d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//a03d.png"));
            BufferedImage a03n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//a03n.png"));
            BufferedImage a04d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//a04d.png"));
            BufferedImage a04n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//a04n.png"));
            BufferedImage a05d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//a05d.png"));
            BufferedImage a05n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//a05n.png"));
            BufferedImage a06d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//a06d.png"));
            BufferedImage a06n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//a06n.png"));
            BufferedImage c01d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//c01d.png"));
            BufferedImage c01n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//c01n.png"));
            BufferedImage c02d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//c02d.png"));
            BufferedImage c02n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//c02n.png"));
            BufferedImage c03d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//c03d.png"));
            BufferedImage c03n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//c03n.png"));
            BufferedImage c04d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//c04d.png"));
            BufferedImage c04n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//c04n.png"));
            BufferedImage d01d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//d01d.png"));
            BufferedImage d01n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//d01n.png"));
            BufferedImage d02d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//d02d.png"));
            BufferedImage d02n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//d02n.png"));
            BufferedImage d03d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//d03d.png"));
            BufferedImage d03n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//d03n.png"));
            BufferedImage f01d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//f01d.png"));
            BufferedImage f01n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//f01n.png"));
            BufferedImage r01d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//r01d.png"));
            BufferedImage r01n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//r01n.png"));
            BufferedImage r02d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//r02d.png"));
            BufferedImage r02n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//r02n.png"));
            BufferedImage r03d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//r03d.png"));
            BufferedImage r03n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//r03n.png"));
            BufferedImage r04d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//r04d.png"));
            BufferedImage r04n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//r04n.png"));
            BufferedImage r05d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//r05d.png"));
            BufferedImage r05n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//r05n.png"));
            BufferedImage r06d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//r06d.png"));
            BufferedImage r06n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//r06n.png"));
            BufferedImage s01d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//s01d.png"));
            BufferedImage s01n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//s01n.png"));
            BufferedImage s02d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//s02d.png"));
            BufferedImage s02n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//s02n.png"));
            BufferedImage s03d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//s03d.png"));
            BufferedImage s03n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//s03n.png"));
            BufferedImage s04d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//s04d.png"));
            BufferedImage s04n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//s04n.png"));
            BufferedImage s05d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//s05d.png"));
            BufferedImage s05n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//s05n.png"));
            BufferedImage s06d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//s06d.png"));
            BufferedImage s06n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//s06n.png"));
            BufferedImage t01d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//t01d.png"));
            BufferedImage t01n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//t01n.png"));
            BufferedImage t02d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//t02d.png"));
            BufferedImage t02n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//t02n.png"));
            BufferedImage t03d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//t03d.png"));
            BufferedImage t03n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//t03n.png"));
            BufferedImage t04d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//t04d.png"));
            BufferedImage t04n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//t04n.png"));
            BufferedImage t05d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//t05d.png"));
            BufferedImage t05n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//t05n.png"));
            BufferedImage u00d = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//u00d.png"));
            BufferedImage u00n = ImageIO.read(new File("C://Users//olege//IdeaProjects//WeatherApp//WeatherAppIcons//u00n.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Window listener terminates the program when the close window button
     * is clicked.
     */
    private class WindowListener extends WindowAdapter {
        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
    }

    public static void main ( String[] args )
    {
        WeatherExtractGUI we1 = new WeatherExtractGUI();     // Opens the main frame
    }

}
