package EjercicosTest;

import com.javi.algortimos.Ejercicio2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
public class OperacionesTest {

    Ejercicio2 ejercicio2 = new Ejercicio2();

    @Test
    public void testSuma() {
        assertThat(ejercicio2.suma(3, 3), equalTo(6));
    }

    @Test
    public void testResta() {
        assertThat(ejercicio2.resta(3, 3), equalTo(0));
    }

    @Test
    public void testDivision() {
        assertThat(ejercicio2.division(9, 6), equalTo(1.5));
    }

    @Test
    public void testMultiplicacion() {
        assertThat(ejercicio2.multiplicacion(3, 3), equalTo(9));
    }

}
