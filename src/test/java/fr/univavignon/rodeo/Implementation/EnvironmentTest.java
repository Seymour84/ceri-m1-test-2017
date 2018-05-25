package fr.univavignon.rodeo.Implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import fr.univavignon.rodeo.api.Animal;
import fr.univavignon.rodeo.api.Environment;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.api.Specie;
import fr.univavignon.rodeo.Interface.IEnvironmentTest;

public class EnvironmentTest extends IEnvironmentTest {
	
	private Environment environment, environmentTest;
	private List<ISpecie> species, speciesTest;
	
	@Before
	public void init() {
		species = Arrays.asList(
					new Specie("Buffles", 1, Arrays.asList(
						new Animal("Forest Buffalo", 1, false, false, false), 	
						new Animal("Diabuffalo", 3, true, false, false), 		
						new Animal("Buff the Magic Dragon", 30, false, true, false)
					)),
					new Specie("Zebres", 1, Arrays.asList(
						new Animal("Zebra", 0, false, false, false),			
						new Animal("Trojan Zebra", 25, true, false, false),		
						new Animal("Zegasus", 30, false, true, false)			
					)),
					new Specie("Elephants", 1, Arrays.asList(
						new Animal("African Elephant", 0, false, false, false), 
						new Animal("Skelephant", 30, false, false, true) 		
					)),
					new Specie("Autruches", 2, Arrays.asList(
						new Animal("Ostrich", 0, false, false, false),			
						new Animal("Bosstrich", 30, false, false, true)			
					)),
					new Specie("Girafes", 3, Arrays.asList(
						new Animal("Giraffe", 0, false, false, false),			
						new Animal("UFG", 30, false, false, true)				
					)),
					new Specie("Vautours", 4, Arrays.asList(
						new Animal("Egyptian Vulture", 1, false, false, false), 
						new Animal("Vulture-on", 5, true, false, false), 		
						new Animal("Volture", 30, false, true, false) 			
					)),
					new Specie("Lions", 5, Arrays.asList(
						new Animal("Dande Lion", 1, false, false, false), 		
						new Animal("Le'Ion Chef", 5, true, false, false), 		
						new Animal("Nian Monster ", 30, false, true, false) 	
					))
				);
		environment = new Environment("Savane", 1, species);
	}
	
	@Test
	public void testGetAreas() {
		assertEquals(1, environment.getAreas());
	}
	
	@Test
	public void testGetSpecies() {
		assertEquals(species, environment.getSpecies());
	}
	
	@Test
	public void testEquals() {
		speciesTest = Arrays.asList(
				new Specie("Buffles", 1, Arrays.asList(
					new Animal("Forest Buffalo", 1, false, false, false), 		
					new Animal("Diabuffalo", 3, true, false, false), 			
					new Animal("Buff the Magic Dragon", 30, false, true, false) 
				)),
				new Specie("Zebres", 1, Arrays.asList(
					new Animal("Zebra", 0, false, false, false),				
					new Animal("Trojan Zebra", 25, true, false, false),			
					new Animal("Zegasus", 30, false, true, false)				
				)),
				new Specie("Elephants", 1, Arrays.asList(
					new Animal("African Elephant", 0, false, false, false), 	
					new Animal("Skelephant", 30, false, false, true) 			
				)),
				new Specie("Autruches", 2, Arrays.asList(
					new Animal("Ostrich", 0, false, false, false),				
					new Animal("Bosstrich", 30, false, false, true)				
				)),
				new Specie("Girafes", 3, Arrays.asList(
					new Animal("Giraffe", 0, false, false, false),				
					new Animal("UFG", 30, false, false, true)					
				)),
				new Specie("Vautours", 4, Arrays.asList(
					new Animal("Egyptian Vulture", 1, false, false, false), 	
					new Animal("Vulture-on", 5, true, false, false), 			
					new Animal("Volture", 30, false, true, false) 				
				)),
				new Specie("Lions", 5, Arrays.asList(
					new Animal("Dande Lion", 1, false, false, false), 			
					new Animal("Le'Ion Chef", 5, true, false, false), 			
					new Animal("Nian Monster ", 30, false, true, false) 		
				))
			);
		environmentTest = new Environment("Savane", 1, speciesTest);
		assertEquals(environment, environmentTest);
	}
	
