package com.company.Adapter;

public class AdapterApp {
    public static void main(String[] args){
        new VectorAdapterFormRaster().drawLine();
        new VectorAdapterFormRaster2().drawSquare();
    }
}
//case 1: with inhiration

interface VectorGraphicsInterface{
    void drawLine();
    void drawSquare();
}

class RasterGraphics{
    void drawRasterLine(){
        System.out.println("Print line");
    }
    void drawRasterSquare(){
        System.out.println("Print square");
    }
}

class VectorAdapterFormRaster extends RasterGraphics implements VectorGraphicsInterface{
    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

//case 2: with composition
class VectorAdapterFormRaster2 implements VectorGraphicsInterface{
    private RasterGraphics rasterGraphics = new RasterGraphics();
    @Override
    public void drawLine() {
        rasterGraphics.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        rasterGraphics.drawRasterSquare();
    }
}