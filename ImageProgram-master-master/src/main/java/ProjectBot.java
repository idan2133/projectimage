import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class ProjectBot extends JFrame {
    String ownurl = ("https://www.facebook.com/public/");
    JLabel PictureLable;
    BufferedImage MyProfliPicture;
    ChromeDriver driver;

    public ProjectBot() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(ownurl + Main.panel.buttons.Searcher.getText());

        WebElement profile = driver.findElement(By.className("_4bl7"));
        profile.click();
        WebElement profilePicture = driver.findElement(By.className("pzggbiyp"));
        profilePicture.click();
        while (true) if (driver.findElement(By.className("mpmpiqla")).isDisplayed()) break;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement profilePictureXPath = driver.findElement(By.xpath("//img[@data-visualcompletion='media-vc-image']"));





        String str = profilePictureXPath.getAttribute("src");

        try {
            MyProfliPicture = ImageIO.read(new URL(str));
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }


        Image scaledImage = MyProfliPicture.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        PictureLable = new JLabel(new ImageIcon(scaledImage));
        PictureLable.setBounds(65, 80, 300, 300);
        PictureLable.setVisible(false);
        Main.panel.add(PictureLable);
        repaint();

        Main.panel.filteredPicLabel = new JLabel(new ImageIcon(scaledImage));
        Main.panel.filteredPicLabel.setBounds(Main.panel.buttons.ButtonSearcher.getX() + Main.panel.buttons.ButtonSearcher.getWidth() + 60, 80, 300, 300);
        Main.panel.filteredPicLabel.setVisible(false);
        Main.panel.add(Main.panel.filteredPicLabel);
        repaint();

        try {
            ImageIO.write(toBufferedImage(scaledImage), "png", Main.panel.FinalPicture);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
        BufferedImage Buffered = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        
        Graphics2D bGr = Buffered.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        return Buffered;
    }

}

