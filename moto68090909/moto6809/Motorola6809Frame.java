import javax.swing.*;
import java.awt.Font;

public class Motorola6809Frame extends JFrame {
    
    //private MOTO cpu = new MOTO();
    
    //private EditeurMoto editeurMoto = new EditeurMoto();
    
    public Motorola6809Frame() {
        CpuFrame cpu = new CpuFrame();
        EditeurMoto editeurMoto;
        ROMFrame romFrame = new ROMFrame();
        ram RAM;
        setTitle("Motorola 6809 CPU");
        setSize(800, 63); // Ajuster la hauteur pour s'adapter à la barre de menu
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Créer la barre de menu
        JMenuBar menuBar = new JMenuBar();

        // Créer le menu 'Fichier'
        JMenu fichierMenu = new JMenu("Fichier");
        menuBar.add(fichierMenu);
        fichierMenu.setFont(new Font("lucida Console", Font.BOLD, 12)); // Définir la police souhaitée

        // Créer le menu 'Simulation'
        JMenu simulationMenu = new JMenu("Simulation");
        menuBar.add(simulationMenu);
        simulationMenu.setFont(new Font("lucida Console", Font.BOLD, 12)); // Définir la police souhaitée
        //cpu.setVisible(true);
        // Créer le menu 'Fenetre'
        JMenu fenetreMenu = new JMenu("Fenetre");
        menuBar.add(fenetreMenu);
        fenetreMenu.setFont(new Font("lucida Console", Font.BOLD, 12)); // Définir la police souhaitée

        // Créer l'élément de menu 'RAM' avec case à cocher
        JCheckBoxMenuItem ramMenuItem = new JCheckBoxMenuItem("RAM");
        ramMenuItem.setFont(new Font("lucida Console", Font.BOLD, 12)); // Définir la police souhaitée
        fenetreMenu.add(ramMenuItem);

        // Créer l'élément de menu 'ROM' avec case à cocher
        JCheckBoxMenuItem romMenuItem = new JCheckBoxMenuItem("ROM");
        fenetreMenu.add(romMenuItem);
        romMenuItem.setFont(new Font("lucida Console", Font.BOLD, 12)); // Définir la police souhaitée

        // Créer l'élément de menu 'PROGRAMME' avec case à cocher
        JCheckBoxMenuItem programmeMenuItem = new JCheckBoxMenuItem("PROGRAMME");
        fenetreMenu.add(programmeMenuItem);
        programmeMenuItem.setFont(new Font("lucida Console", Font.BOLD, 12)); // Définir la police souhaitée

        // Create the 'Editeur' menu item
        //JMenuItem editeurMenuItem = new JMenuItem("Editeur");
        //fenetreMenu.add(editeurMenuItem);
        //editeurMenuItem.setFont(new Font("lucida Console", Font.BOLD, 12)); // Set the desired font

        // Create the 'Editeur' menu item with a checkbox
        JCheckBoxMenuItem editeurMenuItem = new JCheckBoxMenuItem("Editeur");
        fenetreMenu.add(editeurMenuItem);
        editeurMenuItem.setFont(new Font("lucida Console", Font.BOLD, 12)); // Set the desired font
        // Set the menu bar to the frame
        setJMenuBar(menuBar);

        // Initialize RAM and ROM
        //RAM = new ram();
        //ROMFrame rom = new ROMFrame();

        // Add item listeners to the menu items
        ramMenuItem.addItemListener(e -> {
            if (ramMenuItem.isSelected()) {
                RAM.setVisible(true);
            } else {
                RAM.setVisible(false);
            }
        });
        editeurMenuItem.addItemListener(e -> {
            if (editeurMenuItem.isSelected()) {
                //editeurMoto.setVisible(true);
                editeurMoto = new EditeurMoto(cpu, RAM, romFrame);
                editeurMoto.setVisible(true);
            } else {
                //editeurMoto.setVisible(false);
                //EditeurMoto editeurMoto = new EditeurMoto();
                editeurMoto.setVisible(false);
            }
        });
        romMenuItem.addItemListener(e -> {
            if (romMenuItem.isSelected()) {
                //rom.setVisible(true);
                ROMFrame rom = new ROMFrame();
                rom.setVisible(true);
            } else {
                //rom.setVisible(false);
                ROMFrame rom = new ROMFrame();
                rom.setVisible(false);
            }
        });
        programmeMenuItem.addItemListener(e -> {
            if (programmeMenuItem.isSelected()) {
                //cpu.setVisible(true);
                cpu = new CpuFrame();
                cpu.setVisible(true);
            } else {
                //cpu.setVisible(false);
                cpu = new CpuFrame();
                cpu.setVisible(false);
            }
        });
       

        // Set the frame visible
        setVisible(true);
    }
    

    public static void main(String[] args) {
        Motorola6809Frame frame = new Motorola6809Frame();
        frame.setVisible(true);
    }
}
        
    