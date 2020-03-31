package list;

public class Linkedlist {
    private Node head;
    private int size;

    public Linkedlist(){
        this.head = null;
        this.size = 0;
    }

    public void setHead(Node head){
        this.head = head;
        this.incSize();
    }

    public void incSize(){
        this.size++;
    }
    
    public void decSize(){
        this.size--;
    }

    public int Size(){
        return this.size;
    }

    public Node getHead(){
        return this.head;
    }

    public void doSelectionSort(){
        Node toSwap = this.getHead();
        Node current = this.getHead();
        Node next = current.getNext();

        while(current.getNext() != null){
            while(next != null){
                if(current.getData().getNama().toLowerCase().compareTo(next.getData().getNama().toLowerCase()) > 0){
                    current = next;
                }
                next = next.getNext();
            }
            Data tmp = toSwap.getData();
            toSwap.setData(current.getData());
            current.setData(tmp);

            toSwap = toSwap.getNext();
            current = toSwap;
            next = current.getNext();
        }
    }

    public void searchContainsEditor(String editor){
        Node current = this.getHead();

        while(current != null){
            if(current.getData().getNama().toLowerCase().contains(editor.toLowerCase())){
                System.out.println(current.getData().getNama() + " ditemukan dengan total artikel yang di edit adalah " + current.getData().getFreq() + ".");
            }
            if(current.getNext() == null){
                break;
            }
            current = current.getNext();
        }
    }

    public Node searchData(String editor){
        Node current = this.getHead();

        while(current != null){
            if(current.getData().getNama().toLowerCase().equals(editor.toLowerCase())){
                return current;
            }
            if(current.getNext() == null){
                break;
            }
            current = current.getNext();
        }
        return null;
    }

    public String fetchData(String editor){
        Node isFound = this.searchData(editor);

        if(isFound != null){
            return isFound.getData().getNama() + " ditemukan dengan total artikel yang di edit adalah " + isFound.getData().getFreq() + ".";
        }else{
            return "Data " + editor + " tidak ditemukan.";
        }
    }

    public void fetchAllData(String editor){
        Node isFound = this.searchData(editor);
        if(isFound != null){
            System.out.println(this.fetchData(editor));
            isFound.getData().getJudul();
        }else{
            System.out.println("Data " + editor + " tidak ditemukan.");
        }
    }

    public void add(String editor){
        Node isFound = this.searchData(editor);

        if(isFound == null){
            this.setHead(new Node(new Data(editor), this.getHead()));
        }else{
            isFound.getData().addFreq();
        }
            
    }

    public void display(){
        Node current = this.getHead();

        while(current != null){
            System.out.println(current.getData().getNama() + " = " + current.getData().getFreq() + " artikel");
            if(current.getNext() == null){
                break;
            }
            current = current.getNext();
        }
    }
}