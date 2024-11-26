package ru.netology.manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;


public class PosterManagerTest {

    PosterManager manager = new PosterManager();

    PosterItem item1 = new PosterItem("Защитник");
    PosterItem item2 = new PosterItem("Мой личный штат Айдахо");
    PosterItem item3 = new PosterItem("Настоящий детектив");
    PosterItem item4 = new PosterItem("Побег из Шоушенка");
    PosterItem item5 = new PosterItem("Молчание ягнят");
    PosterItem item6 = new PosterItem("Зеленая миля");
    PosterItem item7 = new PosterItem("Большой куш");
    PosterItem item8 = new PosterItem("Реквием по мечте");

    @Test
    public void shouldAddNewFilm() {

        manager.addFilm(item1);

        PosterItem[] expected = {item1};
        PosterItem[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllFilms() {

        manager.addFilm(item1);
        manager.addFilm(item2);
        manager.addFilm(item3);
        manager.addFilm(item4);
        manager.addFilm(item5);
        manager.addFilm(item6);
        manager.addFilm(item7);
        manager.addFilm(item8);

        PosterItem[] expected = {item1, item2, item3, item4, item5, item6, item7, item8};
        PosterItem[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

// тесты при лимите по умолчанию 5 фильмов
@Test
public void shouldFindLastDefaultLimitLengthZero() {

    PosterItem[] expected = {};
    PosterItem[] actual = manager.findLast();

    Assertions.assertArrayEquals(expected, actual);
}

@Test
public void shouldFindLastDefaultLimitLengthLimit() {

    manager.addFilm(item1);
    manager.addFilm(item2);
    manager.addFilm(item3);
    manager.addFilm(item4);
    manager.addFilm(item5);

    PosterItem[] expected = {item5, item4, item3, item2, item1};
    PosterItem[] actual = manager.findLast();

    Assertions.assertArrayEquals(expected, actual);
}
    @Test
    public void shouldFindLastDefaultLimitLengthBeforeLimit() {

        manager.addFilm(item1);
        manager.addFilm(item2);
        manager.addFilm(item3);
        manager.addFilm(item4);

        PosterItem[] expected = {item4, item3, item2, item1};
        PosterItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastDefaultLimitLengthAfterLimit() {

        manager.addFilm(item1);
        manager.addFilm(item2);
        manager.addFilm(item3);
        manager.addFilm(item4);
        manager.addFilm(item5);
        manager.addFilm(item6);

        PosterItem[] expected = {item6, item5, item4, item3, item2};
        PosterItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    // тесты при задании лимита и постоянной длине массива

    @Test
    public void shouldFindLastLimitZeroLengthConst() {

        manager.addFilm(item1);
        manager.addFilm(item2);
        manager.addFilm(item3);
        manager.addFilm(item4);
        manager.addFilm(item5);
        manager.addFilm(item6);
        manager.addFilm(item7);
        manager.addFilm(item8);

        PosterItem[] expected = {};
        PosterItem[] actual = manager.findLast(0);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastLimitEqualLengthConst() {

        manager.addFilm(item1);
        manager.addFilm(item2);
        manager.addFilm(item3);
        manager.addFilm(item4);
        manager.addFilm(item5);
        manager.addFilm(item6);
        manager.addFilm(item7);
        manager.addFilm(item8);

        PosterItem[] expected = {item8, item7, item6, item5, item4, item3, item2, item1};
        PosterItem[] actual = manager.findLast(8);

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindLastLimitAfterLengthConst() {

        manager.addFilm(item1);
        manager.addFilm(item2);
        manager.addFilm(item3);
        manager.addFilm(item4);
        manager.addFilm(item5);
        manager.addFilm(item6);
        manager.addFilm(item7);
        manager.addFilm(item8);

        PosterItem[] expected = {item8, item7, item6, item5, item4, item3, item2, item1};
        PosterItem[] actual = manager.findLast(9);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastLimitBeforeLengthConst() {

        manager.addFilm(item1);
        manager.addFilm(item2);
        manager.addFilm(item3);
        manager.addFilm(item4);
        manager.addFilm(item5);
        manager.addFilm(item6);
        manager.addFilm(item7);
        manager.addFilm(item8);

        PosterItem[] expected = {item8, item7, item6, item5, item4, item3, item2};
        PosterItem[] actual = manager.findLast(7);

        Assertions.assertArrayEquals(expected, actual);
    }

}
