package ru.astondevs.homework.arychev.patterns.chainofresponsibility;

class ConcreteHandler3 extends RequestHandler {
    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType() == RequestType.TYPE3) {
            System.out.println("ConcreteHandler3 handles the request.");
        } else {
            super.handleRequest(request);
        }
    }
}