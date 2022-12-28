package oop_hw_3;

public class Word {
    Model model;

    public void setModel(Model model) {
        this.model = model;
    }

    TitleFormat format;

    public void appendData(String text) {
        model.appendRawData(text);
    }

    public void setFormat(TitleFormat f) {
        format = f;
    }

    void click() {
        format.print(model.getRawData());
    }
}
