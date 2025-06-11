package br.edu.ifba.inf008;

public class App 
{
    public static void main( String[] args )
    {
        do {
            br.edu.ifba.inf008.eventManager.ui.MainMenu mainMenu = new br.edu.ifba.inf008.eventManager.ui.MainMenu();
            mainMenu.show();
        } while (br.edu.ifba.inf008.eventManager.ui.MainMenu.isRunning());
    }
}
