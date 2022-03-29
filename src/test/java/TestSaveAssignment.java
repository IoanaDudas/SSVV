import domain.Tema;
import org.junit.jupiter.api.Test;
import repository.TemaXMLRepository;
import validation.TemaValidator;
import validation.Validator;

import static org.junit.jupiter.api.Assertions.*;

public class TestSaveAssignment {
    @Test
    public void TestSaveAssignment_DataIsValidAndNonexistent_Success() {
        Tema tema = new Tema("5", "tema", 10, 8);
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

    @Test
    public void TestSaveAssignment_IdIsNull_ReturnsNull() {
        Tema tema = new Tema(null, "tema", 10, 8);
        Validator<Tema> temaValidator = new TemaValidator();
        TemaXMLRepository temaXMLRepository = new TemaXMLRepository(temaValidator, "test_teme.xml");

        assertNull(temaXMLRepository.save(tema));
    }

    @Test
    public void TestSaveAssignment_DescriptionIsEmpty_ReturnsNull() {
        Tema tema = new Tema("5", "", 10, 8);
        Validator<Tema> temaValidator = new TemaValidator();
        TemaXMLRepository temaXMLRepository = new TemaXMLRepository(temaValidator, "test_teme.xml");

        assertNull(temaXMLRepository.save(tema));
    }

    @Test
    public void TestSaveAssignment_DeadlineIsGreaterThan14_ReturnsNull() {
        Tema tema = new Tema("5", "tema", 15, 8);
        Validator<Tema> temaValidator = new TemaValidator();
        TemaXMLRepository temaXMLRepository = new TemaXMLRepository(temaValidator, "test_teme.xml");

        assertNull(temaXMLRepository.save(tema));
    }

    @Test
    public void TestSaveAssignment_StartineIsSmallerThan1_ReturnsNull() {
        Tema tema = new Tema("5", "tema", 10, 0);
        Validator<Tema> temaValidator = new TemaValidator();
        TemaXMLRepository temaXMLRepository = new TemaXMLRepository(temaValidator, "test_teme.xml");

        assertNull(temaXMLRepository.save(tema));
    }

    @Test
    public void TestSaveAssignment_StartineIsGreaterThanDeadline_ReturnsNull() {
        Tema tema = new Tema("5", "tema", 10, 12);
        Validator<Tema> temaValidator = new TemaValidator();
        TemaXMLRepository temaXMLRepository = new TemaXMLRepository(temaValidator, "test_teme.xml");

        assertNull(temaXMLRepository.save(tema));
    }
}
