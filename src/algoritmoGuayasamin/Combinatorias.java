package algoritmoGuayasamin;

import java.util.ArrayList;
import java.util.List;
/**
* @author
* Luis Guerrero
*/
public class Combinatorias {

	int largoConjunto1;
	int largoConjunto2;
	int TotalCombinatorias;
	
	List<Object[]> contenedor = new ArrayList<Object[]>();
	ArrayList<String> contenedor1 = new ArrayList<String>();
	
	/**Constructor por defecto
	 * Inicializa las variables 
	 * largoConjunto1=0, largoConjunto2=0, TotalCombinatorias=0*/
	public Combinatorias() {
		
			this.largoConjunto1=0;
			this.largoConjunto2=0;
			this.TotalCombinatorias=0;
	}
	
	/**
	 * @param conjunto1
	 * Arreglo String: Segun su tamaño sera la cantidad de conjuntos
	 * @param conjunto2
	 * Arreglo String: Segun su tamaño sera el largo de cada conjunto
	 * @Descripcion Meteodo que genera combinaciones sin repeticion con ambos parametros
	 * */
	public void Combinar(ArrayList<String> conjunto1, ArrayList<String> conjunto2){
		
		this.largoConjunto1 = conjunto1.size(); // Variable int que almacena el tamaño de conjunto1
		this.largoConjunto2 = conjunto2.size(); // Variable int que almacena el tamaño de conjunto2
		int contador=0;
		
		for(int i=0; i<largoConjunto1; i++){
			
			for(int k=0; k<largoConjunto2; k++)
			{
				StringBuffer concatenar = new StringBuffer(conjunto1.get(i).toString());
				concatenar.append(conjunto2.get(k));	//concateno el elemento del conjunto1 con el conjunto2
				contenedor1.add(concatenar.toString()); //Agrego concatenar como elemento string
				
				if(contador == largoConjunto2-1){
					Object[] object = contenedor1.toArray();	//Agrego todo el arreglo de contenedor1 
					contenedor.add(object);						//Agrego arreglo a contenedor
					contador=0;									//reinicio contador en 0
					contenedor1.clear();						//elimino todos elementos de contenedor1
				}
				else contador++;
			}
		}
		TotalCombinatorias = contenedor.size();	//Asigno el tamaño del contenedor a TotalCombinatorias

	}//fin metodo Combinar

	/**@return el total de combinatorias*/
	public int getTotalCombinatorias(){
		return TotalCombinatorias;
	}
}//fin clase