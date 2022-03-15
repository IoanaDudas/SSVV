import domain.Student;
import org.junit.Test;
import repository.StudentXMLRepository;
import validation.StudentValidator;
import validation.Validator;

import static org.junit.Assert.assertNull;

public class TestSaveStudent {

    @Test
    public void TestSaveStudent_IdIsNull() {
        Student student = new Student(null, "Andrei", 200);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void TestSaveStudent_DataIsValid() {
        Student student = new Student("12", "Andrei", 200);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));

        studentXMLRepository.delete("12");
    }
}
