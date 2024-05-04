public class Pessoa {
    String nome;
    int idade;
    double altura;

    public static final int NOME = 0;
    public static final int IDADE = 1;
    public static final int ALTURA = 2;

    public Pessoa(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;        
    }

    public int compare(Pessoa p, int atributo) {
        if (atributo == NOME) {
            return this.nome.compareTo(p.nome);
        } 
        
        if (atributo == IDADE) {
            return this.idade - p.idade;
        } 
        
        if (atributo == ALTURA) {
            if (this.altura > p.altura) {
                return 1;
            } else if (this.altura < p.altura) {
                return -1;
            }
        }

        return 0;
    }
}
