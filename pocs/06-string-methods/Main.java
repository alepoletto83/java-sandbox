void main() {

    // isBlank() é true pra "" E pra string só de espaços; isEmpty() só pra ""
    // são métodos de instância: com null dão NPE (o StringUtils do Commons era null-safe)
    var texto = " ";
    IO.println("isBlank: " + texto.isBlank());
    IO.println("isEmpty: " + texto.isEmpty());

    // strip() tira espaços das bordas igual trim()
    var texto2 = " java ";
    IO.println(texto2.strip());

    // stripLeading() tira só do começo, stripTrailing() só do fim
    IO.println("[" + texto2.stripLeading() + "]");
    IO.println("[" + texto2.stripTrailing() + "]");

    // repeat(n) repete a string n vezes
    IO.println("=".repeat(20));

    // lines() quebra a string num Stream<String> por quebra de linha
    var poema = """
            rosas são vermelhas

            violetas são azuis
            """;
    IO.println(poema.lines().count());
    poema.lines()
            .filter(linha -> !linha.isBlank())
            .forEach(IO::println);
}
