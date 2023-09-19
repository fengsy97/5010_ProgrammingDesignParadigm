// controller is used to "view" the input data and take
// appropriate step to response

import java.io.InputStream;
import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;
    private Scanner input;
    public Controller(Model model, View view, InputStream input){
        this.model = model;
        this.view = view;
        this.input = new Scanner(input);
    }
    public void main_flow(){
        while(true){
            model.setData("Welcome to This Program, please input your option:");
            view.View_Print(this.model.getData());
            // view.showOptions();
            String option = this.input.next();
            switch (option) {
                case "E":
                    model.setData(option);
                    view.View_Print(this.model.getData());
                    break;
                case "Q":
                    model.setData("Quit success");
                    view.View_Print(this.model.getData());
                    return;
                default:
                    view.Error_Print();
            }

        }
    }
}
