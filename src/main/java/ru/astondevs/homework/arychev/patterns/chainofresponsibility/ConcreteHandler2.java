package ru.astondevs.homework.arychev.patterns.chainofresponsibility;

public class ConcreteHandler2 extends RequestHandler {
    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType() == RequestType.TYPE2) {
            System.out.println("ConcreteHandler2 handles the request.");
        } else {
            super.handleRequest(request);
        }
    }
}