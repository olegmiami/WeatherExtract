import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WeatherGUI extends WeatherExtract {

    String currentTemp = getTemp("https://api.weatherbit.io/v2.0/forecast/hourly?city=Kusterdingen&key=453e1f9cd56745e2b4f8353fba9d27be&hours=1");
    String currentInfo = getDescription("https://api.weatherbit.io/v2.0/forecast/hourly?city=Kusterdingen&key=453e1f9cd56745e2b4f8353fba9d27be&hours=1");

    private JFrame frame;
    private JPanel panel1;
    private JLabel curWeather;;

    //Constructor
    WeatherGUI() {
        //create frame
        frame = new JFrame("WF");
        frame.setSize(500, 500);

        panel1.add(curWeather);
        //add window listener for closing window
        frame.addWindowListener(new WindowListener());
        frame.getContentPane().add(panel1);
        frame.setVisible(true); //set the frame visible
    }

    private void createUIComponents() {
        curWeather = new JLabel("Current weather: " + currentTemp + "°С");
    }

    //------------------------------------------------------------------------------------------------------------------

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

    public static void main ( String[] args ) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        WeatherGUI a1 = new WeatherGUI();
    }
}
