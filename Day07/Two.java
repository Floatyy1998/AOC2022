package Day07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import java.util.List;

public class Two {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("Day07/Day07.txt"));

        DirectoryEntry rootDirectory = new DirectoryEntry(null, "/");
        DirectoryEntry currentDirectory = rootDirectory;

        List<DirectoryEntry> allDirectories = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {

            String[] linearr = line.split(" ");
            if ("$".equals(linearr[0])) {
                if ("cd".equals(linearr[1])) {
                    if ("/".equals(linearr[2])) {
                        currentDirectory = rootDirectory;
                    } else if ("..".equals(linearr[2])) {
                        currentDirectory = currentDirectory.getParent();
                    } else {
                        currentDirectory = currentDirectory.getDir(linearr[2]);
                    }
                }
            } else if ("dir".equals(linearr[0])) {
                DirectoryEntry de = new DirectoryEntry(currentDirectory, linearr[1]);
                currentDirectory.addFile(de);
                allDirectories.add(de);
            } else {
                currentDirectory.addFile(new FileEntry(linearr[1], Long.parseLong(linearr[0])));
            }
        }

        long sizeOfRoot = rootDirectory.size();
        long spaceLeft = 70000000 - sizeOfRoot;
        long spaceToRemove = 30000000 - spaceLeft;

        List<DirectoryEntry> candidates = new ArrayList<>();

        for (DirectoryEntry de : allDirectories) {
            if (de.size() > spaceToRemove) {
                candidates.add(de);
            }
        }

        candidates.add(rootDirectory);

        candidates.sort((a, b) -> (int) (a.size() - b.size()));

        System.out.println(candidates.get(0).size());
    }
}