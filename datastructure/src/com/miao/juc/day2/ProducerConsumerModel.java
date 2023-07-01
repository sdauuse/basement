package com.miao.juc.day2;

import java.util.LinkedList;

/**
 * 异步模式之生产者/消费者
 *
 * @author miaoyin
 */
public class ProducerConsumerModel {

    public static void main(String[] args) {

    }
}

class Message {
    private int id;
    private Object message;

    public Message(int id, Object message) {
        this.id = id;
        this.message = message;
    }

    public Object getMessage() {
        return message;
    }
}

class MessageQueue {
    private LinkedList<Message> queue;
    private int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    //消费者
    public Message take() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                System.out.println("wait,没有货了");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message = queue.removeFirst();
            queue.notifyAll();
            return message;
        }
    }

    //生产者
    public void put(Message message) {
        synchronized (queue) {
            while (queue.size() == capacity) {
                System.out.println("库存已达上限, wait");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.addLast(message);
            queue.notifyAll();
        }
    }
}
