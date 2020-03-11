package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.demo.domain.History;
import com.example.demo.domain.HistoryRepository;
import com.example.demo.provider.Form;
import com.example.demo.service.DemoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/*
* In this case, the better option is to mock the "RangeAddends" class and test it separately.
*/

@ExtendWith(MockitoExtension.class)
class DemoApplicationTests {

	@InjectMocks
	DemoService demoService;

	@Mock
	HistoryRepository historyRepository;

	@Test
	void calculateSubsets_nullHistory() {
		when(historyRepository.findFirstByTotalAndList("10", "1,2,3,4,5")).thenReturn(null);
		when(historyRepository.save(any(History.class))).thenReturn(new History());

		Form form = new Form();
		form.setTotal("10");
		form.setList("1,2,3,4,5");

		String result = demoService.calculateSubsetsFromForm(form);
		assertEquals("[1,2,3,4] [1,4,5] [2,3,5]", result);
	}

	@Test
	void calculateSubsets_withHistory() {
		History history = new History();
		history.setTotal("10");
		history.setList("1,2,3,4,5");
		history.setResult("[1,2,3,4] [1,4,5] [2,3,5]");
		when(historyRepository.findFirstByTotalAndList("10", "1,2,3,4,5")).thenReturn(history);

		Form form = new Form();
		form.setTotal("10");
		form.setList("1,2,3,4,5");

		String result = demoService.calculateSubsetsFromForm(form);
		assertEquals("[1,2,3,4] [1,4,5] [2,3,5]", result);
	}
}
