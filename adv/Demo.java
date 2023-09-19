public class Demo {
    public static void main(String []args) {
        Model model = new Model();
        View view = new View(System.out);
        Controller controller = new Controller(model, view, System.in);
        controller.main_flow();
    }
}