	@Test
	public void testNotEquals() {
		speciesTest = Arrays.asList(
				new Specie("Buffles", 1, Arrays.asList(
					new Animal("Forest Buffalo", 1, false, false, false), 		
					new Animal("Diabuffalo", 3, true, false, false), 			
					new Animal("Buff the Magic Dragon", 30, false, true, false) 
				)),
				new Specie("Zebres", 1, Arrays.asList(
					new Animal("Zebra", 0, false, false, false),				
					new Animal("Trojan Zebra", 25, true, false, false),			
					new Animal("Zegasus", 30, false, true, false)				
				)),
				new Specie("Elephants", 1, Arrays.asList(
					new Animal("African Elephant", 0, false, false, false), 	
					new Animal("Skelephant", 30, false, false, true) 			
				)),
				new Specie("Autruches", 2, Arrays.asList(
					new Animal("Ostrich", 0, false, false, false),				
					new Animal("Bosstrich", 30, false, false, true)				
				)),
				new Specie("Girafes", 3, Arrays.asList(
					new Animal("Giraffe", 0, false, false, false),				
					new Animal("UFG", 30, false, false, true)					
				)),
				new Specie("Vautours", 4, Arrays.asList(
					new Animal("Egyptian Vulture", 1, false, false, false), 	
					new Animal("Vulture-on", 5, true, false, false), 			
					new Animal("Volture", 30, false, true, false) 				
				)),
				new Specie("Lions", 5, Arrays.asList(
					new Animal("Dande Lion", 1, false, false, false), 			
					new Animal("Le'Ion Chef", 5, true, false, false), 			
					new Animal("Nian Monster ", 30, false, true, false) 		
				))
			);
		environmentTest = new Environment("test", 1, speciesTest);
		assertNotEquals(environment, environmentTest);
	}
	
	@Test
	public void testNotEquals2() {
		speciesTest = Arrays.asList(
				new Specie("Buffles", 1, Arrays.asList(
					new Animal("Forest Buffalo", 1, false, false, false), 		
					new Animal("Diabuffalo", 3, true, false, false), 			
					new Animal("Buff the Magic Dragon", 30, false, true, false) 
				)),
				new Specie("Zebres", 1, Arrays.asList(
					new Animal("Zebra", 0, false, false, false),				
					new Animal("Trojan Zebra", 25, true, false, false),			
					new Animal("Zegasus", 30, false, true, false)				
				)),
				new Specie("Elephants", 1, Arrays.asList(
					new Animal("African Elephant", 0, false, false, false), 	
					new Animal("Skelephant", 30, false, false, true) 			
				)),
				new Specie("Autruches", 2, Arrays.asList(
					new Animal("Ostrich", 0, false, false, false),				
					new Animal("Bosstrich", 30, false, false, true)				
				)),
				new Specie("Girafes", 3, Arrays.asList(
					new Animal("Giraffe", 0, false, false, false),				
					new Animal("UFG", 30, false, false, true)					
				)),
				new Specie("Vautours", 4, Arrays.asList(
					new Animal("Egyptian Vulture", 1, false, false, false), 	
					new Animal("Vulture-on", 5, true, false, false), 			
					new Animal("Volture", 30, false, true, false) 				
				)),
				new Specie("Lions", 5, Arrays.asList(
					new Animal("Dande Lion", 1, false, false, false), 			
					new Animal("Le'Ion Chef", 5, true, false, false), 			
					new Animal("Nian Monster ", 30, false, true, false) 		
				))
			);
		environmentTest = new Environment("Savane", 84140, speciesTest);
		assertNotEquals(environment, environmentTest);
	}
	
	@Test
	public void testNotEquals3() {
		speciesTest = Arrays.asList(
				new Specie("Vautours", 4, Arrays.asList(
					new Animal("Egyptian Vulture", 1, false, false, false), 	
					new Animal("Vulture-on", 5, true, false, false), 			
					new Animal("Volture", 30, false, true, false) 				
				))
			);
		environmentTest = new Environment("Savane", 1, speciesTest);
		assertNotEquals(environment, environmentTest);
	}
	
	@Test
	public void testNotEquals4() {
		speciesTest = Arrays.asList(
				new Specie("test", 1, Arrays.asList(
					new Animal("Forest Buffalo", 1, false, false, false), 		
					new Animal("Diabuffalo", 3, true, false, false), 			
					new Animal("Buff the Magic Dragon", 30, false, true, false) 
				)),
				new Specie("Zebres", 1, Arrays.asList(
					new Animal("Zebra", 0, false, false, false),				
					new Animal("Trojan Zebra", 25, true, false, false),			
					new Animal("Zegasus", 30, false, true, false)				
				)),
				new Specie("Elephants", 1, Arrays.asList(
					new Animal("African Elephant", 0, false, false, false), 	
					new Animal("Skelephant", 30, false, false, true) 			
				)),
				new Specie("Autruches", 2, Arrays.asList(
					new Animal("Ostrich", 0, false, false, false),				
					new Animal("Bosstrich", 30, false, false, true)				
				)),
				new Specie("Girafes", 3, Arrays.asList(
					new Animal("Giraffe", 0, false, false, false),				
					new Animal("UFG", 30, false, false, true)					
				)),
				new Specie("Vautours", 4, Arrays.asList(
					new Animal("Egyptian Vulture", 1, false, false, false), 	
					new Animal("Vulture-on", 5, true, false, false), 			
					new Animal("Volture", 30, false, true, false) 				
				)),
				new Specie("Lions", 5, Arrays.asList(
					new Animal("Dande Lion", 1, false, false, false), 			
					new Animal("Le'Ion Chef", 5, true, false, false), 			
					new Animal("Nian Monster ", 30, false, true, false) 		
				))
			);
		environmentTest = new Environment("Savane", 1, speciesTest);
		assertNotEquals(environment, environmentTest);
	}
}