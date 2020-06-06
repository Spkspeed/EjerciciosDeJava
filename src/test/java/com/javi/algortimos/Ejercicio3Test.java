import com.javi.algortimos.Ejercicio3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
public class Ejercicio3Test {

    Ejercicio3 ejercicio3 = new Ejercicio3();

    @Test
    public void verificarOracionConCincoPalabras() {
        String sentence = "Hola mi nombre es robot";

        List result = ejercicio3.splitSentence(sentence);
        assertThat(result.size(), equalTo(5));
    }

    @Test
    public void verificarOracionConCincoPalabrasYEspacioFinal() {
        String sentence = "Hola mi nombre es robot ";

        List result = ejercicio3.splitSentence(sentence);
        assertThat(result.size(), equalTo(5));
    }

    @Test
    public void verificarOracionConUnaPalabras() {
        String sentence = "robot";

        List result = ejercicio3.splitSentence(sentence);
        assertThat(result.size(), equalTo(1));
    }

    @Test
    public void verificarOracionConUnEspacio() {
        String sentence = " ";

        List result = ejercicio3.splitSentence(sentence);
        assertThat(result.size(), equalTo(0));
    }

    @Test
    public void verificarOracionVacia() {
        String sentence = "";

        List result = ejercicio3.splitSentence(sentence);
        assertThat(result.size(), equalTo(1));
    }

}
