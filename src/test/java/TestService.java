import domain.Nota;
import domain.Pair;
import domain.Student;
import domain.Tema;
import org.junit.jupiter.api.BeforeEach;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestService {
    private Service service;
    private StudentXMLRepository studentXMLRepository;
    private TemaXMLRepository temaXMLRepository;
    private NotaXMLRepository notaXMLRepository;

    @BeforeEach
    void SetUp() {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");
        temaXMLRepository = new TemaXMLRepository(temaValidator, "test_teme.xml");
        notaXMLRepository = new NotaXMLRepository(notaValidator, "test_note.xml");

        service = new Service(studentXMLRepository, temaXMLRepository, notaXMLRepository);
    }

    @Test
    public void TestAddStudent() {
        assertEquals(service.saveStudent("55", "Andrei", 200), 0);

        studentXMLRepository.delete("55");
    }

    @Test
    public void TestAddAssignment() {
        assertEquals(service.saveTema("5", "tema", 10, 8), 0);

        temaXMLRepository.delete("5");
    }

    @Test
    public void TestAddGrade() {
        assertEquals(service.saveNota("1", "2",  9, 8, "yay"), 0);

        notaXMLRepository.delete(new Pair<>("1", "2"));
    }

    @Test
    public void TestIntegrationAddGrade() {
        assertEquals(service.saveStudent("55", "Andrei", 200), 0);
        assertEquals(service.saveTema("5", "tema", 10, 8), 0);
        assertEquals(service.saveNota("55", "5",  10, 6, "yay"), 0);

        studentXMLRepository.delete("55");
        temaXMLRepository.delete("5");
        notaXMLRepository.delete(new Pair<>("55", "5"));
    }
}
