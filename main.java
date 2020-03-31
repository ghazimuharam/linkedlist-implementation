import list.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * main
 */
public class main {

    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        Scanner inp = new Scanner(System.in);

        try {
            File myObj = new File("sda.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splitter = data.split("::");
                ll.add(splitter[0]);

                if(ll.searchData(splitter[0]) != null){
                    ll.searchData(splitter[0]).getData().addJudul(splitter[1]);
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        ll.doSelectionSort();
        while(true){
            System.out.print("\tProgram LinkedList Struktur Data dan Algoritma\n\n1. Tampilan semua editor\n2. Cari nama editor\n3. Cari artikel per editor\n\nMasukkan Pilihan : ");
            int pilihan = Integer.parseInt(inp.nextLine());
            if(pilihan == 1){
                ll.display();
            }else if(pilihan == 2){
                System.out.print("Input nama editor : ");
                String editor = inp.nextLine();
                System.out.println("\n");
                ll.searchContainsEditor(editor);
            }else if(pilihan == 3){
                System.out.print("Input nama editor : ");
                String editor = inp.nextLine();
                System.out.println("");
                ll.fetchAllData(editor);
            }else{
                System.out.println("Pilihan tidak ditemukan\n");
                System.exit(1);
            }
            System.out.println("----------------------------------------------------\n\n");
        }

    }
}
