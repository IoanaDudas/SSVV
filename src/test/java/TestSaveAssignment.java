import domain.Tema;
import org.junit.jupiter.api.Test;
import repository.TemaXMLRepository;
import validation.TemaValidator;
import validation.Validator;

import static org.junit.jupiter.api.Assertions.*;

public class TestSaveAssignment {
    @Test
    public void TestSaveAssignment_DataIsValidAndNonexistent_Success() {
        Tema tema = new Tema("5", "tema", 10, 5);
        Validator<Tema> temaValidator = new TemaValidator();
        TemaXMLRepository temaXMLRepository = new TemaXMLRepository(temaValidator, "test_teme.xml");

        assertEquals(temaXMLRepository.save(tema), tema);

        temaXMLRepository.delete("5");
    }

    @Test
    public void TestSaveAssignment_DataIsValidAndExistent_ReturnsNull() {
        Tema tema = new Tema("2", "XML", 8, 7);
        Validator<Tema> temaValidator = new TemaValidator();
        TemaXMLRepository temaXMLRepository = new TemaXMLRepository(temaValidator, "test_teme.xml");

        assertNull(temaXMLRepository.save(tema));
    }
}
