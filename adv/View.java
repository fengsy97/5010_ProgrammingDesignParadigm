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
        this.streamout.println("\nInvalid input. Try again: "); 
    }

}
