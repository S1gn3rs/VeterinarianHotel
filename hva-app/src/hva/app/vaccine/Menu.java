package hva.app.vaccine;

public class Menu extends pt.tecnico.uilib.menus.Menu {

    public Menu(hva.Hotel receiver) {
        super(Label.TITLE, //
                new DoShowAllVaccines(receiver),
                new DoRegisterVaccine(receiver),
                new DoVaccinateAnimal(receiver),
                new DoShowVaccinations(receiver)
        );
    }

}
