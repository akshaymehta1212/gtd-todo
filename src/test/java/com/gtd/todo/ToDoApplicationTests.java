package com.gtd.todo;

import com.gtd.todo.repository.ToDoItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ToDoItemRepository.class})
class ToDoApplicationTests {

	@Test
	void contextLoads() {
	}

}
