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
    public int ID_component(){
        view.ID_Print();
        String result  = this.model.getComponents();
        view.View_Print(result);
        String Input = this.input.next();
        int ID;
        try {
           ID = Integer.parseInt(Input);
        }
        catch (NumberFormatException e) {
           ID = -1;
        }
        if(ID < 0 || ID > result.split(":").length - 2 ){
            view.Error_Print();
            ID = -1;
        }
        return ID;
    }
    public int ID_Type(int ID){
        view.ID_Print();
        String result  = this.model.getTypes(ID);
        view.View_Print(result);
        String Input = this.input.next();
        int ID_c;
        try {
           ID_c = Integer.parseInt(Input);
        }
        catch (NumberFormatException e) {
           ID_c = -1;
        }
        if(ID < 0 || ID_c > result.split(":").length - 2 ){
            view.Error_Print();
            ID_c = -1 ;
        }
        return ID_c;
    }
    public void choose_component(){
        int ID = ID_component();
        if(ID < 0){return;}
        int ID_c = ID_Type(ID);
        if(ID_c < 0){return;}
        this.model.set_chosen(ID,ID_c);
    }
    public void remove_component(){
        int ID = ID_component();
        if(ID < 0){return;}
        this.model.set_chosen(ID,-1);
    }
    public void clear_chosen(){
        this.model.clear_chosen();
    }

    // Check the details of each part
    // public void Check_database(){
    //     view.ID_Print();
    //     String result  = this.model.getComponents();
    // }
    public void main_flow(){
        model.setData("Welcome to This PC Building Program, let's build your own pc");
        view.View_Print(this.model.getData());
        while(true){
            if(true){
                view.View_Print(this.model.getStatus());
                choose_component();
                view.View_Print(this.model.getStatus());
                // clear_chosen();
                // view.View_Print(this.model.getStatus());
                return ;
            }
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
            break;

        }
    }
}
