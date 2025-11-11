package org.example.java_practice_room.javaGuide.code;

public class Agency {

    public static interface SmsService {
        void send(String message);
    }

    public static class SmsServiceImpl implements SmsService {
        @Override
        public void send(String message) {
            System.out.println("模拟发送短信：" + message);
        }
    }

    public static class smsProxy implements SmsService {
        private final SmsService smsService;

        public smsProxy(SmsService smsService) {
            this.smsService = smsService;
        }

        @Override
        public void send(String message) {
            System.out.println("代理开始");
            smsService.send(message);
            System.out.println("代理结束");
        }
    }

    public static void main(String[] args) {
        System.out.println("\033[1m代理模式\033[0m");
        System.out.println("代理分为静态代理和动态代理，静态代理常见于jvm中");
        SmsServiceImpl smsServiceImpl = new SmsServiceImpl();
        smsProxy smsProxy  = new smsProxy(smsServiceImpl);
        smsProxy.send("发送中...");
    }
}
