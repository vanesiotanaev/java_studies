package oop_hw_5;

public class Model {
    public void app() {
        View view = new View();
        view.info();
        Input in = new Input();
        int number = in.getNumber();
        Infrastructure infrastructure = new Infrastructure();
        if (number == 1) {
            infrastructure.allStaff();
        }
        if (number == 2) {
            String info = in.getStaffInfo();
            infrastructure.search(info);
        }
        if (number == 3) {
            String experience = in.getExperienceInfo();
            int result = Integer.parseInt(experience);
            infrastructure.searchExperience(result);
        }
    }
}
