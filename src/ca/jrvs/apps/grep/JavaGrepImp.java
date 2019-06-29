package ca.jrvs.apps.grep;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaGrepImp implements JavaGrep{
    private String rootpath;
    private String regex;
    private String outFile;

    @Override
    public void process() throws IOException{
        List<String> matchedLines = new ArrayList<>();
        for (File file : lamdalistFiles(this.getRootPath())){
            for(String line : streamReadLines(file)){
                if (containsPattern(line)){
                    matchedLines.add(line);
                }
            }
        }
writeToFile(matchedLines);
    }

    @Override
    public List<File> listFiles(String rootdir) {
        List<File> files= new ArrayList<>();
        File dir= new File(rootdir);

        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                files.addAll(listFiles(file.getPath()));
            } else {
                files.add(file);
            }
        }

        return files;
    }
    //Using and stream API Method 2
    public List<File> lamdalistFiles(String rootpath) throws IOException {
        return Files.walk(Paths.get(rootpath)).filter(Files::isRegularFile).map(Path::toFile).collect(Collectors.toList());
    }
    @Override
    //Method 1
    public List<String> readLines(File inputFile) {
        if (!inputFile.isFile()){
            throw new IllegalArgumentException("Not a file");
        }
        List<String> lines= new ArrayList<>();
        try {
            BufferedReader br =new BufferedReader(new FileReader(inputFile));
            String line;
            while((line = br.readLine())!=null) {
                lines.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lines;
    }
    //Method 2
    public List<String> streamReadLines(File inputFile) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        return br.lines().collect(Collectors.toList());
    }

    @Override
    public boolean containsPattern(String line) {
        return line.matches(this.getRegex());
    }

    @Override
    public void writeToFile(List<String> lines) throws IOException {
        FileOutputStream fs=new FileOutputStream(this.getOutFile());
        OutputStreamWriter ow=new OutputStreamWriter(fs);
        BufferedWriter bw= new BufferedWriter(ow);
        for (String line : lines){
            bw.write(line);
            bw.newLine();
        }
        bw.close();
    }







    public String getRootPath() {
        return rootpath;
    }

    public void setRootPath(String rootpath) {
        this.rootpath = rootpath;
    }

    @Override
    public String getRegex() {
        return regex;
    }

    @Override
    public void setRegex(String regex) {
        this.regex = regex;
    }

    @Override
    public String getOutFile() {
        return outFile;
    }

    @Override
    public void setOutFile(String outFile) {
        this.outFile = outFile;
    }

    public static void main(String[] args) {
        if(args.length!=3){
            throw new IllegalArgumentException("Usage: regex rootpath outfile");
        }
        JavaGrepImp javaGrepImp= new JavaGrepImp();
        javaGrepImp.setRegex(args[0]);
        javaGrepImp.setRootPath(args[1]);
        javaGrepImp.setOutFile(args[2]);

        try {
            javaGrepImp.process();
        }catch (Exception ex){
            ex.printStackTrace();
        }


    }

}
