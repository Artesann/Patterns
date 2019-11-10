package com.company.Visitor;

public class VisitorApp {
    public static void main(String[] args){
        Visitor goodVisitor = new GoodVisitor();
        Visitor badVisitor = new BadVisitor();

        Element engineElem = new EngineElement();
        Element bodyElem = new BodyElement();

        goodVisitor.visit((EngineElement) engineElem);
        goodVisitor.visit((BodyElement) bodyElem);
        badVisitor.visit((EngineElement) engineElem);
        badVisitor.visit((BodyElement) bodyElem);

        System.out.println();

        engineElem.accept(goodVisitor);
        bodyElem.accept(badVisitor);
    }
}

interface Visitor{
    void visit(EngineElement engine);
    void visit(BodyElement body);
}

class BadVisitor implements Visitor{
    @Override
    public void visit(EngineElement engine) {
        System.out.println("Broke engine");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Slap car");
    }
}

class GoodVisitor implements Visitor{
    @Override
    public void visit(EngineElement engine) {
        System.out.println("Turn on engine");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Didn't slap car");
    }
}

interface Element{
    void accept(Visitor visitor);
}

class BodyElement implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class EngineElement implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}