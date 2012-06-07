package algoritmoGuayasamin;

import java.util.*;

/**
 * @author 
 * Luis Guerrero
 */
class Permutaciones {

	public ArrayList<String> permutacion;
	int TotalPermutaciones;

	/**
	 * Constructor por defecto 
	 * Inicializa permutacion 
	 * Inicializa TotalPermutaciones en 0
	 */
	public Permutaciones() {
		permutacion = new ArrayList<String>();
		this.TotalPermutaciones = 0;
	}

	/**
	 * @param prefijo
	 *            ="" (insertar espacio obligatoriamente)
	 * @param sufijo
	 *            =El conjunto a permutar Metodo recursivo permutacion almacena
	 *            las permutaciones en cada ciclo
	 */
	public void Permutacion(String prefijo, String sufijo) {
		String nuevoPrefijo, nuevoSufijo;							//Declaro variables de tipo String
		int numDeCaracteres = sufijo.length();						//Asigno el largo de sufijo

		if (numDeCaracteres == 1) {
			permutacion.add(prefijo + sufijo);						//Agrego prefijo + sufijo concatenados
			TotalPermutaciones = permutacion.size();				//Asigno el tamaño de permutacion

		} else {
			for (int i = 0; i < numDeCaracteres; i++) {
				nuevoSufijo = sufijo.substring(1, numDeCaracteres);	//Asigno sufijo desde la posicion 1 hasta el largo
				nuevoPrefijo = prefijo + sufijo.charAt(0);			//Asigno prefijo + el elemento de la posicion 0 de sufijo

				Permutacion(nuevoPrefijo, nuevoSufijo);				//llamada recursiva con los nuevos prefijo y sufijo

				sufijo = nuevoSufijo + sufijo.charAt(0);			//Asigno nuevo sufijo y el elemento de la posicion 0 de sufijo
			}
		}
	}//fin metodo permutacion

	/** @return el total de permutaciones */
	public int getTotalPermutaciones() {
		return TotalPermutaciones;
	}

}// fin clase