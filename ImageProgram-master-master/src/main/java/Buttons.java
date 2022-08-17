import javax.swing.*;
import java.awt.*;


public class Buttons extends JFrame {
    private final int UnKnowButton = Panel.WINDOW_WIDTH / 2 - 85;
    private final int Button_Rohav = 200;
    private final int Button_Gova = 20;

    JButton FlipME;
    JLabel title;
    JTextField Searcher;
    JButton ButtonSearcher;
    JButton Sepia;
    JButton BlackAndWhite;
    JButton contracts;
    JButton colorShiftRight;
    JButton colorShiftLeft;

    public Buttons() {
        title = new JLabel("  Search A Profile ");
        title.setFont(new Font("David", Font.BOLD, 25));
        title.setBounds(UnKnowButton, 50, 300, Button_Gova);
        Main.panel.add(title);

        Searcher = new JTextField();
        Searcher.setBounds(UnKnowButton, title.getY() + title.getHeight() + 10, 120, Button_Gova);
        Main.panel.add(Searcher);

        ButtonSearcher = makeButton("Search", Searcher.getX() + Searcher.getWidth(), Searcher.getY(), Searcher.getWidth() - 40, Searcher.getHeight());
        Main.panel.add(ButtonSearcher);
        repaint();

        FlipME = makeButton("FlipME", UnKnowButton, ButtonSearcher.getY() + ButtonSearcher.getHeight() + 10, Button_Rohav, Button_Gova);
        FlipME.setVisible(false);
        Main.panel.add(FlipME);
        repaint();

        colorShiftRight = makeButton("Color Shift Right", UnKnowButton, FlipME.getY() + FlipME.getHeight() + 10, Button_Rohav, Button_Gova);
        colorShiftRight.setVisible(false);
        Main.panel.add(colorShiftRight);
        repaint();

        colorShiftLeft = makeButton("Color Shift Left", UnKnowButton, colorShiftRight.getY() + colorShiftRight.getHeight() + 10, Button_Rohav, Button_Gova);
        colorShiftLeft.setVisible(false);
        Main.panel.add(colorShiftLeft);
        repaint();

        Sepia = makeButton("Sepia", UnKnowButton, colorShiftLeft.getY() + colorShiftLeft.getHeight() + 10, Button_Rohav, Button_Gova);
        Sepia.setVisible(false);
        Main.panel.add(Sepia);
        repaint();

        BlackAndWhite = makeButton("Black & White", UnKnowButton, Sepia.getY() + Sepia.getHeight() + 10, Button_Rohav, Button_Gova);
        BlackAndWhite.setVisible(false);
        Main.panel.add(BlackAndWhite);
        repaint();

        contracts = makeButton("Contracts", UnKnowButton, BlackAndWhite.getY() + BlackAndWhite.getHeight() + 10, Button_Rohav, Button_Gova);
        contracts.setVisible(false);
        Main.panel.add(contracts);
        repaint();
    }

    public JButton makeButton(String str, int x, int y, int width, int height) {
        JButton tempButton = new JButton(str);
        tempButton.setBounds(x, y, width, height);
        Main.panel.add(tempButton);
        return tempButton;
    }
}
