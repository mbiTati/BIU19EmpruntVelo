import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VeloTest {

    @Test
    void nouveauVelo_estDisponible_parDefaut() {
        Velo v = new Velo("V001", "VTT");

        assertEquals("V001", v.getCode());
        assertEquals("VTT", v.getType());
        assertTrue(v.isDisponible(), "Un vélo créé doit être disponible");
    }

    @Test
    void setDisponible_false_rendVeloIndisponible() {
        Velo v = new Velo("V002", "Ville");

        v.setDisponible(false);

        assertFalse(v.isDisponible(), "Le vélo doit être marqué comme indisponible");
    }

    @Test
    void toString_afficheStatutCorrect() {
        Velo v = new Velo("V003", "Electrique");

        assertTrue(v.toString().contains("Disponible"));

        v.setDisponible(false);

        assertTrue(v.toString().contains("Emprunte"));
    }

    @Test
    void chercher_retourneVeloDisponible_siExiste() {
        Velo[] velos = {
            new Velo("V001", "VTT"),
            new Velo("V002", "Ville"),
            new Velo("V003", "Electrique")
        };

        Velo v = Velo.chercher(velos, "V002");

        assertNotNull(v);
        assertEquals("V002", v.getCode());
        assertTrue(v.isDisponible());
    }

    @Test
    void chercher_retourneNull_siVeloIndisponible() {
        Velo v1 = new Velo("V001", "VTT");
        Velo v2 = new Velo("V002", "Ville");

        v2.setDisponible(false);

        Velo[] velos = { v1, v2 };

        Velo v = Velo.chercher(velos, "V002");

        assertNull(v, "Un vélo indisponible ne doit pas être retourné");
    }

    @Test
    void chercher_retourneNull_siCodeInconnu() {
        Velo[] velos = {
            new Velo("V001", "VTT"),
            new Velo("V002", "Ville")
        };

        Velo v = Velo.chercher(velos, "V999");

        assertNull(v);
    }
}
