package com.satyamcompany.app.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.satyamcompany.app.dao.MenuDaoSpringJdbcImpl;
import com.satyamcompany.app.exceptions.ClassNotFoundException;
import com.satyamcompany.app.model.Menu;

@ExtendWith(MockitoExtension.class)
class MenuServiceImplTest {

	@Mock
	private MenuDaoSpringJdbcImpl menuDaoSpringJdbcImpl;

	@InjectMocks
	private MenuServiceImpl menuServiceImpl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Disabled
	@Test
	void testSetMenuDao() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllMenu() {
		List<Menu> menu = List.of(new Menu("Cup cakes", 49.00f, 4));
		when(menuDaoSpringJdbcImpl.getAllMenu()).thenReturn(menu);
		assertEquals(menuServiceImpl.getAllMenu().size(), 1);
	}

	@Test
	void testGetMenuByNameShouldReturnTheMenu() throws ClassNotFoundException {
		Optional<Menu> optional = Optional.of(new Menu("Cup cakes", 49.00f, 4));
		when(menuDaoSpringJdbcImpl.getMenuByName("Cup cakes")).thenReturn(optional);
		assertEquals(menuServiceImpl.getMenuByName("Cup cakes").getMenuName(), "Cup cakes");
	}

	@Test
	void testGetMenuByNameShouldThrowException() throws ClassNotFoundException {
		Optional<Menu> optional = Optional.of(new Menu("Kashmiri Alur Dum", 250.00f, 1));
		when(menuDaoSpringJdbcImpl.getMenuByName("Kashmiri Alur Dum")).thenReturn(optional);
		assertEquals(menuServiceImpl.getMenuByName("Kashmiri Alur Dum").getMenuName(), "Kashmiri Alur Dum");
	}

	@Test
	void testCreateMenu_SHOULD_SUCCESS() {
		Menu menu = new Menu("Cup cakes", 49.00f, 4);
		when(menuDaoSpringJdbcImpl.createMenu(menu)).thenReturn(true);
		assertTrue(menuServiceImpl.createMenu(menu));
	}

}
