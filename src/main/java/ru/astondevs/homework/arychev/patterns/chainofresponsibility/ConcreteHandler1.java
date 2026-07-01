package ru.astondevs.homework.arychev.patterns.chainofresponsibility;

class ConcreteHandler1 extends RequestHandler {
    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType() == RequestType.TYPE1) {
            System.out.println("ConcreteHandler1 handles the request.");
        } else {
            super.handleRequest(request);
        }
    }
}