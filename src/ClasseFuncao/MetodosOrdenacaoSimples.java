package ClasseFuncao;

public class MetodosOrdenacaoSimples {

	// O selection sort (do ingl�s, ordena��o por sele��o) � um algoritmo de
	// ordena��o baseado em se passar sempre o menor valor do vetor para a
	// primeira posi��o (ou o maior dependendo da ordem requerida), depois o de
	// segundo menor valor para a segunda posi��o, e assim � feito
	// sucessivamente com os (n-1) elementos restantes, at� os �ltimos dois
	// elementos.
	public static void selectionSort(int[] array) {
		for (int fixo = 0; fixo < array.length - 1; fixo++) {
			int menor = fixo;

			for (int i = menor + 1; i < array.length; i++) {
				if (array[i] < array[menor]) {
					menor = i;
				}
			}
			if (menor != fixo) {
				// Troca
				int t = array[fixo];
				array[fixo] = array[menor];
				array[menor] = t;
			}
		}
	}

	// Insertion sort, ou ordena��o por inser��o, � um simples algoritmo de
	// ordena��o, eficiente quando aplicado a um pequeno n�mero de elementos. Em
	// termos gerais, ele percorre um vetor de elementos da esquerda para a
	// direita e � medida que avan�a vai deixando os elementos mais � esquerda
	// ordenados. O algoritmo de inser��o funciona da mesma maneira com que
	// muitas pessoas ordenam cartas em um jogo de baralho como o p�quer
	public static void insertionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int temp = array[i];
			int j;
			for (j = i - 1; j >= 0 && temp < array[j]; j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = temp;
		}
	}

	// O bubble sort, ou ordena��o por flutua��o (literalmente "por bolha"), �
	// um algoritmo de ordena��o dos mais simples. A ideia � percorrer o vector
	// diversas vezes, a cada passagem fazendo flutuar para o topo o maior
	// elemento da sequ�ncia. Essa movimenta��o lembra a forma como as bolhas em
	// um tanque de �gua procuram seu pr�prio n�vel, e disso vem o nome do
	// algoritmo.
	//
	// No melhor caso, o algoritmo executa n opera��es relevantes, onde n
	// representa o n�mero de elementos do vector. No pior caso, s�o feitas n^2
	// opera��es. A complexidade desse algoritmo � de Ordem quadr�tica. Por
	// isso, ele n�o � recomendado para programas que precisem de velocidade e
	// operem com quantidade elevada de dados.

	public static void bubbleSort(int[] array) {

		// int array[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		boolean troca = true;
		int aux;
		while (troca) {
			troca = false;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					aux = array[i];
					array[i] = array[i + 1];
					array[i + 1] = aux;
					troca = true;
				}
			}
		}
	}

	// O Algoritmo repetidamente reordena diferentes pares de itens, separados
	// por um salto, que � calculado a cada passagem. M�todo semelhante ao
	// Bubble Sort, por�m mais eficiente.
	public static <E extends Comparable<? super E>> void combSort(E[] input) {
		int gap = input.length;
		boolean swapped = true;
		while (gap > 1 || swapped) {
			if (gap > 1)
				gap = (int) (gap / 1.247330950103979);

			int i = 0;
			swapped = false;
			while (i + gap < input.length) {
				if (input[i].compareTo(input[i + gap]) > 0) {
					E t = input[i];
					input[i] = input[i + gap];
					input[i + gap] = t;
					swapped = true;
				}
				i++;
			}
		}
	}
}
