package org.example;

import com.github.javafaker.Faker;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var faker = new Faker();

        var clothing = Clothing.builder()
                .name(faker.commerce().productName())
                .price(Double.parseDouble(faker.commerce().price().replace(",", ".")))
                .description(faker.lorem().sentence())
                .build();

        OrderProcessor<Clothing> clothingOrder = new OrderProcessor<>(clothing);
        clothingOrder.process();
        clothingOrder.startProcessing();

        var clothingList = IntStream.range(0, 10).mapToObj(i -> Clothing.builder()
                        .name(faker.commerce().productName())
                        .price(Double.parseDouble(faker.commerce().price().replace(",", ".")))
                        .description(faker.lorem().sentence())
                        .build())
                .toList();

        clothingList.parallelStream()
                .map(OrderProcessor::new)
                .forEach(OrderProcessor::startProcessing);

        var electronics = new Electronics(
                faker.commerce().productName(),
                Double.parseDouble(faker.commerce().price().replace(",", ".")),
                faker.lorem().sentence()
        );

        OrderProcessor<Electronics> electronicsOrder = new OrderProcessor<>(electronics);
        electronicsOrder.process();
        electronicsOrder.startProcessing();

        var electronicsList = IntStream.range(0, 10).mapToObj(i -> new Electronics(
                        faker.commerce().productName(),
                        Double.parseDouble(faker.commerce().price().replace(",", ".")),
                        faker.lorem().sentence()
                ))
                .toList();

        electronicsList.parallelStream()
                .map(OrderProcessor::new)
                .forEach(OrderProcessor::startProcessing);
    }
}
