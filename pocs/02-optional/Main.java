import java.util.Optional;

void main() {
    // Criar
    Optional<String> cheio = Optional.of("x");
    Optional<String> vazio = Optional.empty();
    Optional<String> talvez = Optional.ofNullable(podeSerNull(false));
    Optional<String> talvezNull = Optional.ofNullable(podeSerNull(true));
    IO.println("1. " + cheio + " | " + vazio + " | " + talvez + " | " + talvezNull);
    try {
        Optional.of(null); // estoura NPE na hora, ofNullable não
    } catch (NullPointerException e) {
        IO.println("   Optional.of(null) -> " + e.getClass().getSimpleName());
    }

    //  Ler
    if (cheio.isPresent()) {
        IO.println("2. get() = " + cheio.get());
    }
    IO.println("   vazio.orElse(\"default\") = " + vazio.orElse("default"));

    // orElseGet x orElse 
    IO.println("3. cheio.orElse:");
    cheio.orElse(barulho("orElse"));
    IO.println("   cheio.orElseGet:");
    cheio.orElseGet(() -> barulho("orElseGet"));

    // orElseThrow
    try {
        vazio.orElseThrow(() -> new IllegalStateException("tava vazio!"));
    } catch (IllegalStateException e) {
        IO.println("4. orElseThrow -> " + e.getMessage());
    }
  

    // ifPresentOrElse (Java 9)
    cheio.ifPresentOrElse(
            v -> IO.println("5. tem: " + v),
            () -> IO.println("5. nada"));
    vazio.ifPresentOrElse(
            v -> IO.println("   tem: " + v),
            () -> IO.println("   nada"));

    //  or (Java 9)
    IO.println("6. vazio.or(-> cheio) = " + vazio.or(() -> cheio));

    //  isEmpty (Java 11)
    IO.println("7. vazio.isEmpty() = " + vazio.isEmpty() + " | cheio.isEmpty() = " + cheio.isEmpty());
}

String podeSerNull(boolean retornaNull) {
    return retornaNull ? null : "valor";
}

String barulho(String quem) {
    IO.println("   >> fornecedor de " + quem + " foi avaliado");
    return "fallback";
}

Optional<Integer> parseTamanho(String s) {
    return s == null ? Optional.empty() : Optional.of(s.length());
}
