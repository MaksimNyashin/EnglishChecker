import javax.swing.*;
import java.awt.event.ActionListener;

class Game extends BaseForm
{
    private int total, right;
    private JLabel  rusWord;
    private JTextField engWord;
    private JLabel result;
    private JLabel progress;

    Game()
    {
        super("Game");
        total = 0;
        right = 0;
        //Words words = new Words("Purple_Unit_8.txt");
        Words words = new Words(Main.getLanguage() + "\\" + Main.getTest());
        ActionListener actionListener = e -> {
            boolean b = words.checkEngWord(engWord.getText(), result, isSuc -> {
                total++;
                if (isSuc)
                {
                    right++;
                }
                progress.setText(right + "/" + total);
            });
            if (!b)
            {
                //Main.getNewGame().setVisible(true);
                setVisible(false);
                new Results(right, total, words);
                return;
            }
            engWord.setText("");
            rusWord.setText(words.getRusWord());
        };

        rusWord = new JLabel(words.getRusWord() + " ");
        rusWord.setFont(font);
        c.gridx = 0;
        c.gridy = 0;
        contents.add(rusWord, c);

        engWord = new JTextField(15);
        engWord.setFont(font);
        engWord.addActionListener(actionListener);
        //engWord.setBackground(Color.getColor("#EEEEEE"));
        c.gridx = 0;
        c.gridy = 1;
        contents.add(engWord, c);

        result = new JLabel("");
        result.setFont(font);
        result.setVisible(Main.needShow());
        c.gridx = 0;
        c.gridy = 2;
        contents.add(result, c);


        JButton answer = new JButton("Answer");
        answer.setFont(font);
        answer.setHorizontalAlignment(SwingConstants.CENTER);
        answer.setVerticalAlignment(SwingConstants.CENTER);
        answer.addActionListener(actionListener);
        c.gridx = 1;
        c.gridy = 1;
        contents.add(answer, c);

        progress = new JLabel("0/0");
        progress.setFont(font);
        progress.setVisible(Main.needShow());
        c.gridx = 2;
        c.gridy = 1;
        contents.add(progress, c);


        /*if (Main.isHide()) {
            result.setVisible(false);
            progress.setVisible(false);
        }*/
        //JPanel contents = new JPanel();//new FlowLayout(FlowLayout.LEFT));
        /*contents.add(rusWord);
        contents.add(engWord);
        contents.add(answer);
        contents.add(progress);
        contents.add(result);
        setContentPane(contents);

        setBounds(192 * 3, 108 * 3, 384 * 2, 216 * 2);
        setVisible(true);*/
        start(4,4);

    }

    public interface UpdateProgress
    {
        void perform(boolean isSuc);
    }
}
