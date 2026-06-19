package ru.astondevs.homework.arychev.patterns.chainofresponsibility;

/**
 * Класс, представляющий запрос
 */
class Request {
    private final RequestType requestType;

    public Request(RequestType requestType) {
        this.requestType = requestType;
    }

    public RequestType getRequestType() {
        return requestType;
    }
}