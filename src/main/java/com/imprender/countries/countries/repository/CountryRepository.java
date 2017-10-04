package com.imprender.countries.countries.repository;

import com.imprender.countries.countries.model.Country;
import com.imprender.countries.countries.model.SeveralMatchesException;
import javassist.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;

import static java.util.stream.Collectors.toList;

@Repository
public class CountryRepository {
    private List<Country> ALL_COUNTRIES = Arrays.asList(

            new Country(0, "Ecuador", 16.39, "Quito", Arrays.asList("Spanish"), "ecuador.png"),
            new Country(1, "France", 66.9, "Paris", Arrays.asList("French"), "france.png"),
            new Country(2, "India", 1324, "New Delhi", Arrays.asList("Hindi", "English"), "india.png"),
            new Country(3, "Italy", 60.6, "Rome", Arrays.asList("Italian"), "italy.png"),
            new Country(4, "Kenya", 48.46, "Nairobi", Arrays.asList("Swahili", "English"), "kenya.png")
    );

    public List<Country> getAllCountries() {
        return ALL_COUNTRIES;
    }

    //Todo: Just to learn about somethg else...(not sure if it is correct)
    //Todo: I leave it here because the instructions are asking for it, but I am not using it!
    public Country findById(int id) throws Exception {
        List<Country> countries = ALL_COUNTRIES.stream().
                filter(c -> c.getId() == id).collect(toList());
        if (countries.size() == 0) {
            throw new NotFoundException("Country was not found");
        }
        if (countries.size() != 1) {
            throw new SeveralMatchesException("Several countries found!");
        }

        return countries.get(0);
    }

    public void sortByName() {
        Comparator<Country> comparator = Comparator.comparing(Country::getName);
        ALL_COUNTRIES.sort(comparator);
    }

    public void sortByPopulation() {
        Comparator<Country> comparator = Collections.reverseOrder(Comparator.comparing(Country::getPopulation));
        ALL_COUNTRIES.sort(comparator);
    }

    public Country findByName(String name) throws NotFoundException, SeveralMatchesException {

        List<Country> countries = ALL_COUNTRIES.stream().
                filter(c -> c.getName().toLowerCase().equals(name.toLowerCase())).collect(toList());

        if (countries.size() == 0) {
            throw new NotFoundException("Country was not found");
        }
        if (countries.size() != 1) {
            throw new SeveralMatchesException("Several countries found!");
        }
        return countries.get(0);
    }

}
