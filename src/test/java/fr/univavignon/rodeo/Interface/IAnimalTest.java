package fr.univavignon.rodeo.Interface;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import fr.univavignon.rodeo.api.IAnimal;


public class IAnimalTest {
	
	@Mock
	private IAnimal animal;
	
	public static IAnimal getMock() {
		IAnimal animal = mock(IAnimal.class);
		when(animal.getXP()).thenReturn(0);
		when(animal.isSecret()).thenReturn(true);
		when(animal.isEndangered()).thenReturn(true);
		when(animal.isBoss()).thenReturn(true);
		return animal;
	}
	
	@Before
	public void init() {
		animal = getMock();
	}
	
	@Test
	public void testGetXp() {
		assertEquals(0, animal.getXP());
	}
	
	@Test
	public void testIsSecret() {
		assertTrue(animal.isSecret());
	}
	
	@Test
	public void testIsEndangered() {
		assertTrue(animal.isEndangered());
	}
	
	@Test
	public void testIsBoss() {
		assertTrue(animal.isBoss());
	}
}