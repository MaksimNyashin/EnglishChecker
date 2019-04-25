public class Word
{
    public String eng;
    public String rus;
    private int right;
    private int total;

    Word(String coded) {
        String em = "";
        if (coded.equals(em))
        {
            total = -1;
            return;
        }
        String regex = "/";
        String[] z = coded.split(regex);
        String engWord = z[0];
        eng = "";
        StringBuilder leng = new StringBuilder();
        String possibleChars = " -`='_+*<>&!?;";
        for (int i = 0; i < engWord.length(); i++) {
            if ((engWord.charAt(i) >= 'a' && engWord.charAt(i) <= 'z') || (engWord.charAt(i) >= 'A' && engWord.charAt(i) <= 'Z'))
                leng.append(engWord.charAt(i));
            else
                for (int j = 0; j < possibleChars.length(); j++)
                    if (engWord.charAt(i) == possibleChars.charAt(j))
                        leng.append(engWord.charAt(i));
        }
        eng = leng.toString();
        rus = z[1];
        if (z.length > 2)
        {
            right = Integer.parseInt(z[2]);
            total = Integer.parseInt(z[3]);
        }
        else
        {
            right = 0;
            total = 0;
        }
    }

    @Override
    public String toString() {
        System.out.print(eng + "/" + rus + "/" + right + "/" + total + "\n");
        return eng + "/" + rus + "/" + right + "/" + total;
    }

    public String wrongToString()
    {
        return rus + " -> " + eng + "\n";
    }

    public void wrong()
    {
        this.total++;
    }

    public void right()
    {
        this.right++;
        this.total++;
    }

    public int getTotal() {
        return total;
    }
}
