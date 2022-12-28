package oop_hw_3;

class NewFormat implements TitleFormat {

    @Override
    public void print(String text) {
        System.out.println("@" + text + "@");
    }

}