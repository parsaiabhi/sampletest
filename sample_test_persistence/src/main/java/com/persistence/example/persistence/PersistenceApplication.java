package com.persistence.example.persistence;

import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class PersistenceApplication {


    @Autowired
    private  Dept1 department;

    private static Mnager mnager;

    @Autowired
    public PersistenceApplication(Mnager mnager) {
        PersistenceApplication.mnager = mnager;
    }

    @PostConstruct
    public  void init(){
        department.setName("Testing");
    }




    public static void main(String[] args) throws IOException {
        SpringApplication.run(PersistenceApplication.class, args);

        Mnager manager = new Mnager();

        System.out.println("see msg" +mnager.msg("Abhishek" ));


        var myList = new ArrayList<String>();
        System.out.println("hello".isBlank());

        myList.add("A");
        myList.add("B");
        myList.add("C");
        List<String> collect = myList.stream().collect(Collectors.toList());


        System.out.println("java".repeat(4));
        System.out.println("stripTrailing : " + " Foo Bar       ".stripTrailing());
        System.out.println("stripLeading : " + "        Foo Bar ".stripLeading());
        System.out.println("strip :" + " Foo Bar ".strip());


        Stream.iterate(0, i -> i + 1).takeWhile(i -> i <= 5).forEach(System.out::println);

        Stream.of("AAA", "BBB", "CCC").forEachOrdered(s -> System.out.println("output is: " + s));
/*        System.out.println("==============================");
        Stream.of("AAA","BBB","CCC").parallel().forEachOrdered(s -> System.out.println("output is :" +s));*/


        var myList2 = new ArrayList<String>();
        myList2.add("ram");
        myList2.add("abhishek");
        myList2.add("shivam");

        // convert List into Array   ----- old way
        String[] names = myList2.toArray(new String[myList2.size()]);

        // convert List into Array   ------ new way jdk 11 way

        String[] strings = myList2.toArray(String[]::new);

        var op = myList2.stream().filter(Predicate.not(String::isBlank)).collect(Collectors.toList());

        Stream<String> stream
                = Stream.of("aman", "amar", "suraj", "suvam", "Zahafuj");

/*        stream.filter(s -> s.charAt(0) == 'a').forEach(s -> System.out.println("char at 0: " +s));*/

        System.out.println("============================");
        stream.takeWhile(name -> (name.charAt(0) == 'a')).collect(Collectors.toList()).forEach(s -> System.out.println("char at 0: " +s));


        System.out.println("=============number is===============");
        Stream<Integer> stream2 = Stream.of(4, 4, 4, 5, 6, 7, 8, 9, 10);
        stream2.dropWhile(number -> (number / 4 == 1)).forEach(s -> System.out.println("number is: " +s));

        System.out.println("does string have digits: " +isStringOnlyletters("hello2"));


        List<String> ss = new ArrayList<>();
        ss.add("ram");
        ss.add("abhishek");
        ss.stream().map(d -> d.length()).forEach(a -> System.out.println("length is: " +a));

        System.out.println("=============length is ============");
        ss.stream().mapToInt(a -> a.length()).forEach(q -> System.out.println("length is : " +q));


        List<String> list = Arrays.asList("Geeks", "for", "gfg",
                "GeeksforGeeks", "GeeksQuiz");
        System.out.println("=============length is ============");
        list.stream().map(s -> s.length()).forEach(q -> System.out.println("length is : " +q));


            Stream.of("a1","a2","a3").map(s -> s.substring(1)).mapToInt(Integer::parseInt).max().ifPresent(System.out::println);

            Stream.of("a1","d2","f3").map(s -> s.toUpperCase()).anyMatch(a -> a.startsWith("a"));

        System.out.println("isBlank: " + "ram".isBlank());
        System.out.println("ram length is: " + "   ram".strip().length());





    }

    public static boolean isStringOnlyletters(String str){

        "wiw39393".matches("^[a-zA-Z]*$");
        return (
                (str != null) &&
                        (!str.equals("")) &&
                        (str.chars().allMatch(Character::isLetter)));
    }





}
