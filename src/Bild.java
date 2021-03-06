import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

// Diese Klasse ist die Grundlage zum Rendern von Elementen auf dem Frame, anhand der Javax Swing Bibliothek

public class Bild extends JLabel { // Die übergeordnete Klasse ist JLabel

	private static final long serialVersionUID = 3916370092871263037L;

	BufferedImage pic; // pic ist das eingelesene Bild

	public Bild(String sauce) { // Erstellen des Konstruktors mit der Eingabe sauce --> Name der jeweiligen
								// Datei ohne Endung

		super(); // Aufrufen der übergeordneten Klasse

		try {

			pic = ImageIO.read(new File("assets/" + sauce + ".png")); // Einlesen der Datei aus dem "assets" - Ordner

			this.setIcon(new ImageIcon(pic)); // Das eingelesene BufferedImage pic wird auf das JLabel (diese Klasse)
												// geladen

		} catch (IOException ex) {

			// Falls es ein Problem mit dem Einlesen der Datei gibt:
			JOptionPane.showMessageDialog(null, "Please check your file paths", "Error", JOptionPane.ERROR_MESSAGE);

		}

	}

	// Methode zum auswählen eines anderen Bildes ohne ein neues Objekt erstellen zu
	// müssen
	public void changeSauce(String newSauce) {

		try {

			pic = ImageIO.read(new File("assets/" + newSauce + ".png"));

			this.setIcon(new ImageIcon(pic));

		} catch (IOException e) {

			JOptionPane.showMessageDialog(null, "Please check your file paths", "Error", JOptionPane.ERROR_MESSAGE);

		}

	}

}