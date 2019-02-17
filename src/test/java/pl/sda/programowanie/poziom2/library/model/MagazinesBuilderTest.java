package pl.sda.programowanie.poziom2.library.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class MagazinesBuilderTest {

    //https://dzone.com/articles/7-popular-unit-test-naming

    @Test
    public void Should_BuildMagazine_When_DataIsDefined() {
        //given
        String title = "Programista";
        int number = 64;
        int pageCount = 100;

        //when
        Magazines magazine = new MagazinesBuilder()
                .setTitle(title)
                .setNumber(number)
                .setPageCount(pageCount)
                .build();

        //then
        assertNotNull(magazine);
        assertEquals(title, magazine.getTitle());
        assertEquals(pageCount, magazine.getPageCount());
        assertEquals(number, magazine.getNumer());
    }
}