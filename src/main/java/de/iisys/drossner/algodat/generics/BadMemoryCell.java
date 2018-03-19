package de.iisys.drossner.algodat.generics;

public class BadMemoryCell {

    private Object mem;

    public Object getMem() {
        return mem;
    }

    public void setMem(Object mem) {
        this.mem = mem;
    }

    public static void main(String[] args) {
        BadMemoryCell memoryCell = new BadMemoryCell();

        //things..
        String name = "Hans";
        memoryCell.setMem(name);
        name = null;
        //error without prior cast!!
        String newname = (String) memoryCell.getMem();
    }
}
