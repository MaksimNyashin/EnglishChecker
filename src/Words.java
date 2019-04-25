import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Words
{
    private ArrayList<Word> arrayList;
    private String file;
    private int cnt;
    private int num;
    private ArrayList<Word> wrong;

    Words(String source)
    {
        file = source;
        getList();
        num = arrayList.size();
        Random rnd = ThreadLocalRandom.current();
        Collections.shuffle(arrayList, rnd);
        cnt = 0;
        wrong = new ArrayList<>();
    }

    private void getList()
    {
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader reader = new BufferedReader(isr);
            String s;
            arrayList = new ArrayList<>();
            while ((s = reader.readLine()) != null)
            {
                System.out.println(s);
                Word word = new Word(s);
                if (word.getTotal() == -1)
                    continue;
                arrayList.add(new Word(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeList()
    {
        try {
            OutputStreamWriter isr = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
            BufferedWriter writer = new BufferedWriter(isr);
            for (Word i: arrayList)
            {
                writer.write(i.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRusWord()
    {
        return arrayList.get(cnt).rus;
    }
    public boolean checkEngWord(String engWord, JLabel label, Game.UpdateProgress progress)
    {
        String rightWord = arrayList.get(cnt).eng;
        if (cmp(rightWord, engWord))
        {
            label.setText("Correct");
            arrayList.get(cnt).right();
            cnt++;
            progress.perform(true);
        }
        else
        {
            label.setText("Wrong answer     The answer is: " + rightWord);
            arrayList.get(cnt).wrong();
            wrong.add(arrayList.get(cnt));
            cnt++;
            progress.perform(false);
        }
        if (cnt % 15 == 0)
            writeList();
        if (cnt != num)
            return true;
        writeList();
        return false;
    }

    private boolean cmp(String a, String b)
    {
        if (a.length() != b.length())
            return false;
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) != b.charAt(i))
                return  false;
        return true;
    }

    public void writeWrong(JTextArea textArea, int page)
    {
        textArea.setText("Try to remember:\n");
        int onPage = Main.getOnPage();
        for (int i = onPage * (page); i < onPage * (page + 1) && i < wrong.size(); i++)
        {
            Word word = wrong.get(i);
            textArea.append(word.wrongToString());
        }
        System.out.println(textArea.getText());
    }

    public int getWrongNumber() {
        return wrong.size();
    }
}
