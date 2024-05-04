import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        
        Pessoa[] pessoas = {
            new Pessoa("Ellen Ripley", random.nextInt(100), 1.50 + random.nextDouble(0.5)),
            new Pessoa("Luke Skywalker", random.nextInt(100), 1.50 + random.nextDouble(0.5)),
            new Pessoa("James T. Kirk", random.nextInt(100), 1.50 + random.nextDouble(0.5)),
            new Pessoa("Mark Watney", random.nextInt(100), 1.50 + random.nextDouble(0.5)),
            new Pessoa("Paul Atreides", random.nextInt(100), 1.50 + random.nextDouble(0.5)),
            new Pessoa("Neo", random.nextInt(100), 1.50 + random.nextDouble(0.5)),
            new Pessoa("Mr. Robot", random.nextInt(100), 1.50 + random.nextDouble(0.5)),
            new Pessoa("Tony Stark", random.nextInt(100), 1.50 + random.nextDouble(0.5)),
            new Pessoa("Sarah Connor", random.nextInt(100), 1.50 + random.nextDouble(0.5)),
            new Pessoa("Dr. Emmett Brown", random.nextInt(100), 1.50 + random.nextDouble(0.5))
        };

        bubbleSort(pessoas, 2);
        selectionSort(pessoas, 2);
        insertionSort(pessoas, 2);
        quickSort(pessoas, 0, pessoas.length-1, 0);

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.nome + " - " + pessoa.idade + " - " + String.format("%.2f", pessoa.altura));
        }
    }

    public static void bubbleSort(Pessoa[] pessoas, int atributo) {
        int tamanhoLista = pessoas.length;
        
        for (int i = 0; i < tamanhoLista; i++) {
            for (int j = 0; j < tamanhoLista; j++) {
                if (pessoas[j].compare(pessoas[i], atributo) > 0) {
                    var temp = pessoas[j];
                    pessoas[j] = pessoas[i];
                    pessoas[i] = temp;
                }
            }
        }
    }

    public static void selectionSort(Pessoa[] pessoas, int atributo) {
        int tamanhoLista = pessoas.length;

        for (int i = 0; i < tamanhoLista - 1; i++) {
            int min = i;
            for (int j = i + 1; j < tamanhoLista; j++) {
                if (pessoas[j].compare(pessoas[min], atributo) < 0)
                    min = j;
            }
            Pessoa temp = pessoas[i];
            pessoas[i] = pessoas[min];
            pessoas[min] = temp;
        }
    }

    public static void insertionSort(Pessoa[] pessoas, int atributo) {
        int tamanhoLista = pessoas.length;

        int j;
        Pessoa temp;
        for (int i = 0; i < tamanhoLista; i++) {
            j = i;
            while(j > 0 && pessoas[j-1].compare(pessoas[j], atributo) > 0) {
                temp = pessoas[j];
                pessoas[j] = pessoas[j-1];
                pessoas[j-1] = temp;
                j--;
            }
        }
    }

    private static int separar(Pessoa[] pessoas, int inicio, int fim, int atributo) {
		Pessoa pivo = pessoas[inicio];
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (pessoas[i].compare(pivo, atributo) <= 0)
				i++;
			else if (pivo.compare(pessoas[f], atributo) < 0)
				f--;
			else {
				Pessoa troca = pessoas[i];
				pessoas[i] = pessoas[f];
				pessoas[f] = troca;
				i++;
				f--;
			}
		}
		pessoas[inicio] = pessoas[f];
		pessoas[f] = pivo;
		return f;
	}

	public static void quickSort(Pessoa[] pessoas, int inicio, int fim, int atributo) {
		if (inicio < fim) {
			int posicaoPivo = separar(pessoas, inicio, fim, atributo);

			quickSort(pessoas, inicio, posicaoPivo - 1, atributo);
			quickSort(pessoas, posicaoPivo + 1, fim, atributo);
		}
	}
}
