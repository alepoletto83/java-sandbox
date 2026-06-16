import java.util.List;
import java.util.Set;
import java.util.Map;

void main() {

    // List.of -> lista pronta numa linha, mas IMUTÁVEL
    List<String> languages = List.of("java", "Typescript", "Python");
    IO.println(languages);
    IO.println(languages.size());

    // mexer numa List.of estoura UnsupportedOperationException (não tem add/set de verdade)
    try {
        languages.add("c#");
    } catch (Exception e) {
        IO.println(e.getClass().getSimpleName());
    }

    // Set.of não engole duplicata igual HashSet -> dá IllegalArgumentException ("duplicate element")
    Set<String> set = Set.of("a","b","c");
    try {
        Set.of("a", "a");
    } catch (Exception e) {
        IO.println(e.getMessage());
    }

    // Map.of: chave,valor,chave,valor... fica ilegível rápido e limite é 10 pares
    Map<String,Integer> maps = Map.of("um",1,"dois",2);

    // Map.ofEntries: mais verboso mas escala melhor que Map.of
    Map.ofEntries(Map.entry("um", 1),Map.entry("dois",2));

    // .of não aceita null (Arrays.asList aceitava) -> NPE; getMessage() vem null, melhor o getClass
    try {
        List.of("a",null);
    } catch (Exception e) {
        IO.println(e.getMessage());
    }

}
