package classes;

import java.util.*;

public class Operator {

    public void task1 (){

        Thread timeCount = new Thread(() -> {
            int time = 1;
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Time passed: " + time++);
            }
        });

        Thread fiveSeconds = new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Passed 5 seconds" );
            }
        });
        timeCount.start();
        fiveSeconds.start();
    }


    public void task2(int n) throws InterruptedException {
        List<String> numbers = new ArrayList<>();
        List<String> numbersA = new ArrayList<>();
        List<String> numbersB = new ArrayList<>();
        List<String> numbersC = new ArrayList<>();

        for (int i = 1;  i < n; i++){
            numbers.add(String.valueOf(i));
            numbersA.add(String.valueOf(i));
            numbersB.add(String.valueOf(i));
            numbersC.add(String.valueOf(i));
        }

        Thread a = new Thread(() -> fizz(numbersA));
        Thread b = new Thread(() -> buzz(numbersB));

        Thread c = new Thread(() -> fizzbuzz(numbersC));

        Thread d = new Thread(() -> number(numbers, numbersA, numbersB, numbersC));

        a.start();
        b.start();
        c.start();
        a.join();
        b.join();
        c.join();
        d.start();
    }

    private void  fizz(List<String> numbers) {
        for(int i = 0; i < numbers.size(); i++){
            if(Integer.parseInt(numbers.get(i)) % 3 == 0 ){
                numbers.set(i, "fizz");
            }
        }
    }

    private void  buzz(List<String> numbers) {
        for(int i = 0; i < numbers.size(); i++){
            if(Integer.parseInt(numbers.get(i)) % 5 == 0 ){
                numbers.set(i, "buzz");
            }
        }
    }

    private void  fizzbuzz(List<String> numbers)  {
        for(int i = 0; i < numbers.size(); i++){
            if(Integer.parseInt(numbers.get(i)) % 3 == 0 && Integer.parseInt(numbers.get(i)) % 5 == 0){
                numbers.set(i, "fizzbuzz");
            }
        }
    }

    private void number(List<String> numbers, List<String> numbersA, List<String> numbersB, List<String> numbersC) {
        for(int i = 0; i < numbers.size(); i++){
            if(numbersA.get(i).equals("fizz")) {
                numbers.set(i, numbersA.get(i));
            }
            if(numbersB.get(i).equals("buzz")) {
                numbers.set(i, numbersB.get(i));
            }
            if(numbersC.get(i).equals("fizzbuzz")) {
                numbers.set(i, numbersC.get(i));
            }
        }
        for (String number : numbers) {
            System.out.println(number);
        }
    }
}
