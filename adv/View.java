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
        statement += "1.  Add a computer hardware part.\n";
        statement += "2.  Remove a computer hardware part.\n";
        statement += "3.  Show a list of hardware you currently have.\n";
        statement += "4.  Clear the list of hardware you currently have.\n";
        statement += "5.  Display detailed hardware parameters in the database.\n";
        statement += "6.  Show whether there are conflicts between the currently selected hardware.\n";
        statement += "7.  Show options.\n";
        statement += "8.  Show the rules to follow when choosing hardware.\n";
        statement += "9.  Recommend some hardware combinations.\n";
        statement += "10. Quit.";
        this.streamout.println(statement);
    }
    public void Recommend() {
        String statement = "";
    }
    public void Ask_Options() {
        this.streamout.println("\nPlease enter the option's id you want. If you want to know what options you have, please enter 7."); 
    }

}
