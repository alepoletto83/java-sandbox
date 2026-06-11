

import java.util.Arrays;
import java.util.List;

String nome = "Java 25";
// novo main
void main() {
    IO.println("oi, " + nome + "!");
    IO.println("main sem class, sem static, sem args");

    saudacao();

    List versoes =  Arrays.asList(8, 11, 17, 21, 25);
    IO.println("LTS que eu pulei: " + versoes);
}

void saudacao() {
    IO.println("metodo auxiliar também sem static, porque main é de instância");
}
