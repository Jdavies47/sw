package chat.database;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Zsolt Pazmandy on 26/02/16.
 * [1600690] [zxp590]
 * zxp590@student.bham.ac.uk
 * zsoltpazmandy@gmail.com
 * University of Birmingham
 * Computer Science MSc 2015/16
 *
 * JAVA Workshop Group Project 'Athens'
 */
public class SortDataBase {
    static TreeSet<String> itsATree = new TreeSet<>();
    static Scanner input;

    public SortDataBase() {
        try {
            Scanner input = new Scanner(new FileReader("/home/zsolt/IdeaProjects/chat/src/CSDB"));
            while (input.hasNextLine()) {
                itsATree.add(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        SortDataBase s = new SortDataBase();
        System.out.println(itsATree);
    }
}
