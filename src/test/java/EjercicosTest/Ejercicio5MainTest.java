package EjercicosTest;

import com.javi.algortimos.Ejercicio5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)

public class Ejercicio5MainTest {

    Ejercicio5 mensajero = new Ejercicio5();

    @Test
    public void verificarPalabraEsPalindromo() {
        //puedes enviar valores al llamar a un metodo y el puede recibirlos con tales valores esperandolo.
        boolean resultado = mensajero.esPalindromo("anana");
        assertThat(resultado, equalTo(true));

    }

    @Test
    public void verificarPalabraNoEsPalindromo() {
        boolean resultado = mensajero.esPalindromo("pollo");
        assertThat(resultado , equalTo(false));

    }

}
