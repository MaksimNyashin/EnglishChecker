import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

class Settings extends BaseForm{
    private JComboBox<String> test;

    Settings()
    {
        super("Settings");

        /*JComboBox comboBox = new JComboBox();
        comboBox.setEditable(true);*/

        JCheckBox checkHide = new JCheckBox("Show results");
        checkHide.setHorizontalTextPosition(JCheckBox.LEFT);
        checkHide.setFont(font);
        checkHide.setSelected(true);
        c.gridx = 0;
        c.gridy = 0;
        contents.add(checkHide, c);

        String[] langItems = {"English", "Deutsch"};
        JComboBox<String> language = new JComboBox<>(langItems);
        language.setFont(font);
        language.addActionListener(e -> {
            JComboBox box = (JComboBox)e.getSource();
            String item = (String) box.getSelectedItem();
            Main.setLanguage(item);
            test.removeAllItems();
            String[] list = getTestNames();
            for (String s: list)
                test.addItem(s);
        });
        c.gridy = 1;
        contents.add(language, c);

        test = new JComboBox<>(getTestNames());
        //test.setEditable(true);
        test.setFont(font);
        c.gridy = 2;
        contents.add(test, c);

        JButton start = new JButton("Start game");
        start.setFont(font);
        start.addActionListener(e -> {
            Main.setShow(checkHide.isSelected());
            Main.setTest(removeSpaces(String.valueOf(test.getSelectedItem())));
            setVisible(false);
            new Game();
        });
        c.gridx = 0;
        c.gridy = 4;
        contents.add(start, c);

        start(4, 4);
        /*setContentPane(contents);

        setBounds(192 * 3, 108 * 3, 384 * 2, 216 * 2);
        setVisible(true);*/
    }

    private String[] getTestNames()
    {
        ArrayList<String> result = new ArrayList<>();
        File folder = new File(Main.getLanguage());
        File[] folderEntries = folder.listFiles();
        if (folderEntries != null) {
            for (File file : folderEntries)
            {
                if (!file.isDirectory())
                {
                    result.add(addSpaces(file.getName()));
                }
            }
        }
        return result.toArray(new String[0]);
    }

    private String addSpaces(String s) {
        return s.replace('_', ' ');
    }

    private String removeSpaces(String s) {
        return s.replace(' ', '_');
    }
}
