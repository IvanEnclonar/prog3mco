public class GUITestDriver {
    public static void main(String[] args){
        Model model = new Model();
        FactoryView view = new FactoryView();
        FactoryController controller = new FactoryController(view, model);

        //SpecialView view = new SpecialView(model.getVM());
    }
}
