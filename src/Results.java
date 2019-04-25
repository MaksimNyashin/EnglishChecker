import javax.swing.*;
import java.awt.*;

class Results extends BaseForm {



    Results(int right, int total, Words words)
    {
        super("Results");

        JLabel results = new JLabel("Your results are: " + right + "/" + total);
        results.setFont(font);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        contents.add(results, c);


        JTextArea wrongWords = new JTextArea();
        if (right < total)
            words.writeWrong(wrongWords, 0);
        else
            wrongWords.append("You're awesome\nEverything is correct!");
        wrongWords.setFont(font);
        wrongWords.setEnabled(false);
        wrongWords.setBackground(Color.getColor("#EEEEEE"));
        wrongWords.setDisabledTextColor(Color.black);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        contents.add(wrongWords, c);


        JButton onNewGame = new JButton("Exit to menu");
        onNewGame.setFont(font);
        onNewGame.addActionListener(e -> {
            setVisible(false);
            Main.getNewGame().setVisible(true);
        });
        c.gridx = 2;
        c.gridy = 1;
        contents.add(onNewGame, c);

        JButton restart = new JButton("Try again");
        restart.setFont(font);
        restart.addActionListener(e -> {
            setVisible(false);
            new Game();
        });
        c.gridx = 2;
        c.gridy = 0;
        contents.add(restart, c);

        int mistakePages = (words.getWrongNumber() + Main.getOnPage() - 1) / Main.getOnPage();
        Integer[] mistakesItems = new Integer[mistakePages];
        for (int i = 0; i < mistakePages; i++)
        {
            /*JLabel jLabel = new JLabel("" + (i + 1));
            jLabel.setFont(font);
            int finalI = i;
            jLabel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    page = finalI;
                    words.writeWrong(wrongWords, page);
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            list.add(jLabel);*/
            mistakesItems[i] = i + 1;
        }
        JComboBox<Integer> mistakes = new JComboBox<>(mistakesItems);
        mistakes.setFont(font);
        mistakes.addActionListener(e -> {
            JComboBox box = (JComboBox)e.getSource();
            Integer item = (Integer) box.getSelectedItem();
            //noinspection ConstantConditions
            words.writeWrong(wrongWords, item - 1);
        });
        if (mistakePages == 0)
            mistakes.setVisible(false);
        else
            mistakes.setVisible(true);
        c.gridx = 1;
        c.gridy = 0;
        contents.add(mistakes, c);
        /*int i = 0;
        for (JLabel jLabel: list) {
            c.gridx = i;
            c.gridy = 1;
            contents.add(jLabel, c);
            i++;
        }*/


        start(5, 5);
        /*setContentPane(contents);


        setBounds(192 * 2, 108 * 2, 192 * 6, 108 * 6

        );
        setVisible(true);*/
    }
}
