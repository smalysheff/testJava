import java.io.*;
import java.util.*;

public class Program{
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("c:/test/login.txt");
        FileReader fr1 = new FileReader("c:/test/Pass.txt");

        File dir = new File("c:/test/Registration");
        System.out.println(dir.mkdir()?"Success":"Failed");
        File file = new File("c:/test/Registration/reg.txt");
        file.createNewFile();

        FileWriter fw = new FileWriter(file);

        List<String> login = new ArrayList<>();
        List<String> pass = new ArrayList<>();
        Map<String, String> reg = new HashMap<>();

        BufferedReader readerLogin = new BufferedReader(fr);
        BufferedReader readerPass = new BufferedReader(fr1);
        String strLogin;
        String strPass;

        while((strLogin = readerLogin.readLine()) != null){
            strPass = readerPass.readLine();
            if(strLogin.isEmpty()) break;
            login.add(strLogin);
            pass.add(strPass);
        }


        for (int i = 0; i < login.size(); i++) {
            reg.put(login.get(i), pass.get(i));
        }

        for (Map.Entry x: reg.entrySet()) {
            fw.write(x.getKey().toString() + x.getValue() + '\n');
        }

        fr.close();
        fr1.close();
        fw.close();
        readerLogin.close();
        readerPass.close();







    }
}