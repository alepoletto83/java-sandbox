void main() {

    // text block: multilinha sem \n nem +
    var endereco = """
            1188 main st
            v8b 9v5
            """;
    IO.println(endereco);

    // a margem é definida pela posição do """ de fechamento
    var bloco = """
            esquerda
              recuado
            """;
    IO.println("[" + bloco + "]");

    // text block termina com \n implícito; o \ no fim suprime essa quebra
    var semQuebraFinal = """
            linha um
            linha dois""";
    IO.println("[" + semQuebraFinal + "]");

    // \s preserva espaços à direita que seriam removidos
    var comEspaco = """
            fim com espacos   \s
            """;
    IO.println("[" + comEspaco.stripTrailing().length() + "]");

    // sem interpolação: placeholders + .formatted()
    var saudacao = """
            Olá, %s! Você tem %d anos.
            """.formatted("Alexandre", 43);
    IO.println(saudacao);

    // caso real: JSON legível
    var json = """
            {
              "nome": "%s",
              "cidade": "%s",
              "ativo": %b
            }
            """.formatted("Alexandre", "Squamish", true);
    IO.println(json);
}
