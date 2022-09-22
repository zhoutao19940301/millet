//package com.zmm.milletucapi.utils;
//
//import java.util.Random;
//
//public class Tank implements Movable {
//​
//    /**
//     * 模拟坦克移动了一段时间
//     */
//    @Override
//    public void move() {
//        System.out.println("Tank moving claclacla...");
//        try {
//            Thread.sleep(new Random().nextInt(10000));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//​
//    public static void main(String[] args) {
//        new TankLogProxy(
//                new TankTimeProxy(
//                        new Tank()
//                )
//        ).move();
//    }
//}
//​
//class TankTimeProxy implements Movable {
//​
//    private Movable movable;
//​
//    TankTimeProxy(Movable movable) {
//        this.movable = movable;
//    }
//​
//    @Override
//    public void move() {
//        long start = System.currentTimeMillis();
//        movable.move();
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
//    }
//}
//​
//class TankLogProxy implements Movable {
//​
//    private Movable movable;
//​
//    TankLogProxy(Movable movable) {
//        this.movable = movable;
//    }
//​
//    @Override
//    public void move() {
//        System.out.println("tank start");
//        movable.move();
//        System.out.println("tank stop");
//    }
//}
//​
//interface Movable {
//    void move();
//}