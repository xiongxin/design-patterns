package com.xiongxin.chain;

public class PipelineDemo {

    public HandlerChainContext head = new HandlerChainContext(new AbstractHandler() {
        @Override
        void doHandler(HandlerChainContext handlerChainContext, Object arg0) {
            handlerChainContext.runNext(arg0);
        }
    });

    public void requestProcess(Object arg0) {
        this.head.handler(arg0);
    }

    public void addLast(AbstractHandler handler) {
        var context = head;
        while (context.next != null) {
            context = context.next;
        }

        context.next = new HandlerChainContext(handler);
    }

    public static void main(String[] args) {
        var pipeline = new PipelineDemo();

        pipeline.addLast(new Handler1());
        pipeline.addLast(new Handler2());
        pipeline.addLast(new Handler3());
        pipeline.addLast(new Handler2());

        pipeline.requestProcess("abc");
    }
}


// handler上下文，主要负责责任链和链的执行
class HandlerChainContext {
    HandlerChainContext next;
    AbstractHandler handler;

    public HandlerChainContext(AbstractHandler handler) {
        this.handler = handler;
    }

    void handler(Object arg0) {
        this.handler.doHandler(this, arg0);
    }

    void runNext(Object arg0) {
        if (this.next != null) {
            this.next.handler(arg0);
        }
    }
}

// 处理器抽象类
abstract class AbstractHandler {

    abstract void doHandler(HandlerChainContext handlerChainContext, Object arg0);
}


class Handler1 extends AbstractHandler {
    @Override
    void doHandler(HandlerChainContext handlerChainContext, Object arg0) {
        arg0 = arg0.toString() + "...handler1的小尾巴....";
        System.out.println("我是handler1的实力，我在处理: " + arg0);

        handlerChainContext.runNext(arg0);
    }
}

class Handler2 extends AbstractHandler {
    @Override
    void doHandler(HandlerChainContext handlerChainContext, Object arg0) {
        arg0 = arg0.toString() + "...handler2的小尾巴....";
        System.out.println("我是handler2的实力，我在处理: " + arg0);

        handlerChainContext.runNext(arg0);
    }
}

class Handler3 extends AbstractHandler {
    @Override
    void doHandler(HandlerChainContext handlerChainContext, Object arg0) {
        arg0 = arg0.toString() + "...handler3的小尾巴....";
        System.out.println("我是handler3的实力，我在处理: " + arg0);

        handlerChainContext.runNext(arg0);
    }
}