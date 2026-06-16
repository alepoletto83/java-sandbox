import java.util.List;
import java.util.stream.Stream;

void main() {

    List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 1, 2);

    // takeWhile: pega do começo enquanto < 5 e para no 5
    // (ignora o 1 e 2 do fim, diferente do filter)
    IO.println(nums.stream().takeWhile(p -> p < 5).toList());

    // dropWhile: descarta enquanto < 5 e mantém o resto inteiro
    // repara que o 1 e 2 do fim ficaram
    IO.println(nums.stream().dropWhile(p -> p < 5).toList());

    // filter pra comparar: varre tudo, não liga pra ordem -> [1, 2, 3, 4, 1, 2]
    IO.println(nums.stream().filter(p -> p < 5).toList());

    // Stream.ofNullable: vira stream de 0 ou 1 elemento, mata o if != null
    String temValor = "abc";
    String ehNull = null;
    IO.println(Stream.ofNullable(temValor).count()); // 1
    IO.println(Stream.ofNullable(ehNull).count());    // 0

    // toList do Java 16: atalho do collect(Collectors.toList()) mas IMUTÁVEL
    List<Integer> vezes10 = nums.stream().map(n -> n * 10).toList();
    IO.println(vezes10);
    try {
        vezes10.add(999);
    } catch (UnsupportedOperationException e) {
        IO.println("nao pode mexer: " + e);
    }
}
