public class Main {
    public static void main(String[] args){
        Model model = new Model();
        FactoryView view = new FactoryView();
        FactoryController controller = new FactoryController(view, model);
    }
}
