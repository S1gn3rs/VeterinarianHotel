package hva.app.animal;

public class Menu extends pt.tecnico.uilib.menus.Menu {

    public Menu(hva.Hotel receiver) {
        super(Label.TITLE, //
                new DoShowAllAnimals(receiver),
                new DoRegisterAnimal(receiver),
                new DoTransferToHabitat(receiver),
                new DoShowSatisfactionOfAnimal(receiver)
        );
    }

}
