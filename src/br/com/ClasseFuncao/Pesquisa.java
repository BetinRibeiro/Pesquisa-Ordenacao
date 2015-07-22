package br.com.ClasseFuncao;

import java.util.Random;

public class Pesquisa {

	// A pesquisa ou busca binária (em inglês binary search algorithm ou binary
	// chop) é um algoritmo de busca em vetores que segue o paradigma de divisão
	// e conquista. Ela parte do pressuposto de que o vetor está ordenado e
	// realiza sucessivas divisões do espaço de busca comparando o elemento
	// buscado (chave) com o elemento no meio do vetor. Se o elemento do meio do
	// vetor for a chave, a busca termina com sucesso. Caso contrário, se o
	// elemento do meio vier antes do elemento buscado, então a busca continua
	// na metade posterior do vetor. E finalmente, se o elemento do meio vier
	// depois da chave, a busca continua na metade anterior do vetor.

	public static int buscaBinaria(int[] array, int valor) {
		int inicio = 0;
		int fim = array.length - 1;

		while (inicio <= fim) {
			int meio = (inicio + fim) / 2;

			if (array[meio] == valor) {
				return meio;
			}

			if (valor > array[meio]) {
				inicio = meio + 1;
			} else {
				fim = meio - 1;
			}
		}
		return -1;
	}

	// Na área de informática, ou Ciência da Computação, costuma-se usar o termo
	// busca linear (ou busca sequêncial) para expressar um tipo de pesquisa em
	// vetores ou listas de modo sequencial, i. e., elemento por elemento, de
	// modo que a função do tempo em relação ao número de elementos é linear, ou
	// seja, cresce proporcionalmente. Num vetor ordenado, essa não é a pesquisa
	// mais eficiente, a pesquisa (ou busca) binária, por exemplo, é um tipo de
	// pesquisa com o gráfico de tempo logarítmo.

	public int procura(Object[] vetor, Object elementoProcurado) {
		for (int i = 0; i < vetor.length; i++)
			if (vetor[i].equals(elementoProcurado))
				return i;
		return -1; // Não achou, retorna -1
	}

	// Bogosort (também conhecido como CaseSort), é um algoritmo de ordenação
	// extremamente ineficiente. É baseado na reordenação aleatória dos
	// elementos. Não é utilizado na prática, mas pode ser usado no ensino de
	// algorítmos mais eficientes. Seu nome veio do engraçado termo quantum
	// bogodynamics e, ultimamente, a palavra bogus.
	
	public static void bogoSort(int length, int range) {
		int []array = randomIntArray(length,range);
			
		while (! isSorted(array))
			array = randomArray(array);
			
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
			
	}
		
	private static boolean isSorted(int [] array)
	{
	    for (int i = 0; i < (array.length - 1); ++i) {
	    	if (array[i] > array[i+1])
	    		return false;
	    }
	        
	    return true;
	}
		
	private static int [] randomArray(int [] array) {
			 
	    int size = array.length;
	    int[] indices = new int[size]; 
	    for (int i=0; i<size; i++) {
	    	indices[i] = i;
	    }
		      
	    Random random = new Random();
	    for (int i = 0; i < size; i++) {
	      boolean unique = false;
	      int nRandom = 0;
	      while (!unique) {
	        unique = true;
	        nRandom = random.nextInt(size);
	        for (int j = 0; j < i; j++) {
	          if (indices[j] == nRandom) {
	             unique = false;
	             break;
	          }
	        }
	      } 
		 
	      indices[i] = nRandom; 
	    }
		 
	    int [] result = new int[size];
	        for (int k = 0; k < size; k++) {
	    result[indices[k]] = array[k];
	    }

	    return result;
	}
		
	private static int[] randomIntArray(int length, int n)
	{
	  int[] a = new int[length];
	  Random generator = new Random();
	  for (int i = 0; i < a.length; i++)
	  {
	      a[i] = generator.nextInt(n);
	  }
	  return a;
	}

}
