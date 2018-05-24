package fr.univavignon.rodeo.api;

import java.util.List;

public class Environment implements IEnvironment {

	private String name;
	private int areaNumber;
	private List<ISpecie> species;
	
	public Environment(String name, int areaNumber, List<ISpecie> species) {
		this.name = name;
		this.areaNumber = areaNumber;
		this.species = species;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getAreas() {
		return areaNumber;
	}

	@Override
	public List<ISpecie> getSpecies() {
		return species;
	}

	@Override
	public boolean equals(Object e) {
		Environment environment = (Environment) e;
		List<ISpecie> speciesObject = environment.getSpecies();
		if (name.equals(environment.getName()) && areaNumber == environment.getAreas() && species.size() == speciesObject.size()) {
			for (int i=0; i < species.size(); i++) {
				if (!((Specie)species.get(i)).equals(speciesObject.get(i)))
					return false;
			}
		}
		else {
			return false;
		}
		
		return true;
	}
}