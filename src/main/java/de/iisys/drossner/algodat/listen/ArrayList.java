package de.iisys.drossner.algodat.listen;

public class ArrayList {

    private String[] basis;
    private int free;

    public ArrayList(){
        this(10);
    }

    public ArrayList(int initialCap){
        this.basis = new String[initialCap];
        free = 0;
    }

    public void add(String s){
        if(s == null) throw new NullPointerException();
        realloc();
        basis[free++] = s;
    }

    public void add(String s, int pos){
        if(pos < 0 || pos > free) throw new IndexOutOfBoundsException();
        if(s == null) throw new NullPointerException();
        realloc();
        System.arraycopy(basis, pos, basis, pos+1, free - pos);
        basis[pos] = s;
        free++;
    }

    public String get(int index){
        if(index < 0 || index >= free) throw new IndexOutOfBoundsException();
        return basis[index];
    }

    public String remove(int index){
        if(index < 0 || index >= free) throw new IndexOutOfBoundsException();
        String tmp = basis[index];
        System.arraycopy(basis, index+1, basis, index, free - index);
        basis[--free] = null;
        return tmp;
    }

    private void realloc(){
        if(free >= basis.length){
            String[] narr = new String[basis.length * 2];
            //effizient arrays kopieren
            System.arraycopy(basis, 0, narr, 0, basis.length);
            basis = narr;
        }
    }

    public void print(){
        int i = 0;
        String out = basis[i];
        while (out != null){
            System.out.println(i+": "+out);
            out = basis[++i];
        }
        System.out.println("-----------");
    }

}
