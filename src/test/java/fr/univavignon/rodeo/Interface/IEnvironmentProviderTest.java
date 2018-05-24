package fr.univavignon.rodeo.Interface;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.IEnvironmentProvider;

public class IEnvironmentProviderTest {

	@Mock
	public IEnvironmentProvider environmentProvider;
	
	@Mock
	public static IEnvironment environment;
	
	public static List<String> environments = Arrays.asList("Savane","Jungle","Montagne","Jurassic");
	
	public static IEnvironmentProvider getMock() {
		IEnvironmentProvider environmentProvider = mock(IEnvironmentProvider.class);
		environment = IEnvironmentTest.getMock();
		when(environmentProvider.getEnvironment("Jungle")).thenReturn(environment);
		doThrow(IllegalArgumentException.class).when(environmentProvider).getEnvironment(null);
		when(environmentProvider.getAvailableEnvironments()).thenReturn(environments);
		return environmentProvider;
	}
	
	@Before
	public void init() {
		environmentProvider = getMock();
	}
	
	@Test
	public void testGetEnvironment() {
		assertEquals(environment, environmentProvider.getEnvironment("Jungle"));
	}
	
	@Test
	public void testGetAvailableEnvironments() {
		assertEquals(environments, environmentProvider.getAvailableEnvironments());
	}

	@Test (expected=IllegalArgumentException.class)
	public void testGetEnvironmentIsNull() {
		environmentProvider.getEnvironment(null);
	}
}