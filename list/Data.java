package list;

public class Data {
    private String editor;
    private Linkedlist judul = new Linkedlist();
    private int freq;

    public Data(String editor) {
        this.editor = editor;
        this.freq = 1;
    }

    public String getNama() {
        return this.editor;
    }

    public int getFreq(){
        return this.freq;
    }

    public void addFreq(){
        this.freq += 1;
    }

    public void addJudul(String artikel){
        judul.add(artikel);
    }

    public void getJudul() {
        Node current = judul.getHead();
        int i = 1;
        while(current != null){
            System.out.println(i+". "+current.getData().getNama());
            if(current.getNext() == null){
                break;
            }
            current = current.getNext();
            i++;
        }
    }
}