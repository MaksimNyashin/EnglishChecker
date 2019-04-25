import codecs
t = "English\\Copies\\"
t1 = "English\\"

def main():
    s = input("Enter filename: ")
    fi = codecs.open("in.txt", "r", "utf-8")
    a = fi.read().split('\n')
    fi.close()
    fo = codecs.open("out.txt", "w", "utf-8")
    fo2 = codecs.open(t + s + ".txt", "w", "utf-8")
    fo3 = codecs.open(t1 + s + ".txt", "w", "utf-8")
    if a[0][0] == "[":
        a = a[1:]
    n = len(a) // 5
    for i in range(n):
        s1 = a[i * 5 + 1].split(": ")[1][1: -1]
        s2 = a[i * 5 + 4].split(": ")[1][1: -1]
        s1 = s1.replace("/", " or ")
        s2 = s2.replace("/", " или ")
        fo.write(s1 + "/" + s2 + "\n")
        fo2.write(s1 + "/" + s2 + "\n")
        fo3.write(s1 + "/" + s2 + "\n")
        #print(s1 + "/" + s2)
    fo.close()
    fo2.close()

main()
