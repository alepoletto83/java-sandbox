import java.util.List;
import java.util.HashMap;
import java.util.function.BiFunction;

void main() {

    // var infere o tipo da variável local pelo valor da direita (continua estático, não é Object)
    var texto = "java";
    var numero = 42;
    var lista = List.of("a", "b", "c");
    IO.println(texto);
    IO.println(numero);
    IO.println(lista);

    // com var é obrigatório dizer os tipos no new, senão vira HashMap<Object,Object>
    var mapa = new HashMap<String, Integer>();
    mapa.put("um", 1);
    mapa.put("dois", 2);
    IO.println(mapa);

    // var no for clássico e no for-each
    for (var i = 0; i < 3; i++) {
        IO.println("for " + i);
    }
    for (var item : lista) {
        IO.println("for-each " + item);
    }

    // var infere o tipo do literal: int trunca na divisão, double não
    var inteiroX = 7;
    var inteiroY = 2;
    IO.println(inteiroX / inteiroY);   // 3
    var decimal = 7.0;
    IO.println(decimal / inteiroY);    // 3.5

    // var NÃO funciona em lambda (precisa de target type); mas dá pra usar var nos parâmetros (Java 11)
    BiFunction<Integer, Integer, Integer> func = (var a, var b) -> a + b;
    IO.println(func.apply(3, 4));

    // var guarda o tipo anônimo com os campos extras; com `Object bicho` não daria pra ler .nome
    var bicho = new Object() { String nome = "gato"; int patas = 4; };
    IO.println(bicho.nome + " tem " + bicho.patas + " patas");
}
