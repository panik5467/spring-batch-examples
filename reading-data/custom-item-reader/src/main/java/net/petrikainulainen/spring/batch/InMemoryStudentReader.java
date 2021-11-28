package net.petrikainulainen.spring.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.core.annotation.BeforeStep;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.*;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * This class demonstrates how we can implement a custom ItemReader.
 */
public class InMemoryStudentReader implements ItemReader<StudentDTO> {

    private int nextStudentIndex;
    private List<StudentDTO> studentData;
    private Set<StudentDTO> students;
	private Iterator itr ;

    InMemoryStudentReader() {
        //initialize();
    }

    private void initialize() {
		
		studentData = new ArrayList<>();
		
		int rand = new Random().nextInt(10 - 5 + 1) + 5;
		for (int i=0; i< rand ; i++) {
			studentData.add(StudentDTO.builder().name("Tony").age(10).build());
			studentData.add(StudentDTO.builder().name("Nick").age(5).build());
			studentData.add(StudentDTO.builder().name("Ian").age(12).build());
			//studentData.add(StudentDTO.builder().name("Ram").age(10).build());
			//studentData.add(StudentDTO.builder().name("Sami").age(5).build());
		}

        studentData = studentData.stream()
			//.filter(s -> s.getAge() == 10)
			.sorted(Comparator.comparingInt(StudentDTO::getAge))
			.collect(Collectors.toList());

        nextStudentIndex = 0;
		
		students = new HashSet<StudentDTO>(studentData);
		itr = students.iterator();
		
    }

    @Override
    public StudentDTO read() throws Exception {
        StudentDTO nextStudent = null;

        if (nextStudentIndex < studentData.size()) {
            //nextStudent = studentData.get(nextStudentIndex);
            nextStudentIndex++;
        }
		if (itr.hasNext())
			nextStudent = (StudentDTO) itr.next();
			//System.out.println("\t --------" + itr.next().toString());
		
		return nextStudent;
    }

	@BeforeStep
	public void beforeStep() {
		initialize();
	}
	

}
