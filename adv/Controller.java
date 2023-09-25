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
        view.View_Print("Clear successfully.");
    }
    public void get_advise(){
        view.Recommend();
        String option = this.input.next();
        int ID;
        try {
           ID = Integer.parseInt(option);
        }
        catch (NumberFormatException e) {
           ID = -1;
        }
        if(ID < 0 || ID > 2 ){
            view.Error_Print();
            ID = -1 ;
        }
        if(ID < 0){return;}
        view.View_Print(this.model.getRecommend(ID));
    }
    public void get_conflict(){
        boolean Conflict_CPU = this.model.Conflict_CPU();
        boolean Conflict_Power = this.model.Conflict_Power();
        if(Conflict_CPU){view.Conflict_Cpu();}
        if(Conflict_Power){view.Conflict_Power();}
        if(Conflict_Power || Conflict_CPU){return;}
        view.View_Print("There is no conflict in this hardware list.");
    }

    public void get_detail(){
        int ID = ID_component();
        if(ID < 0){return;}
        view.View_Print(this.model.get_detail(ID));
        return;
    }

    public void main_flow(){
        model.setData("Welcome to This PC Building Program, let's build your own pc");
        view.View_Print(this.model.getData());
        view.Options_Print();
        while(true){
            view.Ask_Options();
            String option = this.input.next();
            switch (option) {
                case "0":
                    choose_component();
                    break;
                case "1":
                    remove_component();
                    break;
                case "2":
                    view.View_Print(this.model.getStatus());
                    break;
                case "3":
                    get_advise();
                    break;
                case "4":
                    get_detail();
                    break;
                case "5":
                    get_conflict();
                    break;
                case "6":
                    view.Options_Print();
                    break;
                case "7":
                    view.Rules_Print();
                    break;
                case "8":
                    
                    clear_chosen();
                    break;
                case "9":
                    model.setData("Quit success");
                    view.View_Print(this.model.getStatus());
                    return;
                default:
                    view.Error_Print();
            }
        }
    }
}
