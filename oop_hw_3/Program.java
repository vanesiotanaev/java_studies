package oop_hw_3;

public class Program {

    public static void main(String[] args) {

        Word doc1 = new Word();
        WriteFile write = new WriteFile();
        doc1.setModel(new StringFormat());
        String text1 = "Test1";
        doc1.appendData(text1);
        write.writeFile(text1);
        doc1.setFormat(new FunnyFormat());
        doc1.click();

        String text2 = "Test2";
        write.writeFile(text2);
        doc1.appendData(text2);

        doc1.setFormat(new SadFormat());
        doc1.click();

        doc1.setFormat(new NewFormat());
        doc1.click();
    }
}