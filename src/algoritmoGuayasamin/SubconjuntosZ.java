package algoritmoGuayasamin;

//import java.math.BigInteger;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
/**
* @LuisGuerrero
*/
public class SubconjuntosZ {
	
	List<Object[]> conjuntos;
	boolean podar = false;
	private long totalCombination;
	long contador;
	
	//constructor por defecto
	public SubconjuntosZ() {
		this.contador=0;
		this.totalCombination=0;
	}
	
	public SubconjuntosZ(List<Object[]> conjuntos) {
		this.conjuntos = conjuntos;
		Object[][] presente = new Object[conjuntos.size()][2];
		for(int i = 0; i < conjuntos.size(); i++)
		{
			presente[i][0] = false;
			presente[i][1] = new boolean[conjuntos.get(i).length];
		}
		
		// Inicialmente conjuntos esta todo en false
		arbolPrincipal(presente, 0);
	}

	public long getTotalCombination() {
	return totalCombination;
	}
	
	
	
	private void procesarSolucionPrincipal(Object[][] presente)
	{
		List<boolean[]> subconjuntos = new ArrayList<boolean[]>();
		for (int i = 0; i < presente.length; i++)
		{
			if (Boolean.parseBoolean(presente[i][0].toString()))
			{
				//boolean[] presente1 = (boolean[])presente[i][1]; //probando
				subconjuntos.add((boolean[])presente[i][1]);
			}
		}
		if(subconjuntos.size() > 0)
			this.arbolSecundario(presente, subconjuntos, 0);
	
	}

	private void arbolPrincipal(Object[][] presente,int posicionActual)
	{
		if(presente.length == posicionActual)
		{
			procesarSolucionPrincipal(presente);
			podar = true; //al eliminar esta asignacion se crean combinaciones hasta llegar a 1 objeto de la lista. 
		}
		else
		{
			if(!podar)
			{
				presente[posicionActual][0] = true;
				arbolPrincipal(presente, posicionActual + 1);
				if(!podar)
				{
					presente[posicionActual][0] = false;
					arbolPrincipal(presente, posicionActual + 1);
				}
			}
		}
	}

	private void procesarSolucionSecundaria(Object[][] presente,List<boolean[]> subconjuntos)
	{
		
		List<Object> combinaciones = new ArrayList<Object>();
		for(int i = 0; i < subconjuntos.size(); i++)
		{
			for(int j = 0; j < subconjuntos.get(i).length; j++)
			{
			
				if(subconjuntos.get(i)[j])
				{
					int k = -1;
					for(int m = 0; m < presente.length; m++)
					{
						if(Boolean.parseBoolean(presente[m][0].toString()))
							k++;
						if(k == i)
						{
							combinaciones.add(conjuntos.get(m)[j]);
							break;
						}
					}
					break;
				}
			}
		}
		System.out.println(combinaciones);
		contador++;
		totalCombination=contador;
	}

	private void arbolSecundario(Object[][] presente,List<boolean[]> subconjuntos,int posicionActual)
	{
		if(subconjuntos.size() == posicionActual)
		{
			procesarSolucionSecundaria(presente,subconjuntos);
		}
		else
		{
			for(int i = 0; i < subconjuntos.get(posicionActual).length; i++)
			{
				subconjuntos.set(posicionActual, new boolean[subconjuntos.get(posicionActual).length]);
				subconjuntos.get(posicionActual)[i] = true;
				arbolSecundario(presente,subconjuntos, posicionActual + 1);
			}
		}
	}
}