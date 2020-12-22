package com.tuling.designpattern.responsibilitychain;

public class ResponsibilityChain {

    public static void main(String[] args) {
        Request request = new Request.RequestBuilder().frequentOk(true).loggedOn(true).build();
        RequestFrequentHandler requestFrequentHandler = new RequestFrequentHandler(new LogInHandler(null));
        if (requestFrequentHandler.process(request)) {
            System.out.println("正常访问");
        } else {
            System.out.println("访问异常");
        }
    }
}

class Request {

    private boolean loggedOn;
    private boolean frequentOk;
    private boolean isPermitted;
    private boolean containsSensitiveWords;
    private String requestBody;

    public Request(boolean loggedOn, boolean frequentOk, boolean isPermitted, boolean containsSensitiveWords) {
        this.loggedOn = loggedOn;
        this.frequentOk = frequentOk;
        this.isPermitted = isPermitted;
        this.containsSensitiveWords = containsSensitiveWords;
    }

    static class RequestBuilder {

        private boolean loggedOn;
        private boolean frequentOk;
        private boolean isPermitted;
        private boolean containsSensitiveWords;

        RequestBuilder loggedOn(boolean loggedOn) {
            this.loggedOn = loggedOn;
            return this;
        }

        RequestBuilder frequentOk(boolean frequentOk) {
            this.frequentOk = frequentOk;
            return this;
        }

        RequestBuilder permitted(boolean permitted) {
            isPermitted = permitted;
            return this;
        }

        RequestBuilder containsSensitiveWords(boolean containsSensitiveWords) {
            this.containsSensitiveWords = containsSensitiveWords;
            return this;
        }

        public Request build() {
            Request request = new Request(loggedOn, frequentOk, isPermitted, containsSensitiveWords);
            return request;

        }
    }


    public boolean isLoggedOn() {
        return loggedOn;
    }

    public boolean isFrequentOk() {
        return frequentOk;
    }

    public boolean isPermitted() {
        return isPermitted;
    }

    public boolean isContainsSensitiveWords() {
        return containsSensitiveWords;
    }
}

abstract class Handler {

    Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    abstract boolean process(Request request);
}

class RequestFrequentHandler extends Handler {

    public RequestFrequentHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {

        System.out.println("访问频率控制");
        if(request.isFrequentOk()) {
            Handler next = getNext();
            if(null==next) {
                return true;
            }
            if(!next.process(request)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}

class LogInHandler extends Handler {

    public LogInHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {

        System.out.println("登录验证");
        if (request.isLoggedOn()) {
            Handler next = getNext();
            if (null==next) {
                return true;
            }
            if (!next.process(request)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}