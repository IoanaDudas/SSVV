import domain.Student;
import org.junit.Test;
import repository.StudentXMLRepository;
import validation.StudentValidator;
import validation.Validator;

import static org.junit.Assert.*;

public class TestSaveStudentAssignment {
    @Test
    public void TestSaveStudent_DataIsValid_Success() {
        Student student = new Student("12", "Andrei", 200);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertEquals(studentXMLRepository.save(student), student);

        studentXMLRepository.delete("12");
    }

    @Test
    public void TestSaveStudent_IdIsNull_ReturnsNull() {
        Student student = new Student(null, "Andrei", 200);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void TestSaveStudent_IdIsEmpty_ReturnsNull() {
        Student student = new Student("", "Andrei", 200);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void TestSaveStudent_NameIsNull_ReturnsNull() {
        Student student = new Student("55", null, 200);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void TestSaveStudent_NameIsEmpty_ReturnsNull() {
        Student student = new Student("55", "", 200);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void TestSaveStudent_DataIsValid_GroupIs109_ReturnsNull() {
        Student student = new Student("55", "Andrei", 109);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void TestSaveStudent_DataIsValid_GroupIs110_ReturnsNull() {
        Student student = new Student("55", "Andrei", 110);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void TestSaveStudent_DataIsValid_GroupIsGreaterThan110_Success() {
        Student student = new Student("0", "Andrei", 111);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertEquals(studentXMLRepository.save(student), student);

        studentXMLRepository.delete("0");
    }

    @Test
    public void TestSaveStudent_DataIsValid_GroupIsSmallerThan938_Success() {
        Student student = new Student("0", "Andrei", 937);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertEquals(studentXMLRepository.save(student), student);

        studentXMLRepository.delete("0");
    }

    @Test
    public void TestSaveStudent_DataIsValid_GroupIs938_ReturnsNull() {
        Student student = new Student("55", "Andrei", 938);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void TestSaveStudent_DataIsValid_GroupIs939_ReturnsNull() {
        Student student = new Student("55", "Andrei", 939);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void TestSaveStudent_DataIsValid_GroupIsMinus1_ReturnsNull() {
        Student student = new Student("55", "Andrei", -1);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void TestSaveStudent_DataIsValid_GroupIs0_ReturnsNull() {
        Student student = new Student("55", "Andrei", 0);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void TestSaveStudent_DataIsValid_GroupIs1_ReturnsNull() {
        Student student = new Student("55", "Andrei", 1);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void TestSaveStudent_DataIsValid_GroupIsMaxIntMinus1_ReturnsNull() {
        Student student = new Student("55", "Andrei", Integer.MAX_VALUE - 1);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void TestSaveStudent_DataIsValid_GroupIsMaxInt_ReturnsNull() {
        Student student = new Student("55", "Andrei", Integer.MAX_VALUE);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }
}
