package ClasseFuncao;

public class MetodosOrdenacaoSimples {

	// O selection sort (do inglês, ordenação por seleção) é um algoritmo de
	// ordenação baseado em se passar sempre o menor valor do vetor para a
	// primeira posição (ou o maior dependendo da ordem requerida), depois o de
	// segundo menor valor para a segunda posição, e assim é feito
	// sucessivamente com os (n-1) elementos restantes, até os últimos dois
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

	// Insertion sort, ou ordenação por inserção, é um simples algoritmo de
	// ordenação, eficiente quando aplicado a um pequeno número de elementos. Em
	// termos gerais, ele percorre um vetor de elementos da esquerda para a
	// direita e à medida que avança vai deixando os elementos mais à esquerda
	// ordenados. O algoritmo de inserção funciona da mesma maneira com que
	// muitas pessoas ordenam cartas em um jogo de baralho como o pôquer
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

	// O bubble sort, ou ordenação por flutuação (literalmente "por bolha"), é
	// um algoritmo de ordenação dos mais simples. A ideia é percorrer o vector
	// diversas vezes, a cada passagem fazendo flutuar para o topo o maior
	// elemento da sequência. Essa movimentação lembra a forma como as bolhas em
	// um tanque de água procuram seu próprio nível, e disso vem o nome do
	// algoritmo.
	//
	// No melhor caso, o algoritmo executa n operações relevantes, onde n
	// representa o número de elementos do vector. No pior caso, são feitas n^2
	// operações. A complexidade desse algoritmo é de Ordem quadrática. Por
	// isso, ele não é recomendado para programas que precisem de velocidade e
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
	// por um salto, que é calculado a cada passagem. Método semelhante ao
	// Bubble Sort, porém mais eficiente.
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
