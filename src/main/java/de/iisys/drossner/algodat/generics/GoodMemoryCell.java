package de.iisys.drossner.algodat.generics;

public class GoodMemoryCell<T> {
    
    private T mem;

    public T getMem() {
        return mem;
    }

    public void setMem(T mem) {
        this.mem = mem;
    }

    public static void main(String[] args) {
        GoodMemoryCell<String> cell = new GoodMemoryCell<>();
        
        cell.setMem("hans");
        
        String test = cell.getMem();
        System.out.println("test = " + test);
    }
}
