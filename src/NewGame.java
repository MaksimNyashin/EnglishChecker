import javax.swing.*;

class NewGame extends BaseForm
{
    NewGame()
    {
        super("Start new game");

        JButton start = new JButton("New Game");
        start.setFont(font);
        /*start.setHorizontalAlignment(SwingConstants.CENTER);
        start.setVerticalAlignment(SwingConstants.CENTER);*/
        start.addActionListener(e -> {
            setVisible(false);
            new Game();
            //setVisible(true);
        });

        JButton choose = new JButton("Set mode");
        choose.setFont(font);
        choose.addActionListener(e -> {
            setVisible(false);
            new Settings();
            //setVisible(true);
        });
        c.gridx = 0;
        c.gridy = 0;

        //JPanel contents = new JPanel();//new FlowLayout(FlowLayout.LEFT));
        //contents.add(start);
        contents.add(choose, c);
        /*setContentPane(contents);

        setBounds(192 * 4, 108 * 4, 384, 216);
        setVisible(true);*/
        Main.setNewGame(NewGame.this);
        start(2, 2);
    }
}
