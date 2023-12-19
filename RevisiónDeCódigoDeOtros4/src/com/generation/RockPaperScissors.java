package com.generation;

// Importé el Scanner
import java.util.Scanner;

// Cambié el nombre de la clase de "Codigo4" a "RockPaperScissors"
public class RockPaperScissors {

	// Dentro de "new Scanner()" falta "System.in", lo agregué.
	// También cambié el nombre del scanner para mejorar legibilidad (Sergio mencionó que sc es un nombre común para el scanner).
	// Por consecuencia, cambié otras líneas que usaban el scanner para que tengan el nuevo nombre.
	// Hice que el scanner fuera uno de los atributos de la clase y lo inicialicé en el método constructor.
	private Scanner sc;

	// Cambié el nombre del String j1 para mayor claridad (igual con j2).
	// Y los hice ser atributos de la clase. También los inicialicé en el método constructor.
	private String jugadorUno; // = sc.nextLine();
	private String jugadorDos; // = sc.nextLine();

	// Generé un método constructor.
	public RockPaperScissors() {
		this.jugadorUno = null;
		this.jugadorDos = null;
		this.sc = new Scanner(System.in);
	}

	// Agregué Setters y Getters
	public String getJugadorUno() {
		return jugadorUno;
	}

	public void setJugadorUno(String jugadorUno) {
		this.jugadorUno = jugadorUno;
	}

	public String getJugadorDos() {
		return jugadorDos;
	}

	public void setJugadorDos(String jugadorDos) {
		this.jugadorDos = jugadorDos;
	}

	// El scanner no fue cerrado para evitar malgastar recursos. Lo hice un método.
	public void closeScanner() {
		this.sc.close();
	}

	// Hice que las jugadas fueran un método que se puede reutilizar para leer tanto jugador uno como jugador dos
	public void preguntarSeleccion (String numeroDeJugador) {
		System.out.print("Turno del " + numeroDeJugador + " (introduzca piedra, papel o tijeras): ");
		// Como no había código en caso de que escriban algo en el escaner incorrecto, agregué un condicional para ello:
		String seleccion = this.sc.nextLine();
		if (seleccion.toLowerCase().equals("piedra") || seleccion.toLowerCase().equals("papel") || seleccion.toLowerCase().equals("tijeras") ) {
			if (numeroDeJugador.toLowerCase().equals("jugador uno") || numeroDeJugador.toLowerCase().equals("jugador 1") ) {
				this.setJugadorUno(seleccion.toLowerCase() );
				// Agregué esta línea sólo para tratar de esconder la selección del primer jugador
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			} else {
				this.setJugadorDos(seleccion.toLowerCase() );
			}
		} else {
			System.out.println("Selección inválida. Por favor introduzca la palabra \"piedra\", la palabra \"papel\" o la palabra \"tijeras\".\n");
			this.preguntarSeleccion (numeroDeJugador);
		}
	}

	// Hice que el resultado fuera un método
	public void mostrarResultado () {
		// como es un string, en lugar de "==" debería ser .equals
		if ( this.getJugadorUno().equals(this.getJugadorDos() ) ) {
			System.out.println("Empate");
		} else {
			// Cambié el nombre de la variable de "g" a "ganador" para mejorar legibilidad.
			// También lo cambié de int a byte para no desperdiciar recursos.
			byte ganador = 2;
			switch(this.getJugadorUno()) {
			case "piedra":
				// como es un string, en lugar de "==" debería ser .equals
				if (this.getJugadorDos().equals("tijeras") ) {
					ganador = 1;
				}
				// Falta un break
				break;

			case "papel":
				// como es un string, en lugar de "==" debería ser .equals
				if (this.getJugadorDos().equals("piedra") ) {
					ganador = 1;
					// Faltaba una llave de cierre y también un break
				}
				break;

				// el case decía "tijera" en lugar de "tijeras"
			case "tijeras":
				if (this.getJugadorDos().equals("papel") ) {
					ganador = 1;
				}
				break;

			default:
			}

			System.out.println("\nGana el jugador " + ganador);
		}
		this.closeScanner();
	}

	// Main Method faltaba para poder ejecutar el código
	public static void main(String[] args) {
		RockPaperScissors test = new RockPaperScissors();
		test.preguntarSeleccion ("Jugador 1");
		test.preguntarSeleccion ("Jugador 2");
		test.mostrarResultado();
	}
}

// En general, estoy usando Ctrl + I para corregir la identación