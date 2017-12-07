package string;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * <p>Description : leetcodeJava
 * <p>Date : 2017/10/26 22:32
 * <p>@author : Matrix [xhyrzldf@foxmail.com]
 */
public class lambdaTest {

    public static List<String> getArtistNamesAndNations(List<Artist> artists) {
        return artists.stream()
                .flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
                .collect(toList());
    }

    public static void main(String[] args) {
        BigDecimal number = new BigDecimal(0);


        List<Artist> artists = Arrays.asList(
                new Artist("jack", "china"),
                new Artist("mike", "London")
        );

        System.out.println(getArtistNamesAndNations(artists).size());
    }
}
