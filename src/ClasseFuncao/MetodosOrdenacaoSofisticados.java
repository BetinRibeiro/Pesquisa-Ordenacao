package ClasseFuncao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class MetodosOrdenacaoSofisticados {
	// O merge sort, ou ordenação por mistura, é um exemplo de algoritmo de
	// ordenação do tipo dividir-para-conquistar.
	//
	//// Sua ideia básica consiste em Dividir(o problema em vários sub-problemas
	// e resolver esses sub-problemas através da recursividade) e
	// Conquistar(após todos os sub-problemas terem sido resolvidos ocorre a
	// conquista que é a união das resoluções dos sub-problemas).Como o
	// algoritmo do Merge Sort usa a recursividade em alguns problemas esta
	// técnica não é muito eficiente devido ao alto consumo de memória e tempo
	// de execução.

	public static void mergeSort(int[] array, int inicio, int fim) {
		if (fim <= inicio) {
			return;
		}
		int meio = (inicio + fim) / 2;
		mergeSort(array, inicio, meio);
		mergeSort(array, meio + 1, fim);
		int[] A = new int[meio - inicio + 1];
		int[] B = new int[fim - meio];
		for (int i = 0; i <= meio - inicio; i++) {
			A[i] = array[inicio + i];
		}
		for (int i = 0; i <= fim - meio - 1; i++) {
			B[i] = array[meio + 1 + i];
		}
		int i = 0;
		int j = 0;
		for (int k = inicio; k <= fim; k++) {
			if (i < A.length && j < B.length) {
				if (A[i] < B[j]) {
					array[k] = A[i++];
				} else {
					array[k] = B[j++];
				}
			} else if (i < A.length) {
				array[k] = A[i++];
			} else if (j < B.length) {
				array[k] = B[j++];
			}
		}
	}
	//
	// Tem um desempenho em tempo de execução muito bom em conjuntos ordenados
	// aleatoriamente, tem um uso de memória bem comportado e o seu desempenho
	// em pior cenário é praticamente igual ao desempenho em cenário médio.
	// Alguns algoritmos de ordenação rápidos têm desempenhos espectacularmente
	// ruins no pior cenário, quer em tempo de execução, quer no uso da memória.
	// O Heapsort trabalha no lugar e o tempo de execução em pior cenário para
	// ordenar n elementos é de O (n lg n). Lê-se logaritmo (ou log) de "n" na
	// base 2. Para valores de n, razoavelmente grandes, o termo lg n é quase
	// constante, de modo que o tempo de ordenação é quase linear com o número
	// de itens a ordenar.

	public static void heapSort(int[] v) {
		buildMaxHeap(v);
		int n = v.length;

		for (int i = v.length - 1; i > 0; i--) {
			swap(v, i, 0);
			maxHeapify(v, 0, --n);
		}
	}

	private static void buildMaxHeap(int[] v) {
		for (int i = v.length / 2 - 1; i >= 0; i--)
			maxHeapify(v, i, v.length);
	}

	private static void maxHeapify(int[] v, int pos, int n) {
		int maxi;
		int l = 2 * pos;
		int right = 2 * pos + 1;
		if ((l < n) && (v[l] > v[pos])) {
			maxi = l;
		} else {
			maxi = pos;
		}
		if (right < n && v[right] > v[maxi]) {
			maxi = right;
		}
		if (maxi != pos) {
			swap(v, pos, maxi);
			maxHeapify(v, maxi, n);
		}
	}

	public static void swap(int[] v, int j, int aposJ) {
		int aux = v[j];
		v[j] = v[aposJ];
		v[aposJ] = aux;
	}

	// versão do algoritmo acima mas com a versão 5 do java

	public static <T extends Comparable<? super T>> void heapSort(T[] v) {
		buildMaxHeap(v);
		int n = v.length;

		for (int i = v.length - 1; i > 0; i--) {
			swap(v, i, 0);
			maxHeapify(v, 0, --n);
		}
	}

	private static <T extends Comparable<? super T>> void buildMaxHeap(T v[]) {
		for (int i = v.length / 2 - 1; i >= 0; i--)
			maxHeapify(v, i, v.length);
	}

	private static <T extends Comparable<? super T>> void maxHeapify(T[] v, int pos, int n) {
		int max = 2 * pos + 1, right = max + 1;
		if (max < n) {
			if (right < n && v[max].compareTo(v[right]) < 0)
				max = right;
			if (v[max].compareTo(v[pos]) > 0) {
				swap(v, max, pos);
				maxHeapify(v, max, n);
			}
		}
	}

	public static void swap(Object[] v, int j, int aposJ) {
		Object aux = v[j];
		v[j] = v[aposJ];
		v[aposJ] = aux;
	}

	// Shell sort é o mais eficiente algoritmo de classificação dentre os de
	// complexidade quadrática. É um refinamento do método de inserção direta.2
	// O algoritmo difere do método de inserção direta pelo fato de no lugar de
	// considerar o array a ser ordenado como um único segmento, ele considera
	// vários segmentos sendo aplicado o método de inserção direta em cada um
	// deles.3 Basicamente o algoritmo passa várias vezes pela lista dividindo o
	// grupo maior em menores. Nos grupos menores é aplicado o método da
	// ordenação por inserção. Implementações do algoritmo. Procure a versão em
	// inglês desse mesmo link.

	public static void shellSort(Integer[] nums) {
		int h = 1;
		int n = nums.length;
		while (h < n)
			h = h * 3 + 1;
		h = h / 3;
		int c, j;
		while (h > 0) {
			for (int i = h; i < n; i++) {
				c = nums[i];
				j = i;
				while (j >= h && nums[j - h] > c) {
					nums[j] = nums[j - h];
					j = j - h;
				}
				nums[j] = c;
			}
			h = h / 2;
		}
	}

	// O Radix sort é um algoritmo de ordenação rápido e estável que pode ser
	// usado para ordenar itens que estão identificados por chaves únicas. Cada
	// chave é uma cadeia de caracteres ou número, e o radix sort ordena estas
	// chaves numa qualquer ordem relacionada com a lexicografia.
	//
	// Na ciência da computação, radix sort é um algoritmo de ordenação que
	// ordena inteiros processando dígitos individuais. Como os inteiros podem
	// representar strings compostas de caracteres (como nomes ou datas) e
	// pontos flutuantes especialmente formatados, radix sort não é limitado
	// somente a inteiros.

	private static final int MAX_CHARS = 28;

	private static void radixSort(String[] v) {
		Queue<String> queues[] = createQueues();
		for (int pos = maxSize(v) - 1; pos >= 0; pos--) {
			for (int i = 0; i < v.length; i++) {
				int q = queueNo(v[i], pos);
				queues[q].add(v[i]);
			}
			restore(queues, v);
		}
	}

	private static void restore(Queue<String>[] qs, String[] v) {
		int contv = 0;
		for (int q = 0; q < qs.length; q++)
			while (qs[q].size() > 0)
				v[contv++] = qs[q].remove();
	}

	private static Queue<String>[] createQueues() {
		LinkedList<String>[] result = new LinkedList[MAX_CHARS];
		for (int i = 0; i < MAX_CHARS; i++) {
			result[i] = new LinkedList<String>();
		}
		return result;
	}

	private static int queueNo(String string, int pos) {
		if (pos >= string.length()) {
			return 0;
		}
		char ch = string.charAt(pos);
		if ((ch >= 'A') && (ch <= 'Z')) {
			return (ch - 'A' + 1);
		} else if (ch >= 'a' && ch <= 'z') {
			return ch - 'a' + 1;
		} else {
			return 27;
		}
	}

	private static int maxSize(String[] v) {
		int maxValue = v[0].length();

		for (int i = 1; i < v.length; i++) {
			if (maxValue < v[i].length()) {
				maxValue = v[i].length();
			}
		}
		return maxValue;
	}

	public static void printStringArray(String[] arrToPrint) {
		for (int i = 0; i < arrToPrint.length; i++) {
			System.out.print(arrToPrint[i] + " ");
		}
		System.out.println();
	}

	// Algoritmo similiar ao Insertion sort com a diferença que o Gnome sort
	// leva um elemento para sua posição correta, com uma seqüencia grande de
	// trocas assim como o Bubble sort
	//
	// O algoritmo percorre o vetor comparando seus elementos dois a dois, assim
	// que ele encontra um elemento que está na posição incorreta, ou seja, um
	// número maior antes de um menor, ele troca a posição dos elementos, e
	// volta com este elemento até que encontre o seu respectivo lugar.

	public static Integer[] gnomeSort(Integer[] array) {
		int pivout = 0;
		int aux;
		while (pivout < (array.length - 1)) {
			if (array[pivout] > array[pivout + 1]) {
				aux = array[pivout];
				array[pivout] = array[pivout + 1];
				array[pivout + 1] = aux;
				if (pivout > 0) {
					pivout -= 2;
				}
			}
			pivout++;
		}
		return array;
	}

	// Bucket sort, ou bin sort, é um algoritmo de ordenação que funciona
	// dividindo um vetor em um número finito de recipientes. Cada recipiente é
	// então ordenado individualmente, seja usando um algoritmo de ordenação
	// diferente, ou usando o algoritmo bucket sort recursivamente. O bucket
	// sort tem complexidade linear (Θ(n)) quando o vetor a ser ordenado contém
	// valores que são uniformemente distribuídos.

	public static void BucketSort(int[] vetor, int maiorValor) {
		int numBaldes = maiorValor / 5;

		LinkedList[] B = new LinkedList[numBaldes];

		for (int i = 0; i < numBaldes; i++) {
			B[i] = new LinkedList<Integer>();
		}

		// Coloca os valores no balde respectivo:
		for (int i = 0; i < vetor.length; i++) {
			int j = numBaldes - 1;
			while (true) {
				if (j < 0) {
					break;
				}
				if (vetor[i] >= (j * 5)) {
					B[j].add(vetor[i]);
					break;
				}
				j--;
			}
		}

		// Ordena e atualiza o vetor:
		int indice = 0;
		for (int i = 0; i < numBaldes; i++) {

			int[] aux = new int[B[i].size()];

			// Coloca cada balde num vetor:
			for (int j = 0; j < aux.length; j++) {
				aux[j] = (Integer) B[i].get(j);
			}

			MetodosOrdenacaoSimples.insertionSort(aux); // algoritmo escolhido para
												// ordenação.

			// Devolve os valores ao vetor de entrada:
			for (int j = 0; j < aux.length; j++, indice++) {
				vetor[indice] = aux[j];
			}

		}
	}

	// Cocktail sort, também conhecido como Shaker Sort, bubble sort
	// bidirecional (que também pode se referir a uma variante do selection
	// sort), ripple sort, shuttle sort ou happy hour sort, é uma variação do
	// bubble sort que é tanto um algoritmo de ordenação estável quanto uma
	// ordenação por comparação. O algoritmo difere do bubble sort pelo fato de
	// ordenar em ambas as direções em cada passagem através da lista. Este
	// algoritmo de ordenação é apenas ligeiramente mais difícil de implementar
	// do que o bubble sort, e resolve o problema com os chamados coelhos e
	// tartarugas no bubble sort.

	private static void cocktail(int[] vetor) {
		int tamanho, inicio, fim, swap, aux;
		tamanho = 20; // para um vetor de 20 elementos
		inicio = 0;
		fim = tamanho - 1;
		swap = 0;
		while (swap == 0 && inicio < fim) {
			swap = 1;
			for (int i = inicio; i < fim; i = i + 1) {
				if (vetor[i] > vetor[i + 1]) {
					aux = vetor[i];
					vetor[i] = vetor[i + 1];
					vetor[i + 1] = aux;
					swap = 0;
				}
			}
			fim = fim - 1;
			for (int i = fim; i > inicio; i = i - 1) {
				if (vetor[i] < vetor[i - 1]) {
					aux = vetor[i];
					vetor[i] = vetor[i - 1];
					vetor[i - 1] = aux;
					swap = 0;
				}
			}
			inicio = inicio + 1;
		}
	}
	// O algoritmo Quicksort é um método de ordenação muito rápido e eficiente,
	// inventado por C.A.R. Hoare em 19601 , quando visitou a Universidade de
	// Moscovo como estudante. Naquela época, Hoare trabalhou em um projeto de
	// tradução de máquina para o National Physical Laboratory. Ele criou o
	// 'Quicksort ao tentar traduzir um dicionário de inglês para russo,
	// ordenando as palavras, tendo como objetivo reduzir o problema original em
	// subproblemas que possam ser resolvidos mais facil e rapidamente. Foi
	// publicado em 1962 após uma série de refinamentos.

	// essa implementação é feita em java 8, temos na internete outros
	// algoritmos em java com versões anteriores

	public static class QuickSort {

		public static List<Integer> ordenar(List<Integer> vetor) {
			if (vetor.size() <= 1)
				return vetor;
			else {
				int pivo = vetor.get(vetor.size() / 2);
				List<Integer> concatenado = new ArrayList<>();
				concatenado.addAll(ordenar(vetor.stream().filter(i -> i > pivo).collect(Collectors.toList())));
				concatenado.addAll(vetor.stream().filter(i -> i == pivo).collect(Collectors.toList()));
				concatenado.addAll(ordenar(vetor.stream().filter(i -> i < pivo).collect(Collectors.toList())));
				return concatenado;
			}
		}

	}
}
