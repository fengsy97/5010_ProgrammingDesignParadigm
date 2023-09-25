// in this class, we use text messages to prompt users how to interact with the program
import java.io.PrintStream;
public class View {
    private PrintStream streamout;
    public View(PrintStream streamout) {
        this.streamout = streamout;
    }
    public void View_Print(String s){
        this.streamout.println(s);
    }
    public void Error_Print() {
        this.streamout.println("Your input is invalid."); 
    }
    public void ID_Print() {
        this.streamout.println("Please enter the ID you want to choose."); 
    }
    
    public void Options_Print(){
        String statement = "\nPlease choose from the following options by entering its id :\n";
        statement += "0. Add a computer hardware.\n";
        statement += "1. Remove a computer hardware.\n";
        statement += "2. Show the list of hardware you currently have.\n";
        statement += "3. Recommend some hardware combinations.\n";
        statement += "4. Display detailed hardware parameters in the database.\n";
        statement += "5. Show whether there are conflicts between the currently selected hardware.\n";
        statement += "6. Show options.\n";
        statement += "7. Show the rules to follow when choosing hardware.\n";
        statement += "8. Clear the list of hardware you currently have.\n";
        statement += "9. Quit.";
        this.streamout.println(statement);
    }
    public void Recommend() {
        String statement = "Please choose from the following types:\n";
        statement += "0. Household daily use.\n";
        statement += "1. Heavy gamer use.\n";
        statement += "2. Productivity use.\n";
        this.streamout.println(statement);

    }
    public void Rules_Print(){
        String statement = "0. For safety reasons, the sum of the power consumption of the GPU and CPU should be less than 70% of the rated power of the power supply.\n";
        statement += "Intel CPUs use Intel corresponding motherboards, AMD CPUs use Intel corresponding motherboards.";
        this.streamout.println(statement);
    }
    public void Ask_Options() {
        this.streamout.println("\nPlease enter the option's id you want. If you want to know what options you have, please enter 6."); 
    }
    public void Conflict_Power(){
        this.streamout.println("Warning : The sum of GPU and CPU power consumption exceeds the safe range."); 
    }
    public void Conflict_Cpu(){
        this.streamout.println("Warning : CPU and motherboard are not compatible."); 
    }

}
