package Challenge23_Stream_sources;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class The_bingo_game {
    public static void main(String[] args) {

        Stream<String> streamB =
                IntStream.rangeClosed(1, 15)
                        .mapToObj(i -> "B" + i);

        Stream<String> streamI =
                IntStream.range(16, 31)
                        .mapToObj(i -> "I" + i);

        Stream<String> streamN =
                Stream.iterate(31, n -> n + 1)
                        .limit(15)
                        .map(n -> "N" + n);

        Stream<String> streamG =
                Stream.of(IntStream.rangeClosed(46, 60).toArray())
                        .flatMap(arr -> IntStream.of(arr).mapToObj(i -> "G" + i));

        Stream.Builder<String> builder = Stream.builder();
        for (int i = 61; i <= 75; i++) {
            builder.add("O" + i);
        }
        Stream<String> streamO = builder.build();

        Stream<String> allStreams =
                Stream.concat(
                        Stream.concat(
                                Stream.concat(streamB, streamI),
                                Stream.concat(streamN, streamG)
                        ),
                        streamO
                );

        allStreams.forEach(System.out::println);
    }
}