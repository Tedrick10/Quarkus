package quarkus.graphql;

import org.eclipse.microprofile.graphql.*;

import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class FilmResource {
    @Inject
    GalaxyService galaxyService;

    @Query
    @Description("Get all films from a galaxy far far away")
    public List<Film> getAllFilms() {
        return this.galaxyService.getAllFilms();
    }

    @Query
    @Description("Get a film from a galaxy far far away")
    public Film getAFilmByIndex(@Name("filmId") int index) {
        return this.galaxyService.getFilm(index);
    }

    @Query
    @Description("Get all heroes from a galaxy")
    public List<Hero> getAllHeroes() {
        return this.galaxyService.getAllHeroes();
    }

    @Query
    @Description("Get a hero from a galaxy")
    public Hero getAHeroByIndex(@Name("heroId") int index) {
        return this.galaxyService.getHero(index);
    }

    @Mutation
    public Boolean addNewHero(Hero hero) {
        return this.galaxyService.addNewHero(hero);
    }

    @Mutation
    public Hero deleteHero(int index) {
        return this.galaxyService.deleteHero(index);
    }
}
