import javax.swing.*;
import java.awt.*;

class BaseForm extends JFrame {
    Font font;
    JPanel contents;
    GridBagConstraints c;
    BaseForm(String PageName)
    {
        super(PageName);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        font = Main.getFont();
        contents = new JPanel(new GridBagLayout());
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);
    }

    void start(int WidthCoefficient, int HeightCoefficient)
    {
        WidthCoefficient = 10;
        HeightCoefficient = 10;
        setContentPane(contents);
        setBounds(Main.getWidthOne() * (10 - WidthCoefficient) / 2,
                Main.getHeightOne() * (10 - HeightCoefficient) / 2,
                Main.getWidthOne() * WidthCoefficient,
                Main.getHeightOne() * HeightCoefficient);
        setVisible(true);
    }
}
