import javax.swing.*;
import java.io.File;

public class Panel extends JFrame {


    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 500;
    Buttons buttons;
    Filters filters = new Filters();
    ProjectBot bot;
    JLabel filteredPicLabel;
    String Ownurl;
    File FinalPicture;
    File file;


    public Panel() {

        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("Facebook.png");
        JLabel background;
        background = new JLabel ("",img,JLabel.CENTER);
        background.setBounds(0,0,1000,500);
        add(background);

    }

    public void doEveryThing() {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\David\\Downloads\\chromedriver_win32\\chromedriver.exe");
        Ownurl = ("https://www.facebook.com/public/");
        FinalPicture = new File("C:\\Users\\David\\Pictures\\pictures\\tikyaa");

        buttons = new Buttons();
        buttons.ButtonSearcher.addActionListener((event) -> {
            bot = new ProjectBot();
            buttons.colorShiftRight.setVisible(true);
            buttons.colorShiftLeft.setVisible(true);
            buttons.Sepia.setVisible(true);
            buttons.BlackAndWhite.setVisible(true);
            buttons.contracts.setVisible(true);
            buttons.FlipME.setVisible(true);
            bot.PictureLable.setVisible(true);
            Main.panel.filteredPicLabel.setVisible(true);

            bot.driver.manage().window().minimize();
        });
        buttons.colorShiftRight.addActionListener((event) -> {
            try {
                file = filters.colorShiftRight(FinalPicture);
                filteredPicLabel.setIcon(new ImageIcon(String.valueOf(file)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        buttons.colorShiftLeft.addActionListener((event) -> {
            try {
                file = filters.colorShiftLeft(FinalPicture);
                filteredPicLabel.setIcon(new ImageIcon(String.valueOf(file)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        buttons.Sepia.addActionListener((event) -> {
            try {
                file = filters.sepia(FinalPicture);
                filteredPicLabel.setIcon(new ImageIcon(String.valueOf(file)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        buttons.BlackAndWhite.addActionListener((event) -> {
            try {
                file = filters.greyScale(FinalPicture);
                filteredPicLabel.setIcon(new ImageIcon(String.valueOf(file)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        buttons.contracts.addActionListener((event) -> {
            try {
                file = filters.contracts(FinalPicture);
                filteredPicLabel.setIcon(new ImageIcon(String.valueOf(file)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        buttons.FlipME.addActionListener((event) -> {
            try {
                file = filters.flipImage(FinalPicture);
                filteredPicLabel.setIcon(new ImageIcon(String.valueOf(file)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        repaint();
    }

}

