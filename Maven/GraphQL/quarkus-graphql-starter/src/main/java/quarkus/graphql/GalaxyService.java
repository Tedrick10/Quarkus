package quarkus.graphql;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class GalaxyService {
    private List<Hero> heroes = new ArrayList<Hero>();
    private List<Film> films = new ArrayList<Film>();

    public GalaxyService() {
        Film aNewHope = new Film(
                "A New Hope",
                4,
                "George Lucas",
                LocalDate.of(1977, Month.MAY, 25)
                );
        Film theEmpiresStrikeBack = new Film(
                "The Emipres Strike Back",
                5,
                "George Lucas",
                LocalDate.of(1980, Month.MAY, 21)
        );
        Film returnOfTheJedi = new Film(
                "Return Of The Jedi",
                6,
                "George Lucas",
                LocalDate.of(1983, Month.MAY, 25)
        );

        this.films.add(aNewHope);
        this.films.add(theEmpiresStrikeBack);
        this.films.add(returnOfTheJedi);

        Hero luke = new Hero(
                "Luke",
                "Skywalker",
                1.7,
                73,
                false,
                LightSaber.GREEN,
                Arrays.asList(4, 5, 6)
        );
        Hero leia = new Hero(
                "Leia",
                "Organa",
                1.5,
                51,
                false,
                LightSaber.BLUE,
                Arrays.asList(4, 5, 6)
        );
        Hero vader = new Hero(
                "Darth",
                "Vader",
                1.9,
                89,
                true,
                LightSaber.RED,
                Arrays.asList(4, 5, 6)
        );

        this.heroes.add(luke);
        this.heroes.add(leia);
        this.heroes.add(vader);
    }

    public List<Film> getAllFilms() {
       return this.films;
    }

    public Film getFilm(int index) {
        return this.films.get(index);
    }

    public List<Hero> getAllHeroes() {
        return this.heroes;
    }

    public Hero getHero(int index) {
        return this.heroes.get(index);
    }

    public Boolean addNewHero(Hero hero) {
        return this.heroes.add(hero);
    }

    public Hero deleteHero(int id) {
        return this.heroes.remove(id);
    }
}
