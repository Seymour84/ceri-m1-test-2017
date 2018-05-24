package fr.univavignon.rodeo.Interface;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.api.SpecieLevel;

public class IGameStateTest {
	
	@Mock
	private static IAnimal animal;
	
	@Mock
	private static ISpecie specie;

	@Mock
	private IGameState gameState;
	
	private static SpecieLevel noviceLevel, mediumLevel, hardLevel, bestLevel;
	
	public static IGameState getMock() {
		IGameState gameState = mock(IGameState.class);
		when(gameState.getSpecieLevel(specie)).thenReturn(bestLevel);
		when(gameState.getProgression()).thenReturn(0);
		doThrow(IllegalStateException.class).when(gameState).exploreArea();
		doThrow(IllegalArgumentException.class).when(gameState).catchAnimal(null);
		doThrow(IllegalStateException.class).when(gameState).catchAnimal(animal);
		doThrow(IllegalArgumentException.class).when(gameState).getSpecieLevel(null);
		return gameState;
	}

	@Before
	public void init() {
		noviceLevel = SpecieLevel.NOVICE;
		mediumLevel = SpecieLevel.WRANGLER;
		hardLevel = SpecieLevel.CHAMPION;
		bestLevel = SpecieLevel.MASTER;

		animal = IAnimalTest.getMock();
		specie = ISpecieTest.getMock();
		gameState = getMock();		
	}
	
	@Test
	public void testGetSpecieLevel() {
		assertEquals(bestLevel, gameState.getSpecieLevel(specie));
		assertEquals(600, gameState.getSpecieLevel(specie).getRequiredXP());
	}
	
	@Test
	public void testGetSpecieNoviceLevel() {
		when(gameState.getSpecieLevel(specie)).thenReturn(noviceLevel);
		assertEquals(noviceLevel, gameState.getSpecieLevel(specie));
	}
	
	@Test
	public void testGetSpeciemediumLevel() {
		when(gameState.getSpecieLevel(specie)).thenReturn(mediumLevel);
		assertEquals(mediumLevel, gameState.getSpecieLevel(specie));
	}
	
	@Test
	public void testGetSpeciehardLevel() {
		when(gameState.getSpecieLevel(specie)).thenReturn(hardLevel);
		assertEquals(hardLevel, gameState.getSpecieLevel(specie));
	}
	
	@Test
	public void testGetSpeciebestLevel() {
		when(gameState.getSpecieLevel(specie)).thenReturn(bestLevel);
		assertEquals(bestLevel, gameState.getSpecieLevel(specie));
	}
	
	@Test
	public void testGetProgression() {
		assertEquals(0, gameState.getProgression());
	}

	@Test (expected=IllegalStateException.class)
	public void testExploreArea() {
		gameState.exploreArea();
	}
	
	@Test (expected=IllegalStateException.class)
	public void testCatchAnimalNotExist() {
		gameState.catchAnimal(animal);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testCatchAnimalIsNull() {
		gameState.catchAnimal(null);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testGetSpecieLevelIsNull() {
		gameState.getSpecieLevel(null);
	}
}